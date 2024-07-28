package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.s;
import java.lang.ref.WeakReference;

final class ai implements c.C0130c {

    /* renamed from: a  reason: collision with root package name */
    final boolean f8414a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<ag> f8415b;

    /* renamed from: c  reason: collision with root package name */
    private final a<?> f8416c;

    public ai(ag agVar, a<?> aVar, boolean z) {
        this.f8415b = new WeakReference<>(agVar);
        this.f8416c = aVar;
        this.f8414a = z;
    }

    public final void a(ConnectionResult connectionResult) {
        ag agVar = (ag) this.f8415b.get();
        if (agVar != null) {
            s.a(Looper.myLooper() == agVar.f8403a.m.b(), (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            agVar.f8404b.lock();
            try {
                if (agVar.b(0)) {
                    if (!connectionResult.b()) {
                        agVar.b(connectionResult, this.f8416c, this.f8414a);
                    }
                    if (agVar.d()) {
                        agVar.e();
                    }
                    agVar.f8404b.unlock();
                }
            } finally {
                agVar.f8404b.unlock();
            }
        }
    }
}
