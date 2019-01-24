package com.gxy.canal.handler;

import com.gxy.canal.handler.entity.DMLEntity;

/**
 * 表执行DML语句进行的处理
 *
 * @author guoxingyong
 * @since 2019/1/23 14:09
 */
public interface TableDMLHandler<T> {
    /**
     * 数据插入
     */
    void dataInsert(DMLEntity<T> dmlEntity);

    /**
     * 数据更新
     */
    void dataUpdate(DMLEntity<T> dmlEntity);

    /**
     * 数据删除
     */
    void dataDelete(DMLEntity<T> dmlEntity);


    void exceptionHandler(Throwable throwable);
}
