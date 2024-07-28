package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.nativesdk.transcation.PayUtility;

final class OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1(d dVar, OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1 oneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1) {
        super(2, dVar);
        this.this$0 = oneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1 oneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1 = new OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1(dVar, this.this$0);
        oneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1.p$ = (CoroutineScope) obj;
        return oneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            this.this$0.this$0.this$0.onDestroy();
            PayUtility.killPaytmSDK(this.this$0.this$0.this$0.getContext());
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
