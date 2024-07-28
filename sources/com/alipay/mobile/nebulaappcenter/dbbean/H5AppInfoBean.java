package com.alipay.mobile.nebulaappcenter.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nebula_app_table")
public class H5AppInfoBean {
    public static final String COL_POOL_ID = "app_pool_id";
    @DatabaseField
    private String app_dsec;
    @DatabaseField
    private int app_pool_id;
    @DatabaseField
    private int auto_install;
    @DatabaseField
    private String extend_info;
    @DatabaseField
    private String fallback_base_url;
    @DatabaseField
    private String icon_url;
    @DatabaseField
    private String main_url;
    @DatabaseField
    private String name;
    @DatabaseField(generatedId = true, index = true, unique = true)
    private int nbId;
    @DatabaseField
    private int online;
    @DatabaseField
    private String package_url;
    @DatabaseField
    private String patch;
    @DatabaseField
    private Long size;
    @DatabaseField
    private String sub_url;
    @DatabaseField
    private String system_max;
    @DatabaseField
    private String system_min;
    @DatabaseField
    private String vhost;

    public int getNbId() {
        return this.nbId;
    }

    public void setNbId(int i2) {
        this.nbId = i2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getApp_pool_id() {
        return this.app_pool_id;
    }

    public void setApp_pool_id(int i2) {
        this.app_pool_id = i2;
    }

    public String getPatch() {
        return this.patch;
    }

    public void setPatch(String str) {
        this.patch = str;
    }

    public int getOnline() {
        return this.online;
    }

    public void setOnline(int i2) {
        this.online = i2;
    }

    public int getAuto_install() {
        return this.auto_install;
    }

    public void setAuto_install(int i2) {
        this.auto_install = i2;
    }

    public String getApp_dsec() {
        return this.app_dsec;
    }

    public void setApp_dsec(String str) {
        this.app_dsec = str;
    }

    public String getFallback_base_url() {
        return this.fallback_base_url;
    }

    public void setFallback_base_url(String str) {
        this.fallback_base_url = str;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public String getSub_url() {
        return this.sub_url;
    }

    public void setSub_url(String str) {
        this.sub_url = str;
    }

    public String getVhost() {
        return this.vhost;
    }

    public void setVhost(String str) {
        this.vhost = str;
    }

    public String getExtend_info() {
        return this.extend_info;
    }

    public void setExtend_info(String str) {
        this.extend_info = str;
    }

    public String getPackage_url() {
        return this.package_url;
    }

    public void setPackage_url(String str) {
        this.package_url = str;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public String getMain_url() {
        return this.main_url;
    }

    public void setMain_url(String str) {
        this.main_url = str;
    }

    public String getSystem_max() {
        return this.system_max;
    }

    public void setSystem_max(String str) {
        this.system_max = str;
    }

    public String getSystem_min() {
        return this.system_min;
    }

    public void setSystem_min(String str) {
        this.system_min = str;
    }
}
