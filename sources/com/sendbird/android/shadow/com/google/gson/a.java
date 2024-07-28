package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.JavaVersion;
import com.sendbird.android.shadow.com.google.gson.internal.PreJava9DateFormatProvider;
import com.sendbird.android.shadow.com.google.gson.internal.bind.util.ISO8601Utils;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
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

final class a extends TypeAdapter<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Date> f44865a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f44866b = new ArrayList();

    public final /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.f44866b) {
            jsonWriter.value(this.f44866b.get(0).format(date));
        }
    }

    a(Class<? extends Date> cls, String str) {
        this.f44865a = a(cls);
        this.f44866b.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f44866b.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        this.f44865a = a(cls);
        this.f44866b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f44866b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.f44866b.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i2, i3));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    private Date a(String str) {
        synchronized (this.f44866b) {
            for (DateFormat parse : this.f44866b) {
                try {
                    Date parse2 = parse.parse(str);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                Date parse3 = ISO8601Utils.parse(str, new ParsePosition(0));
                return parse3;
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        }
    }

    public final String toString() {
        DateFormat dateFormat = this.f44866b.get(0);
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
        Class<? extends Date> cls = this.f44865a;
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
