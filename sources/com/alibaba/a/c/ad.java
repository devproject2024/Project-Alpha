package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class ad implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static ad f6263a = new ad();

    public final int a() {
        return 2;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.a(16);
            return null;
        } else if (g2.a() == 2) {
            int n = g2.n();
            g2.a(16);
            return Integer.valueOf(n);
        } else if (g2.a() != 3) {
            return g.m(bVar.a((Object) null));
        } else {
            BigDecimal k = g2.k();
            g2.a(16);
            return Integer.valueOf(k.intValue());
        }
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        Number number = (Number) obj;
        if (number != null) {
            baVar.a(number.intValue());
            if (ahVar.b(bb.WriteClassName)) {
                Class<?> cls = number.getClass();
                if (cls == Byte.class) {
                    baVar.a('B');
                } else if (cls == Short.class) {
                    baVar.a('S');
                }
            }
        } else if (baVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }
}
