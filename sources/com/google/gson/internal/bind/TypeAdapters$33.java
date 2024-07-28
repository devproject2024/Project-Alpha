package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;

class TypeAdapters$33 implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f39536a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Class f39537b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ w f39538c;

    TypeAdapters$33(Class cls, Class cls2, w wVar) {
        this.f39536a = cls;
        this.f39537b = cls2;
        this.f39538c = wVar;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (rawType == this.f39536a || rawType == this.f39537b) {
            return this.f39538c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f39537b.getName() + "+" + this.f39536a.getName() + ",adapter=" + this.f39538c + "]";
    }
}
