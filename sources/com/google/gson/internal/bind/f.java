package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class f extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f39566a = new SqlDateTypeAdapter$1();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f39567b = new SimpleDateFormat("MMM d, yyyy");

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.f39567b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e2) {
            throw new u((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.value(date == null ? null : this.f39567b.format(date));
    }
}
