package net.one97.paytm.fastscanner.b;

import kotlin.g.b.k;
import kotlin.u;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public String f50433a;

    /* renamed from: b  reason: collision with root package name */
    private int f50434b;

    /* renamed from: c  reason: collision with root package name */
    private int f50435c;

    public final String toString() {
        return "QRData(qrId=" + this.f50433a + ", scannedBy=" + this.f50434b + ", source=" + this.f50435c + ")";
    }

    public e(String str, int i2, int i3) {
        k.c(str, "qrId");
        this.f50433a = str;
        this.f50434b = i2;
        this.f50435c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.fastscanner.camera_utility.QRData");
        } else if (k.a((Object) this.f50433a, (Object) ((e) obj).f50433a)) {
            return true;
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return this.f50433a.hashCode();
    }
}
