package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import org.parceler.Parcel;

@Parcel
public class BaseRequest {
    @c(a = "appVersion")
    @a
    private String appVersion;
    @c(a = "cloudMessagingId")
    @a
    private String cloudMessagingId;
    @c(a = "deviceUniqueId")
    @a
    private String deviceUniqueId;
    @c(a = "last_screen_name")
    @a
    private String lastScreenName;
    @c(a = "lat")
    @a
    private Double lattitude;
    @c(a = "long")
    @a
    private Double longitude;
    @c(a = "page_no")
    @a
    private int pageNo = 1;
    @c(a = "page_size")
    @a
    private int pageSize = 10;
    @c(a = "screen_name")
    @a
    private String screenName;
    @c(a = "source")
    @a
    private String source = "android";
    @c(a = "test_user_type")
    @a
    private String testUserType = AppConstants.orgUserType;

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getCloudMessagingId() {
        return this.cloudMessagingId;
    }

    public void setCloudMessagingId(String str) {
        this.cloudMessagingId = str;
    }

    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }

    public String getLastScreenName() {
        return this.lastScreenName;
    }

    public void setLastScreenName(String str) {
        this.lastScreenName = str;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int i2) {
        this.pageNo = i2;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public Double getLattitude() {
        return this.lattitude;
    }

    public void setLattitude(Double d2) {
        this.lattitude = d2;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d2) {
        this.longitude = d2;
    }

    public String getTestUserType() {
        return this.testUserType;
    }

    public void setTestUserType(String str) {
        this.testUserType = str;
    }
}
