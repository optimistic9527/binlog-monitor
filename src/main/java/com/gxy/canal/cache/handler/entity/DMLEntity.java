package com.gxy.canal.cache.handler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author guoxingyong
 * @since 2019/1/24 10:43
 */
@Getter
@Setter
@ToString
public class DMLEntity<T> {
    /**
     * 数据库名称
     */
    private String database;

    /**
     * 数据库里面的执行时间(event time)
     */
    private Long es;

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
    private List<T> data;
    /**
     * 被修改过的老值 filedName:value
     * old : [{"accumulateCashier":"59","merchantId":"009011"}]
     */
    private List<Map<String, ?>> old;
}
