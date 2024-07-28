package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;

public final class y implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final y f6216a = new y();

    public final int a() {
        return 2;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String u = g2.u();
                g2.a(16);
                return Double.valueOf(Double.parseDouble(u));
            }
            long s = g2.s();
            g2.a(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf((short) ((int) s));
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf((byte) ((int) s));
            }
            if (s < -2147483648L || s > 2147483647L) {
                return Long.valueOf(s);
            }
            return Integer.valueOf((int) s);
        } else if (g2.a() != 3) {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return g.h(a2);
            }
            if (type == Short.TYPE || type == Short.class) {
                return g.d(a2);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return g.b(a2);
            }
            return g.e(a2);
        } else if (type == Double.TYPE || type == Double.class) {
            String u2 = g2.u();
            g2.a(16);
            return Double.valueOf(Double.parseDouble(u2));
        } else {
            T k = g2.k();
            g2.a(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf(k.shortValue());
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf(k.byteValue());
            }
            return k;
        }
    }
}
