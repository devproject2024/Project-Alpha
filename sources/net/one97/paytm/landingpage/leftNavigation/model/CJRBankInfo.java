package net.one97.paytm.landingpage.leftNavigation.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CJRBankInfo extends IJRPaytmDataModel {
    private String accountNo;
    private Integer status;

    public static /* synthetic */ CJRBankInfo copy$default(CJRBankInfo cJRBankInfo, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRBankInfo.status;
        }
        if ((i2 & 2) != 0) {
            str = cJRBankInfo.accountNo;
        }
        return cJRBankInfo.copy(num, str);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.accountNo;
    }

    public final CJRBankInfo copy(Integer num, String str) {
        return new CJRBankInfo(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRBankInfo)) {
            return false;
        }
        CJRBankInfo cJRBankInfo = (CJRBankInfo) obj;
        return k.a((Object) this.status, (Object) cJRBankInfo.status) && k.a((Object) this.accountNo, (Object) cJRBankInfo.accountNo);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.accountNo;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRBankInfo(status=" + this.status + ", accountNo=" + this.accountNo + ")";
    }

    public CJRBankInfo(Integer num, String str) {
        this.status = num;
        this.accountNo = str;
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setAccountNo(String str) {
        this.accountNo = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }
}
