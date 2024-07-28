package net.one97.paytm.autoaddmoney.b;

import android.os.Bundle;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f49163a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f49164b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Exception f49165c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.a((Object) this.f49163a, (Object) fVar.f49163a) && k.a((Object) this.f49164b, (Object) fVar.f49164b) && k.a((Object) this.f49165c, (Object) fVar.f49165c);
    }

    public final int hashCode() {
        String str = this.f49163a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Bundle bundle = this.f49164b;
        int hashCode2 = (hashCode + (bundle != null ? bundle.hashCode() : 0)) * 31;
        Exception exc = this.f49165c;
        if (exc != null) {
            i2 = exc.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SessionTimeOutWrapper(className=" + this.f49163a + ", bundle=" + this.f49164b + ", exception=" + this.f49165c + ")";
    }

    public f(String str, Exception exc) {
        k.c(str, "className");
        k.c(exc, "exception");
        this.f49163a = str;
        this.f49165c = exc;
    }
}
