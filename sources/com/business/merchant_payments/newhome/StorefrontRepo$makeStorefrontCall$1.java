package com.business.merchant_payments.newhome;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "StorefrontRepo.kt", c = {19}, d = "makeStorefrontCall", e = "com.business.merchant_payments.newhome.StorefrontRepo")
public final class StorefrontRepo$makeStorefrontCall$1 extends d {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StorefrontRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StorefrontRepo$makeStorefrontCall$1(StorefrontRepo storefrontRepo, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = storefrontRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.makeStorefrontCall(this);
    }
}
