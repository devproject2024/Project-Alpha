package com.business.merchant_payments.ups;

import java.util.UUID;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import okhttp3.RequestBody;

@f(b = "UPSDataProvider.kt", c = {253}, d = "savePrefsToUPS", e = "com.business.merchant_payments.ups.UPSDataProvider")
public final class UPSDataProvider$savePrefsToUPS$2 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UPSDataProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$savePrefsToUPS$2(UPSDataProvider uPSDataProvider, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = uPSDataProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.savePrefsToUPS((RequestBody) null, (UUID) null, this);
    }
}
