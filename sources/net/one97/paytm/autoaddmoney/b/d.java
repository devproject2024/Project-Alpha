package net.one97.paytm.autoaddmoney.b;

import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f49159a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f49160b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (k.a((Object) this.f49159a, (Object) dVar.f49159a)) {
                    if (this.f49160b == dVar.f49160b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f49159a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.f49160b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "LoaderWrapper(message=" + this.f49159a + ", isShow=" + this.f49160b + ")";
    }

    public d(String str, boolean z) {
        k.c(str, "message");
        this.f49159a = str;
        this.f49160b = z;
    }
}
