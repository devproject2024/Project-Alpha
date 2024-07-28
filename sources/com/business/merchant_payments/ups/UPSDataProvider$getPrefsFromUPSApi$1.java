package com.business.merchant_payments.ups;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "UPSDataProvider.kt", c = {165}, d = "getPrefsFromUPSApi", e = "com.business.merchant_payments.ups.UPSDataProvider")
public final class UPSDataProvider$getPrefsFromUPSApi$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UPSDataProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$getPrefsFromUPSApi$1(UPSDataProvider uPSDataProvider, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = uPSDataProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPrefsFromUPSApi((String) null, this);
    }
}
