package com.business.merchant_payments.payment;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "PaymentsRepo.kt", c = {36}, d = "callPrimaryAPI", e = "com.business.merchant_payments.payment.PaymentsRepo")
public final class PaymentsRepo$callPrimaryAPI$1 extends d {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PaymentsRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsRepo$callPrimaryAPI$1(PaymentsRepo paymentsRepo, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = paymentsRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.callPrimaryAPI(0, this);
    }
}
