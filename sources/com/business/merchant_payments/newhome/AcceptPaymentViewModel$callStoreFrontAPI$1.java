package com.business.merchant_payments.newhome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.SFUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "AcceptPaymentViewModel.kt", c = {203}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$callStoreFrontAPI$1")
public final class AcceptPaymentViewModel$callStoreFrontAPI$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$callStoreFrontAPI$1(AcceptPaymentViewModel acceptPaymentViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$callStoreFrontAPI$1 acceptPaymentViewModel$callStoreFrontAPI$1 = new AcceptPaymentViewModel$callStoreFrontAPI$1(this.this$0, dVar);
        acceptPaymentViewModel$callStoreFrontAPI$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$callStoreFrontAPI$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$callStoreFrontAPI$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$callStoreFrontAPI$1$storeFrontApiCall$1((d) null), 3, (Object) null);
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
        HomeResponse homeResponse = (HomeResponse) obj;
        if (homeResponse != null) {
            LiveData<SanitizedResponseModel> mStoreFrontAPIResponse = this.this$0.getMStoreFrontAPIResponse();
            if (mStoreFrontAPIResponse != null) {
                ((y) mStoreFrontAPIResponse).setValue(SFUtils.getSanitizedResponse$default(SFUtils.INSTANCE, homeResponse, false, 2, (Object) null));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.modal.SanitizedResponseModel>");
            }
        } else {
            LiveData<SanitizedResponseModel> mStoreFrontAPIResponse2 = this.this$0.getMStoreFrontAPIResponse();
            if (mStoreFrontAPIResponse2 != null) {
                ((y) mStoreFrontAPIResponse2).setValue(null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.modal.SanitizedResponseModel>");
            }
        }
        return x.f47997a;
    }
}
