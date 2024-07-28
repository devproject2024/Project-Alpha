package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.util.p;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f38754a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38755b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38756c;

    /* renamed from: d  reason: collision with root package name */
    public final String f38757d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38758e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38759f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38760g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38761a;

        /* renamed from: b  reason: collision with root package name */
        public String f38762b;

        /* renamed from: c  reason: collision with root package name */
        public String f38763c;

        /* renamed from: d  reason: collision with root package name */
        public String f38764d;

        /* renamed from: e  reason: collision with root package name */
        public String f38765e;

        /* renamed from: f  reason: collision with root package name */
        public String f38766f;

        /* renamed from: g  reason: collision with root package name */
        public String f38767g;
    }

    public /* synthetic */ g(String str, String str2, String str3, String str4, String str5, String str6, String str7, byte b2) {
        this(str, str2, str3, str4, str5, str6, str7);
    }

    private g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        s.a(!p.a(str), (Object) "ApplicationId must be set.");
        this.f38755b = str;
        this.f38754a = str2;
        this.f38758e = str3;
        this.f38759f = str4;
        this.f38756c = str5;
        this.f38760g = str6;
        this.f38757d = str7;
    }

    public static g a(Context context) {
        v vVar = new v(context);
        String a2 = vVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new g(a2, vVar.a("google_api_key"), vVar.a("firebase_database_url"), vVar.a("ga_trackingId"), vVar.a("gcm_defaultSenderId"), vVar.a("google_storage_bucket"), vVar.a("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!q.a(this.f38755b, gVar.f38755b) || !q.a(this.f38754a, gVar.f38754a) || !q.a(this.f38758e, gVar.f38758e) || !q.a(this.f38759f, gVar.f38759f) || !q.a(this.f38756c, gVar.f38756c) || !q.a(this.f38760g, gVar.f38760g) || !q.a(this.f38757d, gVar.f38757d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return q.a(this.f38755b, this.f38754a, this.f38758e, this.f38759f, this.f38756c, this.f38760g, this.f38757d);
    }

    public final String toString() {
        return q.a((Object) this).a("applicationId", this.f38755b).a("apiKey", this.f38754a).a("databaseUrl", this.f38758e).a("gcmSenderId", this.f38756c).a("storageBucket", this.f38760g).a("projectId", this.f38757d).toString();
    }
}
