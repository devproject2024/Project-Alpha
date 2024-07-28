package com.paytm.business.merchantprofile.inactivemerchant;

import android.content.Context;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.business.common_module.b.j;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.ProfileGTMConstants;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.g.b.g;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class MerchantAccountStateManager implements p {
    public final MerchantAccountState inactiveMerchantData;
    public boolean isMerchantDataUpdated;
    public q lifecycleOwner;

    public MerchantAccountStateManager() {
        this((q) null, 1, (g) null);
    }

    public final void getMerchantAccountState() {
        getMerchantAccountState$default(this, (Boolean) null, 1, (Object) null);
    }

    public MerchantAccountStateManager(q qVar) {
        k lifecycle;
        this.lifecycleOwner = qVar;
        if (!(qVar == null || (lifecycle = qVar.getLifecycle()) == null)) {
            lifecycle.a(this);
        }
        this.inactiveMerchantData = new MerchantAccountState((y) null, (y) null, 3, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantAccountStateManager(q qVar, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : qVar);
    }

    public final q getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(q qVar) {
        this.lifecycleOwner = qVar;
    }

    public final MerchantAccountState getInactiveMerchantData() {
        return this.inactiveMerchantData;
    }

    public final boolean isMerchantDataUpdated() {
        return this.isMerchantDataUpdated;
    }

    public final void setMerchantDataUpdated(boolean z) {
        this.isMerchantDataUpdated = z;
    }

    public static /* synthetic */ void getMerchantAccountState$default(MerchantAccountStateManager merchantAccountStateManager, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        merchantAccountStateManager.getMerchantAccountState(bool);
    }

    public final void getMerchantAccountState(Boolean bool) {
        ProfileConfig instance = ProfileConfig.getInstance();
        kotlin.g.b.k.b(instance, "ProfileConfig.getInstance()");
        if (!instance.getGTMDataProvider().getBoolean(ProfileGTMConstants.INSTANT_REACTIVATION_ENABLED, false)) {
            this.inactiveMerchantData.getUiState().setValue(new Success((Object) null, 1, (g) null));
            this.inactiveMerchantData.getAccountState().setValue(DeActivatedNotEligibleForInstantReactivation.INSTANCE);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new MerchantAccountStateManager$getMerchantAccountState$1(this, bool, 10000, (d) null), 2, (Object) null);
    }

    private final HashMap<String, Object> reactivationStatusParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("solution", "pg_profile_update");
        hashMap.put("entityType", "INDIVIDUAL");
        hashMap.put("solutionSubType", "MERCHANT_REACTIVATION");
        return hashMap;
    }

    @aa(a = k.a.ON_DESTROY)
    public final void destroy() {
        k lifecycle;
        q qVar = this.lifecycleOwner;
        if (!(qVar == null || (lifecycle = qVar.getLifecycle()) == null)) {
            lifecycle.b(this);
        }
        this.lifecycleOwner = null;
    }

    public static /* synthetic */ boolean isAccountReactivationPending$default(MerchantAccountStateManager merchantAccountStateManager, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        return merchantAccountStateManager.isAccountReactivationPending(bool);
    }

    public final boolean isAccountReactivationPending(Boolean bool) {
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            ProfileConfig instance = ProfileConfig.getInstance();
            kotlin.g.b.k.b(instance, "ProfileConfig.getInstance()");
            j appSharedPreference = instance.getAppSharedPreference();
            ProfileConfig instance2 = ProfileConfig.getInstance();
            kotlin.g.b.k.b(instance2, "ProfileConfig.getInstance()");
            Context appContext = instance2.getAppContext();
            kotlin.g.b.k.b(appContext, "ProfileConfig.getInstance().appContext");
            appSharedPreference.a(appContext, ProfileSharedPreferences.ACCOuNT_REACTIVATION_PENDING, booleanValue);
            return booleanValue;
        }
        ProfileConfig instance3 = ProfileConfig.getInstance();
        kotlin.g.b.k.b(instance3, "ProfileConfig.getInstance()");
        j appSharedPreference2 = instance3.getAppSharedPreference();
        ProfileConfig instance4 = ProfileConfig.getInstance();
        kotlin.g.b.k.b(instance4, "ProfileConfig.getInstance()");
        Context appContext2 = instance4.getAppContext();
        kotlin.g.b.k.b(appContext2, "ProfileConfig.getInstance().appContext");
        return appSharedPreference2.b(appContext2, ProfileSharedPreferences.ACCOuNT_REACTIVATION_PENDING, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0 A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b5 A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getReactivationEligibility(kotlin.d.d<? super com.business.common_module.utilities.a.b<com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse<com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility>>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationEligibility$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationEligibility$1 r0 = (com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationEligibility$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationEligibility$1 r0 = new com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationEligibility$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r7)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x0092
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            java.lang.String r4 = "ProfileConfig.getInstance()"
            kotlin.g.b.k.b(r2, r4)
            com.business.common_module.b.f r2 = r2.getGTMDataProvider()
            java.lang.String r5 = "ump_base_url"
            java.lang.String r2 = r2.getString(r5, "")
            r7.append(r2)
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            kotlin.g.b.k.b(r2, r4)
            com.business.common_module.b.f r2 = r2.getGTMDataProvider()
            java.lang.String r5 = "mp_instant_reactivation_eligibility_url"
            java.lang.String r2 = r2.getString(r5, "")
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()     // Catch:{ Exception -> 0x00d1 }
            kotlin.g.b.k.b(r2, r4)     // Catch:{ Exception -> 0x00d1 }
            com.paytm.business.merchantprofile.common.utility.ProfileKotlinNetworkService r2 = r2.getKotlinNetworkService()     // Catch:{ Exception -> 0x00d1 }
            com.paytm.business.merchantprofile.ProfileConfig r5 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()     // Catch:{ Exception -> 0x00d1 }
            kotlin.g.b.k.b(r5, r4)     // Catch:{ Exception -> 0x00d1 }
            android.content.Context r4 = r5.getAppContext()     // Catch:{ Exception -> 0x00d1 }
            java.util.HashMap r4 = com.paytm.business.merchantprofile.common.utility.RequestParamUtil.getHeaders(r4)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r5 = "RequestParamUtil.getHead…getInstance().appContext)"
            kotlin.g.b.k.b(r4, r5)     // Catch:{ Exception -> 0x00d1 }
            r0.L$0 = r6     // Catch:{ Exception -> 0x00d1 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x00d1 }
            r0.label = r3     // Catch:{ Exception -> 0x00d1 }
            java.lang.Object r7 = r2.getReactivationEligibility(r7, r4, r0)     // Catch:{ Exception -> 0x00d1 }
            if (r7 != r1) goto L_0x0092
            return r1
        L_0x0092:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x00d1 }
            boolean r0 = r7.isSuccessful()     // Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00c7
            int r0 = r7.code()     // Catch:{ Exception -> 0x00d1 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x00c7
            java.lang.Object r0 = r7.body()     // Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00c7
            java.lang.Object r0 = r7.body()     // Catch:{ Exception -> 0x00d1 }
            com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse r0 = (com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse) r0     // Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00b5
            java.lang.String r0 = r0.getStatus()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            java.lang.String r1 = "SUCCESS"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)     // Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00c7
            java.lang.Object r0 = r7.body()     // Catch:{ Exception -> 0x00d1 }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r7, r0)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00cb
        L_0x00c7:
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r7)     // Catch:{ Exception -> 0x00d1 }
        L_0x00cb:
            java.lang.String r0 = "if(response.isSuccessful…r(response)\n            }"
            kotlin.g.b.k.b(r7, r0)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00db
        L_0x00d1:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r0 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r0)
        L_0x00db:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager.getReactivationEligibility(kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b4 A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9 A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2 A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getReactivationStatus(kotlin.d.d<? super com.business.common_module.utilities.a.b<com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationStatus$1 r0 = (com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationStatus$1 r0 = new com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getReactivationStatus$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x0096
        L_0x0027:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            java.lang.String r4 = "ProfileConfig.getInstance()"
            kotlin.g.b.k.b(r2, r4)
            com.business.common_module.b.f r2 = r2.getGTMDataProvider()
            java.lang.String r5 = "ump_base_url"
            java.lang.String r2 = r2.getString(r5, "")
            r8.append(r2)
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            kotlin.g.b.k.b(r2, r4)
            com.business.common_module.b.f r2 = r2.getGTMDataProvider()
            java.lang.String r5 = "mp_reactivation_status_url"
            java.lang.String r2 = r2.getString(r5, "")
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.paytm.business.merchantprofile.ProfileConfig r2 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()     // Catch:{ Exception -> 0x00d5 }
            kotlin.g.b.k.b(r2, r4)     // Catch:{ Exception -> 0x00d5 }
            com.paytm.business.merchantprofile.common.utility.ProfileKotlinNetworkService r2 = r2.getKotlinNetworkService()     // Catch:{ Exception -> 0x00d5 }
            java.util.HashMap r5 = r7.reactivationStatusParams()     // Catch:{ Exception -> 0x00d5 }
            com.paytm.business.merchantprofile.ProfileConfig r6 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()     // Catch:{ Exception -> 0x00d5 }
            kotlin.g.b.k.b(r6, r4)     // Catch:{ Exception -> 0x00d5 }
            android.content.Context r4 = r6.getAppContext()     // Catch:{ Exception -> 0x00d5 }
            java.util.HashMap r4 = com.paytm.business.merchantprofile.common.utility.RequestParamUtil.getHeaders(r4)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = "RequestParamUtil.getHead…getInstance().appContext)"
            kotlin.g.b.k.b(r4, r6)     // Catch:{ Exception -> 0x00d5 }
            r0.L$0 = r7     // Catch:{ Exception -> 0x00d5 }
            r0.L$1 = r8     // Catch:{ Exception -> 0x00d5 }
            r0.label = r3     // Catch:{ Exception -> 0x00d5 }
            java.lang.Object r8 = r2.getReactivationStatus(r8, r5, r4, r0)     // Catch:{ Exception -> 0x00d5 }
            if (r8 != r1) goto L_0x0096
            return r1
        L_0x0096:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00d5 }
            boolean r0 = r8.isSuccessful()     // Catch:{ Exception -> 0x00d5 }
            if (r0 == 0) goto L_0x00cb
            int r0 = r8.code()     // Catch:{ Exception -> 0x00d5 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x00cb
            java.lang.Object r0 = r8.body()     // Catch:{ Exception -> 0x00d5 }
            if (r0 == 0) goto L_0x00cb
            java.lang.Object r0 = r8.body()     // Catch:{ Exception -> 0x00d5 }
            com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse r0 = (com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse) r0     // Catch:{ Exception -> 0x00d5 }
            if (r0 == 0) goto L_0x00b9
            java.lang.String r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00ba
        L_0x00b9:
            r0 = 0
        L_0x00ba:
            java.lang.String r1 = "200"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)     // Catch:{ Exception -> 0x00d5 }
            if (r0 == 0) goto L_0x00cb
            java.lang.Object r0 = r8.body()     // Catch:{ Exception -> 0x00d5 }
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a(r8, r0)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00cf
        L_0x00cb:
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r8)     // Catch:{ Exception -> 0x00d5 }
        L_0x00cf:
            java.lang.String r0 = "if(response.isSuccessful…r(response)\n            }"
            kotlin.g.b.k.b(r8, r0)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00df
        L_0x00d5:
            r8 = move-exception
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r8)
            java.lang.String r0 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r8, r0)
        L_0x00df:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager.getReactivationStatus(kotlin.d.d):java.lang.Object");
    }
}
