package net.one97.paytm.nativesdk.NetworkHandler;

import android.content.Context;
import java.util.HashMap;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class HawkEyeEvent {
    private static volatile HawkEyeEvent INSTANCE;
    private Context mContext;
    private String mHawkEyeApiSecret = BuildConfig.HAWKEYE_API_SECRET;
    private HashMap<String, String> mHawkEyeHeader = new HashMap<>();
    private String mHawkEyeUrl = SDKConstants.HAWKEYE_PROD_API_URL;

    private HawkEyeEvent(Context context) {
        this.mContext = context;
        this.mHawkEyeHeader.put("authorization", this.mHawkEyeApiSecret);
    }

    public static HawkEyeEvent getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (HawkEyeEvent.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HawkEyeEvent(context);
                }
            }
        }
        return INSTANCE;
    }

    public void logApiEvent(boolean z, String str, long j, String str2, int i2) {
        logApiEvent(z, str, j, str2, i2, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x010e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x016e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x016f, code lost:
        net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0172, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x016e A[ExcHandler: JSONException (r0v1 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logApiEvent(boolean r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.lang.String r21) {
        /*
            r14 = this;
            r1 = r14
            r2 = r16
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r0 = "userId"
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r4 = r4.getCustomerId()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "deviceManufacturer"
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "osType"
            java.lang.String r4 = "android"
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "osVersion"
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "origin"
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r4 = r4.getMid()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "deviceName"
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "deviceId"
            android.content.Context r4 = r1.mContext     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getDeviceId(r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "android-debug"
            java.lang.String r4 = "clientId"
            r3.put(r4, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r4.<init>()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r5 = "eventType"
            if (r0 == 0) goto L_0x006c
            if (r15 == 0) goto L_0x0066
            java.lang.String r0 = "apiError"
            r4.put(r5, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            goto L_0x0071
        L_0x0066:
            java.lang.String r0 = "apiLog"
            r4.put(r5, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            goto L_0x0071
        L_0x006c:
            r0 = r21
            r4.put(r5, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
        L_0x0071:
            java.lang.String r0 = "responseType"
            java.lang.String r5 = "json"
            r4.put(r0, r5)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "userFacing"
            r5 = 0
            r4.put(r0, r5)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            android.content.Context r0 = r1.mContext     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getNetworkType(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            if (r6 != 0) goto L_0x0090
            java.lang.String r6 = "networkType"
            r4.put(r6, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
        L_0x0090:
            java.lang.String r0 = "responseTime"
            r6 = r19
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "verticalName"
            java.lang.String r6 = "Payment Gateway"
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "responseCode"
            r6 = r20
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "timestamp"
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r7 = "yyyy-MM-dd'T'HH:mm:ss"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r6.<init>(r7, r8)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.util.Date r7 = new java.util.Date     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r8 = r17
            r7.<init>(r8)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r6 = r6.format(r7)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            net.one97.paytm.nativesdk.Utils.LocationManager r0 = net.one97.paytm.nativesdk.Utils.LocationManager.getManger()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            android.content.Context r6 = r1.mContext     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            android.location.Location r0 = r0.getLocation(r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r6.<init>()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r7 = "lat"
            java.lang.String r8 = net.one97.paytm.nativesdk.Utils.SDKUtility.getLatitude(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r7 = "lon"
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getLongitude(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r6.put(r7, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "location"
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "uri"
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            android.content.Context r6 = r1.mContext     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r6, r5)     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            java.lang.String r5 = "appVersionCode"
            int r6 = r0.versionCode     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            java.lang.String r5 = "appVersion"
            java.lang.String r0 = r0.versionName     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            r4.put(r5, r0)     // Catch:{ Exception -> 0x010e, JSONException -> 0x016e }
            goto L_0x0112
        L_0x010e:
            r0 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
        L_0x0112:
            java.lang.String r0 = "flowName"
            java.lang.String r5 = "online_payments"
            r4.put(r0, r5)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r0 = "mid"
            net.one97.paytm.nativesdk.MerchantBL r5 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r5 = r5.getMid()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r4.put(r0, r5)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r0.<init>()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r0.put(r4)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.String r4 = "events"
            r3.put(r4, r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest r0 = new net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r6 = 1
            java.lang.String r7 = r1.mHawkEyeUrl     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r1.mHawkEyeHeader     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r9 = 0
            java.lang.String r10 = r3.toString()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent$1 r11 = new net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent$1     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r11.<init>(r2)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent$2 r12 = new net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent$2     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r12.<init>(r2)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            java.lang.Class<java.lang.Object> r13 = java.lang.Object.class
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r0.setFromHawkEye()     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            com.android.volley.DefaultRetryPolicy r2 = new com.android.volley.DefaultRetryPolicy     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r3 = 2500(0x9c4, float:3.503E-42)
            r4 = 2
            r5 = 1065353216(0x3f800000, float:1.0)
            r2.<init>(r3, r4, r5)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r0.setRetryPolicy(r2)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            android.content.Context r2 = r1.mContext     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue r2 = net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue.getInstance(r2)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            r2.addToRequestQueue(r0)     // Catch:{ JSONException -> 0x016e, Exception -> 0x0169 }
            return
        L_0x0169:
            r0 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
            return
        L_0x016e:
            r0 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent.logApiEvent(boolean, java.lang.String, long, java.lang.String, int, java.lang.String):void");
    }
}
