package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.internal.k;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RuntimeTypeAdapterFactory<T> implements x {
    /* access modifiers changed from: private */
    public final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw new NullPointerException();
        }
        this.baseType = cls;
        this.typeFieldName = str;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "sub_type");
    }

    public final RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw new NullPointerException();
        } else if (this.subtypeToLabel.containsKey(cls) || this.labelToSubtype.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.labelToSubtype.put(str, cls);
            this.subtypeToLabel.put(cls, str);
            return this;
        }
    }

    public final RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }

    public final <R> w<R> create(f fVar, a<R> aVar) {
        if (aVar.getRawType() != this.baseType) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry next : this.labelToSubtype.entrySet()) {
            w a2 = fVar.a((x) this, a.get((Class) next.getValue()));
            linkedHashMap.put(next.getKey(), a2);
            linkedHashMap2.put(next.getValue(), a2);
        }
        return new w<R>() {
            public R read(JsonReader jsonReader) throws IOException {
                l a2 = k.a(jsonReader);
                l b2 = a2.h().b(RuntimeTypeAdapterFactory.this.typeFieldName);
                if (b2 != null) {
                    String c2 = b2.c();
                    w wVar = (w) linkedHashMap.get(c2);
                    if (wVar != null) {
                        return wVar.fromJsonTree(a2);
                    }
                    throw new p("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " subtype named " + c2 + "; did you forget to register a subtype?");
                }
                throw new p("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }

            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls = r.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
                w wVar = (w) linkedHashMap2.get(cls);
                if (wVar != null) {
                    o h2 = wVar.toJsonTree(r).h();
                    if (!h2.a(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                        o oVar = new o();
                        oVar.a(RuntimeTypeAdapterFactory.this.typeFieldName, (l) new r(str));
                        for (Map.Entry next : h2.f39636a.entrySet()) {
                            oVar.a((String) next.getKey(), (l) next.getValue());
                        }
                        k.a(oVar, jsonWriter);
                        return;
                    }
                    throw new p("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                throw new p("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
        }.nullSafe();
    }
}
