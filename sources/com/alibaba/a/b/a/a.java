package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.c;
import com.alibaba.a.b.d;
import com.alibaba.a.b.f;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class a implements z {
    /* access modifiers changed from: protected */
    public abstract <T> T b(b bVar, Type type, Object obj);

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        Object obj2 = null;
        if (g2.a() == 2) {
            obj2 = Long.valueOf(g2.s());
            g2.a(16);
        } else if (g2.a() == 4) {
            String l = g2.l();
            g2.a(16);
            String str = l;
            if (g2.a(c.AllowISO8601DateFormat)) {
                f fVar = new f(l);
                Date date = l;
                if (fVar.z()) {
                    date = fVar.y().getTime();
                }
                fVar.close();
                str = date;
            }
            obj2 = str;
        } else if (g2.a() == 8) {
            g2.d();
        } else if (g2.a() == 12) {
            g2.d();
            if (g2.a() == 4) {
                if (com.alibaba.a.a.DEFAULT_TYPE_KEY.equals(g2.l())) {
                    g2.d();
                    bVar.a(17);
                    Class<?> a2 = g.a(g2.l());
                    if (a2 != null) {
                        type = a2;
                    }
                    bVar.a(4);
                    bVar.a(16);
                }
                g2.p();
                if (g2.a() == 2) {
                    long s = g2.s();
                    g2.d();
                    obj2 = Long.valueOf(s);
                    bVar.a(13);
                } else {
                    throw new com.alibaba.a.d("syntax error : " + g2.b());
                }
            } else {
                throw new com.alibaba.a.d("syntax error");
            }
        } else if (bVar.f6223f == 2) {
            bVar.f6223f = 0;
            bVar.a(16);
            if (g2.a() != 4) {
                throw new com.alibaba.a.d("syntax error");
            } else if ("val".equals(g2.l())) {
                g2.d();
                bVar.a(17);
                obj2 = bVar.a((Object) null);
                bVar.a(13);
            } else {
                throw new com.alibaba.a.d("syntax error");
            }
        } else {
            obj2 = bVar.a((Object) null);
        }
        return b(bVar, type, obj2);
    }
}
