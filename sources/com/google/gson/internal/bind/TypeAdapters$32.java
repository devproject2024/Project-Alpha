package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;

class TypeAdapters$32 implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f39534a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f39535b;

    TypeAdapters$32(Class cls, w wVar) {
        this.f39534a = cls;
        this.f39535b = wVar;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType() == this.f39534a) {
            return this.f39535b;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f39534a.getName() + ",adapter=" + this.f39535b + "]";
    }
}
