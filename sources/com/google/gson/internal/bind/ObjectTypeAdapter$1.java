package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;

class ObjectTypeAdapter$1 implements x {
    ObjectTypeAdapter$1() {
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType() == Object.class) {
            return new e(fVar);
        }
        return null;
    }
}
