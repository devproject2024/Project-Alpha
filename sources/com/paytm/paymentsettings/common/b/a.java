package com.paytm.paymentsettings.common.b;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.nativesdk.BuildConfig;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f43424d;

    /* renamed from: a  reason: collision with root package name */
    private Context f43425a;

    /* renamed from: b  reason: collision with root package name */
    private String f43426b = "https://accounts-analyticsapp.paytm.com/appdebuganalytics/triggers/save";

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f43427c = new HashMap<>();

    private a(Context context) {
        this.f43425a = context;
        this.f43427c.put("authorization", BuildConfig.HAWKEYE_API_SECRET);
        this.f43427c.put("Content-Type", "application/json");
    }

    public static a a(Context context) {
        if (f43424d == null) {
            synchronized (a.class) {
                if (f43424d == null) {
                    f43424d = new a(context);
                }
            }
        }
        return f43424d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0150, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0151, code lost:
        com.paytm.paymentsettings.common.b.b.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0154, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0155, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0156, code lost:
        com.paytm.paymentsettings.common.b.b.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0159, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0155 A[ExcHandler: JSONException (r6v1 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:1:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r6, final java.lang.String r7, long r8, java.lang.String r10, int r11) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "userId"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "deviceManufacturer"
            java.lang.String r3 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "osType"
            java.lang.String r3 = "android"
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "osVersion"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "origin"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "deviceName"
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "deviceId"
            com.paytm.paymentsettings.common.b.d$a r3 = com.paytm.paymentsettings.common.b.d.f43432a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            android.content.Context r3 = r5.f43425a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r4 = "context"
            kotlin.g.b.k.c(r3, r4)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            int r4 = androidx.core.app.a.a((android.content.Context) r3, (java.lang.String) r4)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            if (r4 != 0) goto L_0x0050
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r4 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r4)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            if (r3 != 0) goto L_0x0051
            java.lang.String r3 = "2k3k4k34k3k"
            goto L_0x0051
        L_0x0050:
            r3 = r0
        L_0x0051:
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r2 = "android-debug"
            java.lang.String r3 = "clientId"
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r2.<init>()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r3 = "eventType"
            if (r6 == 0) goto L_0x006a
            java.lang.String r6 = "apiError"
            r2.put(r3, r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            goto L_0x006f
        L_0x006a:
            java.lang.String r6 = "apiLog"
            r2.put(r3, r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
        L_0x006f:
            java.lang.String r6 = "responseType"
            java.lang.String r3 = "json"
            r2.put(r6, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "userFacing"
            r3 = 0
            r2.put(r6, r3)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.paymentsettings.common.b.d$a r6 = com.paytm.paymentsettings.common.b.d.f43432a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            android.content.Context r6 = r5.f43425a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = com.paytm.paymentsettings.common.b.d.a.a((android.content.Context) r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            if (r4 != 0) goto L_0x0090
            java.lang.String r4 = "networkType"
            r2.put(r4, r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
        L_0x0090:
            java.lang.String r6 = "responseTime"
            r2.put(r6, r10)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "verticalName"
            java.lang.String r10 = "Payment Gateway"
            r2.put(r6, r10)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "responseCode"
            r2.put(r6, r11)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "timestamp"
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r11 = "yyyy-MM-dd'T'HH:mm:ss"
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r10.<init>(r11, r4)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.util.Date r11 = new java.util.Date     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r11.<init>(r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r8 = r10.format(r11)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r2.put(r6, r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "uri"
            r2.put(r6, r7)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            android.content.Context r6 = r5.f43425a     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            android.content.Context r8 = r5.f43425a     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r8, r3)     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            java.lang.String r8 = "appVersionCode"
            int r9 = r6.versionCode     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            r2.put(r8, r9)     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            java.lang.String r8 = "appVersion"
            java.lang.String r6 = r6.versionName     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            r2.put(r8, r6)     // Catch:{ Exception -> 0x00e2, JSONException -> 0x0155 }
            goto L_0x00e6
        L_0x00e2:
            r6 = move-exception
            com.paytm.paymentsettings.common.b.b.a(r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
        L_0x00e6:
            java.lang.String r6 = "flowName"
            java.lang.String r8 = "online_payments"
            r2.put(r6, r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r6 = "mid"
            r2.put(r6, r0)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r6.<init>()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r6.put(r2)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r8 = "events"
            r1.put(r8, r6)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = new com.paytm.network.b     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r6.<init>()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            android.content.Context r8 = r5.f43425a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((android.content.Context) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.a$c r8 = com.paytm.network.a.c.AUTH     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((com.paytm.network.a.c) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.a$b r8 = com.paytm.network.a.b.SILENT     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((com.paytm.network.a.b) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r8 = "HawkEye"
            com.paytm.network.b r6 = r6.c(r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.a$a r8 = com.paytm.network.a.C0715a.POST     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((com.paytm.network.a.C0715a) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r8 = r5.f43426b     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((java.lang.String) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r5.f43427c     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            java.lang.String r8 = r1.toString()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.b((java.lang.String) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.paymentsettings.common.b.a$a r8 = new com.paytm.paymentsettings.common.b.a$a     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r8.<init>()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((com.paytm.network.model.IJRPaytmDataModel) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.paymentsettings.common.b.a$1 r8 = new com.paytm.paymentsettings.common.b.a$1     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r8.<init>(r7)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.b r6 = r6.a((com.paytm.network.listener.b) r8)     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            com.paytm.network.a r6 = r6.l()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            r6.a()     // Catch:{ JSONException -> 0x0155, Exception -> 0x0150 }
            return
        L_0x0150:
            r6 = move-exception
            com.paytm.paymentsettings.common.b.b.a(r6)
            return
        L_0x0155:
            r6 = move-exception
            com.paytm.paymentsettings.common.b.b.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.b.a.a(boolean, java.lang.String, long, java.lang.String, int):void");
    }

    /* renamed from: com.paytm.paymentsettings.common.b.a$a  reason: collision with other inner class name */
    class C0735a extends IJRPaytmDataModel {
        String value;

        C0735a() {
        }

        /* access modifiers changed from: package-private */
        public final String getValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public final void setValue(String str) {
            this.value = str;
        }

        public final IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
            C0735a aVar = new C0735a();
            aVar.setValue(str);
            return aVar;
        }
    }
}
