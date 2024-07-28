package com.google.gson;

import com.google.gson.internal.bind.c;
import com.google.gson.internal.bind.d;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class w<T> {
    public abstract T read(JsonReader jsonReader) throws IOException;

    public abstract void write(JsonWriter jsonWriter, T t) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new JsonWriter(writer), t);
    }

    public final w<T> nullSafe() {
        return new w<T>() {
            public final void write(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    w.this.write(jsonWriter, t);
                }
            }

            public final T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return w.this.read(jsonReader);
                }
                jsonReader.nextNull();
                return null;
            }
        };
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final l toJsonTree(T t) {
        try {
            d dVar = new d();
            write(dVar, t);
            return dVar.a();
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson((Reader) new StringReader(str));
    }

    public final T fromJsonTree(l lVar) {
        try {
            return read(new c(lVar));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }
}
