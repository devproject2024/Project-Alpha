package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import com.appsflyer.AFEvent;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.model.event.Purchase;
import com.appsflyer.internal.model.event.SdkServices;
import com.appsflyer.internal.model.event.Validate;
import com.appsflyer.internal.referrer.Payload;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x implements Runnable {

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String f308 = null;

    /* renamed from: ι  reason: contains not printable characters */
    private static String f309 = "https://%ssdk-services.%s/validate-android-signature";
    /* access modifiers changed from: private */

    /* renamed from: ı  reason: contains not printable characters */
    public WeakReference<Context> f310;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private String f311;
    /* access modifiers changed from: private */

    /* renamed from: ȷ  reason: contains not printable characters */
    public Map<String, String> f312;

    /* renamed from: ɩ  reason: contains not printable characters */
    private String f313;

    /* renamed from: ɹ  reason: contains not printable characters */
    private String f314;

    /* renamed from: Ι  reason: contains not printable characters */
    private final Intent f315;

    /* renamed from: І  reason: contains not printable characters */
    private String f316;

    /* renamed from: і  reason: contains not printable characters */
    private String f317;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private String f318;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AppsFlyerLibCore.f58);
        sb.append("/androidevent?buildnumber=5.4.0&app_id=");
        f308 = sb.toString();
    }

    public x(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.f310 = new WeakReference<>(context);
        this.f313 = str;
        this.f316 = str2;
        this.f318 = str4;
        this.f311 = str5;
        this.f314 = str6;
        this.f312 = map;
        this.f317 = str3;
        this.f315 = intent;
    }

    public final void run() {
        String str = this.f313;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isTrackingStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.f310.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.f316);
                    hashMap.put("sig-data", this.f318);
                    hashMap.put("signature", this.f317);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            x xVar = x.this;
                            x.m208(xVar, hashMap2, xVar.f312, x.this.f310);
                        }
                    }).start();
                    hashMap.put("dev_key", this.f313);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl(f309);
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai.f183.m144("server_request", url, jSONObject);
                    HttpURLConnection r1 = m207((Purchase) new SdkServices().params(hashMap).urlString(url));
                    int i2 = -1;
                    if (r1 != null) {
                        i2 = r1.getResponseCode();
                    }
                    String r4 = AppsFlyerLibCore.getInstance().m99(r1);
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai.f183.m144("server_response", url, String.valueOf(i2), r4);
                    JSONObject jSONObject2 = new JSONObject(r4);
                    jSONObject2.put("code", i2);
                    if (i2 == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        m210(jSONObject2.optBoolean("result"), this.f318, this.f311, this.f314, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        m210(false, this.f318, this.f311, this.f314, jSONObject2.toString());
                    }
                    if (r1 != null) {
                        r1.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static HttpURLConnection m207(Purchase purchase) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(purchase.urlString());
        AFLogger.afDebugLog(sb.toString());
        return new ad(purchase.trackingStopped(AppsFlyerLib.getInstance().isTrackingStopped())).m125();
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static void m210(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLibCore.f60 != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLibCore.f60.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLibCore.f60;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static /* synthetic */ void m208(x xVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f308));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = AppsFlyerLibCore.getSharedPreferences((Context) weakReference.get()).getString(Payload.REFERRER, "");
            AFEvent key = new Validate((Context) weakReference.get()).key(xVar.f313);
            key.f8 = string;
            key.f9 = xVar.f315;
            Validate validate = (Validate) key;
            Map<String, Object> r1 = AppsFlyerLibCore.getInstance().m102((AFEvent) validate);
            r1.put("price", xVar.f311);
            r1.put("currency", xVar.f314);
            r1.put("receipt_data", map);
            if (map2 != null) {
                r1.put("extra_prms", map2);
            }
            String jSONObject = new JSONObject(r1).toString();
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144("server_request", obj, jSONObject);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection r6 = m207((Purchase) validate.params(r1).urlString(obj));
                int i2 = -1;
                if (r6 != null) {
                    i2 = r6.getResponseCode();
                }
                String r9 = AppsFlyerLibCore.getInstance().m99(r6);
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m144("server_response", obj, String.valueOf(i2), r9);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(i2);
                sb2.append(": ");
                sb2.append(new JSONObject(r9).toString());
                AFLogger.afInfoLog(sb2.toString());
                if (r6 != null) {
                    r6.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
