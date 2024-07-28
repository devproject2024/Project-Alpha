package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.b.i;
import com.alibaba.a.d.c;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;
import java.util.Map;

public final class v extends o {

    /* renamed from: c  reason: collision with root package name */
    private final z f6212c;

    public v(i iVar, Class<?> cls, c cVar) {
        super(cls, cVar);
        this.f6212c = iVar.a(cVar);
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        d g2 = bVar.g();
        if (g2.a() == 2) {
            long s = g2.s();
            g2.a(16);
            if (obj == null) {
                map.put(this.f6199a.f6351a, Long.valueOf(s));
            } else {
                a(obj, s);
            }
        } else {
            Long l = null;
            if (g2.a() == 8) {
                g2.a(16);
            } else {
                l = g.l(bVar.a((Object) null));
            }
            if (l != null || c() != Long.TYPE) {
                if (obj == null) {
                    map.put(this.f6199a.f6351a, l);
                } else {
                    a(obj, (Object) l);
                }
            }
        }
    }
}
