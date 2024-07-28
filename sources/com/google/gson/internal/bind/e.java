package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.g;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.util.ArrayList;

public final class e extends w<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f39563a = new ObjectTypeAdapter$1();

    /* renamed from: b  reason: collision with root package name */
    private final f f39564b;

    e(f fVar) {
        this.f39564b = fVar;
    }

    public final Object read(JsonReader jsonReader) throws IOException {
        switch (jsonReader.peek()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                g gVar = new g();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    gVar.put(jsonReader.nextName(), read(jsonReader));
                }
                jsonReader.endObject();
                return gVar;
            case STRING:
                return jsonReader.nextString();
            case NUMBER:
                return Double.valueOf(jsonReader.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case NULL:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        w<?> a2 = this.f39564b.a(obj.getClass());
        if (a2 instanceof e) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        a2.write(jsonWriter, obj);
    }
}
