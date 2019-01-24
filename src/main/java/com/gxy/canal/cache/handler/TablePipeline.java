package com.gxy.canal.cache.handler;

/**
 * @author guoxingyong
 * @since 2019/1/23 15:14
 */
public interface TablePipeline<T> extends TableDMLHandlerInvoker<T>, TableDDLHandlerInvoker {

    /**
     * @return 当前链的table
     */
    Table table();

    /**
     * @param tableDDLHandler tableDDLHandler
     * @return this
     */
    TablePipeline addTableDDLHandler(TableDDLHandler tableDDLHandler);

    /**
     * @param tableDMLHandler tableDMLHandler
     * @return this
     */
    TablePipeline addTableDMLHandler(TableDMLHandler<T> tableDMLHandler);

    /**
     *  @param handlerName handler名称
     * @param tableDDLHandler tableDDLHandler
     * @return this
     */
    TablePipeline addTableDDLHandler(String handlerName, TableDDLHandler tableDDLHandler);

    /**
     * @param handlerName handler名称
     * @param tableDMLHandler tableDMLHandler
     * @return this
     */
    TablePipeline addTableDMLHandler(String handlerName, TableDMLHandler<T> tableDMLHandler);

    /**
     * 移除tableDDLHandler
     * @param tableDDLHandler tableDDLHandler
     * @return this
     */
    TablePipeline removeTableDDLHandler(TableDDLHandler tableDDLHandler);

    /**
     * 移除handlerName的TableDDLHandler
     * @param handlerName handlerName
     * @return this
     */
    TablePipeline removeTableDDLHandler(String handlerName);

    /**
     * 移除handlerName的TableDMLHandle
     * @param tableDMLHandler tableDDLHandler
     * @return this
     */
    TablePipeline removeTableDMLHandler(TableDMLHandler<T> tableDMLHandler);

    /**
     * 移除handlerName的TableDMLHandle
     * @param handlerName handlerName
     * @return this
     */
    TablePipeline removeTableDMLHandler(String handlerName);

    /**
     *
     * @param isDDL 是否是ddl操作
     * @param throwable 异常
     * @return this
     */
    TablePipeline fireHandlerException(boolean isDDL, Throwable throwable);

}
