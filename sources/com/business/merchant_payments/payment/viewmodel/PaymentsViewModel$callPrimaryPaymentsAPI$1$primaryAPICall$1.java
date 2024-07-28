package com.business.merchant_payments.payment.viewmodel;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.primary.PrimaryAPIModel;
import com.business.merchant_payments.payment.PaymentsRepo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "PaymentsViewModel.kt", c = {157}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1")
public final class PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1 extends k implements m<CoroutineScope, d<? super b<PrimaryAPIModel>>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    public PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1 paymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1 = new PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1(dVar);
        paymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1.p$ = (CoroutineScope) obj;
        return paymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsViewModel$callPrimaryPaymentsAPI$1$primaryAPICall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            PaymentsRepo paymentsRepo = PaymentsRepo.INSTANCE;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = paymentsRepo.callPrimaryAPI(4, this);
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
