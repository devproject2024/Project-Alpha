package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.b.a.h;
import com.google.gsonhtcfix.d.a;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class k<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f39688a;

    /* renamed from: b  reason: collision with root package name */
    private final y<T> f39689b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f39690c;

    k(f fVar, y<T> yVar, Type type) {
        this.f39688a = fVar;
        this.f39689b = yVar;
        this.f39690c = type;
    }

    public final T a(a aVar) throws IOException {
        return this.f39689b.a(aVar);
    }

    public final void a(c cVar, T t) throws IOException {
        y<T> yVar = this.f39689b;
        Type type = this.f39690c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f39690c) {
            yVar = this.f39688a.a(com.google.gsonhtcfix.c.a.get(type));
            if (yVar instanceof h.a) {
                y<T> yVar2 = this.f39689b;
                if (!(yVar2 instanceof h.a)) {
                    yVar = yVar2;
                }
            }
        }
        yVar.a(cVar, t);
    }
}
