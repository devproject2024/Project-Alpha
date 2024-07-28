package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.location.aa;
import com.google.android.gms.internal.location.aj;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<Object> f11372a = new com.google.android.gms.common.api.a<>("LocationServices.API", f11377f, f11376e);
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final a f11373b = new aj();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final c f11374c = new e();
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final h f11375d = new aa();

    /* renamed from: e  reason: collision with root package name */
    private static final a.g<t> f11376e = new a.g<>();

    /* renamed from: f  reason: collision with root package name */
    private static final a.C0125a<t, Object> f11377f = new m();

    public static abstract class a<R extends l> extends d.a<R, t> {
        public a(com.google.android.gms.common.api.e eVar) {
            super(f.f11372a, eVar);
        }
    }

    public static t a(com.google.android.gms.common.api.e eVar) {
        boolean z = true;
        s.b(eVar != null, "GoogleApiClient parameter is required.");
        t tVar = (t) eVar.a(f11376e);
        if (tVar == null) {
            z = false;
        }
        s.a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return tVar;
    }

    public static i a(Activity activity) {
        return new i(activity);
    }

    public static i a(Context context) {
        return new i(context);
    }

    public static b b(Activity activity) {
        return new b(activity);
    }

    public static b b(Context context) {
        return new b(context);
    }
}
