package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@f(b = "OneClickLoadingHelper.kt", c = {115, 151}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$redirectToBankPage$1")
final class OneClickLoadingHelper$redirectToBankPage$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ a $suspendFunction;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ OneClickLoadingHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingHelper$redirectToBankPage$1(OneClickLoadingHelper oneClickLoadingHelper, a aVar, d dVar) {
        super(2, dVar);
        this.this$0 = oneClickLoadingHelper;
        this.$suspendFunction = aVar;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        OneClickLoadingHelper$redirectToBankPage$1 oneClickLoadingHelper$redirectToBankPage$1 = new OneClickLoadingHelper$redirectToBankPage$1(this.this$0, this.$suspendFunction, dVar);
        oneClickLoadingHelper$redirectToBankPage$1.p$ = (CoroutineScope) obj;
        return oneClickLoadingHelper$redirectToBankPage$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((OneClickLoadingHelper$redirectToBankPage$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i2;
        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope2 = this.p$;
            i2 = this.this$0.messageSwitchTime + 10;
            OneClickLoadingHelper oneClickLoadingHelper = this.this$0;
            this.L$0 = coroutineScope2;
            this.I$0 = i2;
            this.label = 1;
            Object timer = oneClickLoadingHelper.timer(i2, this);
            if (timer == aVar) {
                return aVar;
            }
            Object obj2 = timer;
            coroutineScope = coroutineScope2;
            obj = obj2;
        } else if (i3 == 1) {
            i2 = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(obj);
        } else if (i3 == 2) {
            ResultKt.a(obj);
            this.this$0.onDestroy();
            return x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow = (Flow) obj;
        this.L$0 = coroutineScope;
        this.I$0 = i2;
        this.L$1 = flow;
        this.label = 2;
        if (flow.collect(new OneClickLoadingHelper$redirectToBankPage$1$invokeSuspend$$inlined$collect$1(this), this) == aVar) {
            return aVar;
        }
        this.this$0.onDestroy();
        return x.f47997a;
    }
}
