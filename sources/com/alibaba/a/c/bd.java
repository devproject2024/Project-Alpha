package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bd implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static bd f6309a = new bd();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        a(ahVar, (String) obj);
    }

    public static void a(ah ahVar, String str) {
        ba baVar = ahVar.f6266a;
        if (str != null) {
            baVar.b(str);
        } else if (baVar.b(bb.WriteNullStringAsEmpty)) {
            baVar.b("");
        } else {
            baVar.write("null");
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 4) {
            T l = g2.l();
            g2.a(16);
            return l;
        } else if (g2.a() == 2) {
            T u = g2.u();
            g2.a(16);
            return u;
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            return a2.toString();
        }
    }
}
