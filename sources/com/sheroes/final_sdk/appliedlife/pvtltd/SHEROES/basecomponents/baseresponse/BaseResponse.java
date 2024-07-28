package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse;

import com.google.gson.a.c;
import java.util.HashMap;
import org.parceler.Parcel;

@Parcel
public class BaseResponse {
    @c(a = "fieldErrorMessageMap")
    private HashMap<String, String> fieldErrorMessageMap;
    @c(a = "numFound")
    private int numFound;
    @c(a = "screen_name")
    private String screenName;
    @c(a = "start")
    private int start;
    @c(a = "status")
    private String status;

    public HashMap<String, String> getFieldErrorMessageMap() {
        return this.fieldErrorMessageMap;
    }

    public void setFieldErrorMessageMap(HashMap<String, String> hashMap) {
        this.fieldErrorMessageMap = hashMap;
    }

    public int getNumFound() {
        return this.numFound;
    }

    public void setNumFound(int i2) {
        this.numFound = i2;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i2) {
        this.start = i2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }
}
