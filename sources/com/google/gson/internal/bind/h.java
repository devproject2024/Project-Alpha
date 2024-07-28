package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class h<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f39570a;

    /* renamed from: b  reason: collision with root package name */
    private final w<T> f39571b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f39572c;

    h(f fVar, w<T> wVar, Type type) {
        this.f39570a = fVar;
        this.f39571b = wVar;
        this.f39572c = type;
    }

    public final T read(JsonReader jsonReader) throws IOException {
        return this.f39571b.read(jsonReader);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        w<T> wVar = this.f39571b;
        Type type = this.f39572c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f39572c) {
            wVar = this.f39570a.a(a.get(type));
            if (wVar instanceof ReflectiveTypeAdapterFactory.a) {
                w<T> wVar2 = this.f39571b;
                if (!(wVar2 instanceof ReflectiveTypeAdapterFactory.a)) {
                    wVar = wVar2;
                }
            }
        }
        wVar.write(jsonWriter, t);
    }
}
