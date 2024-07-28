package androidx.lifecycle;

import androidx.lifecycle.k;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

final class LifecycleController$observer$1 implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f3581a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Job f3582b;

    public final void a(q qVar, k.a aVar) {
        kotlin.g.b.k.c(qVar, "source");
        kotlin.g.b.k.c(aVar, "<anonymous parameter 1>");
        k lifecycle = qVar.getLifecycle();
        kotlin.g.b.k.a((Object) lifecycle, "source.lifecycle");
        if (lifecycle.a() == k.b.DESTROYED) {
            l lVar = this.f3581a;
            Job.DefaultImpls.cancel$default(this.f3582b, (CancellationException) null, 1, (Object) null);
            lVar.f3671b.b(lVar.f3670a);
            e eVar = lVar.f3673d;
            eVar.f3666b = true;
            eVar.a();
            return;
        }
        k lifecycle2 = qVar.getLifecycle();
        kotlin.g.b.k.a((Object) lifecycle2, "source.lifecycle");
        if (lifecycle2.a().compareTo(this.f3581a.f3672c) < 0) {
            this.f3581a.f3673d.f3665a = true;
            return;
        }
        e eVar2 = this.f3581a.f3673d;
        if (!eVar2.f3665a) {
            return;
        }
        if (!eVar2.f3666b) {
            eVar2.f3665a = false;
            eVar2.a();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}
