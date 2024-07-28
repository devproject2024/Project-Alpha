package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.c;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;
import java.util.Map;

public final class p extends o {
    public p(Class<?> cls, c cVar) {
        super(cls, cVar);
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        d g2 = bVar.g();
        if (g2.a() == 2) {
            int n = g2.n();
            g2.a(16);
            if (obj == null) {
                map.put(this.f6199a.f6351a, Integer.valueOf(n));
            } else {
                a(obj, n);
            }
        } else {
            Integer num = null;
            if (g2.a() == 8) {
                g2.a(16);
            } else {
                num = g.m(bVar.a((Object) null));
            }
            if (num != null || c() != Integer.TYPE) {
                if (obj == null) {
                    map.put(this.f6199a.f6351a, num);
                } else {
                    a(obj, (Object) num);
                }
            }
        }
    }
}
