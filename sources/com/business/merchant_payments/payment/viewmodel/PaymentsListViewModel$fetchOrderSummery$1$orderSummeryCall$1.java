package com.business.merchant_payments.payment.viewmodel;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import com.business.merchant_payments.payment.PaymentsRepo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "PaymentsListViewModel.kt", c = {68}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1")
public final class PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1 extends k implements m<CoroutineScope, d<? super b<SummaryDateRangeViewData>>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ PaymentsListViewModel$fetchOrderSummery$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1(PaymentsListViewModel$fetchOrderSummery$1 paymentsListViewModel$fetchOrderSummery$1, d dVar) {
        super(2, dVar);
        this.this$0 = paymentsListViewModel$fetchOrderSummery$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1 paymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1 = new PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1(this.this$0, dVar);
        paymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1.p$ = (CoroutineScope) obj;
        return paymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            PaymentsRepo paymentsRepo = PaymentsRepo.INSTANCE;
            String mStartDate = this.this$0.this$0.getMStartDate();
            String mEndDate = this.this$0.this$0.getMEndDate();
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = paymentsRepo.getOrderSummeryData(mStartDate, mEndDate, this);
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
