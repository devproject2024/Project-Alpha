package net.one97.paytm.common.entity.upgradeKyc;

import net.one97.paytm.common.entity.IJRDataModel;

public class KycUserSaveResponse implements IJRDataModel {
    private String errorMsg;
    private KycUserDetails kycUserDetails;
    private int statusCode;
    private String successMsg;
    private String uniqueReference;

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getSuccessMsg() {
        return this.successMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getUniqueReference() {
        return this.uniqueReference;
    }

    public void setUniqueReference(String str) {
        this.uniqueReference = str;
    }

    public KycUserDetails getKycUserDetails() {
        return this.kycUserDetails;
    }

    public void setKycUserDetails(KycUserDetails kycUserDetails2) {
        this.kycUserDetails = kycUserDetails2;
    }
}
