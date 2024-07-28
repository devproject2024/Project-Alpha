package com.business.merchant_payments.newhome;

import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "AcceptPaymentViewModel.kt", c = {201}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1")
public final class AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1 extends k implements m<CoroutineScope, d<? super HomeResponse>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    public AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1 acceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1 = new AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1(dVar);
        acceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            StorefrontRepo storefrontRepo = StorefrontRepo.INSTANCE;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = storefrontRepo.makeStorefrontCall(this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
