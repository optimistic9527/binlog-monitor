package com.gxy.canal.handler;

import com.gxy.canal.handler.entity.DDLEntity;

/**
 * 表进行执行DDL语句的时候的处理
 *
 * @author guoxingyong
 * @since 2019/1/23 14:20
 */
public interface TableDDLHandler {
    /**
     * 表修改
     */
    void tableAlter(DDLEntity ddlEntity);

    /**
     * 表创建
     */
    void tableCreate(DDLEntity ddlEntity);

    /**
     * 表删除
     */
    void tableErase(DDLEntity ddlEntity);


    void exceptionHandler(Throwable throwable);
}
