package net.one97.paytm.passbook.beans;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRAddress extends IJRDataModel {
    public static final String RESPONSE_STATUS_FAILURE = "Failure";
    private static final long serialVersionUID = 1;
    @c(a = "areaName")
    private String areaName;
    @c(a = "areaType")
    private String areaType;
    @c(a = "id_str")
    private String idStr;
    @c(a = "location")
    private CJRLocation location;
    @c(a = "address1")
    private String mAddress1;
    @c(a = "address2")
    private String mAddress2;
    @c(a = "id")
    private String mAddressId;
    @c(a = "city")
    private String mCity;
    @c(a = "country")
    private String mCountry;
    @c(a = "ERROR")
    private String mError;
    @c(a = "fulladdress")
    private String mFulladdress;
    private boolean mIsChecked;
    @c(a = "isDeleted")
    private boolean mIsDeleted;
    @c(a = "message")
    private String mMessage;
    @c(a = "mobile")
    private String mMobile;
    @c(a = "name")
    private String mName;
    @c(a = "pin")
    private String mPin;
    @c(a = "priority")
    private int mPriority;
    @c(a = "responseCode")
    private String mResponseCode;
    @c(a = "state")
    private String mState;
    @c(a = "status")
    private String mStatus;
    @c(a = "title")
    private String mTitle;
    @c(a = "type")
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
