package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@f(b = "OneClickLoadingSheet.kt", c = {67, 139}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet$initView$2")
final class OneClickLoadingSheet$initView$2 extends k implements m<CoroutineScope, d<? super x>, Object> {
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ OneClickLoadingSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingSheet$initView$2(OneClickLoadingSheet oneClickLoadingSheet, d dVar) {
        super(2, dVar);
        this.this$0 = oneClickLoadingSheet;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        OneClickLoadingSheet$initView$2 oneClickLoadingSheet$initView$2 = new OneClickLoadingSheet$initView$2(this.this$0, dVar);
        oneClickLoadingSheet$initView$2.p$ = (CoroutineScope) obj;
        return oneClickLoadingSheet$initView$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((OneClickLoadingSheet$initView$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            coroutineScope = this.p$;
            OneClickLoadingSheet oneClickLoadingSheet = this.this$0;
            int access$getTransactionMaxTime$p = oneClickLoadingSheet.transactionMaxTime;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = oneClickLoadingSheet.timer(access$getTransactionMaxTime$p, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(obj);
        } else if (i2 == 2) {
            ResultKt.a(obj);
            return x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow = (Flow) obj;
        this.L$0 = coroutineScope;
        this.L$1 = flow;
        this.label = 2;
        if (flow.collect(new OneClickLoadingSheet$initView$2$invokeSuspend$$inlined$collect$1(this), this) == aVar) {
            return aVar;
        }
        return x.f47997a;
    }
}
