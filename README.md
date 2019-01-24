# binlog-monitor
对于mysql binlog进行监控后传输到kafka，从kafka拿到binlog解析数据后进行业务链调用
```
    @Bean
    public TableManager tableManager() {
        DefaultTableManager defaultTableManager = new DefaultTableManager();
        //注冊你需要去进行业务操作的数据库表，注册自己的DML与DDL业务链就可以了
        Table.createAndRegister("gar_store_order", GarStoreOrder.class, defaultTableManager)
                .addTableDMLHandler(new GarStoreOrderDMLHandler<>())
                .addTableDDLHandler(new GarStoreOrderDDLHandler());
        Table.createAndRegister("user", User.class, defaultTableManager)
                .addTableDMLHandler(new UserDMLHandler<>())
                .addTableDDLHandler(new UserDDLHandler());
        return defaultTableManager;
    }
```
