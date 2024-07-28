package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class KYCStatus implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "isKycUnderProcess")
    private String isKycUnderProcess;
    @b(a = "is_verified_email")
    private int isVerifiedEmail;
    @b(a = "is_verified_mobile")
    private int isVerifiedMobile;
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;
    @b(a = "walletType")
    private String walletType;

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public int getIsVerifiedEmail() {
        return this.isVerifiedEmail;
    }

    public int getIsVerifiedMobile() {
        return this.isVerifiedMobile;
    }

    public String getWalletType() {
        return this.walletType;
    }

    public String getIsKycUnderProcess() {
        return this.isKycUnderProcess;
    }
}
