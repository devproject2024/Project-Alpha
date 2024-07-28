package net.one97.paytm.passbook.beans;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PaymentHistoryTransactionHeader {
    private String txnDate;

    public PaymentHistoryTransactionHeader() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ PaymentHistoryTransactionHeader copy$default(PaymentHistoryTransactionHeader paymentHistoryTransactionHeader, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentHistoryTransactionHeader.txnDate;
        }
        return paymentHistoryTransactionHeader.copy(str);
    }

    public final String component1() {
        return this.txnDate;
    }

    public final PaymentHistoryTransactionHeader copy(String str) {
        return new PaymentHistoryTransactionHeader(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PaymentHistoryTransactionHeader) && k.a((Object) this.txnDate, (Object) ((PaymentHistoryTransactionHeader) obj).txnDate);
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
        return "PaymentHistoryTransactionHeader(txnDate=" + this.txnDate + ")";
    }

    public PaymentHistoryTransactionHeader(String str) {
        this.txnDate = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentHistoryTransactionHeader(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getTxnDate() {
        return this.txnDate;
    }

    public final void setTxnDate(String str) {
        this.txnDate = str;
    }
}
