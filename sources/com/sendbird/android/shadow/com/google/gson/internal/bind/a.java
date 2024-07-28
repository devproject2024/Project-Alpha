package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class a<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f44983a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<T> f44984b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f44985c;

    a(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f44983a = gson;
        this.f44984b = typeAdapter;
        this.f44985c = type;
    }

    public final T read(JsonReader jsonReader) throws IOException {
        return this.f44984b.read(jsonReader);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f44984b;
        Type type = this.f44985c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f44985c) {
            typeAdapter = this.f44983a.getAdapter(TypeToken.get(type));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.f44984b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(jsonWriter, t);
    }
}
