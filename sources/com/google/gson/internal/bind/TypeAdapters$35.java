package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;

class TypeAdapters$35 implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f39542a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f39543b;

    TypeAdapters$35(Class cls, w wVar) {
        this.f39542a = cls;
        this.f39543b = wVar;
    }

    public <T2> w<T2> create(f fVar, a<T2> aVar) {
        final Class<? super T2> rawType = aVar.getRawType();
        if (!this.f39542a.isAssignableFrom(rawType)) {
            return null;
        }
        return new w<T1>() {
            public final void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                TypeAdapters$35.this.f39543b.write(jsonWriter, t1);
            }

            public final T1 read(JsonReader jsonReader) throws IOException {
                T1 read = TypeAdapters$35.this.f39543b.read(jsonReader);
                if (read == null || rawType.isInstance(read)) {
                    return read;
                }
                throw new u("Expected a " + rawType.getName() + " but was " + read.getClass().getName());
            }
        };
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f39542a.getName() + ",adapter=" + this.f39543b + "]";
    }
}
