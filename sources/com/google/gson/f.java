package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.b;
import com.google.gson.internal.bind.d;
import com.google.gson.internal.bind.e;
import com.google.gson.internal.bind.g;
import com.google.gson.internal.bind.i;
import com.google.gson.internal.c;
import com.google.gson.internal.j;
import com.google.gson.internal.k;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f {
    private static final com.google.gson.b.a<?> r = com.google.gson.b.a.get(Object.class);

    /* renamed from: a  reason: collision with root package name */
    final List<x> f39449a;

    /* renamed from: b  reason: collision with root package name */
    final Excluder f39450b;

    /* renamed from: c  reason: collision with root package name */
    final e f39451c;

    /* renamed from: d  reason: collision with root package name */
    final Map<Type, h<?>> f39452d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f39453e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f39454f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f39455g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f39456h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f39457i;
    final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final v o;
    final List<x> p;
    final List<x> q;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> s;
    private final Map<com.google.gson.b.a<?>, w<?>> t;
    private final c u;
    private final JsonAdapterAnnotationTypeAdapterFactory v;

    public f() {
        this(Excluder.f39473a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, v.DEFAULT, (String) null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    f(Excluder excluder, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, v vVar, String str, int i2, int i3, List<x> list, List<x> list2, List<x> list3) {
        final w wVar;
        w wVar2;
        w wVar3;
        boolean z8 = z7;
        v vVar2 = vVar;
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f39450b = excluder;
        this.f39451c = eVar;
        this.f39452d = map;
        this.u = new c(map);
        this.f39453e = z;
        this.f39454f = z2;
        this.f39455g = z3;
        this.f39456h = z4;
        this.f39457i = z5;
        this.j = z6;
        this.k = z8;
        this.o = vVar2;
        this.l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.Y);
        arrayList.add(e.f39563a);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(i.D);
        arrayList.add(i.m);
        arrayList.add(i.f39579g);
        arrayList.add(i.f39581i);
        arrayList.add(i.k);
        if (vVar2 == v.DEFAULT) {
            wVar = i.t;
        } else {
            wVar = new w<Number>() {
                public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.nullValue();
                    } else {
                        jsonWriter.value(number.toString());
                    }
                }

                public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.peek() != JsonToken.NULL) {
                        return Long.valueOf(jsonReader.nextLong());
                    }
                    jsonReader.nextNull();
                    return null;
                }
            };
        }
        arrayList.add(i.a(Long.TYPE, Long.class, wVar));
        Class cls = Double.TYPE;
        Class<Double> cls2 = Double.class;
        if (z8) {
            wVar2 = i.v;
        } else {
            wVar2 = new w<Number>() {
                public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    f.a(number.doubleValue());
                    jsonWriter.value(number);
                }

                public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.peek() != JsonToken.NULL) {
                        return Double.valueOf(jsonReader.nextDouble());
                    }
                    jsonReader.nextNull();
                    return null;
                }
            };
        }
        arrayList.add(i.a(cls, cls2, wVar2));
        Class cls3 = Float.TYPE;
        Class<Float> cls4 = Float.class;
        if (z8) {
            wVar3 = i.u;
        } else {
            wVar3 = new w<Number>() {
                public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    f.a((double) number.floatValue());
                    jsonWriter.value(number);
                }

                public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.peek() != JsonToken.NULL) {
                        return Float.valueOf((float) jsonReader.nextDouble());
                    }
                    jsonReader.nextNull();
                    return null;
                }
            };
        }
        arrayList.add(i.a(cls3, cls4, wVar3));
        arrayList.add(i.x);
        arrayList.add(i.o);
        arrayList.add(i.q);
        arrayList.add(i.a(AtomicLong.class, new w<AtomicLong>() {
            public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                w.this.write(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
            }

            public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) w.this.read(jsonReader)).longValue());
            }
        }.nullSafe()));
        arrayList.add(i.a(AtomicLongArray.class, new w<AtomicLongArray>() {
            public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    w.this.write(jsonWriter, Long.valueOf(atomicLongArray.get(i2)));
                }
                jsonWriter.endArray();
            }

            public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) w.this.read(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe()));
        arrayList.add(i.s);
        arrayList.add(i.z);
        arrayList.add(i.F);
        arrayList.add(i.H);
        arrayList.add(i.a(BigDecimal.class, i.B));
        arrayList.add(i.a(BigInteger.class, i.C));
        arrayList.add(i.J);
        arrayList.add(i.L);
        arrayList.add(i.P);
        arrayList.add(i.R);
        arrayList.add(i.W);
        arrayList.add(i.N);
        arrayList.add(i.f39576d);
        arrayList.add(b.f39550a);
        arrayList.add(i.U);
        arrayList.add(g.f39568a);
        arrayList.add(com.google.gson.internal.bind.f.f39566a);
        arrayList.add(i.S);
        arrayList.add(com.google.gson.internal.bind.a.f39546a);
        arrayList.add(i.f39574b);
        arrayList.add(new CollectionTypeAdapterFactory(this.u));
        arrayList.add(new MapTypeAdapterFactory(this.u, z2));
        this.v = new JsonAdapterAnnotationTypeAdapterFactory(this.u);
        arrayList.add(this.v);
        arrayList.add(i.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.u, eVar, excluder, this.v));
        this.f39449a = Collections.unmodifiableList(arrayList);
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> w<T> a(com.google.gson.b.a<T> aVar) {
        w<T> wVar = this.t.get(aVar == null ? r : aVar);
        if (wVar != null) {
            return wVar;
        }
        Map map = this.s.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap();
            this.s.set(map);
            z = true;
        }
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a aVar3 = new a();
            map.put(aVar, aVar3);
            for (x create : this.f39449a) {
                w<T> create2 = create.create(this, aVar);
                if (create2 != null) {
                    if (aVar3.f39462a == null) {
                        aVar3.f39462a = create2;
                        this.t.put(aVar, create2);
                        return create2;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public final <T> w<T> a(x xVar, com.google.gson.b.a<T> aVar) {
        if (!this.f39449a.contains(xVar)) {
            xVar = this.v;
        }
        boolean z = false;
        for (x next : this.f39449a) {
            if (z) {
                w<T> create = next.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (next == xVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> w<T> a(Class<T> cls) {
        return a(com.google.gson.b.a.get(cls));
    }

    public final l a(Object obj) {
        if (obj == null) {
            return n.f39635a;
        }
        Class<?> cls = obj.getClass();
        d dVar = new d();
        a(obj, (Type) cls, (JsonWriter) dVar);
        return dVar.a();
    }

    public final String b(Object obj) {
        if (obj == null) {
            return a((l) n.f39635a);
        }
        return a(obj, (Type) obj.getClass());
    }

    public final String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(k.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    private void a(Object obj, Type type, JsonWriter jsonWriter) throws m {
        w<?> a2 = a(com.google.gson.b.a.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f39456h);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f39453e);
        try {
            a2.write(jsonWriter, obj);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public final String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(k.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public final JsonWriter a(Writer writer) throws IOException {
        if (this.f39455g) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f39457i) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.f39453e);
        return jsonWriter;
    }

    public final JsonReader a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.j);
        return jsonReader;
    }

    private void a(l lVar, JsonWriter jsonWriter) throws m {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f39456h);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f39453e);
        try {
            k.a(lVar, jsonWriter);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public final <T> T a(String str, Class<T> cls) throws u {
        return j.a(cls).cast(a(str, (Type) cls));
    }

    public final <T> T a(String str, Type type) throws u {
        if (str == null) {
            return null;
        }
        return a((Reader) new StringReader(str), type);
    }

    public final <T> T a(Reader reader, Class<T> cls) throws u, m {
        JsonReader a2 = a(reader);
        T a3 = a(a2, (Type) cls);
        a((Object) a3, a2);
        return j.a(cls).cast(a3);
    }

    private <T> T a(Reader reader, Type type) throws m, u {
        JsonReader a2 = a(reader);
        T a3 = a(a2, type);
        a((Object) a3, a2);
        return a3;
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new u((Throwable) e2);
            } catch (IOException e3) {
                throw new m((Throwable) e3);
            }
        }
    }

    private <T> T a(JsonReader jsonReader, Type type) throws m, u {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            jsonReader.peek();
            T read = a(com.google.gson.b.a.get(type)).read(jsonReader);
            jsonReader.setLenient(isLenient);
            return read;
        } catch (EOFException e2) {
            if (1 != 0) {
                jsonReader.setLenient(isLenient);
                return null;
            }
            throw new u((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new u((Throwable) e3);
        } catch (IOException e4) {
            throw new u((Throwable) e4);
        } catch (AssertionError e5) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e5.getMessage());
            assertionError.initCause(e5);
            throw assertionError;
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }

    public final <T> T a(l lVar, Class<T> cls) throws u {
        return j.a(cls).cast(a(lVar, (Type) cls));
    }

    public final <T> T a(l lVar, Type type) throws u {
        if (lVar == null) {
            return null;
        }
        return a((JsonReader) new com.google.gson.internal.bind.c(lVar), type);
    }

    static class a<T> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        w<T> f39462a;

        a() {
        }

        public final T read(JsonReader jsonReader) throws IOException {
            w<T> wVar = this.f39462a;
            if (wVar != null) {
                return wVar.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        public final void write(JsonWriter jsonWriter, T t) throws IOException {
            w<T> wVar = this.f39462a;
            if (wVar != null) {
                wVar.write(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.f39453e + ",factories:" + this.f39449a + ",instanceCreators:" + this.u + "}";
    }
}
