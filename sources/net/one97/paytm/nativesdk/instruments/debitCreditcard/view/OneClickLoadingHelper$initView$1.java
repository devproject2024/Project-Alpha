package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@f(b = "OneClickLoadingHelper.kt", c = {58, 151}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1")
final class OneClickLoadingHelper$initView$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ x.e $iterator;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ OneClickLoadingHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingHelper$initView$1(OneClickLoadingHelper oneClickLoadingHelper, x.e eVar, d dVar) {
        super(2, dVar);
        this.this$0 = oneClickLoadingHelper;
        this.$iterator = eVar;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        OneClickLoadingHelper$initView$1 oneClickLoadingHelper$initView$1 = new OneClickLoadingHelper$initView$1(this.this$0, this.$iterator, dVar);
        oneClickLoadingHelper$initView$1.p$ = (CoroutineScope) obj;
        return oneClickLoadingHelper$initView$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((OneClickLoadingHelper$initView$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        x.e eVar;
        x.c cVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            coroutineScope = this.p$;
            x.e eVar2 = new x.e();
            eVar2.element = "";
            cVar = new x.c();
            cVar.element = -1;
            OneClickTransactionInfo paytmSdkCallback = this.this$0.getPaytmSdkCallback();
            if (paytmSdkCallback != null) {
                paytmSdkCallback.oneClickProgressInfo(State.STARTED, new ProcessingInfo((String) eVar2.element, cVar.element));
            }
            OneClickLoadingHelper oneClickLoadingHelper = this.this$0;
            int access$getTransactionMaxTime$p = oneClickLoadingHelper.transactionMaxTime;
            this.L$0 = coroutineScope;
            this.L$1 = eVar2;
            this.L$2 = cVar;
            this.label = 1;
            Object timer = oneClickLoadingHelper.timer(access$getTransactionMaxTime$p, this);
            if (timer == aVar) {
                return aVar;
            }
            Object obj2 = timer;
            eVar = eVar2;
            obj = obj2;
        } else if (i2 == 1) {
            cVar = (x.c) this.L$2;
            eVar = (x.e) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(obj);
        } else if (i2 == 2) {
            ResultKt.a(obj);
            return kotlin.x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow = (Flow) obj;
        this.L$0 = coroutineScope;
        this.L$1 = eVar;
        this.L$2 = cVar;
        this.L$3 = flow;
        this.label = 2;
        if (flow.collect(new OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1(this, eVar, cVar), this) == aVar) {
            return aVar;
        }
        return kotlin.x.f47997a;
    }
}
