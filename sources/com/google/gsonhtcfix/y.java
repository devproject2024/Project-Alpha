package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.a.e;
import com.google.gsonhtcfix.d.a;
import com.google.gsonhtcfix.d.c;
import java.io.IOException;

public abstract class y<T> {
    public abstract T a(a aVar) throws IOException;

    public abstract void a(c cVar, T t) throws IOException;

    public final l a(T t) {
        try {
            e eVar = new e();
            a(eVar, t);
            if (eVar.f39658a.isEmpty()) {
                return eVar.f39659b;
            }
            throw new IllegalStateException("Expected one JSON element but was " + eVar.f39658a);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }
}
