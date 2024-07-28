package net.one97.paytm.nativesdk.walletOtp;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class WalletOtpResponse {
    @c(a = "body")
    private final Body body;
    @c(a = "head")
    private final Head head;

    public WalletOtpResponse() {
        this((Head) null, (Body) null, 3, (g) null);
    }

    public static /* synthetic */ WalletOtpResponse copy$default(WalletOtpResponse walletOtpResponse, Head head2, Body body2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            head2 = walletOtpResponse.head;
        }
        if ((i2 & 2) != 0) {
            body2 = walletOtpResponse.body;
        }
        return walletOtpResponse.copy(head2, body2);
    }

    public final Head component1() {
        return this.head;
    }

    public final Body component2() {
        return this.body;
    }

    public final WalletOtpResponse copy(Head head2, Body body2) {
        return new WalletOtpResponse(head2, body2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletOtpResponse)) {
            return false;
        }
        WalletOtpResponse walletOtpResponse = (WalletOtpResponse) obj;
        return k.a((Object) this.head, (Object) walletOtpResponse.head) && k.a((Object) this.body, (Object) walletOtpResponse.body);
    }

    public final int hashCode() {
        Head head2 = this.head;
        int i2 = 0;
        int hashCode = (head2 != null ? head2.hashCode() : 0) * 31;
        Body body2 = this.body;
        if (body2 != null) {
            i2 = body2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "WalletOtpResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public WalletOtpResponse(Head head2, Body body2) {
        this.head = head2;
        this.body = body2;
    }

    public final Head getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletOtpResponse(Head head2, Body body2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : head2, (i2 & 2) != 0 ? null : body2);
    }

    public final Body getBody() {
        return this.body;
    }
}
