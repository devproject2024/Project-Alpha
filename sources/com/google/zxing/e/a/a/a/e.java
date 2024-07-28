package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;
import com.google.zxing.m;

final class e extends i {

    /* renamed from: c  reason: collision with root package name */
    private final String f40316c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40317d;

    e(a aVar, String str, String str2) {
        super(aVar);
        this.f40316c = str2;
        this.f40317d = str;
    }

    /* access modifiers changed from: protected */
    public final void a(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f40317d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        return i2 % 100000;
    }

    public final String a() throws m {
        if (this.f40318a.f39881b == 84) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            b(sb, 48, 20);
            int a2 = this.f40319b.a(68, 16);
            if (a2 != 38400) {
                sb.append('(');
                sb.append(this.f40316c);
                sb.append(')');
                int i2 = a2 % 32;
                int i3 = a2 / 32;
                int i4 = (i3 % 12) + 1;
                int i5 = i3 / 12;
                if (i5 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i5);
                if (i4 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i4);
                if (i2 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i2);
            }
            return sb.toString();
        }
        throw m.getNotFoundInstance();
    }
}
