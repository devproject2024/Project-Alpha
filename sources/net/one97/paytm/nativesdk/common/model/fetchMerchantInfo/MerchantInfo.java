package net.one97.paytm.nativesdk.common.model.fetchMerchantInfo;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class MerchantInfo {
    @c(a = "body")
    private final Body body;
    @c(a = "head")
    private final Head head;

    public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, Body body2, Head head2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            body2 = merchantInfo.body;
        }
        if ((i2 & 2) != 0) {
            head2 = merchantInfo.head;
        }
        return merchantInfo.copy(body2, head2);
    }

    public final Body component1() {
        return this.body;
    }

    public final Head component2() {
        return this.head;
    }

    public final MerchantInfo copy(Body body2, Head head2) {
        return new MerchantInfo(body2, head2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantInfo)) {
            return false;
        }
        MerchantInfo merchantInfo = (MerchantInfo) obj;
        return k.a((Object) this.body, (Object) merchantInfo.body) && k.a((Object) this.head, (Object) merchantInfo.head);
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
        return "MerchantInfo(body=" + this.body + ", head=" + this.head + ")";
    }

    public MerchantInfo(Body body2, Head head2) {
        this.body = body2;
        this.head = head2;
    }

    public final Body getBody() {
        return this.body;
    }

    public final Head getHead() {
        return this.head;
    }
}
