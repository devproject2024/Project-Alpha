package net.one97.paytm.passbook.mapping.a;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public NetworkCustomError f57879a;

    /* renamed from: b  reason: collision with root package name */
    private int f57880b;

    /* renamed from: c  reason: collision with root package name */
    private T f57881c;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (!(this.f57880b == dVar.f57880b) || !k.a((Object) this.f57881c, (Object) dVar.f57881c) || !k.a((Object) this.f57879a, (Object) dVar.f57879a)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f57880b * 31;
        T t = this.f57881c;
        int i3 = 0;
        int hashCode = (i2 + (t != null ? t.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f57879a;
        if (networkCustomError != null) {
            i3 = networkCustomError.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "Error(statusCode=" + this.f57880b + ", ijrDataModel=" + this.f57881c + ", networkCustomError=" + this.f57879a + ")";
    }

    public d(int i2, T t, NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "networkCustomError");
        this.f57880b = i2;
        this.f57881c = t;
        this.f57879a = networkCustomError;
    }
}
