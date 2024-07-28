package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ChequeBookSignature extends IJRPaytmDataModel {
    @b(a = "remarks")
    private String remark;
    @b(a = "status")
    private String status;

    public ChequeBookSignature() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ ChequeBookSignature copy$default(ChequeBookSignature chequeBookSignature, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chequeBookSignature.status;
        }
        if ((i2 & 2) != 0) {
            str2 = chequeBookSignature.remark;
        }
        return chequeBookSignature.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.remark;
    }

    public final ChequeBookSignature copy(String str, String str2) {
        return new ChequeBookSignature(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChequeBookSignature)) {
            return false;
        }
        ChequeBookSignature chequeBookSignature = (ChequeBookSignature) obj;
        return k.a((Object) this.status, (Object) chequeBookSignature.status) && k.a((Object) this.remark, (Object) chequeBookSignature.remark);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.remark;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ChequeBookSignature(status=" + this.status + ", remark=" + this.remark + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChequeBookSignature(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public ChequeBookSignature(String str, String str2) {
        this.status = str;
        this.remark = str2;
    }
}
