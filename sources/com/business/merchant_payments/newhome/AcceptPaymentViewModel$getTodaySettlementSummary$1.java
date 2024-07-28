package com.business.merchant_payments.newhome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "AcceptPaymentViewModel.kt", c = {110}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getTodaySettlementSummary$1")
public final class AcceptPaymentViewModel$getTodaySettlementSummary$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getTodaySettlementSummary$1(AcceptPaymentViewModel acceptPaymentViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getTodaySettlementSummary$1 acceptPaymentViewModel$getTodaySettlementSummary$1 = new AcceptPaymentViewModel$getTodaySettlementSummary$1(this.this$0, dVar);
        acceptPaymentViewModel$getTodaySettlementSummary$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getTodaySettlementSummary$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getTodaySettlementSummary$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            x.e eVar = new x.e();
            eVar.element = GTMDataProviderImpl.Companion.getMInstance().getTodaySettlementSummaryUrl();
            eVar.element = ((String) eVar.element) + "?date=" + DateUtility.getTodayStartDate("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1(eVar, (d) null), 3, (Object) null);
            LiveData<b<TodaySettlementSummaryCardModel>> mTodaySettlementSummary = this.this$0.getMTodaySettlementSummary();
            if (mTodaySettlementSummary != null) {
                y yVar2 = (y) mTodaySettlementSummary;
                this.L$0 = coroutineScope;
                this.L$1 = eVar;
                this.L$2 = async$default;
                this.L$3 = yVar2;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == aVar) {
                    return aVar;
                }
                yVar = yVar2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.common_module.utilities.viewModel.LiveDataWrapper<com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel>>");
            }
        } else if (i2 == 1) {
            yVar = (y) this.L$3;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar.setValue(obj);
        return kotlin.x.f47997a;
    }
}
