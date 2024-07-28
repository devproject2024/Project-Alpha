package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class LoginRequest extends BaseRequest {
    @c(a = "accees_token")
    @a
    private String accessToken;
    @c(a = "advertisementid")
    @a
    private String advertisementid;
    private String callForSignUp;
    @c(a = "deviceid")
    @a
    private String deviceid;
    @c(a = "devicetype")
    @a
    private String devicetype;
    @c(a = "gcmorapnsid")
    @a
    private String gcmorapnsid;
    @c(a = "password")
    @a
    private String password;
    @c(a = "username")
    @a
    private String username;

    public String getAdvertisementid() {
        return this.advertisementid;
    }

    public void setAdvertisementid(String str) {
        this.advertisementid = str;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }

    public String getDevicetype() {
        return this.devicetype;
    }

    public void setDevicetype(String str) {
        this.devicetype = str;
    }

    public String getGcmorapnsid() {
        return this.gcmorapnsid;
    }

    public void setGcmorapnsid(String str) {
        this.gcmorapnsid = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getCallForSignUp() {
        return this.callForSignUp;
    }

    public void setCallForSignUp(String str) {
        this.callForSignUp = str;
    }
}
