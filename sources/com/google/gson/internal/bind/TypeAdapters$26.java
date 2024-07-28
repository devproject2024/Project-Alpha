package com.google.gson.internal.bind;

import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

class TypeAdapters$26 implements x {
    TypeAdapters$26() {
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType() != Timestamp.class) {
            return null;
        }
        final w<Date> a2 = fVar.a(Date.class);
        return new w<Timestamp>() {
            public final /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
                a2.write(jsonWriter, (Timestamp) obj);
            }

            public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
                Date date = (Date) a2.read(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }
        };
    }
}
