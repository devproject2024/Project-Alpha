package com.business.merchant_payments.ups;

import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "UPSDataProvider.kt", c = {65}, d = "invokeSuspend", e = "com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$1")
public final class UPSDataProvider$savePrefsToUPS$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ x.e $body;
    public final /* synthetic */ UUID $uuid;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ UPSDataProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$savePrefsToUPS$1(UPSDataProvider uPSDataProvider, x.e eVar, UUID uuid, d dVar) {
        super(2, dVar);
        this.this$0 = uPSDataProvider;
        this.$body = eVar;
        this.$uuid = uuid;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        UPSDataProvider$savePrefsToUPS$1 uPSDataProvider$savePrefsToUPS$1 = new UPSDataProvider$savePrefsToUPS$1(this.this$0, this.$body, this.$uuid, dVar);
        uPSDataProvider$savePrefsToUPS$1.p$ = (CoroutineScope) obj;
        return uPSDataProvider$savePrefsToUPS$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UPSDataProvider$savePrefsToUPS$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new UPSDataProvider$savePrefsToUPS$1$upsApiCall$1(this, (d) null), 3, (Object) null);
            this.L$0 = coroutineScope;
            this.L$1 = async$default;
            this.label = 1;
            if (async$default.await(this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.x.f47997a;
    }
}
