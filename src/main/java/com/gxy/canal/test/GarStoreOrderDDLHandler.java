package com.gxy.canal.test;

import com.gxy.canal.handler.TableDDLHandler;
import com.gxy.canal.handler.entity.DDLEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guoxingyong
 * @since 2019/1/24 14:26
 */
@Slf4j
public class GarStoreOrderDDLHandler implements TableDDLHandler {
    @Override
    public void tableAlter(DDLEntity ddlEntity) {
        System.out.println(ddlEntity);
    }

    @Override
    public void tableCreate(DDLEntity ddlEntity) {
        System.out.println(ddlEntity);
    }

    @Override
    public void tableErase(DDLEntity ddlEntity) {
        System.out.println(ddlEntity);
    }

    @Override
    public void exceptionHandler(Throwable throwable) {

    }
}
