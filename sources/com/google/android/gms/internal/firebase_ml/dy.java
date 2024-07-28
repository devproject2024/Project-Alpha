package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.bg;

final /* synthetic */ class dy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final dt f9836a;

    /* renamed from: b  reason: collision with root package name */
    private final bg.e.a f9837b;

    /* renamed from: c  reason: collision with root package name */
    private final br f9838c;

    dy(dt dtVar, bg.e.a aVar, br brVar) {
        this.f9836a = dtVar;
        this.f9837b = aVar;
        this.f9838c = brVar;
    }

    public final void run() {
        String str;
        dt dtVar = this.f9836a;
        bg.e.a aVar = this.f9837b;
        br brVar = this.f9838c;
        if (!dtVar.a()) {
            dt.f9818a.a("Logging is disabled.");
            return;
        }
        String str2 = aVar.a().zzbia;
        if ("NA".equals(str2) || "".equals(str2)) {
            str2 = "NA";
        }
        bg.ae.a a2 = bg.ae.a().a(dtVar.f9819b).b(dtVar.f9820c).c(dtVar.f9821d).f(dtVar.f9822e).g(dtVar.f9823f).e(str2).a((Iterable<String>) dt.b());
        if (dtVar.f9825h.b()) {
            str = dtVar.f9825h.d();
        } else {
            str = dj.a().a("firebase-ml-common");
        }
        aVar.a(brVar).a(a2.d(str));
        try {
            dtVar.f9824g.a((bg.e) aVar.i());
        } catch (RuntimeException unused) {
            dt.f9818a.d("Exception thrown from the logging side");
        }
    }
}
