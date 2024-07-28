package com.business.merchant_payments.newhome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
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

@f(b = "AcceptPaymentViewModel.kt", c = {217}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$fetchSettlementRangeSummary$1")
public final class AcceptPaymentViewModel$fetchSettlementRangeSummary$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $endDate;
    public final /* synthetic */ String $startDate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$fetchSettlementRangeSummary$1(AcceptPaymentViewModel acceptPaymentViewModel, String str, String str2, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
        this.$startDate = str;
        this.$endDate = str2;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$fetchSettlementRangeSummary$1 acceptPaymentViewModel$fetchSettlementRangeSummary$1 = new AcceptPaymentViewModel$fetchSettlementRangeSummary$1(this.this$0, this.$startDate, this.$endDate, dVar);
        acceptPaymentViewModel$fetchSettlementRangeSummary$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$fetchSettlementRangeSummary$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$fetchSettlementRangeSummary$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1(this, (d) null), 3, (Object) null);
            LiveData<SettlementRangeSummaryModel> mSettlementRangeSummary = this.this$0.getMSettlementRangeSummary();
            if (mSettlementRangeSummary != null) {
                y yVar2 = (y) mSettlementRangeSummary;
                this.L$0 = coroutineScope;
                this.L$1 = async$default;
                this.L$2 = yVar2;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == aVar) {
                    return aVar;
                }
                yVar = yVar2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel>");
            }
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
