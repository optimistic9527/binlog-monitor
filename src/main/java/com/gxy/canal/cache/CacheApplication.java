package com.gxy.canal.cache;

import com.gxy.canal.cache.handler.DefaultTableManager;
import com.gxy.canal.cache.handler.Table;
import com.gxy.canal.cache.handler.TableManager;
import com.gxy.canal.cache.pojo.GarStoreOrder;
import com.gxy.canal.cache.pojo.User;
import com.gxy.canal.cache.test.GarStoreOrderDDLHandler;
import com.gxy.canal.cache.test.GarStoreOrderDMLHandler;
import com.gxy.canal.cache.test.UserDDLHandler;
import com.gxy.canal.cache.test.UserDMLHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }


    @Bean
    public TableManager tableManager() {
        DefaultTableManager defaultTableManager = new DefaultTableManager();
        Table.createAndRegister("gar_store_order", GarStoreOrder.class, defaultTableManager)
                .addTableDMLHandler(new GarStoreOrderDMLHandler<>())
                .addTableDDLHandler(new GarStoreOrderDDLHandler());
        Table.createAndRegister("user", User.class, defaultTableManager)
                .addTableDMLHandler(new UserDMLHandler<>())
                .addTableDDLHandler(new UserDDLHandler());
        return defaultTableManager;
    }
}

