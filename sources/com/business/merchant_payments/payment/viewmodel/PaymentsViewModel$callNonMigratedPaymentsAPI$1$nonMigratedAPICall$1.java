package com.business.merchant_payments.payment.viewmodel;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.payment.PaymentsRepo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

@f(b = "PaymentsViewModel.kt", c = {189}, d = "invokeSuspend", e = "com.business.merchant_payments.payment.viewmodel.PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1")
public final class PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1 extends k implements m<CoroutineScope, d<? super b<NonMigratedPaymentsModel>>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ PaymentsViewModel$callNonMigratedPaymentsAPI$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1(PaymentsViewModel$callNonMigratedPaymentsAPI$1 paymentsViewModel$callNonMigratedPaymentsAPI$1, d dVar) {
        super(2, dVar);
        this.this$0 = paymentsViewModel$callNonMigratedPaymentsAPI$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1 paymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1 = new PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1(this.this$0, dVar);
        paymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1.p$ = (CoroutineScope) obj;
        return paymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PaymentsViewModel$callNonMigratedPaymentsAPI$1$nonMigratedAPICall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            PaymentsRepo paymentsRepo = PaymentsRepo.INSTANCE;
            String str = this.this$0.$date;
            kotlin.g.b.k.b(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            String str2 = this.this$0.$date;
            kotlin.g.b.k.b(str2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = paymentsRepo.callNonMigratedPaymentsAPI(str, str2, this);
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
