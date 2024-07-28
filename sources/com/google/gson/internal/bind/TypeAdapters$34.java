package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;

class TypeAdapters$34 implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f39539a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Class f39540b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ w f39541c;

    TypeAdapters$34(Class cls, Class cls2, w wVar) {
        this.f39539a = cls;
        this.f39540b = cls2;
        this.f39541c = wVar;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (rawType == this.f39539a || rawType == this.f39540b) {
            return this.f39541c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f39539a.getName() + "+" + this.f39540b.getName() + ",adapter=" + this.f39541c + "]";
    }
}
