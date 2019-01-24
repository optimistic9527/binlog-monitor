package com.gxy.canal.cache.handler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author guoxingyong
 * @since 2019/1/24 11:16
 */
@Getter
@Setter
@ToString
public class DDLEntity {

    /**
     * 数据库名称
     */
    private String database;

    /**
     * 数据库里面的执行时间(event time)
     */
    private Long es;

    /**
     * sql语句(ddl语句会有sql)
     */
    private String sql;

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
}
