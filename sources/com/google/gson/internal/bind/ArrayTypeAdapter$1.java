package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.internal.b;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

class ArrayTypeAdapter$1 implements x {
    ArrayTypeAdapter$1() {
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        Type type = aVar.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type e2 = b.e(type);
        return new a(fVar, fVar.a(a.get(e2)), b.c(e2));
    }
}
