package net.one97.paytm.passbook.beans;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PaymentHistoryRootHeader {
    private final String title;

    public PaymentHistoryRootHeader() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ PaymentHistoryRootHeader copy$default(PaymentHistoryRootHeader paymentHistoryRootHeader, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentHistoryRootHeader.title;
        }
        return paymentHistoryRootHeader.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final PaymentHistoryRootHeader copy(String str) {
        return new PaymentHistoryRootHeader(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PaymentHistoryRootHeader) && k.a((Object) this.title, (Object) ((PaymentHistoryRootHeader) obj).title);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.title;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PaymentHistoryRootHeader(title=" + this.title + ")";
    }

    public PaymentHistoryRootHeader(String str) {
        this.title = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentHistoryRootHeader(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getTitle() {
        return this.title;
    }
}
