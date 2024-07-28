package com.business.merchant_payments.newhome;

import androidx.lifecycle.y;
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

@f(b = "FetchKycBankViewModel.kt", c = {41}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$fetchKycBankInfo$1")
public final class FetchKycBankInfoViewModel$fetchKycBankInfo$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ boolean $isInstantSettleToggled;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ FetchKycBankInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchKycBankInfoViewModel$fetchKycBankInfo$1(FetchKycBankInfoViewModel fetchKycBankInfoViewModel, boolean z, d dVar) {
        super(2, dVar);
        this.this$0 = fetchKycBankInfoViewModel;
        this.$isInstantSettleToggled = z;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        FetchKycBankInfoViewModel$fetchKycBankInfo$1 fetchKycBankInfoViewModel$fetchKycBankInfo$1 = new FetchKycBankInfoViewModel$fetchKycBankInfo$1(this.this$0, this.$isInstantSettleToggled, dVar);
        fetchKycBankInfoViewModel$fetchKycBankInfo$1.p$ = (CoroutineScope) obj;
        return fetchKycBankInfoViewModel$fetchKycBankInfo$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FetchKycBankInfoViewModel$fetchKycBankInfo$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y<b<KycBankInfoModel>> yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.getKycBanInfoLiveData().setValue(b.a());
            y<b<KycBankInfoModel>> kycBanInfoLiveData = this.this$0.getKycBanInfoLiveData();
            FetchKycBankInfoViewModel fetchKycBankInfoViewModel = this.this$0;
            boolean z = this.$isInstantSettleToggled;
            this.L$0 = coroutineScope;
            this.L$1 = kycBanInfoLiveData;
            this.label = 1;
            obj = fetchKycBankInfoViewModel.fetchApi(z, this);
            if (obj == aVar) {
                return aVar;
            }
            yVar = kycBanInfoLiveData;
        } else if (i2 == 1) {
            yVar = (y) this.L$1;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar.setValue(obj);
        return x.f47997a;
    }
}
