package com.gxy.canal.cache.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GarMerchants {
    /**
     * 商户或门店id
     */
    private String merchantsId;

    /**
     * 名称
     */
    private String name;

    private Integer num;

    /**
     * 父节点编号
     */
    private String parentId;

    /**
     * 1为有效，0为失效
     */
    private String valid;

    /**
     * 节点层数，1为商户，2为商户下门店
     */
    private Integer layer;

    /**
     * 商户或者门店编码
     */
    private String mcode;

    /**
     * 地址
     */
    private String address;

    /**
     * 累计兑换积分
     */
    private Integer exchangeInt;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;

    /**
     * 百度经度
     */
    private BigDecimal baiduLng;

    /**
     * 百度纬度
     */
    private BigDecimal baiduLat;

    /**
     * 定位来源,1代表一期平台，2代表二期平台
     */
    private Boolean source;

    /**
     * 0代表不是现场兑换，1代表是现场兑换
     */
    private Boolean liveExchange;

    /**
     * 已经结算积分
     */
    private Integer withdrawInt;

    /**
     * 可结算积分
     */
    private Integer hasWithdrawInt;

    /**
     * 对接门店编号
     */
    private String abutmentShopCode;


    public String getMerchantsId() {
        return this.merchantsId;
    }

    public void setMerchantsId(String merchantsId) {
        this.merchantsId = merchantsId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getValid() {
        return this.valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Integer getLayer() {
        return this.layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public String getMcode() {
        return this.mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExchangeInt() {
        return this.exchangeInt;
    }

    public void setExchangeInt(Integer exchangeInt) {
        this.exchangeInt = exchangeInt;
    }

    public LocalDateTime getAddTime() {
        return this.addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getBaiduLng() {
        return this.baiduLng;
    }

    public void setBaiduLng(BigDecimal baiduLng) {
        this.baiduLng = baiduLng;
    }

    public BigDecimal getBaiduLat() {
        return this.baiduLat;
    }

    public void setBaiduLat(BigDecimal baiduLat) {
        this.baiduLat = baiduLat;
    }

    public Boolean getSource() {
        return this.source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public Boolean getLiveExchange() {
        return this.liveExchange;
    }

    public void setLiveExchange(Boolean liveExchange) {
        this.liveExchange = liveExchange;
    }

    public Integer getWithdrawInt() {
        return this.withdrawInt;
    }

    public void setWithdrawInt(Integer withdrawInt) {
        this.withdrawInt = withdrawInt;
    }

    public Integer getHasWithdrawInt() {
        return this.hasWithdrawInt;
    }

    public void setHasWithdrawInt(Integer hasWithdrawInt) {
        this.hasWithdrawInt = hasWithdrawInt;
    }

    public String getAbutmentShopCode() {
        return this.abutmentShopCode;
    }

    public void setAbutmentShopCode(String abutmentShopCode) {
        this.abutmentShopCode = abutmentShopCode;
    }

}

