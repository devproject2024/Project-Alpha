package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;
import com.google.zxing.h;
import com.google.zxing.m;

final class d extends h {
    d(a aVar) {
        super(aVar);
    }

    public final String a() throws m, h {
        if (this.f40318a.f39881b >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int a2 = this.f40319b.a(48, 2);
            sb.append("(393");
            sb.append(a2);
            sb.append(')');
            int a3 = this.f40319b.a(50, 10);
            if (a3 / 100 == 0) {
                sb.append('0');
            }
            if (a3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a3);
            sb.append(this.f40319b.a(60, (String) null).f40325a);
            return sb.toString();
        }
        throw m.getNotFoundInstance();
    }
}
