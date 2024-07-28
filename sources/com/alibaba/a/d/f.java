package com.alibaba.a.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class f implements ParameterizedType {

    /* renamed from: a  reason: collision with root package name */
    private final Type[] f6374a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f6375b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f6376c;

    public f(Type[] typeArr, Type type, Type type2) {
        this.f6374a = typeArr;
        this.f6375b = type;
        this.f6376c = type2;
    }

    public final Type[] getActualTypeArguments() {
        return this.f6374a;
    }

    public final Type getOwnerType() {
        return this.f6375b;
    }

    public final Type getRawType() {
        return this.f6376c;
    }
}
