package com.gxy.canal.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guoxingyong
 * @since 2019/1/23 17:09
 */
@Setter
@Getter
@Slf4j
public class Table<T> {

    private final String tableName;
    /**
     * table事件处理链
     */
    private final DefaultTablePipeline<T> defaultTablePipeline;

    private final Class<T> entityClass;
    private final AbstractTableManager tableManager;

    private Table(String tableName, Class<T> entityClass, AbstractTableManager tableManager) {
        this.tableName = tableName;
        this.entityClass = entityClass;
        this.tableManager = tableManager;
        defaultTablePipeline = new DefaultTablePipeline<>(this);
    }

    /**
     * @param tableName    表名
     * @param entityClass  实体的class
     * @param tableManager 需要去注册的TableManager
     * @return DefaultTablePipeline
     */
    public static <T> DefaultTablePipeline<T> createAndRegister(String tableName, Class<T> entityClass, AbstractTableManager tableManager) {
        Table<T> table = new Table<>(tableName, entityClass, tableManager);
        tableManager.registerTable(tableName, table);
        return table.getDefaultTablePipeline();
    }
}
