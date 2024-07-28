package net.one97.paytm.upi.common.upi;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class ReferralCodeResponse implements UpiBaseDataModel {
    private String code;
    private String message;
    private String referralCode;
    private String referralContent;
    private String referralUrl;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getReferralUrl() {
        return this.referralUrl;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public String getReferralContent() {
        return this.referralContent;
    }
}
