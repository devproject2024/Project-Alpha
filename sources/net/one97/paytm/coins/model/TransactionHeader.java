package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TransactionHeader extends LoyaltyModel {
    @b(a = "txnDate")
    private String txnDate;

    public TransactionHeader() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ TransactionHeader copy$default(TransactionHeader transactionHeader, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = transactionHeader.getTxnDate();
        }
        return transactionHeader.copy(str);
    }

    public final String component1() {
        return getTxnDate();
    }

    public final TransactionHeader copy(String str) {
        return new TransactionHeader(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TransactionHeader) && k.a((Object) getTxnDate(), (Object) ((TransactionHeader) obj).getTxnDate());
        }
        return true;
    }

    public final int hashCode() {
        String txnDate2 = getTxnDate();
        if (txnDate2 != null) {
            return txnDate2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "TransactionHeader(txnDate=" + getTxnDate() + ")";
    }

    public TransactionHeader(String str) {
        super((String) null, (String) null, (String) null, (String) null, (ExtendedInfoModel) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (g) null);
        this.txnDate = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransactionHeader(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getTxnDate() {
        return this.txnDate;
    }

    public final void setTxnDate(String str) {
        this.txnDate = str;
    }
}
