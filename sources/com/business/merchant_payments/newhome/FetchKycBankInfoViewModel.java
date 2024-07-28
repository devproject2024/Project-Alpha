package com.business.merchant_payments.newhome;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class FetchKycBankInfoViewModel extends c {
    public HashMap<String, Object> headerMap = new HashMap<>();
    public final y<b<KycBankInfoModel>> kycBanInfoLiveData = new y<>();
    public ObservableBoolean kycStatusFlag = new ObservableBoolean(false);
    public HashMap<String, Object> paramsMap = new HashMap<>();
    public String url;

    private final HashMap<String, Object> updateParamsForKyc(HashMap<String, Object> hashMap) {
        return hashMap;
    }

    public final void initDefaultParams() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchKycBankInfoViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final HashMap<String, Object> getHeaderMap() {
        return this.headerMap;
    }

    public final void setHeaderMap(HashMap<String, Object> hashMap) {
        k.d(hashMap, "<set-?>");
        this.headerMap = hashMap;
    }

    public final HashMap<String, Object> getParamsMap() {
        return this.paramsMap;
    }

    public final void setParamsMap(HashMap<String, Object> hashMap) {
        k.d(hashMap, "<set-?>");
        this.paramsMap = hashMap;
    }

    public final y<b<KycBankInfoModel>> getKycBanInfoLiveData() {
        return this.kycBanInfoLiveData;
    }

    public final ObservableBoolean getKycStatusFlag() {
        return this.kycStatusFlag;
    }

    public final void setKycStatusFlag(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.kycStatusFlag = observableBoolean;
    }

    public final void setKycStatusFlag(boolean z) {
        this.kycStatusFlag.set(z);
    }

    public final void fetchKycBankInfo(boolean z) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            this.kycStatusFlag.set(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new FetchKycBankInfoViewModel$fetchKycBankInfo$1(this, z, (d) null), 3, (Object) null);
        }
    }

    public final /* synthetic */ Object fetchApi(boolean z, d<? super b<KycBankInfoModel>> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FetchKycBankInfoViewModel$fetchApi$2(this, z, (d) null), dVar);
    }

    private final HashMap<String, Object> updateHeadersForKyc(HashMap<String, Object> hashMap) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        hashMap.putAll(RequestParamUtil.getHeaders(instance.getAppContext()));
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a1 A[Catch:{ Exception -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00aa A[Catch:{ Exception -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object getKycBankInfo(boolean r7, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.kyc.KycBankInfoModel>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$getKycBankInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$getKycBankInfo$1 r0 = (com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$getKycBankInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$getKycBankInfo$1 r0 = new com.business.merchant_payments.newhome.FetchKycBankInfoViewModel$getKycBankInfo$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x0093
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r8)
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r8 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r8 = r8.getMInstance()
            java.lang.String r8 = r8.getKycBanksUrl()
            r6.url = r8
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r6.headerMap
            java.util.HashMap r8 = r6.updateHeadersForKyc(r8)
            r6.headerMap = r8
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r6.paramsMap
            java.util.HashMap r8 = r6.updateParamsForKyc(r8)
            r6.paramsMap = r8
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = "isContextRequired"
            r8.put(r4, r2)
            com.business.merchant_payments.PaymentsConfig r8 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r8, r2)
            android.app.Application r8 = r8.getApplication()
            boolean r8 = com.business.common_module.utilities.i.a((android.app.Application) r8)
            if (r8 != 0) goto L_0x0075
            r7 = 0
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r7)
            java.lang.String r8 = "LiveDataWrapper.error(null)"
            kotlin.g.b.k.b(r7, r8)
            return r7
        L_0x0075:
            com.business.merchant_payments.PaymentsConfig r8 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00b4 }
            kotlin.g.b.k.b(r8, r2)     // Catch:{ Exception -> 0x00b4 }
            com.business.merchant_payments.utility.APKotlinNetworkService r8 = r8.getKotlinNetworkService()     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r2 = r6.url     // Catch:{ Exception -> 0x00b4 }
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r6.headerMap     // Catch:{ Exception -> 0x00b4 }
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r6.paramsMap     // Catch:{ Exception -> 0x00b4 }
            r0.L$0 = r6     // Catch:{ Exception -> 0x00b4 }
            r0.Z$0 = r7     // Catch:{ Exception -> 0x00b4 }
            r0.label = r3     // Catch:{ Exception -> 0x00b4 }
            java.lang.Object r8 = r8.getBasicInfoDetails(r2, r4, r5, r0)     // Catch:{ Exception -> 0x00b4 }
            if (r8 != r1) goto L_0x0093
            return r1
        L_0x0093:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00b4 }
            boolean r7 = r8.isSuccessful()     // Catch:{ Exception -> 0x00b4 }
            if (r7 == 0) goto L_0x00aa
            java.lang.Object r7 = r8.body()     // Catch:{ Exception -> 0x00b4 }
            if (r7 == 0) goto L_0x00aa
            java.lang.Object r7 = r8.body()     // Catch:{ Exception -> 0x00b4 }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r8, r7)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00ae
        L_0x00aa:
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r8)     // Catch:{ Exception -> 0x00b4 }
        L_0x00ae:
            java.lang.String r8 = "if (response.isSuccessfu…taWrapper.error(response)"
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00be
        L_0x00b4:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r8 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r8)
        L_0x00be:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.FetchKycBankInfoViewModel.getKycBankInfo(boolean, kotlin.d.d):java.lang.Object");
    }
}
