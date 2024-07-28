package com.business.merchant_payments.newhome;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "FetchUserViewModel.kt", c = {64}, d = "getUserDetails", e = "com.business.merchant_payments.newhome.FetchUserViewModel")
public final class FetchUserViewModel$getUserDetails$1 extends d {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FetchUserViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchUserViewModel$getUserDetails$1(FetchUserViewModel fetchUserViewModel, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = fetchUserViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUserDetails(this);
    }
}
