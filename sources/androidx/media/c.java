package androidx.media;

import java.util.Arrays;

final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f3830a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f3831b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f3832c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f3833d = -1;

    c() {
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3831b), Integer.valueOf(this.f3832c), Integer.valueOf(this.f3830a), Integer.valueOf(this.f3833d)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f3831b == cVar.f3831b) {
            int i2 = this.f3832c;
            int i3 = cVar.f3832c;
            int i4 = cVar.f3833d;
            if (i4 == -1) {
                i4 = AudioAttributesCompat.a(i3, cVar.f3830a);
            }
            if (i4 == 6) {
                i3 |= 4;
            } else if (i4 == 7) {
                i3 |= 1;
            }
            if (i2 == (i3 & 273) && this.f3830a == cVar.f3830a && this.f3833d == cVar.f3833d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3833d != -1) {
            sb.append(" stream=");
            sb.append(this.f3833d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f3830a));
        sb.append(" content=");
        sb.append(this.f3831b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3832c).toUpperCase());
        return sb.toString();
    }
}
