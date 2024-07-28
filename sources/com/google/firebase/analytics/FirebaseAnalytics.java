package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.d;
import com.google.android.gms.internal.measurement.mk;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.fc;
import com.google.android.gms.measurement.internal.hd;
import com.google.android.gms.measurement.internal.kd;
import com.google.firebase.iid.FirebaseInstanceId;

public final class FirebaseAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static volatile FirebaseAnalytics f37954a;

    /* renamed from: b  reason: collision with root package name */
    private final fc f37955b;

    /* renamed from: c  reason: collision with root package name */
    private final mk f37956c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f37957d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f37958e;

    public static FirebaseAnalytics getInstance(Context context) {
        if (f37954a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f37954a == null) {
                    if (mk.b(context)) {
                        f37954a = new FirebaseAnalytics(mk.a(context));
                    } else {
                        f37954a = new FirebaseAnalytics(fc.a(context, (zzv) null));
                    }
                }
            }
        }
        return f37954a;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f37957d) {
            mk mkVar = this.f37956c;
            mkVar.a((mk.a) new d(mkVar, activity, str, str2));
        } else if (!kd.a()) {
            this.f37955b.J_().f11831f.a("setCurrentScreen must be called from the main thread");
        } else {
            this.f37955b.h().a(activity, str, str2);
        }
    }

    private FirebaseAnalytics(fc fcVar) {
        s.a(fcVar);
        this.f37955b = fcVar;
        this.f37956c = null;
        this.f37957d = false;
        this.f37958e = new Object();
    }

    private FirebaseAnalytics(mk mkVar) {
        s.a(mkVar);
        this.f37955b = null;
        this.f37956c = mkVar;
        this.f37957d = true;
        this.f37958e = new Object();
    }

    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.a().d();
    }

    public static hd getScionFrontendApiImplementation(Context context, Bundle bundle) {
        mk a2;
        if (mk.b(context) && (a2 = mk.a(context, bundle)) != null) {
            return new a(a2);
        }
        return null;
    }
}
