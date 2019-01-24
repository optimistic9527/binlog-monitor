package com.gxy.canal.cache.handler.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * binlog解析后由canal传输到kafka的数据
 *
 * @author guoxingyong
 * @since 2019/1/21 14:01
 */
@Getter
@Setter
public class CanalEntity {

    /**
     * 数据库名称
     */
    private String database;
    /**
     * 数据库里面的执行时间(event time)
     */
    private Long es;
    /**
     * 记录id
     */
    private Integer id;
    /**
     * 是否是DDL语句
     */
    private Boolean isDdl;
    /**
     * 例子:
     * cashierId : varchar(15)
     * accumulateCashier : int(255)
     * merchantId : varchar(20)
     */
    private Map<String, String> mysqlType;
    /**
     * sql语句(ddl语句会有sql)
     */
    private String sql;
    /**
     * cashierId : 12
     * accumulateCashier : 4
     * merchantId : 12
     */
    private Map<String, Integer> sqlType;
    /**
     * 表名
     */
    private String table;
    /**
     * 解析时间(process time)
     */
    private Long ts;
    /**
     * 操作类型
     */
    private String type;

    /**
     * bean修改后的数据(ddl语句data会为null)
     */
    private List<JSONObject> data;
    /**
     * 被修改过的老值
     * old : [{"accumulateCashier":"59","merchantId":"009011"}]
     */
    private List<Map<String, ?>> old;


    @Override
    public String toString() {
        return "CanalEntity{" +
                "database='" + database + '\'' +
                ", es=" + es +
                ", id=" + id +
                ", isDdl=" + isDdl +
                ", mysqlType=" + mysqlType +
                ", sql='" + sql + '\'' +
                ", sqlType=" + sqlType +
                ", table='" + table + '\'' +
                ", ts=" + ts +
                ", type='" + type + '\'' +
                ", data=" + data +
                ", old=" + old +
                '}';
    }
}
