package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import com.business.merchant_payments.settlement.repo.SettlementRepo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

@f(b = "AcceptPaymentViewModel.kt", c = {125}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1")
public final class AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1 extends k implements m<CoroutineScope, d<? super b<SettlementBillListModel>>, Object> {
    public final /* synthetic */ x.e $url;
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel$getSettlementBillList$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1(AcceptPaymentViewModel$getSettlementBillList$1 acceptPaymentViewModel$getSettlementBillList$1, x.e eVar, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel$getSettlementBillList$1;
        this.$url = eVar;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1 acceptPaymentViewModel$getSettlementBillList$1$apiCall$1 = new AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1(this.this$0, this.$url, dVar);
        acceptPaymentViewModel$getSettlementBillList$1$apiCall$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getSettlementBillList$1$apiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.this$0.setBillListAPIOngoing(true);
            P4BSettlementsDataHelperMP p4BSettlementsDataHelperMP = P4BSettlementsDataHelperMP.INSTANCE;
            AcceptPaymentViewModel$getSettlementBillList$1 acceptPaymentViewModel$getSettlementBillList$1 = this.this$0;
            RequestBody requestBody = RequestParamUtil.getRequestBody(p4BSettlementsDataHelperMP.getSettlementBillListRequestBody(acceptPaymentViewModel$getSettlementBillList$1.$startDate, acceptPaymentViewModel$getSettlementBillList$1.$endDate, String.valueOf(this.this$0.$pageSize), String.valueOf(acceptPaymentViewModel$getSettlementBillList$1.$page)));
            kotlin.g.b.k.b(requestBody, "RequestParamUtil.getRequ…                        )");
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = SettlementRepo.INSTANCE.getSettlementBillList((String) this.$url.element, requestBody, this);
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
