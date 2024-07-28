package net.one97.paytm.acceptPayment.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.acceptPayment.d.a;
import net.one97.paytm.acceptPayment.model.GAEvent;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static void a(Context context, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(a.f52050a.D())) {
            hashMap.put("merchant_id", a.f52050a.D());
        }
        if (!TextUtils.isEmpty(a.f52050a.t())) {
            hashMap.put("merchant_type", a.f52050a.t());
        }
        a aVar = a.f52050a;
        if (!TextUtils.isEmpty(a.N())) {
            a aVar2 = a.f52050a;
            hashMap.put("user_id", a.N());
        }
        hashMap.put("vertical_name", "business_accept_payment");
        a(GAUtil.CUSTOM_EVENT, hashMap, context);
    }

    public static void a(Context context, GAEvent gAEvent) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(a.f52050a.D())) {
            hashMap.put("merchant_id", a.f52050a.D());
        }
        if (!TextUtils.isEmpty(a.f52050a.t())) {
            hashMap.put("merchant_type", a.f52050a.t());
        }
        a aVar = a.f52050a;
        if (!TextUtils.isEmpty(a.N())) {
            a aVar2 = a.f52050a;
            hashMap.put("user_id", a.N());
        }
        hashMap.put("event_category", gAEvent.eventCategory);
        hashMap.put("event_action", gAEvent.eventAction);
        if (!TextUtils.isEmpty(gAEvent.eventLabel)) {
            hashMap.put("event_label", gAEvent.eventLabel);
        }
        if (!TextUtils.isEmpty(gAEvent.eventLabel2)) {
            hashMap.put("event_label2", gAEvent.eventLabel2);
        }
        if (!TextUtils.isEmpty(gAEvent.eventLabel3)) {
            hashMap.put("event_label3", gAEvent.eventLabel3);
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, gAEvent.screenName);
        hashMap.put("vertical_name", "business_accept_payment");
        a(GAUtil.CUSTOM_EVENT, (HashMap<String, Object>) hashMap, context);
    }

    public static void a(String str, HashMap<String, Object> hashMap, Context context) {
        net.one97.paytm.acceptPayment.b.b.a();
        if (net.one97.paytm.acceptPayment.b.b.b("showGAToastAP")) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : hashMap.entrySet()) {
                Object value = next.getValue();
                sb.append(StringUtility.NEW_LINE);
                sb.append((String) next.getKey());
                sb.append(" = ");
                sb.append(value.toString());
            }
            Toast.makeText(context, sb, 0).show();
        }
        net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a(str, (Map<String, Object>) hashMap, context);
    }

    public static void a(Activity activity) {
        net.one97.paytm.acceptPayment.b.b.a();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(net.one97.paytm.acceptPayment.b.b.a("pfb_deep_link")));
        if (activity != null) {
            try {
                List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.paytm.business")));
                } else {
                    activity.startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static DeepLinkData a(String str) {
        Uri parse = Uri.parse(str);
        DeepLinkData deepLinkData = new DeepLinkData();
        String host = parse.getHost();
        String queryParameter = parse.getQueryParameter("featuretype");
        if (host != null) {
            deepLinkData.f50284b = parse.getHost();
        }
        if (queryParameter != null) {
            deepLinkData.f50288f = queryParameter;
        }
        deepLinkData.f50289g = Uri.parse(str).buildUpon().build();
        return deepLinkData;
    }

    public static HashMap<String, String> a(Uri uri) {
        String queryParameter;
        HashMap<String, String> hashMap = new HashMap<>();
        for (String next : uri.getQueryParameterNames()) {
            if (!(next == null || (queryParameter = uri.getQueryParameter(next)) == null)) {
                hashMap.put(next, queryParameter);
            }
        }
        return hashMap;
    }

    public static String a(JSONObject jSONObject) {
        return jSONObject.toString().replace("\"", "\\\"");
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean a(Activity activity, NetworkCustomError networkCustomError, String str) {
        try {
            if (networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(networkCustomError.networkResponse.data));
            if (jSONObject.get(AppConstants.TRANSACTION_STATUS_ERROR) == null || !jSONObject.getString(AppConstants.TRANSACTION_STATUS_ERROR).equalsIgnoreCase("INVALID_TOKEN") || jSONObject.get("statusCode") == null || !jSONObject.getString("statusCode").equalsIgnoreCase("UMP-400")) {
                return false;
            }
            net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a(activity, str, activity.getIntent().getExtras());
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String a(String str, String str2) {
        return b("paytmmp://accept_money?featuretype=ump-web", str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return r0.build().toString();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x002e }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x002e }
            if (r3 == 0) goto L_0x000f
            java.lang.String r1 = "pageId"
            r0.appendQueryParameter(r1, r3)     // Catch:{ Exception -> 0x002e }
        L_0x000f:
            if (r4 == 0) goto L_0x0017
            java.lang.String r3 = "url"
            r0.appendQueryParameter(r3, r4)     // Catch:{ Exception -> 0x002e }
        L_0x0017:
            android.net.Uri r3 = r0.build()     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            return r2
        L_0x0026:
            android.net.Uri r3 = r0.build()     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.utils.b.b(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(String str, Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }

    public static HashMap<String, Object> a(GAEvent gAEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a();
        if (!TextUtils.isEmpty(a.f52050a.D())) {
            hashMap.put("merchant_id", a.f52050a.D());
        }
        if (!TextUtils.isEmpty(a.f52050a.t())) {
            hashMap.put("merchant_type", a.f52050a.t());
        }
        a aVar = a.f52050a;
        if (!TextUtils.isEmpty(a.N())) {
            a aVar2 = a.f52050a;
            hashMap.put("user_id", a.N());
        }
        hashMap.put("event_category", gAEvent.eventCategory);
        hashMap.put("event_action", gAEvent.eventAction);
        if (!TextUtils.isEmpty(gAEvent.eventLabel)) {
            hashMap.put("event_label", gAEvent.eventLabel);
        }
        if (!TextUtils.isEmpty(gAEvent.eventLabel2)) {
            hashMap.put("event_label2", gAEvent.eventLabel2);
        }
        if (!TextUtils.isEmpty(gAEvent.eventLabel3)) {
            hashMap.put("event_label3", gAEvent.eventLabel3);
        }
        if (!TextUtils.isEmpty(gAEvent.eventLabel4)) {
            hashMap.put("event_label3", gAEvent.eventLabel4);
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, gAEvent.screenName);
        hashMap.put("vertical_name", "business_accept_payment");
        return hashMap;
    }

    public static String a(String str, String str2, String str3) {
        String str4 = "javascript:" + str + "(\"" + str2 + "\",\"" + str3 + "\");";
        new StringBuilder("loadUrl = ").append(str4);
        return str4;
    }

    public static long b(Context context) {
        return com.business.common_module.utilities.a.a(context.getApplicationContext()).b("cache_merchantt_context", 0, true);
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static void a(long j) {
        com.business.common_module.utilities.a.a(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()).a("cache_merchantt_context", j, true);
    }
}
