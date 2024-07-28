package net.one97.paytm.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.postpaid.CJRPPKycDetails;
import net.one97.paytm.common.entity.postpaid.CJRPPKycTnc;

public final class CJRPPUserProfileKycTnc extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accounts")
    private CJRPPAccount[] accounts;
    @b(a = "isInvited")
    private String isInvited;
    @b(a = "kycDetails")
    private CJRPPKycDetails kycDetails;
    @b(a = "kycTnc")
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
