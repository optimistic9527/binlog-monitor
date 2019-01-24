package com.gxy.canal.cache.pojo;

import java.time.LocalDateTime;

public class GarSyncRecord {
    /**
     * 主键自增
     */
    private Integer id;

    /**
     * 同步时间
     */
    private LocalDateTime syncTime;

    /**
     * 1为门店同步，2为兑换记录同步
     */
    private Boolean syncType;

    /**
     * 0一期二期资源对比同步,1为同步资源来自于一期，2同步资源来自于二期
     */
    private Boolean sourceType;

    /**
     * 同步的门店id，兑换记录同步特有字段
     */
    private String merchantsId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getSyncTime() {
        return this.syncTime;
    }

    public void setSyncTime(LocalDateTime syncTime) {
        this.syncTime = syncTime;
    }

    public Boolean getSyncType() {
        return this.syncType;
    }

    public void setSyncType(Boolean syncType) {
        this.syncType = syncType;
    }

    public Boolean getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(Boolean sourceType) {
        this.sourceType = sourceType;
    }

    public String getMerchantsId() {
        return this.merchantsId;
    }

    public void setMerchantsId(String merchantsId) {
        this.merchantsId = merchantsId;
    }

}

