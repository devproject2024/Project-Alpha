package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class d implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final d f6317a = new d();

    public final int a() {
        return 2;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            baVar.write(bigDecimal.toString());
            if (baVar.b(bb.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
                baVar.a('.');
            }
        } else if (baVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        com.alibaba.a.b.d g2 = bVar.g();
        if (g2.a() == 2) {
            long s = g2.s();
            g2.a(16);
            return new BigDecimal(s);
        } else if (g2.a() == 3) {
            T k = g2.k();
            g2.a(16);
            return k;
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            return g.e(a2);
        }
    }
}
