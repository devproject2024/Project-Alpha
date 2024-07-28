package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;

abstract class h extends j {
    h(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        a(sb, i2, length);
    }

    private static void a(StringBuilder sb, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 13; i5++) {
            int charAt = sb.charAt(i5 + i2) - '0';
            if ((i5 & 1) == 0) {
                charAt *= 3;
            }
            i4 += charAt;
        }
        int i6 = 10 - (i4 % 10);
        if (i6 != 10) {
            i3 = i6;
        }
        sb.append(i3);
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int a2 = this.f40319b.a((i4 * 10) + i2, 10);
            if (a2 / 100 == 0) {
                sb.append('0');
            }
            if (a2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a2);
        }
        a(sb, i3);
    }
}
