package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "MerchantAccountStateManager.kt", c = {110}, d = "getReactivationEligibility", e = "com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager")
public final class MerchantAccountStateManager$getReactivationEligibility$1 extends d {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MerchantAccountStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MerchantAccountStateManager$getReactivationEligibility$1(MerchantAccountStateManager merchantAccountStateManager, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = merchantAccountStateManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getReactivationEligibility(this);
    }
}
