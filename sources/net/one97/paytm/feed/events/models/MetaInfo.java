package net.one97.paytm.feed.events.models;

public class MetaInfo {
    private String app_version;
    private Integer dev_batt_perct;
    private boolean dev_is_charging;
    private String dev_motion_state;
    private String dev_netwk_bw;
    private String dev_netwk_type;
    private String deviceId;
    private String latitude;
    private String longitude;
    private String model_version;
    private String sessionId;

    public String getModel_version() {
        return this.model_version;
    }

    public void setModel_version(String str) {
        this.model_version = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public Integer getDev_batt_perct() {
        return this.dev_batt_perct;
    }

    public void setDev_batt_perct(Integer num) {
        this.dev_batt_perct = num;
    }

    public String getDev_netwk_type() {
        return this.dev_netwk_type;
    }

    public void setDev_netwk_type(String str) {
        this.dev_netwk_type = str;
    }

    public String getDev_netwk_bw() {
        return this.dev_netwk_bw;
    }

    public void setDev_netwk_bw(String str) {
        this.dev_netwk_bw = str;
    }

    public String getDev_motion_state() {
        return this.dev_motion_state;
    }

    public void setDev_motion_state(String str) {
        this.dev_motion_state = str;
    }

    public boolean getDev_is_charging() {
        return this.dev_is_charging;
    }

    public void setDev_is_charging(boolean z) {
        this.dev_is_charging = z;
    }

    public MetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z) {
        setModel_version(str);
        setSessionId(str2);
        setDeviceId(str3);
        setApp_version(str4);
        setLatitude(str5);
        setLongitude(str6);
        setDev_batt_perct(num);
        setDev_netwk_type(str7);
        setDev_netwk_bw(str8);
        setDev_motion_state(str9);
        setDev_is_charging(z);
    }
}
