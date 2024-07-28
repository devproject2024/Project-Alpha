package com.google.gson;

import com.google.gson.internal.d;
import com.google.gson.internal.i;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

final class a extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Date> f39446a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f39447b = new ArrayList();

    public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.f39447b) {
            jsonWriter.value(this.f39447b.get(0).format(date));
        }
    }

    a(Class<? extends Date> cls, String str) {
        this.f39446a = a(cls);
        this.f39447b.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f39447b.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        this.f39446a = a(cls);
        this.f39447b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f39447b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (d.b()) {
            this.f39447b.add(i.a(i2, i3));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    private Date a(String str) {
        synchronized (this.f39447b) {
            for (DateFormat parse : this.f39447b) {
                try {
                    Date parse2 = parse.parse(str);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                Date a2 = com.google.gson.internal.bind.a.a.a(str, new ParsePosition(0));
                return a2;
            } catch (ParseException e2) {
                throw new u(str, e2);
            }
        }
    }

    public final String toString() {
        DateFormat dateFormat = this.f39447b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public final /* synthetic */ Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Date a2 = a(jsonReader.nextString());
        Class<? extends Date> cls = this.f39446a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }
}
