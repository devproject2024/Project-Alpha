package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class g extends w<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f39568a = new TimeTypeAdapter$1();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f39569b = new SimpleDateFormat("hh:mm:ss a");

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Time read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Time(this.f39569b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e2) {
            throw new u((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void write(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.f39569b.format(time));
    }
}
