package com.business.merchant_payments.settlement;

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

@f(b = "SettlementDetailViewModel.kt", c = {42}, d = "invokeSuspend", e = "com.business.merchant_payments.settlement.SettlementDetailViewModel$getSettlementBillListDetail$1")
public final class SettlementDetailViewModel$getSettlementBillListDetail$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $endDate;
    public final /* synthetic */ String $settlementQueryType;
    public final /* synthetic */ String $startDate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ SettlementDetailViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettlementDetailViewModel$getSettlementBillListDetail$1(SettlementDetailViewModel settlementDetailViewModel, String str, String str2, String str3, d dVar) {
        super(2, dVar);
        this.this$0 = settlementDetailViewModel;
        this.$startDate = str;
        this.$endDate = str2;
        this.$settlementQueryType = str3;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        SettlementDetailViewModel$getSettlementBillListDetail$1 settlementDetailViewModel$getSettlementBillListDetail$1 = new SettlementDetailViewModel$getSettlementBillListDetail$1(this.this$0, this.$startDate, this.$endDate, this.$settlementQueryType, dVar);
        settlementDetailViewModel$getSettlementBillListDetail$1.p$ = (CoroutineScope) obj;
        return settlementDetailViewModel$getSettlementBillListDetail$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SettlementDetailViewModel$getSettlementBillListDetail$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            String settlementBillListItmDetailUrl = GTMDataProviderImpl.Companion.getMInstance().getSettlementBillListItmDetailUrl();
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1(this, settlementBillListItmDetailUrl, (d) null), 3, (Object) null);
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
            ((y) mSelectedSettledBillListDetail).setValue(new BWSettlementM2BTransactionDetailObservableModel(bVar, 0));
            return x.f47997a;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel>");
    }
}
