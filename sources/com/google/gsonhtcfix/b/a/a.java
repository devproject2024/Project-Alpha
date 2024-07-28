package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.b.b;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E> extends y<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final z f39643a = new z() {
        public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type d2 = b.d(type);
            return new a(fVar, fVar.a(com.google.gsonhtcfix.c.a.get(d2)), b.b(d2));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f39644b;

    /* renamed from: c  reason: collision with root package name */
    private final y<E> f39645c;

    public a(f fVar, y<E> yVar, Class<E> cls) {
        this.f39645c = new k(fVar, yVar, cls);
        this.f39644b = cls;
    }

    public final Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
        if (aVar.f() == com.google.gsonhtcfix.d.b.NULL) {
            aVar.k();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f39645c.a(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance(this.f39644b, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e();
            return;
        }
        cVar.a();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f39645c.a(cVar, Array.get(obj, i2));
        }
        cVar.b();
    }
}
