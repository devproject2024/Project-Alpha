package net.one97.paytm.h5paytmsdk.c.a;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f17072a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17073b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!(this.f17072a == aVar.f17072a) || !k.a((Object) this.f17073b, (Object) aVar.f17073b)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f17072a * 31;
        String str = this.f17073b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FileDownloadError(code=" + this.f17072a + ", message=" + this.f17073b + ")";
    }

    public a(int i2, String str) {
        k.c(str, "message");
        this.f17072a = i2;
        this.f17073b = str;
    }
}
