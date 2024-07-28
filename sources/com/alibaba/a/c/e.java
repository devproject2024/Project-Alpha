package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public final class e implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6318a = new e();

    public final int a() {
        return 2;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            baVar.write(((BigInteger) obj).toString());
        } else if (baVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 2) {
            String u = g2.u();
            g2.a(16);
            return new BigInteger(u);
        }
        Object a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        return g.f(a2);
    }
}
