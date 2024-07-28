package com.paytmmall.clpartifact.repositories;

import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "MoreRepository.kt", c = {127}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/repositories/MoreRepository$getNetworkCacheData$2")
final class MoreRepository$getNetworkCacheData$2 extends k implements m<CoroutineScope, d<? super HomeResponse>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MoreRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoreRepository$getNetworkCacheData$2(MoreRepository moreRepository, d dVar) {
        super(2, dVar);
        this.this$0 = moreRepository;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        MoreRepository$getNetworkCacheData$2 moreRepository$getNetworkCacheData$2 = new MoreRepository$getNetworkCacheData$2(this.this$0, dVar);
        moreRepository$getNetworkCacheData$2.p$ = (CoroutineScope) obj;
        return moreRepository$getNetworkCacheData$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MoreRepository$getNetworkCacheData$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof p.b)) {
            String access$getUrl = this.this$0.getUrl();
            if (TextUtils.isEmpty(access$getUrl)) {
                return null;
            }
            return (HomeResponse) SFGsonUtils.getPojo$default(SFGsonUtils.INSTANCE, com.paytm.network.f.a(access$getUrl, this.this$0.getContext()), HomeResponse.class, false, 4, (Object) null);
        } else {
            throw ((p.b) obj).exception;
        }
    }
}
