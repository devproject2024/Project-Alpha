package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d.c;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;
import java.util.Map;

public final class d extends o {
    public d(Class<?> cls, c cVar) {
        super(cls, cVar);
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        com.alibaba.a.b.d g2 = bVar.g();
        boolean z = true;
        if (g2.a() == 6) {
            g2.a(16);
            if (obj == null) {
                map.put(this.f6199a.f6351a, Boolean.TRUE);
            } else {
                a(obj, true);
            }
        } else if (g2.a() == 2) {
            int n = g2.n();
            g2.a(16);
            if (n != 1) {
                z = false;
            }
            if (obj == null) {
                map.put(this.f6199a.f6351a, Boolean.valueOf(z));
            } else {
                a(obj, z);
            }
        } else if (g2.a() == 8) {
            g2.a(16);
            if (c() != Boolean.TYPE && obj != null) {
                a(obj, (Object) null);
            }
        } else if (g2.a() == 7) {
            g2.a(16);
            if (obj == null) {
                map.put(this.f6199a.f6351a, Boolean.FALSE);
            } else {
                a(obj, false);
            }
        } else {
            Boolean o = g.o(bVar.a((Object) null));
            if (o != null || c() != Boolean.TYPE) {
                if (obj == null) {
                    map.put(this.f6199a.f6351a, o);
                } else {
                    a(obj, (Object) o);
                }
            }
        }
    }
}
