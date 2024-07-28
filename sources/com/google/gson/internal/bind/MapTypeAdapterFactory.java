package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.internal.b;
import com.google.gson.internal.c;
import com.google.gson.internal.e;
import com.google.gson.internal.h;
import com.google.gson.internal.k;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements x {

    /* renamed from: a  reason: collision with root package name */
    final boolean f39495a;

    /* renamed from: b  reason: collision with root package name */
    private final c f39496b;

    public MapTypeAdapterFactory(c cVar, boolean z) {
        this.f39496b = cVar;
        this.f39495a = z;
    }

    public final <T> w<T> create(f fVar, com.google.gson.b.a<T> aVar) {
        w<Boolean> wVar;
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] b2 = b.b(type, b.c(type));
        Type type2 = b2[0];
        if (type2 == Boolean.TYPE || type2 == Boolean.class) {
            wVar = i.f39578f;
        } else {
            wVar = fVar.a(com.google.gson.b.a.get(type2));
        }
        w<?> a2 = fVar.a(com.google.gson.b.a.get(b2[1]));
        h<T> a3 = this.f39496b.a(aVar);
        return new a(fVar, b2[0], wVar, b2[1], a2, a3);
    }

    final class a<K, V> extends w<Map<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private final w<K> f39498b;

        /* renamed from: c  reason: collision with root package name */
        private final w<V> f39499c;

        /* renamed from: d  reason: collision with root package name */
        private final h<? extends Map<K, V>> f39500d;

        public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!MapTypeAdapterFactory.this.f39495a) {
                jsonWriter.beginObject();
                for (Map.Entry entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f39499c.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    l jsonTree = this.f39498b.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z |= (jsonTree instanceof i) || (jsonTree instanceof o);
                }
                if (z) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i2 < size) {
                        jsonWriter.beginArray();
                        k.a((l) arrayList.get(i2), jsonWriter);
                        this.f39499c.write(jsonWriter, arrayList2.get(i2));
                        jsonWriter.endArray();
                        i2++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    l lVar = (l) arrayList.get(i2);
                    if (lVar instanceof r) {
                        r j = lVar.j();
                        if (j.f39637a instanceof Number) {
                            str = String.valueOf(j.b());
                        } else if (j.f39637a instanceof Boolean) {
                            str = Boolean.toString(j.g());
                        } else if (j.f39637a instanceof String) {
                            str = j.c();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (lVar instanceof n) {
                        str = "null";
                    } else {
                        throw new AssertionError();
                    }
                    jsonWriter.name(str);
                    this.f39499c.write(jsonWriter, arrayList2.get(i2));
                    i2++;
                }
                jsonWriter.endObject();
            }
        }

        public a(f fVar, Type type, w<K> wVar, Type type2, w<V> wVar2, h<? extends Map<K, V>> hVar) {
            this.f39498b = new h(fVar, wVar, type);
            this.f39499c = new h(fVar, wVar2, type2);
            this.f39500d = hVar;
        }

        public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map map = (Map) this.f39500d.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read = this.f39498b.read(jsonReader);
                    if (map.put(read, this.f39499c.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new u("duplicate key: ".concat(String.valueOf(read)));
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    e.INSTANCE.promoteNameToValue(jsonReader);
                    K read2 = this.f39498b.read(jsonReader);
                    if (map.put(read2, this.f39499c.read(jsonReader)) != null) {
                        throw new u("duplicate key: ".concat(String.valueOf(read2)));
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }
    }
}
