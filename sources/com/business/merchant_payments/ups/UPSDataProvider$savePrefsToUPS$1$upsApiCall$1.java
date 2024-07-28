package com.business.merchant_payments.ups;

import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

@f(b = "UPSDataProvider.kt", c = {64}, d = "invokeSuspend", e = "com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$1$upsApiCall$1")
public final class UPSDataProvider$savePrefsToUPS$1$upsApiCall$1 extends k implements m<CoroutineScope, d<? super UPSResponse>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ UPSDataProvider$savePrefsToUPS$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$savePrefsToUPS$1$upsApiCall$1(UPSDataProvider$savePrefsToUPS$1 uPSDataProvider$savePrefsToUPS$1, d dVar) {
        super(2, dVar);
        this.this$0 = uPSDataProvider$savePrefsToUPS$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        UPSDataProvider$savePrefsToUPS$1$upsApiCall$1 uPSDataProvider$savePrefsToUPS$1$upsApiCall$1 = new UPSDataProvider$savePrefsToUPS$1$upsApiCall$1(this.this$0, dVar);
        uPSDataProvider$savePrefsToUPS$1$upsApiCall$1.p$ = (CoroutineScope) obj;
        return uPSDataProvider$savePrefsToUPS$1$upsApiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UPSDataProvider$savePrefsToUPS$1$upsApiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            UPSDataProvider$savePrefsToUPS$1 uPSDataProvider$savePrefsToUPS$1 = this.this$0;
            UPSDataProvider uPSDataProvider = uPSDataProvider$savePrefsToUPS$1.this$0;
            RequestBody requestBody = (RequestBody) uPSDataProvider$savePrefsToUPS$1.$body.element;
            kotlin.g.b.k.b(requestBody, "body");
            UUID uuid = this.this$0.$uuid;
            kotlin.g.b.k.b(uuid, "uuid");
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = uPSDataProvider.savePrefsToUPS(requestBody, uuid, this);
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
