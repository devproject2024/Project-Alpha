package com.alipay.mobile.nebulaappcenter.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nebula_app_info_table")
public class H5NebulaAppBean {
    public static final String COL_APP_ID = "app_id";
    public static final String COL_APP_POOL_ID = "app_pool_id";
    public static final String COL_IS_LIMIT = "is_limit";
    public static final String COL_MAP = "is_mapping";
    public static final String COL_VERSION = "version";
    public static final String LOCAL_REPORT = "localReport";
    @DatabaseField
    public int app_channel;
    @DatabaseField
    private String app_dsec;
    @DatabaseField
    private String app_id;
    @DatabaseField
    public int app_type;
    @DatabaseField
    private int auto_install;
    @DatabaseField
    private String extend_info;
    @DatabaseField
    private String fallback_base_url;
    @DatabaseField
    private String icon_url;
    @DatabaseField
    private int is_limit;
    @DatabaseField
    private int is_mapping;
    @DatabaseField
    private int localReport;
    @DatabaseField
    private String main_url;
    @DatabaseField
    private String name;
    @DatabaseField
    private String nbAppType;
    @DatabaseField(generatedId = true, index = true, unique = true)
    private int nbId;
    @DatabaseField
    private String nbl_id;
    @DatabaseField
    private int online;
    @DatabaseField
    private String package_url;
    @DatabaseField
    private String patch;
    @DatabaseField
    private String release_type;
    @DatabaseField
    private Long size;
    @DatabaseField
    private String sub_url;
    @DatabaseField
    private String system_max;
    @DatabaseField
    private String system_min;
    @DatabaseField
    private String third_platform;
    @DatabaseField
    private String update_app_time;
    @DatabaseField
    private String version;
    @DatabaseField
    private String vhost;

    public String getNbl_id() {
        return this.nbl_id;
    }

    public void setNbl_id(String str) {
        this.nbl_id = str;
    }

    public String getNbAppType() {
        return this.nbAppType;
    }

    public void setNbAppType(String str) {
        this.nbAppType = str;
    }

    public int getLocalReport() {
        return this.localReport;
    }

    public void setLocalReport(int i2) {
        this.localReport = i2;
    }

    public String getRelease_type() {
        return this.release_type;
    }

    public void setRelease_type(String str) {
        this.release_type = str;
    }

    public int getApp_channel() {
        return this.app_channel;
    }

    public void setApp_channel(int i2) {
        this.app_channel = i2;
    }

    public int getApp_type() {
        return this.app_type;
    }

    public void setApp_type(int i2) {
        this.app_type = i2;
    }

    public String getThird_platform() {
        return this.third_platform;
    }

    public void setThird_platform(String str) {
        this.third_platform = str;
    }

    public int getIs_limit() {
        return this.is_limit;
    }

    public void setIs_limit(int i2) {
        this.is_limit = i2;
    }

    public int getIs_mapping() {
        return this.is_mapping;
    }

    public void setIs_mapping(int i2) {
        this.is_mapping = i2;
    }

    public String getUpdate_app_time() {
        return this.update_app_time;
    }

    public void setUpdate_app_time(String str) {
        this.update_app_time = str;
    }

    public String getVersion() {
        return this.version;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

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
