package com.gxy.canal.cache.handler;

import com.gxy.canal.cache.handler.entity.DDLEntity;

/**
 * @author guoxingyong
 * @since 2019/1/23 16:18
 */
public interface TableDDLHandlerInvoker {
    TablePipeline fireTableCreate(DDLEntity ddlEntity);

    TablePipeline fireTableAlter(DDLEntity ddlEntity);

    TablePipeline fireTableErase(DDLEntity ddlEntity);
}
