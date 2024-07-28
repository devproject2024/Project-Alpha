package net.one97.paytm.phoenix.d;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f59536a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f59537b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (k.a((Object) this.f59536a, (Object) bVar.f59536a)) {
                    if (this.f59537b == bVar.f59537b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f59536a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.f59537b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "ErrorCallback(callbackId=" + this.f59536a + ", keepCallback=" + this.f59537b + ")";
    }

    public b(String str, boolean z) {
        this.f59536a = str;
        this.f59537b = z;
    }
}
