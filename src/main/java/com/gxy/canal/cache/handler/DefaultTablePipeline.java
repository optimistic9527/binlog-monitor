package com.gxy.canal.cache.handler;

import com.gxy.canal.cache.handler.entity.DDLEntity;
import com.gxy.canal.cache.handler.entity.DMLEntity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author guoxingyong
 * @since 2019/1/23 15:18
 */
public class DefaultTablePipeline<T> implements TablePipeline<T> {

    private final Table table;

    DefaultTablePipeline(Table table) {
        this.table = table;
    }

    private final LinkedHashMap<String, TableDDLHandler> tableDDLHandlerLinkedHashMap = new LinkedHashMap<>(16);

    private final LinkedHashMap<String, TableDMLHandler<T>> tableDMLHandlerLinkedHashMap = new LinkedHashMap<>(16);


    @Override
    public Table table() {
        return table;
    }

    @Override
    public TablePipeline addTableDDLHandler(TableDDLHandler tableDDLHandler) {
        return addTableDDLHandler(null, tableDDLHandler);
    }

    @Override
    public TablePipeline addTableDMLHandler(TableDMLHandler<T> tableDMLHandler) {
        return addTableDMLHandler(null, tableDMLHandler);
    }

    @Override
    public TablePipeline addTableDDLHandler(String handlerName, TableDDLHandler tableDDLHandler) {
        Objects.requireNonNull(tableDDLHandler, "tableDDLHandler can't be null");
        if (handlerName == null) {
            handlerName = generateName(tableDDLHandler);
        }
        synchronized (tableDDLHandlerLinkedHashMap) {
            if (tableDDLHandlerLinkedHashMap.containsKey(handlerName)) {
                throw new IllegalArgumentException("Duplicate handler name: " + handlerName);
            }
            tableDDLHandlerLinkedHashMap.put(handlerName, tableDDLHandler);
        }
        return this;
    }

    @Override
    public TablePipeline addTableDMLHandler(String handlerName, TableDMLHandler<T> tableDMLHandler) {
        Objects.requireNonNull(tableDMLHandler, "tableDMLHandler can't be null");
        if (handlerName == null) {
            handlerName = generateName(tableDMLHandler);
        }
        synchronized (tableDMLHandlerLinkedHashMap) {
            if (tableDMLHandlerLinkedHashMap.containsKey(handlerName)) {
                throw new IllegalArgumentException("Duplicate handler name: " + handlerName);
            }
            tableDMLHandlerLinkedHashMap.put(handlerName, tableDMLHandler);
        }
        return this;
    }

    @Override
    public TablePipeline removeTableDDLHandler(TableDDLHandler tableDDLHandler) {
        Set<Map.Entry<String, TableDDLHandler>> entries = tableDDLHandlerLinkedHashMap.entrySet();
        String moveKey = null;
        for (Map.Entry<String, TableDDLHandler> entry : entries) {
            if (entry.getValue() == tableDDLHandler) {
                moveKey = entry.getKey();
                break;
            }
        }
        if (moveKey != null) {
            synchronized (tableDDLHandlerLinkedHashMap) {
                tableDDLHandlerLinkedHashMap.remove(moveKey);
            }
        }
        return this;
    }

    @Override
    public TablePipeline removeTableDDLHandler(String handlerName) {
        Objects.requireNonNull(handlerName, "handlerName can't be null");
        synchronized (tableDDLHandlerLinkedHashMap) {
            tableDDLHandlerLinkedHashMap.remove(handlerName);
        }
        return this;
    }

    @Override
    public TablePipeline removeTableDMLHandler(TableDMLHandler<T> tableDMLHandler) {
        Set<Map.Entry<String, TableDMLHandler<T>>> entries = tableDMLHandlerLinkedHashMap.entrySet();
        String moveKey = null;
        for (Map.Entry<String, TableDMLHandler<T>> entry : entries) {
            if (entry.getValue() == tableDMLHandler) {
                moveKey = entry.getKey();
                break;
            }
        }
        if (moveKey != null) {
            synchronized (tableDMLHandlerLinkedHashMap) {
                tableDMLHandlerLinkedHashMap.remove(moveKey);
            }
        }
        return this;
    }

    @Override
    public TablePipeline removeTableDMLHandler(String handlerName) {
        Objects.requireNonNull(handlerName, "handlerName can't be null");
        synchronized (tableDMLHandlerLinkedHashMap) {
            tableDMLHandlerLinkedHashMap.remove(handlerName);
        }
        return this;
    }

    @Override
    public TablePipeline fireHandlerException(boolean isDDL, Throwable throwable) {
        if (isDDL) {
            tableDDLHandlerLinkedHashMap.values().forEach(tableDDLHandler -> tableDDLHandler.exceptionHandler(throwable));
        } else {
            tableDMLHandlerLinkedHashMap.values().forEach(tableDMLHandler -> tableDMLHandler.exceptionHandler(throwable));
        }
        return this;
    }

    @Override
    public final TablePipeline fireDataInsert(DMLEntity<T> dmlEntity) {
        tableDMLHandlerLinkedHashMap.values().forEach(tableDMLHandler -> {
            try {
                tableDMLHandler.dataInsert(dmlEntity);
            } catch (Exception e) {
                fireHandlerException(false, e);
            }
        });
        return this;
    }

    @Override
    public final TablePipeline fireDataUpdate(DMLEntity<T> dmlEntity) {
        tableDMLHandlerLinkedHashMap.values().forEach(tableDMLHandler -> {
            try {
                tableDMLHandler.dataUpdate(dmlEntity);
            } catch (Exception e) {
                fireHandlerException(false, e);
            }
        });
        return this;
    }

    @Override
    public final TablePipeline fireDataDelete(DMLEntity<T> dmlEntity) {
        tableDMLHandlerLinkedHashMap.values().forEach(tableDMLHandler -> {
            try {
                tableDMLHandler.dataDelete(dmlEntity);
            } catch (Exception e) {
                fireHandlerException(false, e);
            }
        });
        return this;
    }

    @Override
    public final TablePipeline fireTableCreate(DDLEntity ddlEntity) {
        tableDDLHandlerLinkedHashMap.values().forEach(tableDDLHandler -> {
            try {
                tableDDLHandler.tableCreate(ddlEntity);
            } catch (Exception e) {
                fireHandlerException(true, e);
            }
        });
        return this;
    }


    @Override
    public final TablePipeline fireTableAlter(DDLEntity ddlEntity) {
        tableDDLHandlerLinkedHashMap.values().forEach(tableDDLHandler -> {
            try {
                tableDDLHandler.tableAlter(ddlEntity);
            } catch (Exception e) {
                fireHandlerException(true, e);
            }
        });
        return this;
    }

    @Override
    public final TablePipeline fireTableErase(DDLEntity ddlEntity) {
        tableDDLHandlerLinkedHashMap.values().forEach(tableDDLHandler -> {
            try {
                tableDDLHandler.tableErase(ddlEntity);
            } catch (Exception e) {
                fireHandlerException(true, e);
            }
        });
        return this;
    }


    private String generateName(Object object) {
        return object.getClass().getName();
    }
}
