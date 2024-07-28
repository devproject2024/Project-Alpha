package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.d.b;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.v;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j extends y<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final z f39686a = new z() {
        public final <T> y<T> a(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new j();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f39687b = new SimpleDateFormat("hh:mm:ss a");

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Time a(com.google.gsonhtcfix.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            return new Time(this.f39687b.parse(aVar.i()).getTime());
        } catch (ParseException e2) {
            throw new v((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f39687b.format(time));
    }
}
