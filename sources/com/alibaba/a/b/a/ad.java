package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.b.i;
import com.alibaba.a.d.c;
import java.lang.reflect.Type;
import java.util.Map;

public final class ad extends o {

    /* renamed from: c  reason: collision with root package name */
    private final z f6182c;

    public ad(i iVar, Class<?> cls, c cVar) {
        super(cls, cVar);
        this.f6182c = iVar.a(cVar);
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        d g2 = bVar.g();
        String str = null;
        if (g2.a() == 4) {
            str = g2.l();
            g2.a(16);
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 != null) {
                str = a2.toString();
            }
        }
        if (obj == null) {
            map.put(this.f6199a.f6351a, str);
        } else {
            a(obj, (Object) str);
        }
    }
}
