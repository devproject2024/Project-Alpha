package com.business.merchant_payments.newhome;

import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.b.j;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.google.gson.f;
import com.paytm.utility.b;
import com.paytm.utility.d;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class StorefrontRepo {
    public static final StorefrontRepo INSTANCE = new StorefrontRepo();

    private final String getQueryParamsAppendedStorefrontUrl() {
        String apStorefrontHomePageUrl = GTMDataProviderImpl.Companion.getMInstance().getApStorefrontHomePageUrl();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(AppConstants.TAG_DEVICE, "android");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        linkedHashMap.put(AppConstants.TAG_RESOLUTION, String.valueOf(b.U(instance.getAppContext())));
        linkedHashMap.put("screen_name", "AcceptPaymentMainActivity");
        linkedHashMap.put(AppConstants.TAG_CHILD_SITE_ID, b.u);
        linkedHashMap.put(AppConstants.TAG_SITE_ID, b.t);
        String a2 = b.a(apStorefrontHomePageUrl, (Map<String, String>) linkedHashMap);
        k.b(a2, "CJRAppCommonUtility.buil…lString(url, queryParams)");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        String t = b.t(instance2.getAppContext(), a2);
        k.b(t, "CJRAppCommonUtility.appe…stance().appContext, url)");
        PaymentsConfig instance3 = PaymentsConfig.getInstance();
        k.b(instance3, "PaymentsConfig.getInstance()");
        String s = b.s(instance3.getAppContext(), t);
        k.b(s, "CJRAppCommonUtility.addD…stance().appContext, url)");
        return s;
    }

    private final HashMap<String, String> getSFRequestHeaders() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        HashMap<String, String> n = b.n();
        String n2 = b.n(appContext);
        String a2 = d.a(appContext);
        if (!TextUtils.isEmpty(n2) && b.r(appContext)) {
            k.b(n, "headers");
            n.put("user_id", n2);
        }
        if (!TextUtils.isEmpty(a2)) {
            k.b(n, "headers");
            n.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a2);
        }
        k.b(n, "headers");
        return n;
    }

    private final void writeStorefrontDataToCache(String str) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        j appSharedPreference = instance.getAppSharedPreference();
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        Context appContext = instance2.getAppContext();
        k.b(appContext, "PaymentsConfig.getInstance().appContext");
        appSharedPreference.a(appContext, APSharedPreferences.STORE_FRONT_RESPONSE, str);
    }

    private final HomeResponse getHomeResponseFromCache() {
        return readStorefrontDataFromCache();
    }

    private final HomeResponse readStorefrontDataFromCache() {
        try {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            j appSharedPreference = instance.getAppSharedPreference();
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            Context appContext = instance2.getAppContext();
            k.b(appContext, "PaymentsConfig.getInstance().appContext");
            String b2 = appSharedPreference.b(appContext, APSharedPreferences.STORE_FRONT_RESPONSE, "");
            if (b2 != null) {
                if (b2.length() > 0) {
                    return (HomeResponse) new f().a(b2, HomeResponse.class);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b A[Catch:{ Exception -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097 A[Catch:{ Exception -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object makeStorefrontCall(kotlin.d.d<? super com.paytmmall.clpartifact.view.viewmodel.HomeResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.business.merchant_payments.newhome.StorefrontRepo$makeStorefrontCall$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.business.merchant_payments.newhome.StorefrontRepo$makeStorefrontCall$1 r0 = (com.business.merchant_payments.newhome.StorefrontRepo$makeStorefrontCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.newhome.StorefrontRepo$makeStorefrontCall$1 r0 = new com.business.merchant_payments.newhome.StorefrontRepo$makeStorefrontCall$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r0 = r0.L$0
            com.business.merchant_payments.newhome.StorefrontRepo r0 = (com.business.merchant_payments.newhome.StorefrontRepo) r0
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x009d }
            goto L_0x0065
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0033:
            kotlin.ResultKt.a((java.lang.Object) r8)
            java.lang.String r8 = r7.getQueryParamsAppendedStorefrontUrl()     // Catch:{ Exception -> 0x009c }
            com.business.merchant_payments.PaymentsConfig r2 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x009c }
            java.lang.String r4 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r2, r4)     // Catch:{ Exception -> 0x009c }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r2.getKotlinNetworkService()     // Catch:{ Exception -> 0x009c }
            java.util.HashMap r4 = r7.getSFRequestHeaders()     // Catch:{ Exception -> 0x009c }
            java.lang.String r5 = "{}"
            okhttp3.RequestBody r5 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestBody(r5)     // Catch:{ Exception -> 0x009c }
            java.lang.String r6 = "RequestParamUtil.getRequestBody(\"{}\")"
            kotlin.g.b.k.b(r5, r6)     // Catch:{ Exception -> 0x009c }
            r0.L$0 = r7     // Catch:{ Exception -> 0x009c }
            r0.L$1 = r8     // Catch:{ Exception -> 0x009c }
            r0.label = r3     // Catch:{ Exception -> 0x009c }
            java.lang.Object r8 = r2.getStorefrontHomeData(r8, r4, r5, r0)     // Catch:{ Exception -> 0x009c }
            if (r8 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r7
        L_0x0065:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x009d }
            boolean r1 = r8.isSuccessful()     // Catch:{ Exception -> 0x009d }
            if (r1 == 0) goto L_0x0097
            int r1 = r8.code()     // Catch:{ Exception -> 0x009d }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0097
            java.lang.Object r1 = r8.body()     // Catch:{ Exception -> 0x009d }
            if (r1 == 0) goto L_0x0097
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x009d }
            r1.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.Object r2 = r8.body()     // Catch:{ Exception -> 0x009d }
            java.lang.String r1 = r1.b(r2)     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = "res"
            kotlin.g.b.k.b(r1, r2)     // Catch:{ Exception -> 0x009d }
            r0.writeStorefrontDataToCache(r1)     // Catch:{ Exception -> 0x009d }
            java.lang.Object r8 = r8.body()     // Catch:{ Exception -> 0x009d }
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r8 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r8     // Catch:{ Exception -> 0x009d }
            goto L_0x00a1
        L_0x0097:
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r8 = r0.getHomeResponseFromCache()     // Catch:{ Exception -> 0x009d }
            goto L_0x00a1
        L_0x009c:
            r0 = r7
        L_0x009d:
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r8 = r0.getHomeResponseFromCache()
        L_0x00a1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.newhome.StorefrontRepo.makeStorefrontCall(kotlin.d.d):java.lang.Object");
    }
}
