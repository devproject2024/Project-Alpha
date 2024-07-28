package com.business.merchant_payments.settlement.repo;

import com.business.merchant_payments.settlement.model.UTRV2Request;
import java.util.HashMap;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "SettlementRepo.kt", c = {76}, d = "getMigratedMerchantSettlementSummary", e = "com.business.merchant_payments.settlement.repo.SettlementRepo")
public final class SettlementRepo$getMigratedMerchantSettlementSummary$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SettlementRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettlementRepo$getMigratedMerchantSettlementSummary$1(SettlementRepo settlementRepo, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = settlementRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMigratedMerchantSettlementSummary((String) null, (HashMap<String, Object>) null, (UTRV2Request) null, this);
    }
}
