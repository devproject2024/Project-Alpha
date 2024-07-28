package com.alibaba.a.c;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;

public final class z implements com.alibaba.a.b.a.z, at {

    /* renamed from: a  reason: collision with root package name */
    public static z f6342a = new z();

    public final int a() {
        return 2;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                baVar.write("null");
            } else if (Float.isInfinite(floatValue)) {
                baVar.write("null");
            } else {
                String f2 = Float.toString(floatValue);
                if (f2.endsWith(".0")) {
                    f2 = f2.substring(0, f2.length() - 2);
                }
                baVar.write(f2);
                if (ahVar.b(bb.WriteClassName)) {
                    baVar.a('F');
                }
            }
        } else if (ahVar.b(bb.WriteNullNumberAsZero)) {
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
            return Float.valueOf(Float.parseFloat(u));
        } else if (g2.a() == 3) {
            float w = g2.w();
            g2.a(16);
            return Float.valueOf(w);
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            return g.g(a2);
        }
    }
}
