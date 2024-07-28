package com.business.merchant_payments.payment.viewmodel;

import com.business.common_module.utilities.a.b;
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

@f(b = "PaymentsViewModel.kt", c = {225}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsViewModel$callV2OrderListAPIForDate$1")
public final class PaymentsViewModel$callV2OrderListAPIForDate$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $date;
    public final /* synthetic */ int $nextPage;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ PaymentsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsViewModel$callV2OrderListAPIForDate$1(PaymentsViewModel paymentsViewModel, String str, int i2, d dVar) {
        super(2, dVar);
        this.this$0 = paymentsViewModel;
        this.$date = str;
        this.$nextPage = i2;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsViewModel$callV2OrderListAPIForDate$1 paymentsViewModel$callV2OrderListAPIForDate$1 = new PaymentsViewModel$callV2OrderListAPIForDate$1(this.this$0, this.$date, this.$nextPage, dVar);
        paymentsViewModel$callV2OrderListAPIForDate$1.p$ = (CoroutineScope) obj;
        return paymentsViewModel$callV2OrderListAPIForDate$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsViewModel$callV2OrderListAPIForDate$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new PaymentsViewModel$callV2OrderListAPIForDate$1$orderListAPICall$1(this, (d) null), 3, (Object) null);
            this.L$0 = coroutineScope;
            this.L$1 = async$default;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.handleOrderListAPIResponse((b) obj);
        return x.f47997a;
    }
}
