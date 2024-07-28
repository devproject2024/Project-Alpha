package com.alipay.mobile.nebulaappcenter.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nebula_config")
public class H5AppConfigBean {
    @DatabaseField(defaultValue = "3")
    private int app_pool_limit;
    @DatabaseField
    private String extra;
    @DatabaseField
    private String failed_request_app_list;
    @DatabaseField
    private String last_update_date;
    @DatabaseField(defaultValue = "600")
    private double limitReqRate;
    @DatabaseField(defaultValue = "1800")
    private double normalReqRate;
    @DatabaseField(generatedId = true, index = true, unique = true)
    private int status_id;
    @DatabaseField
    private int strictReqRate;

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public int getStrictReqRate() {
        return this.strictReqRate;
    }

    public void setStrictReqRate(int i2) {
        this.strictReqRate = i2;
    }

    public String getFailed_request_app_list() {
        return this.failed_request_app_list;
    }

    public void setFailed_request_app_list(String str) {
        this.failed_request_app_list = str;
    }

    public String getLast_update_date() {
        return this.last_update_date;
    }

    public void setLast_update_date(String str) {
        this.last_update_date = str;
    }

    public int getApp_pool_limit() {
        return this.app_pool_limit;
    }

    public void setApp_pool_limit(int i2) {
        this.app_pool_limit = i2;
    }

    public int getStatus_id() {
        return this.status_id;
    }

    public void setStatus_id(int i2) {
        this.status_id = i2;
    }

    public double getNormalReqRate() {
        return this.normalReqRate;
    }

    public void setNormalReqRate(double d2) {
        this.normalReqRate = d2;
    }

    public double getLimitReqRate() {
        return this.limitReqRate;
    }

    public void setLimitReqRate(double d2) {
        this.limitReqRate = d2;
    }
}
