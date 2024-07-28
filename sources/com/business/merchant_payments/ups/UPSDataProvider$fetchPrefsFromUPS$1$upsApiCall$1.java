package com.business.merchant_payments.ups;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "UPSDataProvider.kt", c = {42}, d = "invokeSuspend", e = "com.business.merchant_payments.ups.UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1")
public final class UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1 extends k implements m<CoroutineScope, d<? super UPSResponse>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ UPSDataProvider$fetchPrefsFromUPS$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1(UPSDataProvider$fetchPrefsFromUPS$1 uPSDataProvider$fetchPrefsFromUPS$1, d dVar) {
        super(2, dVar);
        this.this$0 = uPSDataProvider$fetchPrefsFromUPS$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1 uPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1 = new UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1(this.this$0, dVar);
        uPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1.p$ = (CoroutineScope) obj;
        return uPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            UPSDataProvider$fetchPrefsFromUPS$1 uPSDataProvider$fetchPrefsFromUPS$1 = this.this$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = uPSDataProvider$fetchPrefsFromUPS$1.this$0.getPrefsFromUPSApi((String) uPSDataProvider$fetchPrefsFromUPS$1.$params.element, this);
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
