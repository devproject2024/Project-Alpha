package net.one97.paytm.passbook.beans;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class BaseUpiResponse extends IJRDataModel {
    @c(a = "BankRRN")
    private String bankRRN;
    @c(a = "message")
    private String message;
    @c(a = "MobileAppData")
    private Object mobileAppData;
    @c(a = "response")
    private String response;
    @c(a = "SeqNo")
    private String seqNo;
    @c(a = "success")
    private boolean success;
    @c(a = "UpiTranlogId")
    private String upiTranlogId;
    @c(a = "UserProfile")
    private String userProfile;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getBankRRN() {
        return this.bankRRN;
    }

    public void setBankRRN(String str) {
        this.bankRRN = str;
    }

    public String getUpiTranlogId() {
        return this.upiTranlogId;
    }

    public void setUpiTranlogId(String str) {
        this.upiTranlogId = str;
    }

    public String getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(String str) {
        this.userProfile = str;
    }

    public String getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(String str) {
        this.seqNo = str;
    }

    public Object getMobileAppData() {
        return this.mobileAppData;
    }

    public void setMobileAppData(Object obj) {
        this.mobileAppData = obj;
    }
}
