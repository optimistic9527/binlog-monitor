package com.gxy.canal.cache.handler;

import com.gxy.canal.cache.handler.entity.DMLEntity;

/**
 * @author guoxingyong
 * @since 2019/1/23 16:17
 */
public interface TableDMLHandlerInvoker<T> {

    TablePipeline fireDataInsert(DMLEntity<T> dmlEntity);

    TablePipeline fireDataUpdate(DMLEntity<T> dmlEntity);

    TablePipeline fireDataDelete(DMLEntity<T> dmlEntity);
}
