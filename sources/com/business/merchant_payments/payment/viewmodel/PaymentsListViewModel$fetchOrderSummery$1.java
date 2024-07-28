package com.business.merchant_payments.payment.viewmodel;

import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "PaymentsListViewModel.kt", c = {69}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel$fetchOrderSummery$1")
public final class PaymentsListViewModel$fetchOrderSummery$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ PaymentsListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsListViewModel$fetchOrderSummery$1(PaymentsListViewModel paymentsListViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = paymentsListViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsListViewModel$fetchOrderSummery$1 paymentsListViewModel$fetchOrderSummery$1 = new PaymentsListViewModel$fetchOrderSummery$1(this.this$0, dVar);
        paymentsListViewModel$fetchOrderSummery$1.p$ = (CoroutineScope) obj;
        return paymentsListViewModel$fetchOrderSummery$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsListViewModel$fetchOrderSummery$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y<b<SummaryDateRangeViewData>> yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new PaymentsListViewModel$fetchOrderSummery$1$orderSummeryCall$1(this, (d) null), 3, (Object) null);
            y<b<SummaryDateRangeViewData>> mDateRangeSummeryAPIData = this.this$0.getMDateRangeSummeryAPIData();
            this.L$0 = coroutineScope;
            this.L$1 = async$default;
            this.L$2 = mDateRangeSummeryAPIData;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == aVar) {
                return aVar;
            }
            yVar = mDateRangeSummeryAPIData;
        } else if (i2 == 1) {
            yVar = (y) this.L$2;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar.setValue(obj);
        return x.f47997a;
    }
}
