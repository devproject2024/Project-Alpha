package com.business.merchant_payments.newhome;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "FetchKycBankViewModel.kt", c = {59}, d = "getKycBankInfo", e = "com.business.merchant_payments.newhome.FetchKycBankInfoViewModel")
public final class FetchKycBankInfoViewModel$getKycBankInfo$1 extends d {
    public Object L$0;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FetchKycBankInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchKycBankInfoViewModel$getKycBankInfo$1(FetchKycBankInfoViewModel fetchKycBankInfoViewModel, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = fetchKycBankInfoViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getKycBankInfo(false, this);
    }
}
