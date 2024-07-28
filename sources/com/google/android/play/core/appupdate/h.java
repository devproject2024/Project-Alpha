package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.a.c;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.p;

final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final o f36901a;

    /* renamed from: b  reason: collision with root package name */
    private final f f36902b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f36903c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f36904d = new Handler(Looper.getMainLooper());

    h(o oVar, Context context) {
        this.f36901a = oVar;
        this.f36902b = new f(context);
        this.f36903c = context;
    }

    public final synchronized void a(c cVar) {
        this.f36902b.a(cVar);
    }

    public final synchronized void b(c cVar) {
        this.f36902b.b(cVar);
    }

    public final e<a> a() {
        o oVar = this.f36901a;
        String packageName = this.f36903c.getPackageName();
        if (oVar.f36919b == null) {
            return o.a();
        }
        o.f36917a.d("requestUpdateInfo(%s)", packageName);
        p pVar = new p();
        oVar.f36919b.a((com.google.android.play.core.b.c) new j(oVar, pVar, packageName, pVar));
        return pVar.f37476a;
    }

    public final boolean a(a aVar, int i2, Activity activity, int i3) throws IntentSender.SendIntentException {
        e b2 = e.a(i2).b();
        g gVar = new g(activity);
        if (!(aVar.a(b2) != null)) {
            return false;
        }
        gVar.a(aVar.a(b2).getIntentSender(), i3);
        return true;
    }

    public final e<Void> b() {
        o oVar = this.f36901a;
        String packageName = this.f36903c.getPackageName();
        if (oVar.f36919b == null) {
            return o.a();
        }
        o.f36917a.d("completeUpdate(%s)", packageName);
        p pVar = new p();
        oVar.f36919b.a((com.google.android.play.core.b.c) new k(oVar, pVar, pVar, packageName));
        return pVar.f37476a;
    }
}
