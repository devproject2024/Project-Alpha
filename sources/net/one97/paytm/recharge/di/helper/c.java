package net.one97.paytm.recharge.di.helper;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.business.merchant_payments.common.utility.AppConstants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.di.d;
import net.one97.paytm.recharge.di.f;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f62654a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static d f62655b = f.f62644a.a();

    private c() {
    }

    public static String a() {
        return f62655b.getString("getalltokens");
    }

    public static String b() {
        return f62655b.getString("frequentOrdersAndroid");
    }

    public static String c() {
        return f62655b.getString("updated_auto_subscription_url");
    }

    public static String a(String str) {
        k.c(str, "orderId");
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            String string = f62655b.getString("newPostOrderURL");
            if (TextUtils.isEmpty(string)) {
                string = "https://cart-staging.paytm.com/v2/myOrders/";
            }
            return k.a(string, (Object) str + "/detail");
        }
        String string2 = f62655b.getString("newPostOrderURL");
        if (TextUtils.isEmpty(string2)) {
            string2 = "https://cart.paytm.com/v2/myOrders/";
        }
        return k.a(string2, (Object) str + "/detail");
    }

    public static String d() {
        String string = f62655b.getString("contributionDetailsUrl");
        if (TextUtils.isEmpty(string)) {
            return p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://digitalproxy-staging.paytm.com/donation/v1/donation/contributionData" : "https://digitalproxy.paytm.com/donation/v1/donation/contributionData";
        }
        return string;
    }

    public static String e() {
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            return "https://catalog-staging.paytm.com/v1/mobile/product/";
        }
        return f62655b.getString("utilityProductDetails");
    }

    public static String f() {
        return f62655b.getString("rbiComplianceTitle", "Update your Automatic Payment Settings");
    }

    public static Integer a(boolean z) {
        return f62655b.getInteger(z ? "rbiComplianceCloseCountCLP" : "rbiComplianceCloseCount");
    }

    public static String g() {
        return f62655b.getString("rbiComplianceDescription", "As per RBI Guidelines Paytm wallet cannot be used for Automatic Payments from 31 Dec 2017. Change your payment mode to a credit or debit card.");
    }

    public static HashSet<Long> h() {
        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add(Long.valueOf((long) f62655b.getInteger("cylinderBookingCategoryId", 0)));
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            hashSet.add(131865L);
        } else {
            hashSet.add(166690L);
        }
        return hashSet;
    }

    public static HashSet<Long> i() {
        String str = "";
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_utility"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForUtilityLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = str;
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            hashSet.add(Long.valueOf(ba.f61546h));
            hashSet.add(Long.valueOf(ba.f61547i));
            hashSet.add(Long.valueOf(ba.j));
            hashSet.add(Long.valueOf(ba.l));
            hashSet.add(Long.valueOf(ba.k));
            try {
                hashSet.addAll(h());
            } catch (Exception e3) {
                CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
                StringBuilder sb2 = new StringBuilder("Unable to add LPG category ID in getSupportedCategoryForUtilityLayoutSourceV8\n ");
                String message2 = e3.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                sb2.append(str);
                cJRRechargeUtilities2.debugLog(sb2.toString());
            }
        }
        return hashSet;
    }

    public static HashSet<Long> j() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_mobile"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForMobileLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            hashSet.add(5L);
            hashSet.add(17L);
            hashSet.add(9L);
            hashSet.add(21L);
            hashSet.add(7L);
            hashSet.add(19L);
            hashSet.add(11L);
            hashSet.add(23L);
        }
        return hashSet;
    }

    public static HashSet<Long> k() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_dth"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForDTHLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            hashSet.add(6L);
            hashSet.add(18L);
        }
        return hashSet;
    }

    public static HashSet<Long> l() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_credit_card"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForCreditCardLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            hashSet.add(101975L);
            hashSet.add(156705L);
        }
        return hashSet;
    }

    public static HashSet<Long> m() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_donation"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForDonationLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add(131651L);
                hashSet.add(106971L);
                hashSet.add(132343L);
            } else {
                hashSet.add(132935L);
                hashSet.add(127781L);
                hashSet.add(204854L);
            }
        }
        return hashSet;
    }

    public static HashSet<Long> n() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_smart_card"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedProductForMetroSmartCardLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add(63793845L);
                hashSet.add(1200146452L);
                hashSet.add(7226428L);
                hashSet.add(1201974419L);
            } else {
                hashSet.add(40778051L);
                hashSet.add(145875304L);
                hashSet.add(7226428L);
            }
        }
        return hashSet;
    }

    public static HashSet<String> o() {
        HashSet<String> hashSet = new HashSet<>();
        try {
            String string = f62655b.getString("recharge_os_ott");
            if (TextUtils.isEmpty(string)) {
                string = "['213436']";
            }
            Object a2 = new com.google.gson.f().a(string, HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String add : hashSet2) {
                    hashSet.add(add);
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedProductForOTTLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        return hashSet;
    }

    public static HashSet<String> p() {
        HashSet<String> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_my_payment"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String add : hashSet2) {
                    hashSet.add(add);
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForMyPaymentLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add("215903");
            } else {
                hashSet.add("262072");
            }
        }
        return hashSet;
    }

    public static HashSet<Long> q() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_pmcare_fund"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedProductForPMCareFundLayoutSourceV8\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add(1201258443L);
            } else {
                hashSet.add(252028625L);
            }
        }
        return hashSet;
    }

    public static HashSet<Long> r() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_meter_code"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getSupportedCategoryForMeterCode\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add(93659L);
                hashSet.add(93590L);
                hashSet.add(93645L);
                hashSet.add(46006L);
                hashSet.add(46007L);
            } else {
                hashSet.add(107730L);
                hashSet.add(101950L);
                hashSet.add(104154L);
                hashSet.add(46006L);
                hashSet.add(46007L);
            }
        }
        return hashSet;
    }

    public static HashSet<Long> s() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_mc_operatorRefNumber"), HashSet.class);
            if (!(a2 instanceof HashSet)) {
                a2 = null;
            }
            HashSet<String> hashSet2 = (HashSet) a2;
            if (hashSet2 != null && (!hashSet2.isEmpty())) {
                for (String parseLong : hashSet2) {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Unable to getExcludedCategoryForMeterCodeFromOperatorRefNumber\n ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            cJRRechargeUtilities.debugLog(sb.toString());
        }
        if (hashSet.isEmpty()) {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashSet.add(93590L);
            } else {
                hashSet.add(101950L);
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r7) {
        /*
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x0033 }
            r1.<init>()     // Catch:{ Exception -> 0x0033 }
            net.one97.paytm.recharge.di.d r3 = f62655b     // Catch:{ Exception -> 0x0033 }
            java.lang.String r4 = "support_widget_ad_category"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<java.util.HashMap> r4 = java.util.HashMap.class
            java.lang.Object r1 = r1.a((java.lang.String) r3, r4)     // Catch:{ Exception -> 0x0033 }
            boolean r3 = r1 instanceof java.util.HashMap     // Catch:{ Exception -> 0x0033 }
            if (r3 != 0) goto L_0x0024
            r1 = r2
        L_0x0024:
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r3 = "156705"
            java.lang.String r4 = "v2/h/psf-for-toll-booking"
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0050
        L_0x0031:
            r3 = move-exception
            goto L_0x0035
        L_0x0033:
            r3 = move-exception
            r1 = r2
        L_0x0035:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r4 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Unable to getSupportedCategoryForAdWidget\n "
            r5.<init>(r6)
            java.lang.String r3 = r3.getMessage()
            if (r3 != 0) goto L_0x0046
            java.lang.String r3 = ""
        L_0x0046:
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.debugLog(r3)
        L_0x0050:
            net.one97.paytm.recharge.di.d r3 = f62655b
            java.lang.String r4 = "base_url_widget_ad"
            java.lang.String r3 = r3.getString(r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0063
            java.lang.String r3 = "https://storefront.paytm.com"
        L_0x0063:
            if (r3 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ad
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ad
            if (r1 == 0) goto L_0x00ad
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x00a5
            boolean r4 = r0.containsKey(r7)
            r5 = 1
            if (r4 != r5) goto L_0x00ad
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r3 = 47
            r2.append(r3)
            if (r1 != 0) goto L_0x0097
            kotlin.g.b.k.a()
        L_0x0097:
            java.lang.Object r7 = r0.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            return r7
        L_0x00a5:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r7.<init>(r0)
            throw r7
        L_0x00ad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.di.helper.c.b(java.lang.String):java.lang.String");
    }

    public static String c(String str) {
        if (str == null) {
            return f62655b.getString("cartVerify");
        }
        if (az.a(CJRRechargeUtilities.INSTANCE.getApplicationContext(), str)) {
            return f62655b.getString("s2sVerify");
        }
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            return "https://cart-staging.paytm.com/v1/expresscart/verify";
        }
        return f62655b.getString("cartVerify");
    }

    public static String t() {
        return f62655b.getString("checkBalance");
    }

    public static String a(JSONObject jSONObject) {
        az azVar = az.f61525a;
        if (jSONObject == null) {
            k.a();
        }
        String a2 = az.a(jSONObject);
        if (a2 == null) {
            return f62655b.getString("cartCheckout");
        }
        if (az.a(CJRRechargeUtilities.INSTANCE.getApplicationContext(), a2)) {
            return f62655b.getString("s2sCheckout");
        }
        return f62655b.getString("cartCheckout");
    }

    public static String u() {
        return f62655b.getString("delete_recentAndroid");
    }

    public static String v() {
        return f62655b.getString("offer_url");
    }

    public static String w() {
        return f62655b.getString("offer_param");
    }

    public static String x() {
        return f62655b.getString("consentFlowSetBillURL");
    }

    public static String y() {
        return f62655b.getString("consentFlowGetBillURL");
    }

    public static String z() {
        return f62655b.getString("consentFlowUnsubscribeURL");
    }

    public static String A() {
        return f62655b.getString("upsell");
    }

    public static String B() {
        return f62655b.getString("digital_catalog_base_url");
    }

    public static boolean C() {
        return f62655b.getBoolean("v3GroupingEnabledNewKey", false);
    }

    public static boolean D() {
        return f62655b.getBoolean("digital_catalog_cache_enable", false);
    }

    public static String E() {
        return f62655b.getString("fetch_bill");
    }

    public static boolean F() {
        return f62655b.getBoolean("isSortPlanAmountDesc", false);
    }

    public static String G() {
        return f62655b.getString("dynamicBrowsePlans");
    }

    public static String H() {
        return f62655b.getString("OperatorAutoDetection");
    }

    public static Integer I() {
        return f62655b.getInteger("max_digit_amount");
    }

    public static List<String> J() {
        try {
            String string = f62655b.getString("utilityVerticals");
            if (TextUtils.isEmpty(string)) {
                return new ArrayList<>(0);
            }
            String[] strArr = (String[]) new com.google.gson.f().a(string, String[].class);
            List<String> asList = Arrays.asList((String[]) Arrays.copyOf(strArr, strArr.length));
            k.a((Object) asList, "Arrays.asList(*verticals)");
            return asList;
        } catch (Exception unused) {
            return new ArrayList<>(0);
        }
    }

    public static String K() {
        return f62655b.getString("shouldIgnoreDbCachedData", "");
    }

    public static String L() {
        return f62655b.getString("fastagProductId");
    }

    public static String M() {
        return f62655b.getString("get_saved_credit_card");
    }

    public static String N() {
        return f62655b.getString("DeleteCard");
    }

    public static String O() {
        return f62655b.getString("catalog_verticals_version_name_new_android");
    }

    public static String P() {
        return f62655b.getString("s2sVersionMapNewKey");
    }

    public static String Q() {
        return f62655b.getString("mobileFlowV3VersionMap");
    }

    public static String R() {
        return f62655b.getString("footerMenuMapV1", "{ '21' : \"{'isSetupAutomaticPaymentsVisible':'8.12.2','isHelpAndSupportVisible':'8.12.2'}\",'156705':\"{'isScratchCardFooterItemVisible':'8.15.2','isSetupAutomaticPaymentsVisible':'8.15.2','isFreqAskedQuestVisible':'8.15.2','isHelpAndSupportVisible':'8.15.2'}\",'17' : \"{'isHelpAndSupportVisible':'8.12.2'}\"}");
    }

    public static String S() {
        return f62655b.getString("recharge_os_versionNewKey");
    }

    public static boolean T() {
        return f62655b.getBoolean("billConsentFlow", false);
    }

    public static boolean U() {
        return f62655b.getBoolean("SkipDeals", false);
    }

    public static String V() {
        return f62655b.getString("cartPublicAPI");
    }

    public static boolean W() {
        return f62655b.getBoolean("isOne2OneEnabled", false);
    }

    public static String X() {
        return f62655b.getString("categorymap");
    }

    public static String Y() {
        String string = f62655b.getString("credit_card_fetch_bin_api_V4");
        if (TextUtils.isEmpty(string)) {
            return p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://pgp-staging.paytm.in/billproxy/api/v4/cc/fetchBin/request" : "https://securegw.paytm.in/billproxy/api/v4/cc/fetchBin/request";
        }
        return string;
    }

    public static String Z() {
        return f62655b.getString("max_digit_utility");
    }

    public static String aa() {
        return f62655b.getString("credit_card_tokenization_api_cardEntryV2");
    }

    public static String ab() {
        return f62655b.getString("credit_card_tokenization_api_recentV2");
    }

    public static String ac() {
        return f62655b.getString("credit_card_tokenization_api_savedV2");
    }

    public static String ad() {
        return f62655b.getString("BrowsePlans");
    }

    public static boolean ae() {
        return f62655b.getBoolean("showMetroTicketCancelOption", false);
    }

    public static String af() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroActiveTicketsAndPassesV2Auth");
        return stringFromContainer4 == null ? "https://digitalproxy.paytm.com/digitaltickets/auth/v2/getTicketsAndPasses" : stringFromContainer4;
    }

    public static String ag() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroPenaltyMsgUrlAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/penalty/messages" : stringFromContainer4;
    }

    public static boolean ah() {
        return f62655b.getBoolean("metro_revamp_flowAndroid", false);
    }

    public static String ai() {
        return f62655b.getString("svp_min_bal");
    }

    public static String aj() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroTermsAndConditionsAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/mumbaimetro/tnc" : stringFromContainer4;
    }

    public static String ak() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroStationListAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/mumbaimetro/stations" : stringFromContainer4;
    }

    public static String al() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroPenaltiesAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/penalties" : stringFromContainer4;
    }

    public static String am() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroTicketPriceAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/mumbaimetro/price" : stringFromContainer4;
    }

    public static String an() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroRefundUrlAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/cancelOrderDetails" : stringFromContainer4;
    }

    public static String ao() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroTicketCancelUrlAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/cancelOrder" : stringFromContainer4;
    }

    public static String ap() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroGenerateTicketUrlAuth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v1/generatePassTicket" : stringFromContainer4;
    }

    public static String aq() {
        String stringFromContainer4 = f62655b.getStringFromContainer4("metroQRRecentUrlV2Auth");
        return stringFromContainer4 == null ? "https://digitalproxy-staging.paytm.com/digitaltickets/auth/v2/recents" : stringFromContainer4;
    }

    public static boolean ar() {
        return f62655b.getBoolean("enableMetroRecentPrefillOptionNew", false);
    }

    public static boolean as() {
        return f62655b.getBoolean("showMetroHelpForCancelledTicketOrder", false);
    }

    public static String at() {
        return f62655b.getString("newThankYouStorefront");
    }

    public static String au() {
        return f62655b.getString("getLocation");
    }

    public static String av() {
        return !p.a("release", SDKConstants.KEY_STAGING_API, true) ? f62655b.getString("thank_you_page_promotion_banner_v2") : "";
    }

    public static String aw() {
        return f62655b.getString("helpVideoDetailsUrl");
    }

    public static boolean ax() {
        return f62655b.getBoolean("enableOrder4_15", true);
    }

    public static String ay() {
        return f62655b.getString("orderStatus4_15");
    }

    public static String az() {
        return f62655b.getString("orderStatus4_22");
    }

    public static String aA() {
        return f62655b.getString("orderStatus4_2");
    }

    public static String aB() {
        return f62655b.getString("orderStatus16");
    }

    public static boolean aC() {
        return f62655b.getBoolean("enableOrder4_22", true);
    }

    public static boolean aD() {
        return f62655b.getBoolean("enableOrder4_2", true);
    }

    public static boolean aE() {
        return f62655b.getBoolean("enableVertical16", true);
    }

    public static String aF() {
        return f62655b.getString("utilityOtpVerify");
    }

    public static String aG() {
        return f62655b.getString("utilityOtpSent");
    }

    public static String aH() {
        return f62655b.getString("success_rate_alert_message_url_new");
    }

    public static HashSet<Long> aI() {
        HashSet<Long> hashSet = new HashSet<>();
        Integer integer = f62655b.getInteger("mumbaiMetroQRTicketsProductID");
        if (integer != null) {
            hashSet.add(Long.valueOf((long) integer.intValue()));
        }
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            hashSet.add(1200137294L);
            hashSet.add(1200138597L);
            hashSet.add(1200138561L);
        } else {
            hashSet.add(146264314L);
            hashSet.add(184207103L);
            hashSet.add(184207135L);
        }
        return hashSet;
    }

    public static HashSet<Long> aJ() {
        HashSet<Long> hashSet = new HashSet<>();
        Integer integer = f62655b.getInteger("delhiMetroQRTicketsProductID");
        if (integer != null) {
            hashSet.add(Long.valueOf((long) integer.intValue()));
        }
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            hashSet.add(1200175682L);
            hashSet.add(1201251940L);
        } else {
            hashSet.add(246795258L);
        }
        return hashSet;
    }

    public static HashSet<Long> aK() {
        HashSet<Long> hashSet = new HashSet<>();
        String string = f62655b.getString("delhiMetroProductIDs");
        if (TextUtils.isEmpty(string)) {
            string = p.a("release", SDKConstants.KEY_STAGING_API, true) ? "[1200175682,1201251940]" : "[246795258,312505919]";
        }
        Object a2 = new com.google.gson.f().a(string, new a().getType());
        k.a(a2, "Gson().fromJson(jsonResp…rayList<Long>>() {}.type)");
        ArrayList arrayList = (ArrayList) a2;
        if (arrayList != null) {
            Collection collection = arrayList;
            if (!collection.isEmpty()) {
                hashSet.addAll(collection);
            }
        }
        return hashSet;
    }

    public static final class a extends com.google.gsonhtcfix.c.a<ArrayList<Long>> {
        a() {
        }
    }

    public static HashSet<Long> aL() {
        HashSet<Long> hashSet = new HashSet<>();
        Integer integer = f62655b.getInteger("hyderabadMetroQRTicketsProductID");
        if (integer != null) {
            try {
                if (!TextUtils.isEmpty(String.valueOf(integer.intValue()))) {
                    hashSet.add(Long.valueOf((long) integer.intValue()));
                }
            } catch (Exception unused) {
            }
        }
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            hashSet.add(1200779784L);
        } else {
            hashSet.add(309696050L);
        }
        return hashSet;
    }

    public static String aM() {
        return f62655b.getString("educationInvalidMobile");
    }

    public static String aN() {
        return f62655b.getString("lengthy_form_save_data_url");
    }

    public static String aO() {
        return f62655b.getString("metroQRRecentUrl");
    }

    public static String aP() {
        return f62655b.getString("get_credit_card_pgmid");
    }

    public static String aQ() {
        return f62655b.getString("get_credit_card_bill_token");
    }

    public static boolean aR() {
        return f62655b.getBoolean("utility_digital_catalog_cache_enable", false);
    }

    public static String aS() {
        return f62655b.getString("myorders");
    }

    public static String aT() {
        return f62655b.getString("logoutIfRequired");
    }

    public static String aU() {
        return f62655b.getString("PaytmCashProductId");
    }

    public static String aV() {
        return f62655b.getString("post_order_success_shop_now");
    }

    public static String aW() {
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            return "";
        }
        String stringFromContainer2 = f62655b.getStringFromContainer2("postPaymentStorefrontUrl");
        return TextUtils.isEmpty(stringFromContainer2) ? f62655b.getString("postPaymentStorefrontUrl") : stringFromContainer2;
    }

    public static String aX() {
        return f62655b.getString("googlePlayBannerUrl");
    }

    public static int aY() {
        return f62655b.getInteger("default_min_bill_amount", 0);
    }

    public static Boolean aZ() {
        return Boolean.valueOf(f62655b.getBoolean("showBillDetails", false));
    }

    public static boolean ba() {
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            return true;
        }
        return f62655b.getBoolean("imps_feature_enabled_key", true);
    }

    public static boolean bb() {
        return f62655b.getBoolean("dth_multiple_subscriber_feature_enabled_key", true);
    }

    public static String bc() {
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            return "https://staging.paytm.com/api/v1/refund/consult";
        }
        return f62655b.getString("imps_consult_url", "");
    }

    public static String bd() {
        return f62655b.getString("imps_add_bank_url", "");
    }

    public static String be() {
        return f62655b.getString("imps_remove_bank_url", "");
    }

    public static String bf() {
        return f62655b.getString("IMPSVersionMapNewKey", "");
    }

    public static long bg() {
        return new BigDecimal(f62655b.getString("app_rating_5_star_time_gap", "0")).longValue();
    }

    public static long bh() {
        return new BigDecimal(f62655b.getString("app_rating_less_than_5_star_time_gap", "0")).longValue();
    }

    public static long bi() {
        return new BigDecimal(f62655b.getString("app_rating_not_now_time_gap", "0")).longValue();
    }

    public static long bj() {
        return new BigDecimal(f62655b.getString("app_rating_thank_you_expire_time", Constants.RESULT_STATUS_SUCCESS)).longValue();
    }

    public static boolean bk() {
        return !f62655b.getBoolean("disableAppRating4RechargeOS", false);
    }

    public static String bl() {
        return f62655b.getString("PGPromoVersionMapNewKey");
    }

    public static HashMap<String, String> bm() {
        HashMap<String, String> hashMap = null;
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_v8_deal_verticalsNewKey"), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            hashMap = (HashMap) a2;
        } catch (Exception unused) {
            CJRRechargeUtilities.INSTANCE.debugLog("GTMLoader Exception getOrderedDealVerticals()");
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap.isEmpty()) {
            String Q = com.paytm.utility.b.Q(CJRRechargeUtilities.INSTANCE.getApplicationContext());
            k.a((Object) Q, "CJRAppCommonUtility.getA….getApplicationContext())");
            hashMap.put("66", Q);
        }
        return hashMap;
    }

    public static HashMap<String, String> bn() {
        HashMap<String, String> hashMap = null;
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_v8_insurance_verticalsNewKey"), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            hashMap = (HashMap) a2;
        } catch (Exception unused) {
            CJRRechargeUtilities.INSTANCE.debugLog("GTMLoader Exception getOrderedInsuranceVerticals()");
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap.isEmpty()) {
            String Q = com.paytm.utility.b.Q(CJRRechargeUtilities.INSTANCE.getApplicationContext());
            k.a((Object) Q, "CJRAppCommonUtility.getA….getApplicationContext())");
            hashMap.put("79", Q);
        }
        return hashMap;
    }

    public static HashMap<String, String> bo() {
        HashMap<String, String> hashMap = null;
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("recharge_os_ignore_verticals"), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            hashMap = (HashMap) a2;
        } catch (Exception unused) {
            CJRRechargeUtilities.INSTANCE.debugLog("GTMLoader Exception getOrderedInsuranceVerticals()");
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap.isEmpty()) {
            String Q = com.paytm.utility.b.Q(CJRRechargeUtilities.INSTANCE.getApplicationContext());
            k.a((Object) Q, "CJRAppCommonUtility.getA….getApplicationContext())");
            hashMap.put("175", Q);
        }
        return hashMap;
    }

    public static boolean bp() {
        return !f62655b.getBoolean("recharge_disable_dont_keep_activities_warning", false);
    }

    public static String bq() {
        String str = "https://" + (p.a("release", SDKConstants.KEY_STAGING_API, true) ? "rechargews-staging.paytm.com" : "digitalapiproxy.paytm.com") + "/bulkActions/v1/order/getBulkActions";
        String string = f62655b.getString("recharge_os_tap_action_url", str);
        return TextUtils.isEmpty(string) ? str : string;
    }

    public static long br() {
        try {
            return (long) f62655b.getInteger("recharge_os_recents_delay", 180000);
        } catch (Exception unused) {
            return 180000;
        }
    }

    public static String d(String str) {
        k.c(str, "accountStatus");
        String str2 = "https://" + (p.a("release", SDKConstants.KEY_STAGING_API, true) ? "staging.paytm.com" : "paytm.com") + "/papi/lms/merchant/account/v2/profile";
        String string = f62655b.getString("merchant_loan_account_url", str2);
        if (!TextUtils.isEmpty(string)) {
            str2 = string;
        }
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + "?account_status=" + str;
    }

    public static String bs() {
        String string = f62655b.getString("paytm_loan_pid", "");
        if (TextUtils.isEmpty(string)) {
            return p.a("release", SDKConstants.KEY_STAGING_API, true) ? "1200748091" : "278567831";
        }
        return string;
    }

    public static String bt() {
        String string = f62655b.getString("RechargeHomeV2API");
        return TextUtils.isEmpty(string) ? "https://storefront.paytm.com/v2/h/onus-categories" : string;
    }

    public static boolean bu() {
        return f62655b.getBooleanFromContainer4("categoryMenuEnabled", false);
    }

    public static HashMap<String, String> bv() {
        HashMap<String, String> hashMap = null;
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("category_menu_ignore_verticals"), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            hashMap = (HashMap) a2;
        } catch (Exception unused) {
        }
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public static boolean bw() {
        return f62655b.isGTMContainerInitialized();
    }

    public static String bx() {
        return f62655b.getString("iOSDownloadCustomerBillURL");
    }

    public static ArrayList<String> by() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String string = f62655b.getString("paytm_first_card_bins");
            if (TextUtils.isEmpty(string)) {
                return arrayList;
            }
            Object a2 = new com.google.gson.f().a(string, new b().getType());
            k.a(a2, "Gson().fromJson(jsonResp…yList<String>>() {}.type)");
            return (ArrayList) a2;
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public static final class b extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
        b() {
        }
    }

    public static boolean bz() {
        return f62655b.getBoolean("isServiceOptionMandatory", true);
    }

    public static boolean bA() {
        return f62655b.getBoolean("isStoreFrontEnabledFromGTM", false);
    }

    public static double bB() {
        String string = f62655b.getString("max_allowed_amount", "999999.00");
        if (TextUtils.isEmpty(string)) {
            return Double.parseDouble("999999.00");
        }
        return Double.parseDouble(string);
    }

    public static String bC() {
        return f62655b.getString("helpAndSupportDeeplink", "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=1");
    }

    public static String bD() {
        return f62655b.getString("scratchCardAndOffersDeeplink", "paytmmp://cash_wallet?featuretype=vip&screen=categoryNewOffers&offertag=Recharge%20and%20Bill%20payment%20Offers");
    }

    public static String bE() {
        return f62655b.getString("FAQDeeplink", "");
    }

    public static String bF() {
        return f62655b.getString("setupAutomaticPayDeeplink", "paytmmp://automatic");
    }

    public static String bG() {
        return f62655b.getString("order_summary_floating_widget_storefront_url", "https://storefront.paytm.com/v2/h/post-txn-page-new");
    }

    public static String bH() {
        return f62655b.getString("myoder_h5page_url", "paytmmp://mini-app?aId=d03b0f5439f03985d38c15eb56bb491f25b6b12d&data=eyJzcGFyYW1zIjp7ImNhblB1bGxEb3duIjpmYWxzZSwicHVsbFJlZnJlc2giOmZhbHNlLCJzaG93VGl0bGVCYXIiOmZhbHNlfX0=&url=https://paytm.com/myorders");
    }

    public static String bI() {
        return f62655b.getString("creditCardFlowV4VersionMap");
    }

    public static String bJ() {
        return f62655b.getString("creditCardConsentFlowVersionMap");
    }

    public static String bK() {
        return f62655b.getString("promoTnCUrl", "https://apiproxy.paytm.com/papi/v1/promosearch/");
    }

    public static String bL() {
        return f62655b.getString("h5_automatic_version_map", "");
    }

    public static String bM() {
        return f62655b.getString("h5_automatic_url", "https://paytm.com/automatic-subscription/v1/index.html");
    }

    public static String bN() {
        return f62655b.getString("h5_automatic_aid", "109200364bd9adad098ce67c643bade349cd01d5");
    }

    public static String bO() {
        return f62655b.getString("h5_automatic_base_url", "https://paytm.com");
    }

    public static String bP() {
        return f62655b.getString("h5_automatic_default_params", "{'pullRefresh':false,'canPullDown':false,'showTitleBar':false}");
    }

    public static boolean a(Context context, String str) {
        if (context == null || !g.c(str)) {
            return false;
        }
        try {
            Object a2 = new com.google.gson.f().a(f62655b.getString("upsellEnabledMap", "{'21':'8.13.4','17':'8.13.4'}"), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (hashMap == null) {
                hashMap = new HashMap();
                Map map = hashMap;
                if (str == null) {
                    k.a();
                }
                map.put(str, "8.12.2");
            }
            if (str == null) {
                k.a();
            }
            return hashMap.containsKey(str) && ba.c((String) hashMap.get(str), context);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            return false;
        }
    }

    public static String bQ() {
        return f62655b.getString("commonDeleteApi", p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://digitalproxy-staging.paytm.com/v1/expressrecharge/deletefromallsystems" : "https://digitalproxy.paytm.com/v1/expressrecharge/deletefromallsystems");
    }

    public static String bR() {
        return f62655b.getString("ru_skip_deal_version", "{'6':'8.12.2','7':'8.12.2','9':'8.12.2','11':'8.12.2','17':'8.12.2','18':'8.12.2','19':'8.12.2','21':'8.12.2','23':'8.12.2','75505':'8.12.2','101975':'8.12.2','156705':'8.12.2', '26':'8.12.2','68869':'8.12.2','78640':'8.12.2','166690':'8.12.2','131865':'8.12.2','64739':'8.12.2','37217':'8.12.2','106022':'8.12.2','132935':'8.12.2','127781':'8.12.2','204854':'8.12.2','207075':'8.12.2', '219876':'8.12.2', '262072':'8.14.2', '101950':'8.16.0'}");
    }

    public static String bS() {
        return f62655b.getString("SFOffersVersionMap", "{'6':'8.12.2','7':'8.12.2','9':'8.12.2','11':'8.12.2','17':'8.12.2','18':'8.12.2','19':'8.12.2','21':'8.12.2','23':'8.12.2','75505':'8.12.2','101975':'8.12.2','156705':'8.12.2', '26':'8.12.2','68869':'8.12.2','78640':'8.12.2','166690':'8.12.2','131865':'8.12.2','64739':'8.12.2','37217':'8.12.2','106022':'8.12.2','132935':'8.12.2','127781':'8.12.2','204854':'8.12.2','207075':'8.12.2', '219876':'8.12.2', '262072':'8.14.2', '101950':'8.16.0'}");
    }

    public static String bT() {
        return f62655b.getString("ru_show_bank_offer_map", "{'ru_show_bank_offer':'9.0.0'}");
    }

    public static int bU() {
        return f62655b.getInteger("ru_mnp_timeout", AppConstants.REQUEST_CODE_FOR_SYSTEM.LOCATION_SETTINGS_DIALOG);
    }
}
