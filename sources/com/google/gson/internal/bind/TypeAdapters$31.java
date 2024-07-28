package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;

class TypeAdapters$31 implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f39532a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f39533b;

    TypeAdapters$31(a aVar, w wVar) {
        this.f39532a = aVar;
        this.f39533b = wVar;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.equals(this.f39532a)) {
            return this.f39533b;
        }
        return null;
    }
}
