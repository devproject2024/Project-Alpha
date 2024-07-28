package net.one97.paytm.passbook.beans.userinfov2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRUserInfoV2 extends IJRDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private int mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "defaultInfo")
    private CJRUserDefaultInfo mUserDefaultInfo;
    @b(a = "userId")
    private String mUserId;

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(int i2) {
        this.mResponseCode = i2;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public CJRUserDefaultInfo getUserDefaultInfo() {
        return this.mUserDefaultInfo;
    }

    public void setUserDefaultInfo(CJRUserDefaultInfo cJRUserDefaultInfo) {
        this.mUserDefaultInfo = cJRUserDefaultInfo;
    }
}
