package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
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

@f(b = "FetchKycBankViewModel.kt", c = {47}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$fetchApi$2")
public final class FetchKycBankInfoViewModel$fetchApi$2 extends k implements m<CoroutineScope, d<? super b<KycBankInfoModel>>, Object> {
    public final /* synthetic */ boolean $isInstantSettleToggled;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ FetchKycBankInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchKycBankInfoViewModel$fetchApi$2(FetchKycBankInfoViewModel fetchKycBankInfoViewModel, boolean z, d dVar) {
        super(2, dVar);
        this.this$0 = fetchKycBankInfoViewModel;
        this.$isInstantSettleToggled = z;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        FetchKycBankInfoViewModel$fetchApi$2 fetchKycBankInfoViewModel$fetchApi$2 = new FetchKycBankInfoViewModel$fetchApi$2(this.this$0, this.$isInstantSettleToggled, dVar);
        fetchKycBankInfoViewModel$fetchApi$2.p$ = (CoroutineScope) obj;
        return fetchKycBankInfoViewModel$fetchApi$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FetchKycBankInfoViewModel$fetchApi$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new FetchKycBankInfoViewModel$fetchApi$2$userApiCall$1(this, (d) null), 3, (Object) null);
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
        return obj;
    }
}
