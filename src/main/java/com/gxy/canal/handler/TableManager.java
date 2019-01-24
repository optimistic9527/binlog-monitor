package com.gxy.canal.handler;

/**
 * @author guoxingyong
 * @since 2019/1/24 9:41
 */
public interface TableManager {

    Table findTable(String tableName);

    boolean tableExist(String tableName);

    Table removeTable(String tableName);

    Integer tableSize();

    void dealCanalData(String canalDataJson);
}
