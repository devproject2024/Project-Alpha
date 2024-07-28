package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import java.io.IOException;
import java.lang.reflect.Type;

public final class g implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final g f6320a = new g();

    public final int a() {
        return 6;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 6) {
            g2.a(16);
            return Boolean.TRUE;
        } else if (g2.a() == 7) {
            g2.a(16);
            return Boolean.FALSE;
        } else if (g2.a() == 2) {
            int n = g2.n();
            g2.a(16);
            if (n == 1) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            return com.alibaba.a.d.g.o(a2);
        }
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if (baVar.b(bb.WriteNullBooleanAsFalse)) {
                baVar.write("false");
            } else {
                baVar.write("null");
            }
        } else if (bool.booleanValue()) {
            baVar.write("true");
        } else {
            baVar.write("false");
        }
    }
}
