package com.gxy.canal.cache.test;

import com.gxy.canal.cache.handler.TableDMLHandler;
import com.gxy.canal.cache.handler.entity.DMLEntity;

/**
 * @author guoxingyong
 * @since 2019/1/24 10:17
 */
public class UserDMLHandler<User> implements TableDMLHandler<User> {

    @Override
    public void dataInsert(DMLEntity<User> dmlEntity) {
        User user = dmlEntity.getData().get(0);
        System.out.println(user);
    }

    @Override
    public void dataUpdate(DMLEntity<User> dmlEntity) {
        User user = dmlEntity.getData().get(0);
        System.out.println(user);
    }

    @Override
    public void dataDelete(DMLEntity<User> dmlEntity) {
        User user = dmlEntity.getData().get(0);
        System.out.println(user);
    }

    @Override
    public void exceptionHandler(Throwable throwable) {

    }
}
