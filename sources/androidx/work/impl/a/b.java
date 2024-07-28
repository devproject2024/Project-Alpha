package androidx.work.impl.a;

import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5116a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5117b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5118c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5119d;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5116a = z;
        this.f5117b = z2;
        this.f5118c = z3;
        this.f5119d = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5116a == bVar.f5116a && this.f5117b == bVar.f5117b && this.f5118c == bVar.f5118c && this.f5119d == bVar.f5119d;
    }

    public final int hashCode() {
        int i2 = this.f5116a ? 1 : 0;
        if (this.f5117b) {
            i2 += 16;
        }
        if (this.f5118c) {
            i2 += UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        }
        return this.f5119d ? i2 + 4096 : i2;
    }

    public final String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f5116a), Boolean.valueOf(this.f5117b), Boolean.valueOf(this.f5118c), Boolean.valueOf(this.f5119d)});
    }
}
