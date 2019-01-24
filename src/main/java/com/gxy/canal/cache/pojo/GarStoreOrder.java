package com.gxy.canal.cache.pojo;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class GarStoreOrder {
    /**
     * 兑换单编号，一期补0id，二期原本id
     */
    private String storeOrderId;

    /**
     * 用户id
     */
    private String citizenId;

    /**
     * 帐号id
     */
    private String accountId;

    /**
     * 兑换积分
     */
    private Integer exchangeInt;

    /**
     * 收银员id
     */
    private String userId;

    /**
     * 门店id
     */
    private String merchantsId;

    /**
     * 兑换时间
     */
    private LocalDateTime exchangeTime;

    /**
     * 1代表一期，2代表二期
     */
    private Boolean sourceType;

    /**
     * 数据原本的兑换单id，二期的生成的id，一期是自增
     */
    private String sourceId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单状态,0代表有效，1代表无效
     */
    private String orderStatus;


    public String getStoreOrderId() {
        return this.storeOrderId;
    }

    public void setStoreOrderId(String storeOrderId) {
        this.storeOrderId = storeOrderId;
    }

    public String getCitizenId() {
        return this.citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getExchangeInt() {
        return this.exchangeInt;
    }

    public void setExchangeInt(Integer exchangeInt) {
        this.exchangeInt = exchangeInt;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMerchantsId() {
        return this.merchantsId;
    }

    public void setMerchantsId(String merchantsId) {
        this.merchantsId = merchantsId;
    }

    public LocalDateTime getExchangeTime() {
        return this.exchangeTime;
    }

    public void setExchangeTime(LocalDateTime exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public Boolean getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(Boolean sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}

