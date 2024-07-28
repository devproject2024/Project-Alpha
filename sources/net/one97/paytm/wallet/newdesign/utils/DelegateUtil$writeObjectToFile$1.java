package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.p2p.theme.e;

@f(b = "DelegrateUtil.kt", c = {36}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$writeObjectToFile$1")
final class DelegateUtil$writeObjectToFile$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filename;
    final /* synthetic */ Object $obj;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegateUtil$writeObjectToFile$1(Context context, Object obj, String str, d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$obj = obj;
        this.$filename = str;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DelegateUtil$writeObjectToFile$1 delegateUtil$writeObjectToFile$1 = new DelegateUtil$writeObjectToFile$1(this.$context, this.$obj, this.$filename, dVar);
        delegateUtil$writeObjectToFile$1.p$ = (CoroutineScope) obj;
        return delegateUtil$writeObjectToFile$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DelegateUtil$writeObjectToFile$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof p.b)) {
            e.a(this.$context, this.$obj, this.$filename);
            return x.f47997a;
        } else {
            throw ((p.b) obj).exception;
        }
    }
}
