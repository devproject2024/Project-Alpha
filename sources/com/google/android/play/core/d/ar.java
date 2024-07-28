package com.google.android.play.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.google.android.play.core.d.b.a;
import com.google.android.play.core.d.b.b;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.p;
import com.google.android.play.core.splitcompat.r;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ar implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f37357a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37358b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f37359c;

    /* renamed from: d  reason: collision with root package name */
    private final m f37360d;

    public ar(Context context, Executor executor, m mVar) {
        this.f37358b = as.a(context);
        this.f37357a = executor;
        this.f37360d = mVar;
    }

    public final e<List<d>> a() {
        return a(an.f37354a);
    }

    public final e<Void> a(int i2) {
        return a(new am(i2));
    }

    public final e<Integer> a(c cVar) {
        return a(new al(cVar));
    }

    public final e<Void> a(List<String> list) {
        return a(new ao(list));
    }

    public final void a(e eVar) {
        a(new ah(eVar));
    }

    public final boolean a(d dVar, Activity activity, int i2) throws IntentSender.SendIntentException {
        return c().a(dVar, activity, i2);
    }

    public final e<Void> b(List<String> list) {
        return a(new ap(list));
    }

    public final Set<String> b() {
        return c().b();
    }

    /* access modifiers changed from: package-private */
    public final synchronized b c() {
        b bVar = this.f37359c;
        if (bVar != null) {
            return bVar;
        }
        Context context = this.f37358b;
        File a2 = b.a(context);
        b aVar = a2 != null ? new a(context, a2, r.a()) : new l(new z(context), context);
        this.f37359c = aVar;
        return aVar;
    }

    private final <T> e<T> a(aq<T> aqVar) {
        b bVar = this.f37359c;
        if (bVar != null) {
            return aqVar.a(bVar);
        }
        p pVar = new p();
        p pVar2 = new p();
        pVar2.f37476a.a(new ai(aqVar, pVar));
        this.f37357a.execute(new aj(this, pVar2));
        return pVar.f37476a;
    }
}
