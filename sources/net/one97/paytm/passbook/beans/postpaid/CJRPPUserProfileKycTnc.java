package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPUserProfileKycTnc extends IJRDataModel {
    @c(a = "accounts")
    private CJRPPAccount[] accounts;
    @c(a = "isInvited")
    private String isInvited;
    @c(a = "kycDetails")
    private CJRPPKycDetails kycDetails;
    @c(a = "kycTnc")
    private CJRPPKycTnc[] kycTnc;
    private CJRPPKycTnc kycTncData;

    public final String isInvited() {
        return this.isInvited;
    }

    public final void setInvited(String str) {
        this.isInvited = str;
    }

    public final CJRPPAccount[] getAccounts() {
        return this.accounts;
    }

    public final void setAccounts(CJRPPAccount[] cJRPPAccountArr) {
        this.accounts = cJRPPAccountArr;
    }

    public final CJRPPKycTnc[] getKycTnc() {
        return this.kycTnc;
    }

    public final void setKycTnc(CJRPPKycTnc[] cJRPPKycTncArr) {
        this.kycTnc = cJRPPKycTncArr;
    }

    public final CJRPPKycTnc getKycTncData() {
        return this.kycTncData;
    }

    public final void setKycTncData(CJRPPKycTnc cJRPPKycTnc) {
        this.kycTncData = cJRPPKycTnc;
    }

    public final CJRPPKycDetails getKycDetails() {
        return this.kycDetails;
    }

    public final void setKycDetails(CJRPPKycDetails cJRPPKycDetails) {
        this.kycDetails = cJRPPKycDetails;
    }
}
