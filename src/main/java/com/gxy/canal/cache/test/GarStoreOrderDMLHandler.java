package com.gxy.canal.cache.test;

import com.gxy.canal.cache.handler.TableDMLHandler;
import com.gxy.canal.cache.handler.entity.DMLEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guoxingyong
 * @since 2019/1/24 10:17
 */
@Slf4j
public class GarStoreOrderDMLHandler<GarStoreOrder> implements TableDMLHandler<GarStoreOrder> {

    @Override
    public void dataInsert(DMLEntity<GarStoreOrder> dmlEntity) {
        GarStoreOrder garStoreOrder = dmlEntity.getData().get(0);
        System.out.println(garStoreOrder);
    }

    @Override
    public void dataUpdate(DMLEntity<GarStoreOrder> dmlEntity) {
        GarStoreOrder garStoreOrder = dmlEntity.getData().get(0);
        System.out.println(garStoreOrder);
    }

    @Override
    public void dataDelete(DMLEntity<GarStoreOrder> dmlEntity) {
        GarStoreOrder garStoreOrder = dmlEntity.getData().get(0);
        System.out.println(garStoreOrder);
    }

    @Override
    public void exceptionHandler(Throwable throwable) {

    }
}
