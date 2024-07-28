package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ChequeDetail implements IJRDataModel {
    @b(a = "accountNumber")
    private String acntNumber;
    @b(a = "number")
    private String chqNumber;
    @b(a = "id")
    private int id;
    @b(a = "status")
    private String status;
    @b(a = "updatedAt")
    private String updatedAt;

    public static /* synthetic */ ChequeDetail copy$default(ChequeDetail chequeDetail, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = chequeDetail.id;
        }
        if ((i3 & 2) != 0) {
            str = chequeDetail.acntNumber;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = chequeDetail.chqNumber;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            str3 = chequeDetail.status;
        }
        String str7 = str3;
        if ((i3 & 16) != 0) {
            str4 = chequeDetail.updatedAt;
        }
        return chequeDetail.copy(i2, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.acntNumber;
    }

    public final String component3() {
        return this.chqNumber;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.updatedAt;
    }

    public final ChequeDetail copy(int i2, String str, String str2, String str3, String str4) {
        return new ChequeDetail(i2, str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ChequeDetail) {
                ChequeDetail chequeDetail = (ChequeDetail) obj;
                if (!(this.id == chequeDetail.id) || !k.a((Object) this.acntNumber, (Object) chequeDetail.acntNumber) || !k.a((Object) this.chqNumber, (Object) chequeDetail.chqNumber) || !k.a((Object) this.status, (Object) chequeDetail.status) || !k.a((Object) this.updatedAt, (Object) chequeDetail.updatedAt)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.id * 31;
        String str = this.acntNumber;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.chqNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.updatedAt;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return hashCode3 + i3;
    }

    public final String toString() {
        return "ChequeDetail(id=" + this.id + ", acntNumber=" + this.acntNumber + ", chqNumber=" + this.chqNumber + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ")";
    }

    public ChequeDetail(int i2, String str, String str2, String str3, String str4) {
        this.id = i2;
        this.acntNumber = str;
        this.chqNumber = str2;
        this.status = str3;
        this.updatedAt = str4;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final String getAcntNumber() {
        return this.acntNumber;
    }

    public final void setAcntNumber(String str) {
        this.acntNumber = str;
    }

    public final String getChqNumber() {
        return this.chqNumber;
    }

    public final void setChqNumber(String str) {
        this.chqNumber = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChequeDetail(int i2, String str, String str2, String str3, String str4, int i3, g gVar) {
        this(i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4);
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(String str) {
        this.updatedAt = str;
    }
}
