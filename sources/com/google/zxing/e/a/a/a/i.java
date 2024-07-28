package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;

abstract class i extends h {
    /* access modifiers changed from: protected */
    public abstract int a(int i2);

    /* access modifiers changed from: protected */
    public abstract void a(StringBuilder sb, int i2);

    i(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb, int i2, int i3) {
        int a2 = this.f40319b.a(i2, i3);
        a(sb, a2);
        int a3 = a(a2);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (a3 / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(a3);
    }
}
