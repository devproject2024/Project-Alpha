package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.w;
import com.google.gson.x;
import java.sql.Date;

class SqlDateTypeAdapter$1 implements x {
    SqlDateTypeAdapter$1() {
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType() == Date.class) {
            return new f();
        }
        return null;
    }
}
