package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public final class k extends o {

    /* renamed from: c  reason: collision with root package name */
    private z f6195c;

    public k(Class<?> cls, c cVar) {
        super(cls, cVar);
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        if (this.f6195c == null) {
            this.f6195c = bVar.c().a(this.f6199a);
        }
        if (type instanceof ParameterizedType) {
            bVar.d().f6241c = type;
        }
        Object a2 = this.f6195c.a(bVar, d(), this.f6199a.f6351a);
        if (bVar.f6223f == 1) {
            b.a e2 = bVar.e();
            e2.f6228c = this;
            e2.f6229d = bVar.d();
            bVar.f6223f = 0;
        } else if (obj == null) {
            map.put(this.f6199a.f6351a, a2);
        } else {
            a(obj, a2);
        }
    }
}
