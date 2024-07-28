package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.b;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f39491a;

    public CollectionTypeAdapterFactory(c cVar) {
        this.f39491a = cVar;
    }

    public final <T> w<T> create(f fVar, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a2 = b.a(type, (Class<?>) rawType);
        return new a(fVar, a2, fVar.a(com.google.gson.b.a.get(a2)), this.f39491a.a(aVar));
    }

    static final class a<E> extends w<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final w<E> f39492a;

        /* renamed from: b  reason: collision with root package name */
        private final h<? extends Collection<E>> f39493b;

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (Object write : collection) {
                this.f39492a.write(jsonWriter, write);
            }
            jsonWriter.endArray();
        }

        public a(f fVar, Type type, w<E> wVar, h<? extends Collection<E>> hVar) {
            this.f39492a = new h(fVar, wVar, type);
            this.f39493b = hVar;
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection collection = (Collection) this.f39493b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f39492a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }
    }
}
