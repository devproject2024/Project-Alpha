package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;
import java.sql.Time;

class TimeTypeAdapter$1 implements x {
    TimeTypeAdapter$1() {
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType() == Time.class) {
            return new g();
        }
        return null;
    }
}
