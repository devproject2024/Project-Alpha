package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d.g;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

public final class t implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final t f6208a = new t();

    public final int a() {
        return 12;
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [T, java.lang.Object[]] */
    public final <T> T a(b bVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return bVar.a(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        bVar.a(genericComponentType, (Collection) arrayList);
        if (!(genericComponentType instanceof Class)) {
            return arrayList.toArray();
        }
        Class cls = (Class) genericComponentType;
        if (cls == Boolean.TYPE) {
            return g.a((Object) arrayList, boolean[].class, bVar.c());
        }
        if (cls == Short.TYPE) {
            return g.a((Object) arrayList, short[].class, bVar.c());
        }
        if (cls == Integer.TYPE) {
            return g.a((Object) arrayList, int[].class, bVar.c());
        }
        if (cls == Long.TYPE) {
            return g.a((Object) arrayList, long[].class, bVar.c());
        }
        if (cls == Float.TYPE) {
            return g.a((Object) arrayList, float[].class, bVar.c());
        }
        if (cls == Double.TYPE) {
            return g.a((Object) arrayList, double[].class, bVar.c());
        }
        ? r2 = (Object[]) Array.newInstance(cls, arrayList.size());
        arrayList.toArray(r2);
        return r2;
    }
}
