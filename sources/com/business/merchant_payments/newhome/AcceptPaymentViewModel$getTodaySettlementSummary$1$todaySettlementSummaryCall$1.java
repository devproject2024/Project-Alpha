package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import com.business.merchant_payments.settlement.repo.SettlementRepo;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "AcceptPaymentViewModel.kt", c = {103, 106}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1")
public final class AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1 extends k implements m<CoroutineScope, d<? super b<TodaySettlementSummaryCardModel>>, Object> {
    public final /* synthetic */ x.e $url;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1(x.e eVar, d dVar) {
        super(2, dVar);
        this.$url = eVar;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1 acceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1 = new AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1(this.$url, dVar);
        acceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getTodaySettlementSummary$1$todaySettlementSummaryCall$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            coroutineScope = this.p$;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = SettlementRepo.INSTANCE.getSettlementSummaryCard((String) this.$url.element, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(obj);
        } else if (i2 == 2) {
            ResultKt.a(obj);
            return (b) this.L$1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b bVar = (b) obj;
        LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
        TodaySettlementSummaryCardModel todaySettlementSummaryCardModel = (TodaySettlementSummaryCardModel) bVar.f7358c;
        ArrayList<LabelModel> settlementAmountDetails = todaySettlementSummaryCardModel != null ? todaySettlementSummaryCardModel.getSettlementAmountDetails() : null;
        String todayStartDate = DateUtility.getTodayStartDate("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        this.L$0 = coroutineScope;
        this.L$1 = bVar;
        this.label = 2;
        return labelPopulationHelperMP.filterLabelData(settlementAmountDetails, todayStartDate, this) == aVar ? aVar : bVar;
    }
}
