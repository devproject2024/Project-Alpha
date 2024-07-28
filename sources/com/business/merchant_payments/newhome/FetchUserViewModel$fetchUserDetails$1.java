package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "FetchUserViewModel.kt", c = {50}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.FetchUserViewModel$fetchUserDetails$1")
public final class FetchUserViewModel$fetchUserDetails$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ FetchUserViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchUserViewModel$fetchUserDetails$1(FetchUserViewModel fetchUserViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = fetchUserViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        FetchUserViewModel$fetchUserDetails$1 fetchUserViewModel$fetchUserDetails$1 = new FetchUserViewModel$fetchUserDetails$1(this.this$0, dVar);
        fetchUserViewModel$fetchUserDetails$1.p$ = (CoroutineScope) obj;
        return fetchUserViewModel$fetchUserDetails$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FetchUserViewModel$fetchUserDetails$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    @f(b = "FetchUserViewModel.kt", c = {52}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.FetchUserViewModel$fetchUserDetails$1$1")
    /* renamed from: com.business.merchant_payments.newhome.FetchUserViewModel$fetchUserDetails$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super x>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ FetchUserViewModel$fetchUserDetails$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.d(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1(this, (d) null), 3, (Object) null);
                this.L$0 = coroutineScope;
                this.L$1 = async$default;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.this$0.this$0.getUserDataObserver().setValue((b) obj);
            return x.f47997a;
        }
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            AnonymousClass1 r1 = new AnonymousClass1(this, (d) null);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r1, this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return x.f47997a;
    }
}
