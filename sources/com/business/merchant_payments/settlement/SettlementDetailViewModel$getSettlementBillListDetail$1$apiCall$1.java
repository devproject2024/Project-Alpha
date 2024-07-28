package com.business.merchant_payments.settlement;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SettlementDetailViewModel.kt", c = {33, 38}, d = "invokeSuspend", e = "com.business.merchant_payments.settlement.SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1")
public final class SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1 extends k implements m<CoroutineScope, d<? super b<SettlementBillListDetailModel>>, Object> {
    public final /* synthetic */ String $url;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ SettlementDetailViewModel$getSettlementBillListDetail$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1(SettlementDetailViewModel$getSettlementBillListDetail$1 settlementDetailViewModel$getSettlementBillListDetail$1, String str, d dVar) {
        super(2, dVar);
        this.this$0 = settlementDetailViewModel$getSettlementBillListDetail$1;
        this.$url = str;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1 settlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1 = new SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1(this.this$0, this.$url, dVar);
        settlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1.p$ = (CoroutineScope) obj;
        return settlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        r4 = r4.getAmountDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            java.lang.Object r0 = r12.L$1
            com.business.common_module.utilities.a.b r0 = (com.business.common_module.utilities.a.b) r0
            kotlin.ResultKt.a((java.lang.Object) r13)
            r13 = r0
            goto L_0x0075
        L_0x0015:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001d:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.a((java.lang.Object) r13)
            goto L_0x004e
        L_0x0025:
            kotlin.ResultKt.a((java.lang.Object) r13)
            kotlinx.coroutines.CoroutineScope r1 = r12.p$
            com.business.merchant_payments.settlement.repo.SettlementRepo r13 = com.business.merchant_payments.settlement.repo.SettlementRepo.INSTANCE
            java.lang.String r4 = r12.$url
            com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP r5 = com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP.INSTANCE
            com.business.merchant_payments.settlement.SettlementDetailViewModel$getSettlementBillListDetail$1 r6 = r12.this$0
            java.lang.String r7 = r6.$startDate
            java.lang.String r8 = r6.$endDate
            java.lang.String r10 = r6.$settlementQueryType
            r9 = 1
            r11 = 50
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            java.util.HashMap r5 = r5.getSettlementBillListItemDetailQueryMap(r6, r7, r8, r9, r10)
            r12.L$0 = r1
            r12.label = r3
            java.lang.Object r13 = r13.getSettlementBillListItemDetail(r4, r5, r12)
            if (r13 != r0) goto L_0x004e
            return r0
        L_0x004e:
            com.business.common_module.utilities.a.b r13 = (com.business.common_module.utilities.a.b) r13
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r3 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE
            T r4 = r13.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r4 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r4
            if (r4 == 0) goto L_0x0063
            com.business.merchant_payments.settlement.model.SettlementAmountDetailsModel r4 = r4.getAmountDetails()
            if (r4 == 0) goto L_0x0063
            java.util.ArrayList r4 = r4.getSettlementAmountDetails()
            goto L_0x0064
        L_0x0063:
            r4 = 0
        L_0x0064:
            com.business.merchant_payments.settlement.SettlementDetailViewModel$getSettlementBillListDetail$1 r5 = r12.this$0
            java.lang.String r5 = r5.$startDate
            r12.L$0 = r1
            r12.L$1 = r13
            r12.label = r2
            java.lang.Object r1 = r3.filterLabelData(r4, r5, r12)
            if (r1 != r0) goto L_0x0075
            return r0
        L_0x0075:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.SettlementDetailViewModel$getSettlementBillListDetail$1$apiCall$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
