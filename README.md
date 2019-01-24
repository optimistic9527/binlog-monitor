# binlog-monitor
对于mysql binlog进行监控后传输到kafka，从kafka拿到binlog解析数据后进行业务链调用
```
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
```
