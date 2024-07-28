package net.one97.paytm.nativesdk.transactionsummary.model;

import androidx.databinding.a;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public final class TxnSummaryResponse extends a implements IJRDataModel {
    private final Body body;
    private final Head head;

    public static /* synthetic */ TxnSummaryResponse copy$default(TxnSummaryResponse txnSummaryResponse, Body body2, Head head2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            body2 = txnSummaryResponse.body;
        }
        if ((i2 & 2) != 0) {
            head2 = txnSummaryResponse.head;
        }
        return txnSummaryResponse.copy(body2, head2);
    }

    public final Body component1() {
        return this.body;
    }

    public final Head component2() {
        return this.head;
    }

    public final TxnSummaryResponse copy(Body body2, Head head2) {
        return new TxnSummaryResponse(body2, head2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TxnSummaryResponse)) {
            return false;
        }
        TxnSummaryResponse txnSummaryResponse = (TxnSummaryResponse) obj;
        return k.a((Object) this.body, (Object) txnSummaryResponse.body) && k.a((Object) this.head, (Object) txnSummaryResponse.head);
    }

    public final int hashCode() {
        Body body2 = this.body;
        int i2 = 0;
        int hashCode = (body2 != null ? body2.hashCode() : 0) * 31;
        Head head2 = this.head;
        if (head2 != null) {
            i2 = head2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TxnSummaryResponse(body=" + this.body + ", head=" + this.head + ")";
    }

    public final Body getBody() {
        return this.body;
    }

    public final Head getHead() {
        return this.head;
    }

    public TxnSummaryResponse(Body body2, Head head2) {
        this.body = body2;
        this.head = head2;
    }
}
