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

@f(b = "PaymentsViewModel.kt", c = {191}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsViewModel$callNonMigratedPaymentsAPI$1")
public final class PaymentsViewModel$callNonMigratedPaymentsAPI$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $date;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ PaymentsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsViewModel$callNonMigratedPaymentsAPI$1(PaymentsViewModel paymentsViewModel, String str, d dVar) {
        super(2, dVar);
        this.this$0 = paymentsViewModel;
        this.$date = str;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsViewModel$callNonMigratedPaymentsAPI$1 paymentsViewModel$callNonMigratedPaymentsAPI$1 = new PaymentsViewModel$callNonMigratedPaymentsAPI$1(this.this$0, this.$date, dVar);
        paymentsViewModel$callNonMigratedPaymentsAPI$1.p$ = (CoroutineScope) obj;
        return paymentsViewModel$callNonMigratedPaymentsAPI$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsViewModel$callNonMigratedPaymentsAPI$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1(this, (d) null), 3, (Object) null);
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
        this.this$0.handleNonMigratedAPIResponse((b) obj);
        return x.f47997a;
    }
}
