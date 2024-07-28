package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TxnDate {
    private String date;

    public TxnDate() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ TxnDate copy$default(TxnDate txnDate, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = txnDate.date;
        }
        return txnDate.copy(str);
    }

    public final String component1() {
        return this.date;
    }

    public final TxnDate copy(String str) {
        return new TxnDate(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TxnDate) && k.a((Object) this.date, (Object) ((TxnDate) obj).date);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.date;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "TxnDate(date=" + this.date + ")";
    }

    public TxnDate(String str) {
        this.date = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TxnDate(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }
}
