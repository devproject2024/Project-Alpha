package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.internal.firebase_ml.bg;
import com.google.android.gms.internal.firebase_ml.dt;

public final class eg implements dt.b {

    /* renamed from: a  reason: collision with root package name */
    private static final j f9858a = new j("MlStatsLogger", "");

    /* renamed from: b  reason: collision with root package name */
    private final a f9859b;

    public eg(Context context) {
        this.f9859b = a.a(context, "FIREBASE_ML_SDK");
    }

    public final void a(bg.e eVar) {
        j jVar = f9858a;
        String valueOf = String.valueOf(eVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(valueOf);
        jVar.a(sb.toString());
        this.f9859b.a(eVar.e()).a();
    }
}
