package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class b {
    @c(a = "details")

    /* renamed from: a  reason: collision with root package name */
    public final a f67154a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && k.a((Object) this.f67154a, (Object) ((b) obj).f67154a);
        }
        return true;
    }

    public final int hashCode() {
        a aVar = this.f67154a;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "MobileAppData(details=" + this.f67154a + ")";
    }
}
