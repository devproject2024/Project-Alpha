package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.b.f;
import java.lang.reflect.Type;
import java.sql.Time;

public final class af implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final af f6183a = new af();

    public final int a() {
        return 2;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        long j;
        d g2 = bVar.g();
        if (g2.a() == 16) {
            g2.a(4);
            if (g2.a() == 4) {
                g2.p();
                if (g2.a() == 2) {
                    long s = g2.s();
                    g2.a(13);
                    if (g2.a() == 13) {
                        g2.a(16);
                        return new Time(s);
                    }
                    throw new com.alibaba.a.d("syntax error");
                }
                throw new com.alibaba.a.d("syntax error");
            }
            throw new com.alibaba.a.d("syntax error");
        }
        T a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof Time) {
            return a2;
        }
        if (a2 instanceof Number) {
            return new Time(((Number) a2).longValue());
        }
        if (a2 instanceof String) {
            String str = (String) a2;
            if (str.length() == 0) {
                return null;
            }
            f fVar = new f(str);
            if (fVar.z()) {
                j = fVar.y().getTimeInMillis();
            } else {
                j = Long.parseLong(str);
            }
            fVar.close();
            return new Time(j);
        }
        throw new com.alibaba.a.d("parse error");
    }
}
