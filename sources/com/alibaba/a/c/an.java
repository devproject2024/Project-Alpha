package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;

public final class an implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static an f6282a = new an();

    public final int a() {
        return 2;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 2) {
            long s = g2.s();
            g2.a(16);
            return Long.valueOf(s);
        }
        Object a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        return g.l(a2);
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            baVar.a(longValue);
            if (ahVar.b(bb.WriteClassName) && longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                baVar.a('L');
            }
        } else if (baVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }
}
