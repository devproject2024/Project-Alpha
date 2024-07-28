package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d;
import com.alibaba.a.d.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    protected final c f6199a;

    /* renamed from: b  reason: collision with root package name */
    protected final Class<?> f6200b;

    public abstract void a(b bVar, Object obj, Type type, Map<String, Object> map);

    public o(Class<?> cls, c cVar) {
        this.f6200b = cls;
        this.f6199a = cVar;
    }

    public final Method a() {
        return this.f6199a.f6352b;
    }

    public final Field b() {
        return this.f6199a.f6353c;
    }

    public final Class<?> c() {
        return this.f6199a.f6354d;
    }

    public final Type d() {
        return this.f6199a.f6355e;
    }

    public final void a(Object obj, boolean z) {
        a(obj, (Object) Boolean.valueOf(z));
    }

    public final void a(Object obj, int i2) {
        a(obj, (Object) Integer.valueOf(i2));
    }

    public final void a(Object obj, long j) {
        a(obj, (Object) Long.valueOf(j));
    }

    public void a(Object obj, Object obj2) {
        Method method = this.f6199a.f6352b;
        if (method != null) {
            try {
                if (this.f6199a.f6356f) {
                    if (Map.class.isAssignableFrom(method.getReturnType())) {
                        Map map = (Map) method.invoke(obj, new Object[0]);
                        if (map != null) {
                            map.putAll((Map) obj2);
                            return;
                        }
                        return;
                    }
                    Collection collection = (Collection) method.invoke(obj, new Object[0]);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                    }
                } else if (obj2 != null || !this.f6199a.f6354d.isPrimitive()) {
                    method.invoke(obj, new Object[]{obj2});
                }
            } catch (Exception e2) {
                throw new d("set property error, " + this.f6199a.f6351a, e2);
            }
        } else {
            Field field = this.f6199a.f6353c;
            if (field != null) {
                try {
                    field.set(obj, obj2);
                } catch (Exception e3) {
                    throw new d("set property error, " + this.f6199a.f6351a, e3);
                }
            }
        }
    }
}
