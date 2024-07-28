package com.business.merchant_payments.newhome;

import android.app.Application;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.model.user.UserDetails;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class FetchUserViewModel extends c {
    public final String FETCH_STRETEGY = "DEFAULT";
    public HashMap<String, Object> headerMap = new HashMap<>();
    public HashMap<String, Object> paramsMap = new HashMap<>();
    public String url;
    public final y<b<UserDetails>> userDataObserver = new y<>();

    public final void initDefaultParams() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchUserViewModel(Application application) {
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

    public final y<b<UserDetails>> getUserDataObserver() {
        return this.userDataObserver;
    }

    public static /* synthetic */ HashMap updateParams$default(FetchUserViewModel fetchUserViewModel, HashMap hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hashMap = new HashMap();
        }
        return fetchUserViewModel.updateParams(hashMap);
    }

    public final HashMap<String, Object> updateParams(HashMap<String, Object> hashMap) {
        k.d(hashMap, "params");
        hashMap.put("fetch_strategy", this.FETCH_STRETEGY);
        return hashMap;
    }

    public static /* synthetic */ HashMap updateHeaders$default(FetchUserViewModel fetchUserViewModel, HashMap hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hashMap = new HashMap();
        }
        return fetchUserViewModel.updateHeaders(hashMap);
    }

    public final HashMap<String, Object> updateHeaders(HashMap<String, Object> hashMap) {
        k.d(hashMap, H5Logger.HEADER);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("verification_type", "oauth_token");
        hashMap.put("data", APSharedPreferences.getInstance().getUserToken());
        hashMap.put("Authorization", AppConstants.KeyValues.AUTHORIZATION_VALUE);
        return hashMap;
    }

    public final void fetchUserDetails() {
        this.url = GTMDataProviderImpl.Companion.getMInstance().getUserInfoV2Url();
        this.headerMap = updateHeaders(this.headerMap);
        this.paramsMap = updateParams(this.paramsMap);
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new FetchUserViewModel$fetchUserDetails$1(this, (d) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUserDetails(kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.user.UserDetails>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.business.merchant_payments.newhome.FetchUserViewModel$getUserDetails$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.merchant_payments.newhome.FetchUserViewModel$getUserDetails$1 r0 = (com.business.merchant_payments.newhome.FetchUserViewModel$getUserDetails$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.newhome.FetchUserViewModel$getUserDetails$1 r0 = new com.business.merchant_payments.newhome.FetchUserViewModel$getUserDetails$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r7)     // Catch:{ Exception -> 0x008a }
            goto L_0x0069
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r7)
            java.lang.String r7 = r6.url
            boolean r7 = android.webkit.URLUtil.isValidUrl(r7)
            if (r7 == 0) goto L_0x0095
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r7, r2)
            android.app.Application r7 = r7.getApplication()
            boolean r7 = com.business.common_module.utilities.i.a((android.app.Application) r7)
            if (r7 == 0) goto L_0x0095
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x008a }
            kotlin.g.b.k.b(r7, r2)     // Catch:{ Exception -> 0x008a }
            com.business.merchant_payments.utility.APKotlinNetworkService r7 = r7.getKotlinNetworkService()     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = r6.url     // Catch:{ Exception -> 0x008a }
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r6.headerMap     // Catch:{ Exception -> 0x008a }
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r6.paramsMap     // Catch:{ Exception -> 0x008a }
            r0.L$0 = r6     // Catch:{ Exception -> 0x008a }
            r0.label = r3     // Catch:{ Exception -> 0x008a }
            java.lang.Object r7 = r7.getUserDetails(r2, r4, r5, r0)     // Catch:{ Exception -> 0x008a }
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x008a }
            boolean r0 = r7.isSuccessful()     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r7.body()     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r7.body()     // Catch:{ Exception -> 0x008a }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r7, r0)     // Catch:{ Exception -> 0x008a }
            goto L_0x0084
        L_0x0080:
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r7)     // Catch:{ Exception -> 0x008a }
        L_0x0084:
            java.lang.String r0 = "if (response.isSuccessfu…taWrapper.error(response)"
            kotlin.g.b.k.b(r7, r0)     // Catch:{ Exception -> 0x008a }
            goto L_0x0094
        L_0x008a:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r0 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r0)
        L_0x0094:
            return r7
        L_0x0095:
            r7 = 0
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r7)
            java.lang.String r0 = "LiveDataWrapper.error(null)"
            kotlin.g.b.k.b(r7, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.FetchUserViewModel.getUserDetails(kotlin.d.d):java.lang.Object");
    }
}
