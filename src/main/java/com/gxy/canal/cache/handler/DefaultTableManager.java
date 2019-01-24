package com.gxy.canal.cache.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxy.canal.cache.contant.TableOperatorConst;
import com.gxy.canal.cache.handler.entity.CanalEntity;
import com.gxy.canal.cache.handler.entity.DDLEntity;
import com.gxy.canal.cache.handler.entity.DMLEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guoxingyong
 * @since 2019/1/24 8:50
 */
@Slf4j
public class DefaultTableManager extends AbstractTableManager {

    @Override
    @SuppressWarnings("unchecked")
    public void dealCanalData(String canalDataJson) {
        CanalEntity canalEntity = JSON.parseObject(canalDataJson, CanalEntity.class);
        log.info("canalEntity:{}", canalEntity);
        String tableName = canalEntity.getTable();
        if (tableName == null) {
            log.warn("canalDataJson parse fail,canalDataJson:{}", canalDataJson);
            return;
        }
        Table<?> table = findTable(tableName);
        if (table == null) {
            log.warn("don't register table information,table name:{}", tableName);
            return;
        }
        DefaultTablePipeline<?> defaultTablePipeline = table.getDefaultTablePipeline();
        String type = canalEntity.getType();
        if (canalEntity.getIsDdl()) {
            DDLEntity ddlEntity = new DDLEntity();
            BeanUtils.copyProperties(canalEntity, ddlEntity);
            log.info("ddlEntity:{}", ddlEntity);
            switch (type) {
                case TableOperatorConst.CREATE:
                    defaultTablePipeline.fireTableCreate(ddlEntity);
                    break;
                case TableOperatorConst.ERASE:
                    defaultTablePipeline.fireTableErase(ddlEntity);
                    break;
                case TableOperatorConst.ALTER:
                    defaultTablePipeline.fireTableAlter(ddlEntity);
                    break;
                default:
                    log.warn("can't recognize this DDL operateType:type:" + type);
            }
        } else {
            List<JSONObject> data = canalEntity.getData();
            List<Object> collect = data.stream().map(jsonObject -> jsonObject.toJavaObject(table.getEntityClass())).collect(Collectors.toList());
            DMLEntity dmlEntity = new DMLEntity();
            dmlEntity.setData(collect);
            BeanUtils.copyProperties(canalEntity, dmlEntity);
            log.info("dmlEntity:{}", dmlEntity);
            switch (type) {
                case TableOperatorConst.INSERT:
                    defaultTablePipeline.fireDataInsert(dmlEntity);
                    break;
                case TableOperatorConst.UPDATE:
                    defaultTablePipeline.fireDataUpdate(dmlEntity);
                    break;
                case TableOperatorConst.DELETE:
                    defaultTablePipeline.fireDataDelete(dmlEntity);
                    break;
                default:
                    log.warn("can't recognize this DML operateType:type:" + type);
            }
        }
    }
}
