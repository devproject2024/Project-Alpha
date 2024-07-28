package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SAHistoryPagination extends IJRDataModel {
    @b(a = "lastTxnId")
    private String lastTxnId;
    @b(a = "transactionDateEpoch")
    private String transactionDateEpoch;

    public SAHistoryPagination() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ SAHistoryPagination copy$default(SAHistoryPagination sAHistoryPagination, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sAHistoryPagination.transactionDateEpoch;
        }
        if ((i2 & 2) != 0) {
            str2 = sAHistoryPagination.lastTxnId;
        }
        return sAHistoryPagination.copy(str, str2);
    }

    public final String component1() {
        return this.transactionDateEpoch;
    }

    public final String component2() {
        return this.lastTxnId;
    }

    public final SAHistoryPagination copy(String str, String str2) {
        return new SAHistoryPagination(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAHistoryPagination)) {
            return false;
        }
        SAHistoryPagination sAHistoryPagination = (SAHistoryPagination) obj;
        return k.a((Object) this.transactionDateEpoch, (Object) sAHistoryPagination.transactionDateEpoch) && k.a((Object) this.lastTxnId, (Object) sAHistoryPagination.lastTxnId);
    }

    public final int hashCode() {
        String str = this.transactionDateEpoch;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lastTxnId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SAHistoryPagination(transactionDateEpoch=" + this.transactionDateEpoch + ", lastTxnId=" + this.lastTxnId + ")";
    }

    public final String getTransactionDateEpoch() {
        return this.transactionDateEpoch;
    }

    public final void setTransactionDateEpoch(String str) {
        this.transactionDateEpoch = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SAHistoryPagination(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getLastTxnId() {
        return this.lastTxnId;
    }

    public final void setLastTxnId(String str) {
        this.lastTxnId = str;
    }

    public SAHistoryPagination(String str, String str2) {
        this.transactionDateEpoch = str;
        this.lastTxnId = str2;
    }
}
