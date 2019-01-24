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

1. 你为什么做这玩意
2. 它和其他竞品有什么不同
3. 你可以干什么，比起其他的呢
4. 你怎么实现的
5. 实现过程中的核心问题你怎么解决的，解决方案是一种吗？为什么你这么选择
6. 你对你做的这个东西还有什么规划
7. 你如何看待你做的东西在所处领域的发展
