package net.one97.paytm.ups;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.ups.manager.DatabaseManager;

@f(b = "UpsSdk.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.ups.UpsSdk$nukeTable$1")
final class UpsSdk$nukeTable$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;

    UpsSdk$nukeTable$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        UpsSdk$nukeTable$1 upsSdk$nukeTable$1 = new UpsSdk$nukeTable$1(dVar);
        upsSdk$nukeTable$1.p$ = (CoroutineScope) obj;
        return upsSdk$nukeTable$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UpsSdk$nukeTable$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            DatabaseManager.INSTANCE.getDatabase().getUpsDao().deleteTable();
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
