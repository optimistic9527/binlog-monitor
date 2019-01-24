package com.gxy.canal;

import com.gxy.canal.handler.DefaultTableManager;
import com.gxy.canal.handler.Table;
import com.gxy.canal.handler.TableManager;
import com.gxy.canal.pojo.GarStoreOrder;
import com.gxy.canal.pojo.User;
import com.gxy.canal.test.GarStoreOrderDDLHandler;
import com.gxy.canal.test.GarStoreOrderDMLHandler;
import com.gxy.canal.test.UserDDLHandler;
import com.gxy.canal.test.UserDMLHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CanalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
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

