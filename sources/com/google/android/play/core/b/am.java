package com.google.android.play.core.b;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

public final class am<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f37270a;

    /* renamed from: b  reason: collision with root package name */
    private final Field f37271b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<T> f37272c;

    am(Object obj, Field field, Class<T> cls) {
        this.f37270a = obj;
        this.f37271b = field;
        this.f37272c = cls;
    }

    am(Object obj, Field field, Class cls, byte b2) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    public final T a() {
        try {
            return this.f37272c.cast(this.f37271b.get(this.f37270a));
        } catch (Exception e2) {
            throw new ao(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f37271b.getName(), this.f37270a.getClass().getName(), this.f37272c.getName()}), e2);
        }
    }

    public final void a(T t) {
        try {
            this.f37271b.set(this.f37270a, t);
        } catch (Exception e2) {
            throw new ao(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f37271b.getName(), this.f37270a.getClass().getName(), this.f37272c.getName()}), e2);
        }
    }

    public final void a(Collection collection) {
        Object[] objArr = (Object[]) a();
        int length = objArr != null ? objArr.length : 0;
        Object[] objArr2 = (Object[]) Array.newInstance(b(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        a(objArr2);
    }

    public final void b(Collection collection) {
        Object[] objArr = (Object[]) a();
        int i2 = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(b(), (objArr != null ? objArr.length : 0) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i2] = obj;
            i2++;
        }
        a(objArr2);
    }

    private Class b() {
        return this.f37271b.getType().getComponentType();
    }
}
