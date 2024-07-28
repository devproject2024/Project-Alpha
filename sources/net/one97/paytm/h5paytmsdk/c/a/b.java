package net.one97.paytm.h5paytmsdk.c.a;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final boolean f17074a;

    /* renamed from: b  reason: collision with root package name */
    final a f17075b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!(this.f17074a == bVar.f17074a) || !k.a((Object) this.f17075b, (Object) bVar.f17075b)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.f17074a;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        a aVar = this.f17075b;
        return i2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public final String toString() {
        return "FileDownloadResult(success=" + this.f17074a + ", error=" + this.f17075b + ")";
    }

    public b(boolean z, a aVar) {
        this.f17074a = z;
        this.f17075b = aVar;
    }
}
