package com.business.merchant_payments.ups;

import com.business.merchant_payments.ups.UPSDataProvider;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@f(b = "UPSDataProvider.kt", c = {43, 44}, d = "invokeSuspend", e = "com.business.merchant_payments.ups.UPSDataProvider$fetchPrefsFromUPS$1")
public final class UPSDataProvider$fetchPrefsFromUPS$1 extends k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
    public final /* synthetic */ x.e $params;
    public final /* synthetic */ UPSDataProvider.UPSResponseListener $upsResponseListener;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ UPSDataProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPSDataProvider$fetchPrefsFromUPS$1(UPSDataProvider uPSDataProvider, x.e eVar, UPSDataProvider.UPSResponseListener uPSResponseListener, d dVar) {
        super(2, dVar);
        this.this$0 = uPSDataProvider;
        this.$params = eVar;
        this.$upsResponseListener = uPSResponseListener;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        UPSDataProvider$fetchPrefsFromUPS$1 uPSDataProvider$fetchPrefsFromUPS$1 = new UPSDataProvider$fetchPrefsFromUPS$1(this.this$0, this.$params, this.$upsResponseListener, dVar);
        uPSDataProvider$fetchPrefsFromUPS$1.p$ = (CoroutineScope) obj;
        return uPSDataProvider$fetchPrefsFromUPS$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UPSDataProvider$fetchPrefsFromUPS$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    @f(b = "UPSDataProvider.kt", c = {}, d = "invokeSuspend", e = "com.business.merchant_payments.ups.UPSDataProvider$fetchPrefsFromUPS$1$1")
    /* renamed from: com.business.merchant_payments.ups.UPSDataProvider$fetchPrefsFromUPS$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ UPSDataProvider$fetchPrefsFromUPS$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<kotlin.x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.d(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, eVar, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                UPSDataProvider$fetchPrefsFromUPS$1 uPSDataProvider$fetchPrefsFromUPS$1 = this.this$0;
                uPSDataProvider$fetchPrefsFromUPS$1.this$0.handleUPSResponse((UPSResponse) eVar.element, uPSDataProvider$fetchPrefsFromUPS$1.$upsResponseListener);
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(T t) {
        CoroutineScope coroutineScope;
        Deferred deferred;
        final x.e eVar;
        x.e eVar2;
        T t2 = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(t);
            CoroutineScope coroutineScope2 = this.p$;
            deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope2, (kotlin.d.f) null, (CoroutineStart) null, new UPSDataProvider$fetchPrefsFromUPS$1$upsApiCall$1(this, (d) null), 3, (Object) null);
            eVar2 = new x.e();
            this.L$0 = coroutineScope2;
            this.L$1 = deferred;
            this.L$2 = eVar2;
            this.L$3 = eVar2;
            this.label = 1;
            T await = deferred.await(this);
            if (await == t2) {
                return t2;
            }
            coroutineScope = coroutineScope2;
            t = await;
            eVar = eVar2;
        } else if (i2 == 1) {
            eVar2 = (x.e) this.L$3;
            eVar = (x.e) this.L$2;
            deferred = (Deferred) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(t);
        } else if (i2 == 2) {
            ResultKt.a(t);
            return kotlin.x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        eVar2.element = (UPSResponse) t;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 r1 = new AnonymousClass1(this, (d) null);
        this.L$0 = coroutineScope;
        this.L$1 = deferred;
        this.L$2 = eVar;
        this.label = 2;
        if (BuildersKt.withContext(main, r1, this) == t2) {
            return t2;
        }
        return kotlin.x.f47997a;
    }
}
