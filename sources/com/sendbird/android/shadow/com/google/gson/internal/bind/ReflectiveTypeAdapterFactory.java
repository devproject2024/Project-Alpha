package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.FieldNamingStrategy;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.annotations.JsonAdapter;
import com.sendbird.android.shadow.com.google.gson.annotations.SerializedName;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Excluder;
import com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Primitives;
import com.sendbird.android.shadow.com.google.gson.internal.reflect.ReflectionAccessor;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public final boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder2) {
        return !excluder2.excludeClass(field.getType(), z) && !excluder2.excludeField(field, z);
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String add : alternate) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
    }

    private a createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        Gson gson2 = gson;
        TypeToken<?> typeToken2 = typeToken;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        Field field2 = field;
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken2, jsonAdapter) : null;
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken2);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        final Field field3 = field;
        final Gson gson3 = gson;
        final TypeToken<?> typeToken3 = typeToken;
        return new a(str, z, z2) {
            /* access modifiers changed from: package-private */
            public final void a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                TypeAdapter typeAdapter;
                Object obj2 = field3.get(obj);
                if (z3) {
                    typeAdapter = typeAdapter2;
                } else {
                    typeAdapter = new a(gson3, typeAdapter2, typeToken3.getType());
                }
                typeAdapter.write(jsonWriter, obj2);
            }

            /* access modifiers changed from: package-private */
            public final void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field3.set(obj, read);
                }
            }

            public final boolean a(Object obj) throws IOException, IllegalAccessException {
                if (this.f44957i && field3.get(obj) != obj) {
                    return true;
                }
                return false;
            }
        };
    }

    private Map<String, a> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<? super Object> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, z);
                if (excludeField || excludeField2) {
                    this.accessor.makeAccessible(field);
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    int size = fieldNames.size();
                    a aVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = fieldNames.get(i3);
                        boolean z2 = i3 != 0 ? false : excludeField;
                        String str2 = str;
                        a aVar2 = aVar;
                        int i4 = i3;
                        int i5 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        aVar = aVar2 == null ? (a) linkedHashMap.put(str2, createBoundField(gson, field, str2, TypeToken.get(resolve), z2, excludeField2)) : aVar2;
                        i3 = i4 + 1;
                        excludeField = z2;
                        fieldNames = list;
                        size = i5;
                        field = field2;
                    }
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + aVar3.f44956h);
                    }
                }
                i2++;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class a {

        /* renamed from: h  reason: collision with root package name */
        final String f44956h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f44957i;
        final boolean j;

        /* access modifiers changed from: package-private */
        public abstract void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected a(String str, boolean z, boolean z2) {
            this.f44956h = str;
            this.f44957i = z;
            this.j = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, a> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, a> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        public final T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    a aVar = this.boundFields.get(jsonReader.nextName());
                    if (aVar != null) {
                        if (aVar.j) {
                            aVar.a(jsonReader, (Object) construct);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException((Throwable) e2);
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
                for (a next : this.boundFields.values()) {
                    if (next.a(t)) {
                        jsonWriter.name(next.f44956h);
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
