package com.gxy.canal.handler;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author guoxingyong
 * @since 2019/1/24 9:43
 */
@Slf4j
public abstract class AbstractTableManager implements TableManager {

    private final ConcurrentHashMap<String, Table<?>> tableMap = new ConcurrentHashMap<>(16);

    void registerTable(String tableName, Table table) {
        if(tableMap.containsKey(tableName)){
            throw new IllegalArgumentException("exist this tableName "+tableName);
        }
        tableMap.put(tableName, table);
    }

    @Override
    public Table findTable(String tableName) {
        return tableMap.get(tableName);
    }

    @Override
    public boolean tableExist(String tableName) {
        return tableMap.containsKey(tableName);
    }

    @Override
    public Table<?> removeTable(String tableName) {
        return tableMap.remove(tableName);
    }

    @Override
    public Integer tableSize() {
        return tableMap.size();
    }
}
