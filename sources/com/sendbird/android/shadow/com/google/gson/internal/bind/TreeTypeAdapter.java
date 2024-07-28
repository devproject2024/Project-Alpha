package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonDeserializationContext;
import com.sendbird.android.shadow.com.google.gson.JsonDeserializer;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonParseException;
import com.sendbird.android.shadow.com.google.gson.JsonSerializationContext;
import com.sendbird.android.shadow.com.google.gson.JsonSerializer;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Preconditions;
import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final TreeTypeAdapter<T>.defpackage.a context = new a(this, (byte) 0);
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = typeAdapterFactory;
    }

    public final T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken2, Object obj) {
        return new b(obj, typeToken2, false, (Class<?>) null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken2, Object obj) {
        return new b(obj, typeToken2, typeToken2.getType() == typeToken2.getRawType(), (Class<?>) null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new b(obj, (TypeToken<?>) null, false, cls);
    }

    static final class b implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        private final TypeToken<?> f44959a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f44960b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f44961c;

        /* renamed from: d  reason: collision with root package name */
        private final JsonSerializer<?> f44962d;

        /* renamed from: e  reason: collision with root package name */
        private final JsonDeserializer<?> f44963e;

        b(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonDeserializer<?> jsonDeserializer = null;
            this.f44962d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f44963e = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            C$Gson$Preconditions.checkArgument((this.f44962d == null && this.f44963e == null) ? false : true);
            this.f44959a = typeToken;
            this.f44960b = z;
            this.f44961c = cls;
        }

        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            TypeToken<?> typeToken2 = this.f44959a;
            if (typeToken2 != null) {
                z = typeToken2.equals(typeToken) || (this.f44960b && this.f44959a.getType() == typeToken.getRawType());
            } else {
                z = this.f44961c.isAssignableFrom(typeToken.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.f44962d, this.f44963e, gson, typeToken, this);
            }
            return null;
        }
    }

    final class a implements JsonDeserializationContext, JsonSerializationContext {
        private a() {
        }

        /* synthetic */ a(TreeTypeAdapter treeTypeAdapter, byte b2) {
            this();
        }

        public final JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        public final JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }

        public final <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }
}
