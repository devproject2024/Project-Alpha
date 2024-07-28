package com.google.firebase.crashlytics.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.a.c.g;
import com.google.firebase.crashlytics.a.c.r;
import com.google.firebase.crashlytics.a.c.t;
import com.google.firebase.crashlytics.a.c.v;
import com.google.firebase.crashlytics.a.f.c;
import com.google.firebase.crashlytics.a.k.a.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final c f38362a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final com.google.firebase.c f38363b;

    /* renamed from: c  reason: collision with root package name */
    public String f38364c;

    /* renamed from: d  reason: collision with root package name */
    public String f38365d;

    /* renamed from: e  reason: collision with root package name */
    public v f38366e;

    /* renamed from: f  reason: collision with root package name */
    public r f38367f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f38368g;

    /* renamed from: h  reason: collision with root package name */
    private PackageManager f38369h;

    /* renamed from: i  reason: collision with root package name */
    private String f38370i;
    private PackageInfo j;
    private String k;
    private String l;
    private String m;

    public e(com.google.firebase.c cVar, Context context, v vVar, r rVar) {
        this.f38363b = cVar;
        this.f38368g = context;
        this.f38366e = vVar;
        this.f38367f = rVar;
    }

    public final boolean a() {
        String str;
        try {
            this.k = this.f38366e.b();
            this.f38369h = this.f38368g.getPackageManager();
            this.f38370i = this.f38368g.getPackageName();
            this.j = this.f38369h.getPackageInfo(this.f38370i, 0);
            this.f38364c = Integer.toString(this.j.versionCode);
            if (this.j.versionName == null) {
                str = "0.0";
            } else {
                str = this.j.versionName;
            }
            this.f38365d = str;
            this.l = this.f38369h.getApplicationLabel(this.f38368g.getApplicationInfo()).toString();
            this.m = Integer.toString(this.f38368g.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            b.a().a(6);
            return false;
        }
    }

    public final String b() {
        return g.b(this.f38368g, "com.crashlytics.ApiEndpoint");
    }

    /* access modifiers changed from: package-private */
    public final a a(String str, String str2) {
        return new a(str, str2, this.f38366e.f38323a, this.f38365d, this.f38364c, g.a(g.i(this.f38368g), str2, this.f38365d, this.f38364c), this.l, t.determineFrom(this.k).getId(), this.m, "0");
    }
}
