package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public final class g implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final g f6191a = new g();

    public final int a() {
        return 14;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        T t;
        Type type2;
        Type type3;
        if (bVar.g().a() == 8) {
            bVar.g().a(16);
            return null;
        }
        Type type4 = type;
        while (!(type4 instanceof Class)) {
            if (type4 instanceof ParameterizedType) {
                type4 = ((ParameterizedType) type4).getRawType();
            } else {
                throw new d("TODO");
            }
        }
        Class<AbstractCollection> cls = (Class) type4;
        if (cls == AbstractCollection.class) {
            t = new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            t = new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            t = new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            t = new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            t = new ArrayList();
        } else if (cls.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type3 = Object.class;
            }
            t = EnumSet.noneOf((Class) type3);
        } else {
            try {
                t = (Collection) cls.newInstance();
            } catch (Exception unused) {
                throw new d("create instane error, class " + cls.getName());
            }
        }
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            type2 = Object.class;
        }
        bVar.a(type2, (Collection) t, obj);
        return t;
    }
}
