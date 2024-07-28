package com.google.gson.internal.bind;

import com.google.gson.internal.bind.a.a;
import com.google.gson.internal.d;
import com.google.gson.internal.i;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f39550a = new DateTypeAdapter$1();

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f39551b = new ArrayList();

    public b() {
        this.f39551b.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f39551b.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.b()) {
            this.f39551b.add(i.a(2, 2));
        }
    }

    private synchronized Date a(String str) {
        for (DateFormat parse : this.f39551b) {
            try {
                return parse.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return a.a(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new u(str, e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.f39551b.get(0).format(date));
        }
    }

    public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return a(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }
}
