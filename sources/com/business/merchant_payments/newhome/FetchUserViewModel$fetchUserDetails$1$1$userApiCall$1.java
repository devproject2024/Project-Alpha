package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.user.UserDetails;
import com.business.merchant_payments.newhome.FetchUserViewModel$fetchUserDetails$1;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "FetchUserViewModel.kt", c = {51}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1")
public final class FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1 extends k implements m<CoroutineScope, d<? super b<UserDetails>>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ FetchUserViewModel$fetchUserDetails$1.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1(FetchUserViewModel$fetchUserDetails$1.AnonymousClass1 r1, d dVar) {
        super(2, dVar);
        this.this$0 = r1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1 fetchUserViewModel$fetchUserDetails$1$1$userApiCall$1 = new FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1(this.this$0, dVar);
        fetchUserViewModel$fetchUserDetails$1$1$userApiCall$1.p$ = (CoroutineScope) obj;
        return fetchUserViewModel$fetchUserDetails$1$1$userApiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FetchUserViewModel$fetchUserDetails$1$1$userApiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            FetchUserViewModel fetchUserViewModel = this.this$0.this$0.this$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = fetchUserViewModel.getUserDetails(this);
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
