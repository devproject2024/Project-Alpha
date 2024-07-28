package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class KYCStatusV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean aadharVerified;
    @b(a = "expiryType")
    private String expiryType;
    public String failSafeKey = "";
    @b(a = "form60")
    private boolean isForm60;
    @b(a = "isKycDone")
    private int isKycDone = -1;
    @b(a = "isExpired")
    private int isKycExpired = 0;
    @b(a = "minorKyc")
    private String isMinor;
    @b(a = "panVerified")
    private String isPanVerified;
    private String iv;
    private String key;
    @b(a = "eligibility")
    private KycEligibility kycEligibility;
    @b(a = "kycExpiryTime")
    private String kycExpiryTime;
    @b(a = "kycType")
    private String kycType;
    @b(a = "message")
    private String message;
    @b(a = "minKyc")
    private boolean minKycStatus;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;

    public boolean isForm60() {
        return this.isForm60;
    }

    public void setForm60(boolean z) {
        this.isForm60 = z;
    }

    public String getIsPanVerified() {
        return this.isPanVerified;
    }

    public void setIsPanVerified(String str) {
        this.isPanVerified = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getIv() {
        return this.iv;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public int getIsKycDone() {
        return this.isKycDone;
    }

    public String getKycType() {
        return this.kycType;
    }

    public boolean isMinKycStatus() {
        return this.minKycStatus;
    }

    public void setFailSafeSystemKey(String str) {
        this.failSafeKey = str;
    }

    public String getFailSafeKey() {
        return this.failSafeKey;
    }

    public boolean isAadharVerified() {
        return this.aadharVerified;
    }

    public void setAadharVerified(boolean z) {
        this.aadharVerified = z;
    }

    public int isKycExpired() {
        return this.isKycExpired;
    }

    public void setIsKycExpired(int i2) {
        this.isKycExpired = i2;
    }

    public String getKycExpiryTime() {
        return this.kycExpiryTime;
    }

    public void setKycExpiryTime(String str) {
        this.kycExpiryTime = str;
    }

    public String getIsMinor() {
        return this.isMinor;
    }

    public void setIsMinor(String str) {
        this.isMinor = str;
    }

    public String getExpiryType() {
        return this.expiryType;
    }

    public void setExpiryType(String str) {
        this.expiryType = str;
    }

    public boolean isMinKycEligible() {
        KycEligibility kycEligibility2 = this.kycEligibility;
        if (kycEligibility2 != null) {
            return kycEligibility2.isMinKycEligible();
        }
        return false;
    }

    public static class KycEligibility implements IJRDataModel {
        @b(a = "fullKycEligible")
        private boolean fullKycEligible;
        @b(a = "minKycEligible")
        private boolean minKycEligible;

        public boolean isMinKycEligible() {
            return this.minKycEligible;
        }

        public void setMinKycEligible(boolean z) {
            this.minKycEligible = z;
        }

        public boolean isFullKycEligible() {
            return this.fullKycEligible;
        }

        public void setFullKycEligible(boolean z) {
            this.fullKycEligible = z;
        }
    }
}
