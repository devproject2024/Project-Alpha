package com.business.merchant_payments.newhome;

import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
import com.business.merchant_payments.settlement.repo.SettlementRepo;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "AcceptPaymentViewModel.kt", c = {215}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1")
public final class AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1 extends k implements m<CoroutineScope, d<? super SettlementRangeSummaryModel>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel$fetchSettlementRangeSummary$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1(AcceptPaymentViewModel$fetchSettlementRangeSummary$1 acceptPaymentViewModel$fetchSettlementRangeSummary$1, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel$fetchSettlementRangeSummary$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1 acceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1 = new AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1(this.this$0, dVar);
        acceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$fetchSettlementRangeSummary$1$apiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            SettlementRepo settlementRepo = SettlementRepo.INSTANCE;
            AcceptPaymentViewModel$fetchSettlementRangeSummary$1 acceptPaymentViewModel$fetchSettlementRangeSummary$1 = this.this$0;
            String str = acceptPaymentViewModel$fetchSettlementRangeSummary$1.$startDate;
            String str2 = acceptPaymentViewModel$fetchSettlementRangeSummary$1.$endDate;
            HashMap<String, Object> headers = RequestParamUtil.getHeaders(acceptPaymentViewModel$fetchSettlementRangeSummary$1.this$0.mAppInstance);
            kotlin.g.b.k.b(headers, "RequestParamUtil.getHeaders(mAppInstance)");
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = settlementRepo.fetchSettlementRangeSummary(str, str2, headers, this);
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
