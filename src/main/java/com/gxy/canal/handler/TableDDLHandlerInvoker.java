package com.gxy.canal.handler;

import com.gxy.canal.handler.entity.DDLEntity;

/**
 * @author guoxingyong
 * @since 2019/1/23 16:18
 */
public interface TableDDLHandlerInvoker {
    TablePipeline fireTableCreate(DDLEntity ddlEntity);

    TablePipeline fireTableAlter(DDLEntity ddlEntity);

    TablePipeline fireTableErase(DDLEntity ddlEntity);
}
