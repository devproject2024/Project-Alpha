package net.one97.paytm.passbook.beans;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SAHistoryTransactionHeader {
    private String txnDate;

    public SAHistoryTransactionHeader() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ SAHistoryTransactionHeader copy$default(SAHistoryTransactionHeader sAHistoryTransactionHeader, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sAHistoryTransactionHeader.txnDate;
        }
        return sAHistoryTransactionHeader.copy(str);
    }

    public final String component1() {
        return this.txnDate;
    }

    public final SAHistoryTransactionHeader copy(String str) {
        return new SAHistoryTransactionHeader(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SAHistoryTransactionHeader) && k.a((Object) this.txnDate, (Object) ((SAHistoryTransactionHeader) obj).txnDate);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.txnDate;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SAHistoryTransactionHeader(txnDate=" + this.txnDate + ")";
    }

    public SAHistoryTransactionHeader(String str) {
        this.txnDate = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SAHistoryTransactionHeader(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getTxnDate() {
        return this.txnDate;
    }

    public final void setTxnDate(String str) {
        this.txnDate = str;
    }
}
