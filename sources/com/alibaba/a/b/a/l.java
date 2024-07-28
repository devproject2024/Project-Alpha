package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class l implements z {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f6196a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Enum> f6197b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Enum> f6198c = new HashMap();

    public final int a() {
        return 2;
    }

    public l(Class<?> cls) {
        this.f6196a = cls;
        try {
            for (Object obj : (Object[]) cls.getMethod("values", new Class[0]).invoke((Object) null, new Object[0])) {
                Enum enumR = (Enum) obj;
                this.f6197b.put(Integer.valueOf(enumR.ordinal()), enumR);
                this.f6198c.put(enumR.name(), enumR);
            }
        } catch (Exception unused) {
            throw new d("init enum values error, " + cls.getName());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        try {
            com.alibaba.a.b.d g2 = bVar.g();
            if (g2.a() == 2) {
                Integer valueOf = Integer.valueOf(g2.n());
                g2.a(16);
                T t = this.f6197b.get(valueOf);
                if (t != null) {
                    return t;
                }
                throw new d("parse enum " + this.f6196a.getName() + " error, value : " + valueOf);
            } else if (g2.a() == 4) {
                String l = g2.l();
                g2.a(16);
                if (l.length() == 0) {
                    return null;
                }
                this.f6198c.get(l);
                return Enum.valueOf(this.f6196a, l);
            } else if (g2.a() == 8) {
                g2.a(16);
                return null;
            } else {
                Object a2 = bVar.a((Object) null);
                throw new d("parse enum " + this.f6196a.getName() + " error, value : " + a2);
            }
        } catch (d e2) {
            throw e2;
        } catch (Throwable th) {
            throw new d(th.getMessage(), th);
        }
    }
}
