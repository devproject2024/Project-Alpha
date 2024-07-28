package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class PaytmLoginRequest extends BaseRequest {
    @c(a = "access_token")
    @a
    private String accessToken;
    @c(a = "advertisementid")
    @a
    private String advertisementID;
    @c(a = "customer_id")
    @a
    private String customerId;
    @c(a = "deviceid")
    @a
    private String deviceId;
    @c(a = "devicetype")
    @a
    private String deviceType;
    @c(a = "first_name")
    @a
    private String firstName;
    @c(a = "gcmorapnsid")
    @a
    private String gcmorapnsId = "dasds";
    @c(a = "last_name")
    @a
    private String lastName;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getGcmorapnsId() {
        return this.gcmorapnsId;
    }

    public void setGcmorapnsId(String str) {
        this.gcmorapnsId = str;
    }

    public String getAdvertisementID() {
        return this.advertisementID;
    }

    public void setAdvertisementID(String str) {
        this.advertisementID = str;
    }
}
