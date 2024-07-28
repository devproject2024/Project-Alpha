package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class a<E> extends w<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f39546a = new ArrayTypeAdapter$1();

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f39547b;

    /* renamed from: c  reason: collision with root package name */
    private final w<E> f39548c;

    public a(f fVar, w<E> wVar, Class<E> cls) {
        this.f39548c = new h(fVar, wVar, cls);
        this.f39547b = cls;
    }

    public final Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f39548c.read(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f39547b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f39548c.write(jsonWriter, Array.get(obj, i2));
        }
        jsonWriter.endArray();
    }
}
