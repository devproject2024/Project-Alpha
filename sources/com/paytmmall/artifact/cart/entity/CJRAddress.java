package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAddress extends IJRPaytmDataModel {
    public static final String RESPONSE_STATUS_FAILURE = "Failure";
    private static final long serialVersionUID = 1;
    @b(a = "areaName")
    private String areaName;
    @b(a = "areaType")
    private String areaType;
    @b(a = "id_str")
    private String idStr;
    @b(a = "location")
    private CJRLocation location;
    @b(a = "address1")
    private String mAddress1;
    @b(a = "address2")
    private String mAddress2;
    @b(a = "id")
    private String mAddressId;
    @b(a = "city")
    private String mCity;
    @b(a = "country")
    private String mCountry;
    @b(a = "ERROR")
    private String mError;
    @b(a = "fulladdress")
    private String mFulladdress;
    private boolean mIsChecked;
    @b(a = "isDeleted")
    private boolean mIsDeleted;
    @b(a = "message")
    private String mMessage;
    @b(a = "mobile")
    private String mMobile;
    @b(a = "name")
    private String mName;
    @b(a = "pin")
    private String mPin;
    @b(a = "priority")
    private int mPriority;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "state")
    private String mState;
    @b(a = "status")
    private String mStatus;
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String type;

    public String getTitle() {
        return this.mTitle;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    public CJRLocation getLocation() {
        return this.location;
    }

    public void setLocation(CJRLocation cJRLocation) {
        this.location = cJRLocation;
    }

    public String getAreaType() {
        return this.areaType;
    }

    public void setAreaType(String str) {
        this.areaType = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setIdStr(String str) {
        this.idStr = str;
    }

    public String getIdStr() {
        return this.idStr;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getError() {
        return this.mError;
    }

    public String getAddress1() {
        return this.mAddress1;
    }

    public void setAddress1(String str) {
        this.mAddress1 = str;
    }

    public String getAddress2() {
        return this.mAddress2;
    }

    public void setAddress2(String str) {
        this.mAddress2 = str;
    }

    public boolean isDeleted() {
        return this.mIsDeleted;
    }

    public String getId() {
        return this.mAddressId;
    }

    public String getName() {
        return this.mName;
    }

    public String getFulladdress() {
        return this.mFulladdress;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getState() {
        return this.mState;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getPin() {
        return this.mPin;
    }

    public String getMobile() {
        return this.mMobile;
    }

    public void setId(String str) {
        this.mAddressId = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setFulladdress(String str) {
        this.mFulladdress = str;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setCountry(String str) {
        this.mCountry = str;
    }

    public void setPin(String str) {
        this.mPin = str;
    }

    public void setMobile(String str) {
        this.mMobile = str;
    }

    public boolean equals(Object obj) {
        try {
            return this.mAddressId.equals(((CJRAddress) obj).mAddressId);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public void setIsChecked(boolean z) {
        this.mIsChecked = z;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i2) {
        this.mPriority = i2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public boolean getIsDeleted() {
        return this.mIsDeleted;
    }
}
