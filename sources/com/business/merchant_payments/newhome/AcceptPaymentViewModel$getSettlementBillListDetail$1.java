package com.business.merchant_payments.newhome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
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

@f(b = "AcceptPaymentViewModel.kt", c = {189}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getSettlementBillListDetail$1")
public final class AcceptPaymentViewModel$getSettlementBillListDetail$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $endDate;
    public final /* synthetic */ int $position;
    public final /* synthetic */ String $startDate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getSettlementBillListDetail$1(AcceptPaymentViewModel acceptPaymentViewModel, String str, String str2, int i2, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
        this.$startDate = str;
        this.$endDate = str2;
        this.$position = i2;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getSettlementBillListDetail$1 acceptPaymentViewModel$getSettlementBillListDetail$1 = new AcceptPaymentViewModel$getSettlementBillListDetail$1(this.this$0, this.$startDate, this.$endDate, this.$position, dVar);
        acceptPaymentViewModel$getSettlementBillListDetail$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getSettlementBillListDetail$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getSettlementBillListDetail$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            String settlementBillListItmDetailUrl = GTMDataProviderImpl.Companion.getMInstance().getSettlementBillListItmDetailUrl();
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getSettlementBillListDetail$1$apiCall$1(this, settlementBillListItmDetailUrl, (d) null), 3, (Object) null);
            this.L$0 = coroutineScope;
            this.L$1 = settlementBillListItmDetailUrl;
            this.L$2 = async$default;
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
        b bVar = (b) obj;
        LiveData<BWSettlementM2BTransactionDetailObservableModel> mSelectedSettledBillListDetail = this.this$0.getMSelectedSettledBillListDetail();
        if (mSelectedSettledBillListDetail != null) {
            ((y) mSelectedSettledBillListDetail).setValue(new BWSettlementM2BTransactionDetailObservableModel(bVar, this.$position));
            return x.f47997a;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel>");
    }
}
