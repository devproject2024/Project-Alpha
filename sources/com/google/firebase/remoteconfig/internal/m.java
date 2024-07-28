package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.internal.o;
import com.google.firebase.remoteconfig.l;
import com.google.firebase.remoteconfig.n;
import java.util.Date;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    static final Date f39402a = new Date(-1);

    /* renamed from: b  reason: collision with root package name */
    static final Date f39403b = new Date(-1);

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f39404c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f39405d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Object f39406e = new Object();

    public m(SharedPreferences sharedPreferences) {
        this.f39404c = sharedPreferences;
    }

    public final boolean a() {
        return this.f39404c.getBoolean("is_developer_mode_enabled", false);
    }

    public final long b() {
        return this.f39404c.getLong("fetch_timeout_in_seconds", 60);
    }

    public final long c() {
        return this.f39404c.getLong("minimum_fetch_interval_in_seconds", g.f39375a);
    }

    public final l d() {
        o oVar;
        synchronized (this.f39405d) {
            long j = this.f39404c.getLong("last_fetch_time_in_millis", -1);
            int i2 = this.f39404c.getInt("last_fetch_status", 0);
            n.a aVar = new n.a();
            aVar.f39431a = this.f39404c.getBoolean("is_developer_mode_enabled", false);
            long j2 = this.f39404c.getLong("fetch_timeout_in_seconds", 60);
            if (j2 >= 0) {
                aVar.f39432b = j2;
                n a2 = aVar.a(this.f39404c.getLong("minimum_fetch_interval_in_seconds", g.f39375a)).a();
                o.a aVar2 = new o.a((byte) 0);
                aVar2.f39416b = i2;
                aVar2.f39415a = j;
                aVar2.f39417c = a2;
                oVar = new o(aVar2.f39415a, aVar2.f39416b, aVar2.f39417c, (byte) 0);
            } else {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", new Object[]{Long.valueOf(j2)}));
            }
        }
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        synchronized (this.f39405d) {
            this.f39404c.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public final a e() {
        a aVar;
        synchronized (this.f39406e) {
            aVar = new a(this.f39404c.getInt("num_failed_fetches", 0), new Date(this.f39404c.getLong("backoff_end_time_in_millis", -1)));
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Date date) {
        synchronized (this.f39406e) {
            this.f39404c.edit().putInt("num_failed_fetches", i2).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f39407a;

        /* renamed from: b  reason: collision with root package name */
        Date f39408b;

        a(int i2, Date date) {
            this.f39407a = i2;
            this.f39408b = date;
        }
    }
}
