package net.one97.paytm.acceptPayment.webview;

import kotlin.g.b.k;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f52223a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof d) && k.a(this.f52223a, ((d) obj).f52223a);
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f52223a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "OnFinish(data=" + this.f52223a + ")";
    }

    private d() {
        super((byte) 0);
        this.f52223a = null;
    }

    public /* synthetic */ d(byte b2) {
        this();
    }
}
