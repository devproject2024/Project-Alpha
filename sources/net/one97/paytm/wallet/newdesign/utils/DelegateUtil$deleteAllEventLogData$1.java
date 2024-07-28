package net.one97.paytm.wallet.newdesign.utils;

import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

@f(b = "DelegrateUtil.kt", c = {55}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$deleteAllEventLogData$1")
final class DelegateUtil$deleteAllEventLogData$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;

    DelegateUtil$deleteAllEventLogData$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DelegateUtil$deleteAllEventLogData$1 delegateUtil$deleteAllEventLogData$1 = new DelegateUtil$deleteAllEventLogData$1(dVar);
        delegateUtil$deleteAllEventLogData$1.p$ = (CoroutineScope) obj;
        return delegateUtil$deleteAllEventLogData$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DelegateUtil$deleteAllEventLogData$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof p.b)) {
            c a2 = b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            net.one97.paytm.wallet.newdesign.a.a.a(a2.getContext()).d();
            return x.f47997a;
        } else {
            throw ((p.b) obj).exception;
        }
    }
}
