package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "MoreRepository.kt", c = {40, 42}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/repositories/MoreRepository$getMoreResponse$1")
final class MoreRepository$getMoreResponse$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ x.e $cacheResponse;
    final /* synthetic */ y $liveData;
    final /* synthetic */ x.e $requestType;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MoreRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoreRepository$getMoreResponse$1(MoreRepository moreRepository, x.e eVar, y yVar, x.e eVar2, d dVar) {
        super(2, dVar);
        this.this$0 = moreRepository;
        this.$cacheResponse = eVar;
        this.$liveData = yVar;
        this.$requestType = eVar2;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        MoreRepository$getMoreResponse$1 moreRepository$getMoreResponse$1 = new MoreRepository$getMoreResponse$1(this.this$0, this.$cacheResponse, this.$liveData, this.$requestType, dVar);
        moreRepository$getMoreResponse$1.p$ = (CoroutineScope) obj;
        return moreRepository$getMoreResponse$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MoreRepository$getMoreResponse$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(T t) {
        x.e eVar;
        T t2 = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                eVar = (x.e) this.L$0;
                if (t instanceof p.b) {
                    throw ((p.b) t).exception;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (!(t instanceof p.b)) {
            x.e eVar2 = this.$cacheResponse;
            MoreRepository moreRepository = this.this$0;
            this.L$0 = eVar2;
            this.label = 1;
            T networkCacheData = moreRepository.getNetworkCacheData(this);
            if (networkCacheData == t2) {
                return t2;
            }
            eVar = eVar2;
            t = networkCacheData;
        } else {
            throw ((p.b) t).exception;
        }
        eVar.element = (HomeResponse) t;
        if (((HomeResponse) this.$cacheResponse.element) == null || (((HomeResponse) this.$cacheResponse.element) instanceof HomeResponse)) {
            this.this$0.handleSucessResponse(this.$liveData, (HomeResponse) this.$cacheResponse.element, (RequestType) this.$requestType.element);
        } else {
            MoreRepository.handleErrorResponse$default(this.this$0, this.$liveData, (RequestType) null, (Throwable) null, 6, (Object) null);
        }
        return kotlin.x.f47997a;
    }
}
