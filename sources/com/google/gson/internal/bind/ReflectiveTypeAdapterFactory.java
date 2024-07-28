package com.google.gson.internal.bind;

import com.google.gson.a.d;
import com.google.gson.e;
import com.google.gson.f;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f39501a;

    /* renamed from: b  reason: collision with root package name */
    private final e f39502b;

    /* renamed from: c  reason: collision with root package name */
    private final Excluder f39503c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f39504d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.gson.internal.a.b f39505e = com.google.gson.internal.a.b.a();

    public ReflectiveTypeAdapterFactory(c cVar, e eVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f39501a = cVar;
        this.f39502b = eVar;
        this.f39503c = excluder;
        this.f39504d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private boolean a(Field field, boolean z) {
        boolean z2;
        com.google.gson.a.a aVar;
        Excluder excluder = this.f39503c;
        Class<?> type = field.getType();
        if (!(excluder.a(type) || excluder.a(type, z))) {
            if ((excluder.f39475c & field.getModifiers()) == 0 && ((excluder.f39474b == -1.0d || excluder.a((d) field.getAnnotation(d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic() && ((!excluder.f39477e || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? aVar.b() : aVar.a()))) && ((excluder.f39476d || !Excluder.c(field.getType())) && !Excluder.b(field.getType()))))) {
                List<com.google.gson.b> list = z ? excluder.f39478f : excluder.f39479g;
                if (!list.isEmpty()) {
                    com.google.gson.c cVar = new com.google.gson.c(field);
                    Iterator<com.google.gson.b> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().shouldSkipField(cVar)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f39502b.translateName(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final <T> w<T> create(f fVar, com.google.gson.b.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new a(this.f39501a.a(aVar), a(fVar, aVar, rawType));
    }

    private Map<String, b> a(f fVar, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Class<? super Object> cls2;
        int i2;
        Field[] fieldArr;
        int i3;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        f fVar2 = fVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.b.a<?> aVar2 = aVar;
        Class<? super Object> cls3 = cls;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean a2 = reflectiveTypeAdapterFactory.a(field, true);
                boolean a3 = reflectiveTypeAdapterFactory.a(field, z);
                if (a2 || a3) {
                    reflectiveTypeAdapterFactory.f39505e.a(field);
                    Type a4 = com.google.gson.internal.b.a(aVar2.getType(), (Class<?>) cls3, field.getGenericType());
                    List<String> a5 = reflectiveTypeAdapterFactory.a(field);
                    int size = a5.size();
                    b bVar = null;
                    int i5 = 0;
                    while (i5 < size) {
                        Class<? super Object> cls4 = cls3;
                        String str = a5.get(i5);
                        boolean z2 = i5 != 0 ? false : a2;
                        com.google.gson.b.a<?> aVar3 = com.google.gson.b.a.get(a4);
                        Class<? super Object> rawType = aVar3.getRawType();
                        boolean z3 = (rawType instanceof Class) && rawType.isPrimitive();
                        com.google.gson.a.b bVar2 = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
                        w<?> a6 = bVar2 != null ? JsonAdapterAnnotationTypeAdapterFactory.a(reflectiveTypeAdapterFactory.f39501a, fVar2, aVar3, bVar2) : null;
                        boolean z4 = a6 != null;
                        if (a6 == null) {
                            a6 = fVar2.a(aVar3);
                        }
                        w<?> wVar = a6;
                        b bVar3 = bVar;
                        int i6 = i5;
                        int i7 = size;
                        List<String> list = a5;
                        AnonymousClass1 r12 = r0;
                        final Field field2 = field;
                        Field field3 = field;
                        final boolean z5 = z4;
                        int i8 = i4;
                        final w<?> wVar2 = wVar;
                        final f fVar3 = fVar;
                        int i9 = length;
                        final com.google.gson.b.a<?> aVar4 = aVar3;
                        Field[] fieldArr2 = declaredFields;
                        final boolean z6 = z3;
                        AnonymousClass1 r0 = new b(str, z2, a3) {
                            /* access modifiers changed from: package-private */
                            public final void a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                                w wVar;
                                Object obj2 = field2.get(obj);
                                if (z5) {
                                    wVar = wVar2;
                                } else {
                                    wVar = new h(fVar3, wVar2, aVar4.getType());
                                }
                                wVar.write(jsonWriter, obj2);
                            }

                            /* access modifiers changed from: package-private */
                            public final void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                                Object read = wVar2.read(jsonReader);
                                if (read != null || !z6) {
                                    field2.set(obj, read);
                                }
                            }

                            public final boolean a(Object obj) throws IOException, IllegalAccessException {
                                if (this.f39516i && field2.get(obj) != obj) {
                                    return true;
                                }
                                return false;
                            }
                        };
                        bVar = bVar3 == null ? (b) linkedHashMap.put(str, r12) : bVar3;
                        i5 = i6 + 1;
                        reflectiveTypeAdapterFactory = this;
                        fVar2 = fVar;
                        cls3 = cls4;
                        a2 = z2;
                        length = i9;
                        declaredFields = fieldArr2;
                        size = i7;
                        a5 = list;
                        field = field3;
                        i4 = i8;
                    }
                    b bVar4 = bVar;
                    i2 = i4;
                    i3 = length;
                    fieldArr = declaredFields;
                    cls2 = cls3;
                    if (bVar4 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar4.f39515h);
                    }
                } else {
                    i2 = i4;
                    i3 = length;
                    fieldArr = declaredFields;
                    cls2 = cls3;
                }
                i4 = i2 + 1;
                z = false;
                reflectiveTypeAdapterFactory = this;
                fVar2 = fVar;
                cls3 = cls2;
                length = i3;
                declaredFields = fieldArr;
            }
            Class<? super Object> cls5 = cls3;
            aVar2 = com.google.gson.b.a.get(com.google.gson.internal.b.a(aVar2.getType(), (Class<?>) cls5, cls5.getGenericSuperclass()));
            cls3 = aVar2.getRawType();
            reflectiveTypeAdapterFactory = this;
            fVar2 = fVar;
        }
        return linkedHashMap;
    }

    static abstract class b {

        /* renamed from: h  reason: collision with root package name */
        final String f39515h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f39516i;
        final boolean j;

        /* access modifiers changed from: package-private */
        public abstract void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.f39515h = str;
            this.f39516i = z;
            this.j = z2;
        }
    }

    public static final class a<T> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private final h<T> f39513a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f39514b;

        a(h<T> hVar, Map<String, b> map) {
            this.f39513a = hVar;
            this.f39514b = map;
        }

        public final T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T a2 = this.f39513a.a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    b bVar = this.f39514b.get(jsonReader.nextName());
                    if (bVar != null) {
                        if (bVar.j) {
                            bVar.a(jsonReader, (Object) a2);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return a2;
            } catch (IllegalStateException e2) {
                throw new u((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public final void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (b next : this.f39514b.values()) {
                    if (next.a(t)) {
                        jsonWriter.name(next.f39515h);
                        next.a(jsonWriter, (Object) t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
