package com.google.zxing.a.c;

import com.google.zxing.b.a;
import com.j256.ormlite.stmt.query.SimpleComparison;

final class b extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f39861c;

    /* renamed from: d  reason: collision with root package name */
    private final short f39862d;

    b(g gVar, int i2, int i3) {
        super(gVar);
        this.f39861c = (short) i2;
        this.f39862d = (short) i3;
    }

    public final void a(a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f39862d;
            if (i2 < s) {
                if (i2 == 0 || (i2 == 31 && s <= 62)) {
                    aVar.b(31, 5);
                    short s2 = this.f39862d;
                    if (s2 > 62) {
                        aVar.b(s2 - 31, 16);
                    } else if (i2 == 0) {
                        aVar.b(Math.min(s2, 31), 5);
                    } else {
                        aVar.b(s2 - 31, 5);
                    }
                }
                aVar.b(bArr[this.f39861c + i2], 8);
                i2++;
            } else {
                return;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(this.f39861c);
        sb.append("::");
        sb.append((this.f39861c + this.f39862d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
