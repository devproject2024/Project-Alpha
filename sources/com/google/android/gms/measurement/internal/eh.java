package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class eh extends fw {

    /* renamed from: a  reason: collision with root package name */
    static final Pair<String, Long> f11858a = new Pair<>("", 0L);
    private boolean A;
    private long B;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f11859b;

    /* renamed from: c  reason: collision with root package name */
    public ek f11860c;

    /* renamed from: d  reason: collision with root package name */
    public final el f11861d = new el(this, "last_upload", 0);

    /* renamed from: e  reason: collision with root package name */
    public final el f11862e = new el(this, "last_upload_attempt", 0);

    /* renamed from: f  reason: collision with root package name */
    public final el f11863f = new el(this, "backoff", 0);

    /* renamed from: g  reason: collision with root package name */
    public final el f11864g = new el(this, "last_delete_stale", 0);

    /* renamed from: h  reason: collision with root package name */
    public final el f11865h = new el(this, "midnight_offset", 0);

    /* renamed from: i  reason: collision with root package name */
    public final el f11866i = new el(this, "first_open_time", 0);
    public final el j = new el(this, "app_install_time", 0);
    public final en k = new en(this, "app_instance_id");
    public final el l = new el(this, "time_before_start", 10000);
    public final el m = new el(this, "session_timeout", 1800000);
    public final ej n = new ej(this, "start_new_session", true);
    public final en o = new en(this, "non_personalized_ads");
    public final ej p = new ej(this, "use_dynamite_api", false);
    public final ej q = new ej(this, "allow_remote_dynamite", false);
    public final el r = new el(this, "last_pause_time", 0);
    public final el s = new el(this, "time_active", 0);
    public boolean t;
    public ej u = new ej(this, "app_backgrounded", false);
    public ej v = new ej(this, "deep_link_retrieval_complete", false);
    public el w = new el(this, "deep_link_retrieval_attempts", 0);
    public final en x = new en(this, "firebase_feature_rollouts");
    private String z;

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> a(String str) {
        h();
        long b2 = j().b();
        String str2 = this.z;
        if (str2 != null && b2 < this.B) {
            return new Pair<>(str2, Boolean.valueOf(this.A));
        }
        this.B = b2 + H_().a(str, o.f12347b);
        AdvertisingIdClient.a();
        try {
            AdvertisingIdClient.a a2 = AdvertisingIdClient.a(k());
            if (a2 != null) {
                this.z = a2.f8043a;
                this.A = a2.f8044b;
            }
            if (this.z == null) {
                this.z = "";
            }
        } catch (Exception e2) {
            J_().j.a("Unable to get advertising id", e2);
            this.z = "";
        }
        AdvertisingIdClient.a();
        return new Pair<>(this.z, Boolean.valueOf(this.A));
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final String b(String str) {
        h();
        String str2 = (String) a(str).first;
        MessageDigest e2 = jq.e();
        if (e2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, e2.digest(str2.getBytes()))});
    }

    eh(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f11859b = k().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.t = this.f11859b.getBoolean("has_been_opened", false);
        if (!this.t) {
            SharedPreferences.Editor edit = this.f11859b.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f11860c = new ek(this, "health_monitor", Math.max(0, o.f12348c.a(null).longValue()), (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences c() {
        h();
        w();
        return this.f11859b;
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        h();
        SharedPreferences.Editor edit = c().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String d() {
        h();
        return c().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void d(String str) {
        h();
        SharedPreferences.Editor edit = c().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String e() {
        h();
        return c().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final Boolean r() {
        h();
        if (!c().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(c().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        h();
        J_().k.a("Setting useService", Boolean.valueOf(z2));
        SharedPreferences.Editor edit = c().edit();
        edit.putBoolean("use_service", z2);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        h();
        J_().k.a("Clearing collection preferences.");
        Boolean t2 = t();
        SharedPreferences.Editor edit = c().edit();
        edit.clear();
        edit.apply();
        if (t2 != null) {
            b(t2.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z2) {
        h();
        J_().k.a("Setting measurementEnabled", Boolean.valueOf(z2));
        SharedPreferences.Editor edit = c().edit();
        edit.putBoolean("measurement_enabled", z2);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final Boolean t() {
        h();
        if (c().contains("measurement_enabled")) {
            return Boolean.valueOf(c().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String u() {
        h();
        String string = c().getString("previous_os_version", (String) null);
        i().w();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = c().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final void c(boolean z2) {
        h();
        J_().k.a("Updating deferred analytics collection", Boolean.valueOf(z2));
        SharedPreferences.Editor edit = c().edit();
        edit.putBoolean("deferred_analytics_collection", z2);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(long j2) {
        return j2 - this.m.a() > this.r.a();
    }
}
