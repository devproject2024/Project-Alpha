package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import java.util.HashMap;
import net.one97.paytm.payments.visascp.VisaSDK;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class HawkEyeEvent {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static int f587 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static HawkEyeEvent f588 = null;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f589 = 1;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f590;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f591;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f592;

    /* renamed from: ॱ  reason: contains not printable characters */
    private HashMap<String, String> f593;

    static {
        int i2 = (f589 + 12) - 1;
        f587 = i2 % 128;
        int i3 = i2 % 2;
    }

    private HawkEyeEvent(Context context) {
        this.f591 = context;
        if (VisaSDK.isStaging() || VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release")) {
            this.f592 = VisaSCPConstants.HAWKEYE_STAGING_API_URL;
            this.f590 = VisaSCPConstants.HAWKEYE_STAGING_API_SECRET;
        } else {
            this.f592 = VisaSCPConstants.HAWKEYE_PROD_API_URL;
            this.f590 = VisaSCPConstants.HAWKEYE_PROD_API_SECRET;
        }
        this.f593 = new HashMap<>();
        this.f593.put("authorization", this.f590);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (f588 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.payments.visascp.network.HawkEyeEvent getInstance(android.content.Context r3) {
        /*
            int r0 = f587
            r1 = r0 & 103(0x67, float:1.44E-43)
            int r2 = ~r1
            r0 = r0 | 103(0x67, float:1.44E-43)
            r0 = r0 & r2
            int r1 = r1 << 1
            int r1 = -r1
            int r1 = -r1
            r2 = r0 ^ r1
            r0 = r0 & r1
            int r0 = r0 << 1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f589 = r0
            int r2 = r2 % 2
            r0 = 75
            if (r2 == 0) goto L_0x001f
            r1 = 90
            goto L_0x0021
        L_0x001f:
            r1 = 75
        L_0x0021:
            if (r1 == r0) goto L_0x0028
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r0 = f588
            if (r0 != 0) goto L_0x0047
            goto L_0x0031
        L_0x0028:
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r0 = f588
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0031
            goto L_0x0047
        L_0x0031:
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r0 = new net.one97.paytm.payments.visascp.network.HawkEyeEvent
            r0.<init>(r3)
            f588 = r0
            int r3 = f587
            r0 = r3 & 108(0x6c, float:1.51E-43)
            r3 = r3 | 108(0x6c, float:1.51E-43)
            int r0 = r0 + r3
            int r0 = r0 + -1
            int r3 = r0 % 128
            f589 = r3
            int r0 = r0 % 2
        L_0x0047:
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r3 = f588
            int r0 = f589
            r1 = r0 & 45
            r0 = r0 | 45
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 + -1
            int r0 = r1 % 128
            f587 = r0
            int r1 = r1 % 2
            return r3
        L_0x005c:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(android.content.Context):net.one97.paytm.payments.visascp.network.HawkEyeEvent");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b1, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03b6, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ba, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:142:0x02ec */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0138 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0396 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:46:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[ExcHandler: JSONException (unused org.json.JSONException), SYNTHETIC, Splitter:B:1:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logApiEvent(boolean r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
            r15 = this;
            r1 = r15
            r0 = r17
            r2 = r26
            java.lang.String r3 = "release"
            java.lang.String r4 = "origin"
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            android.content.Context r6 = r1.f591     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.Utils.getMerchantAppId(r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r5.put(r4, r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "userId"
            r7 = r18
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "deviceId"
            android.content.Context r7 = r1.f591     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.Utils.getDeviceId(r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "deviceManufacturer"
            java.lang.String r7 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "deviceName"
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "osType"
            java.lang.String r7 = "android"
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "osVersion"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "android-prod"
            boolean r7 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r8 = 1
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0052
        L_0x0050:
            r7 = 72
        L_0x0052:
            java.lang.String r9 = "android-debug"
            r10 = 18
            r11 = 0
            r12 = 2
            if (r7 == r8) goto L_0x00a0
            int r7 = f589
            r13 = r7 & 17
            r7 = r7 ^ 17
            r7 = r7 | r13
            int r7 = -r7
            int r7 = -r7
            r14 = r13 | r7
            int r14 = r14 << r8
            r7 = r7 ^ r13
            int r14 = r14 - r7
            int r7 = r14 % 128
            f587 = r7
            int r14 = r14 % r12
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            boolean r7 = r7.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            if (r7 != 0) goto L_0x0077
            r7 = 0
            goto L_0x0078
        L_0x0077:
            r7 = 1
        L_0x0078:
            if (r7 == 0) goto L_0x007b
            goto L_0x00a0
        L_0x007b:
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_DEBUG     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r7 = 88
            if (r3 != 0) goto L_0x0088
            r3 = 88
            goto L_0x008a
        L_0x0088:
            r3 = 25
        L_0x008a:
            if (r3 == r7) goto L_0x00b0
            int r3 = f589
            r6 = r3 & 8
            r3 = r3 | 8
            int r6 = r6 + r3
            int r6 = r6 - r8
            int r3 = r6 % 128
            f587 = r3
            int r6 = r6 % r12
            if (r6 != 0) goto L_0x009d
            r3 = 0
            goto L_0x009e
        L_0x009d:
            r3 = 1
        L_0x009e:
            r6 = r9
            goto L_0x00b0
        L_0x00a0:
            int r3 = f587
            r6 = r3 ^ 18
            r3 = r3 & r10
            int r3 = r3 << r8
            int r6 = r6 + r3
            int r6 = r6 - r11
            int r6 = r6 - r8
            int r3 = r6 % 128
            f589 = r3
            int r6 = r6 % r12
            java.lang.String r6 = "android-staging"
        L_0x00b0:
            java.lang.String r3 = "clientId"
            r5.put(r3, r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r3.<init>()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            android.content.Context r6 = r1.f591     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.Utils.getNetworkType(r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            if (r7 == 0) goto L_0x00c8
            r7 = 0
            goto L_0x00c9
        L_0x00c8:
            r7 = 1
        L_0x00c9:
            if (r7 == 0) goto L_0x00f2
            int r7 = f587
            r9 = r7 & 63
            r7 = r7 ^ 63
            r7 = r7 | r9
            r13 = r9 | r7
            int r13 = r13 << r8
            r7 = r7 ^ r9
            int r13 = r13 - r7
            int r7 = r13 % 128
            f589 = r7
            int r13 = r13 % r12
            java.lang.String r7 = "networkType"
            r3.put(r7, r6)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            int r6 = f587
            r7 = r6 & -120(0xffffffffffffff88, float:NaN)
            int r9 = ~r6
            r9 = r9 & 119(0x77, float:1.67E-43)
            r7 = r7 | r9
            r6 = r6 & 119(0x77, float:1.67E-43)
            int r6 = r6 << r8
            int r7 = r7 + r6
            int r6 = r7 % 128
            f589 = r6
            int r7 = r7 % r12
        L_0x00f2:
            java.lang.String r6 = "timestamp"
            r7 = r19
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "userFacing"
            r3.put(r6, r11)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "uri"
            r3.put(r6, r0)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "responseCode"
            r7 = r21
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            android.content.Context r6 = r1.f591     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            android.content.Context r7 = r1.f591     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r7, r11)     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            java.lang.String r7 = "appVersionCode"
            int r9 = r6.versionCode     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            r3.put(r7, r9)     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            java.lang.String r7 = "appVersion"
            java.lang.String r6 = r6.versionName     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            r3.put(r7, r6)     // Catch:{ Exception -> 0x0138, JSONException -> 0x03b6 }
            int r6 = f587
            r7 = r6 & 123(0x7b, float:1.72E-43)
            r6 = r6 ^ 123(0x7b, float:1.72E-43)
            r6 = r6 | r7
            int r6 = ~r6
            int r7 = r7 - r6
            int r7 = r7 - r8
            int r6 = r7 % 128
            f589 = r6
            int r7 = r7 % r12
            goto L_0x013c
        L_0x0138:
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x013c:
            java.lang.String r6 = "responseTime"
            r7 = r20
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r6 = "verticalName"
            java.lang.String r7 = "visa-scp"
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r6 = 65
            if (r16 != 0) goto L_0x0151
            r7 = 65
            goto L_0x0153
        L_0x0151:
            r7 = 82
        L_0x0153:
            if (r7 == r6) goto L_0x017e
            int r6 = f589
            r7 = r6 | 8
            int r7 = r7 << r8
            r6 = r6 ^ 8
            int r7 = r7 - r6
            int r7 = r7 - r8
            int r6 = r7 % 128
            f587 = r6
            int r7 = r7 % r12
            java.lang.String r6 = "eventType"
            java.lang.String r7 = "apiError"
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            int r6 = f587
            int r6 = r6 + 56
            int r6 = r6 - r8
            int r7 = r6 % 128
            f589 = r7
            int r6 = r6 % r12
            if (r6 == 0) goto L_0x0179
            r6 = 69
            goto L_0x017b
        L_0x0179:
            r6 = 13
        L_0x017b:
            r7 = 69
            goto L_0x0194
        L_0x017e:
            java.lang.String r6 = "eventType"
            java.lang.String r7 = "apiLog"
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            int r6 = f589
            int r6 = r6 + 112
            int r6 = r6 - r8
            int r7 = r6 % 128
            f587 = r7
            int r6 = r6 % r12
            if (r6 != 0) goto L_0x0193
            r6 = 0
            goto L_0x0194
        L_0x0193:
            r6 = 1
        L_0x0194:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            r6.<init>()     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            java.lang.String r7 = "responseType"
            java.lang.String r9 = "json"
            r6.put(r7, r9)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            boolean r7 = android.text.TextUtils.isEmpty(r23)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            r9 = 45
            if (r7 == 0) goto L_0x01ab
            r7 = 45
            goto L_0x01ad
        L_0x01ab:
            r7 = 34
        L_0x01ad:
            if (r7 == r9) goto L_0x01df
            int r7 = f587
            r13 = r7 & 13
            int r14 = ~r13
            r7 = r7 | 13
            r7 = r7 & r14
            int r13 = r13 << r8
            r14 = r7 ^ r13
            r7 = r7 & r13
            int r7 = r7 << r8
            int r14 = r14 + r7
            int r7 = r14 % 128
            f589 = r7
            int r14 = r14 % r12
            java.lang.String r7 = "correlationId"
            r13 = r23
            r6.put(r7, r13)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            int r7 = f589
            r13 = r7 ^ 71
            r7 = r7 & 71
            int r7 = r7 << r8
            int r7 = -r7
            int r7 = -r7
            int r7 = ~r7
            int r13 = r13 - r7
            int r13 = r13 - r8
            int r7 = r13 % 128
            f587 = r7
            int r13 = r13 % r12
            if (r13 != 0) goto L_0x01de
            r7 = 0
            goto L_0x01df
        L_0x01de:
            r7 = 1
        L_0x01df:
            boolean r7 = android.text.TextUtils.isEmpty(r24)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            if (r7 == 0) goto L_0x01e7
            r7 = 1
            goto L_0x01e8
        L_0x01e7:
            r7 = 0
        L_0x01e8:
            if (r7 == 0) goto L_0x01eb
            goto L_0x020a
        L_0x01eb:
            int r7 = f587
            r13 = r7 & 33
            r7 = r7 | 33
            int r13 = r13 + r7
            int r7 = r13 % 128
            f589 = r7
            int r13 = r13 % r12
            java.lang.String r7 = "data"
            r13 = r24
            r6.put(r7, r13)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            int r7 = f589
            r13 = r7 ^ 45
            r7 = r7 & r9
            int r7 = r7 << r8
            int r13 = r13 + r7
            int r7 = r13 % 128
            f587 = r7
            int r13 = r13 % r12
        L_0x020a:
            boolean r7 = android.text.TextUtils.isEmpty(r25)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            if (r7 == 0) goto L_0x0212
            r7 = 0
            goto L_0x0213
        L_0x0212:
            r7 = 1
        L_0x0213:
            if (r7 == 0) goto L_0x0247
            int r7 = f587
            r9 = r7 & -44
            int r13 = ~r7
            r13 = r13 & 43
            r9 = r9 | r13
            r7 = r7 & 43
            int r7 = r7 << r8
            r13 = r9 & r7
            r7 = r7 | r9
            int r13 = r13 + r7
            int r7 = r13 % 128
            f589 = r7
            int r13 = r13 % r12
            java.lang.String r7 = "walletDeviceId"
            r9 = r25
            r6.put(r7, r9)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            int r7 = f589
            r9 = r7 & -24
            int r13 = ~r7
            r13 = r13 & 23
            r9 = r9 | r13
            r7 = r7 & 23
            int r7 = r7 << r8
            int r7 = -r7
            int r7 = -r7
            r13 = r9 ^ r7
            r7 = r7 & r9
            int r7 = r7 << r8
            int r13 = r13 + r7
            int r7 = r13 % 128
            f587 = r7
            int r13 = r13 % r12
        L_0x0247:
            boolean r7 = android.text.TextUtils.isEmpty(r22)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            if (r7 == 0) goto L_0x0250
            r7 = 18
            goto L_0x0252
        L_0x0250:
            r7 = 83
        L_0x0252:
            r9 = 83
            if (r7 == r9) goto L_0x0257
            goto L_0x028b
        L_0x0257:
            int r7 = f589
            r9 = r7 ^ 85
            r13 = r7 & 85
            r9 = r9 | r13
            int r9 = r9 << r8
            r13 = r7 & -86
            int r7 = ~r7
            r7 = r7 & 85
            r7 = r7 | r13
            int r9 = r9 - r7
            int r7 = r9 % 128
            f587 = r7
            int r9 = r9 % r12
            java.lang.String r7 = "responseMessage"
            r9 = r22
            r6.put(r7, r9)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            int r7 = f589
            r9 = r7 ^ 125(0x7d, float:1.75E-43)
            r7 = r7 & 125(0x7d, float:1.75E-43)
            r7 = r7 | r9
            int r7 = r7 << r8
            int r9 = -r9
            r13 = r7 ^ r9
            r7 = r7 & r9
            int r7 = r7 << r8
            int r13 = r13 + r7
            int r7 = r13 % 128
            f587 = r7
            int r13 = r13 % r12
            if (r13 != 0) goto L_0x0289
            r7 = 0
            goto L_0x028b
        L_0x0289:
            r7 = 18
        L_0x028b:
            boolean r7 = android.text.TextUtils.isEmpty(r26)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            if (r7 == 0) goto L_0x0293
            r7 = 1
            goto L_0x0294
        L_0x0293:
            r7 = 0
        L_0x0294:
            if (r7 == r8) goto L_0x02c4
            int r7 = f589
            r9 = r7 & -54
            int r10 = ~r7
            r10 = r10 & 53
            r9 = r9 | r10
            r7 = r7 & 53
            int r7 = r7 << r8
            r10 = r9 ^ r7
            r7 = r7 & r9
            int r7 = r7 << r8
            int r10 = r10 + r7
            int r7 = r10 % 128
            f587 = r7
            int r10 = r10 % r12
            if (r10 != 0) goto L_0x02af
            r7 = 0
            goto L_0x02b0
        L_0x02af:
            r7 = 1
        L_0x02b0:
            if (r7 == 0) goto L_0x02bf
            java.lang.String r7 = "cardAlias"
            r6.put(r7, r2)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            r2 = 0
            super.hashCode()     // Catch:{ all -> 0x02bc }
            goto L_0x02c4
        L_0x02bc:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x02bf:
            java.lang.String r7 = "cardAlias"
            r6.put(r7, r2)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
        L_0x02c4:
            android.content.Context r2 = r1.f591     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.Utils.getMerchantAppId(r2)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            r6.put(r4, r2)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            java.lang.String r2 = "responseType"
            java.lang.String r4 = r6.toString()     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02ec, Exception -> 0x03b1 }
            int r2 = f587
            r4 = r2 & 5
            int r6 = ~r4
            r2 = r2 | 5
            r2 = r2 & r6
            int r4 = r4 << r8
            int r4 = -r4
            int r4 = -r4
            r6 = r2 ^ r4
            r2 = r2 & r4
            int r2 = r2 << r8
            int r6 = r6 + r2
            int r2 = r6 % 128
            f589 = r2
            int r6 = r6 % r12
            goto L_0x02f0
        L_0x02ec:
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x02f0:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r2.<init>()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r2.put(r3)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r3 = "events"
            r5.put(r3, r2)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            net.one97.paytm.payments.visascp.network.VolleyRequest r2 = new net.one97.paytm.payments.visascp.network.VolleyRequest     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r3 = 1
            java.lang.String r4 = r1.f592     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r1.f593     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            net.one97.paytm.payments.visascp.network.model.BaseModel r7 = new net.one97.paytm.payments.visascp.network.model.BaseModel     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r7.<init>()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.Object[] r9 = new java.lang.Object[r12]     // Catch:{ all -> 0x03a8 }
            r9[r8] = r0     // Catch:{ all -> 0x03a8 }
            r9[r11] = r1     // Catch:{ all -> 0x03a8 }
            r10 = 55
            r13 = 176(0xb0, float:2.47E-43)
            java.lang.Object r10 = net.one97.paytm.payments.visascp.network.If.m692(r11, r10, r13)     // Catch:{ all -> 0x03a8 }
            java.lang.Class r10 = (java.lang.Class) r10     // Catch:{ all -> 0x03a8 }
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x03a8 }
            java.lang.Class<net.one97.paytm.payments.visascp.network.HawkEyeEvent> r14 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.class
            r13[r11] = r14     // Catch:{ all -> 0x03a8 }
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            r13[r8] = r14     // Catch:{ all -> 0x03a8 }
            java.lang.reflect.Constructor r10 = r10.getDeclaredConstructor(r13)     // Catch:{ all -> 0x03a8 }
            java.lang.Object r9 = r10.newInstance(r9)     // Catch:{ all -> 0x03a8 }
            com.android.volley.Response$Listener r9 = (com.android.volley.Response.Listener) r9     // Catch:{ all -> 0x03a8 }
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ all -> 0x039f }
            r10[r8] = r0     // Catch:{ all -> 0x039f }
            r10[r11] = r1     // Catch:{ all -> 0x039f }
            r0 = 55
            r13 = 231(0xe7, float:3.24E-43)
            java.lang.Object r0 = net.one97.paytm.payments.visascp.network.If.m692(r11, r0, r13)     // Catch:{ all -> 0x039f }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x039f }
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x039f }
            java.lang.Class<net.one97.paytm.payments.visascp.network.HawkEyeEvent> r14 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.class
            r13[r11] = r14     // Catch:{ all -> 0x039f }
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            r13[r8] = r14     // Catch:{ all -> 0x039f }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r13)     // Catch:{ all -> 0x039f }
            java.lang.Object r0 = r0.newInstance(r10)     // Catch:{ all -> 0x039f }
            com.android.volley.Response$ErrorListener r0 = (com.android.volley.Response.ErrorListener) r0     // Catch:{ all -> 0x039f }
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r9
            r23 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            com.android.volley.DefaultRetryPolicy r0 = new com.android.volley.DefaultRetryPolicy     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r3 = 20000(0x4e20, float:2.8026E-41)
            r4 = 0
            r0.<init>(r3, r12, r4)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r2.setRetryPolicy(r0)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            android.content.Context r0 = r1.f591     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            java.lang.String r3 = r1.f592     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            com.android.volley.RequestQueue r0 = net.one97.paytm.payments.visascp.network.VolleyWrapper.newRequestQueue(r0, r3)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            r0.add(r2)     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            int r0 = f589
            r2 = r0 ^ 101(0x65, float:1.42E-43)
            r3 = r0 & 101(0x65, float:1.42E-43)
            r2 = r2 | r3
            int r2 = r2 << r8
            int r3 = ~r3
            r0 = r0 | 101(0x65, float:1.42E-43)
            r0 = r0 & r3
            int r2 = r2 - r0
            int r0 = r2 % 128
            f587 = r0
            int r2 = r2 % r12
            if (r2 != 0) goto L_0x0393
            goto L_0x0394
        L_0x0393:
            r11 = 1
        L_0x0394:
            if (r11 == r8) goto L_0x0397
            return
        L_0x0397:
            r0 = 0
            super.hashCode()     // Catch:{ all -> 0x039c }
            return
        L_0x039c:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x039f:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            if (r2 == 0) goto L_0x03a7
            throw r2     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x03a7:
            throw r0     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x03a8:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
            if (r2 == 0) goto L_0x03b0
            throw r2     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x03b0:
            throw r0     // Catch:{ JSONException -> 0x03b6, Exception -> 0x03b1 }
        L_0x03b1:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return
        L_0x03b6:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.HawkEyeEvent.logApiEvent(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0350, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0354, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0355, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0359, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:154:0x0297 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x014c */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:66:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:181:? A[ExcHandler: JSONException (unused org.json.JSONException), SYNTHETIC, Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logLocalEvent(boolean r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r24
            r3 = r25
            java.lang.String r4 = "release"
            java.lang.String r5 = "origin"
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            android.content.Context r7 = r1.f591     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.Utils.getMerchantAppId(r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r6.put(r5, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "userId"
            r8 = r19
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "deviceId"
            android.content.Context r8 = r1.f591     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.Utils.getDeviceId(r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "deviceManufacturer"
            java.lang.String r8 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "deviceName"
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "osType"
            java.lang.String r8 = "android"
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "osVersion"
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "android-prod"
            boolean r8 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r9 = 59
            if (r8 == 0) goto L_0x0055
            r8 = 59
            goto L_0x0057
        L_0x0055:
            r8 = 15
        L_0x0057:
            java.lang.String r10 = "android-debug"
            r11 = 0
            r12 = 0
            r13 = 2
            r14 = 1
            if (r8 == r9) goto L_0x00ae
            int r8 = f587
            r9 = r8 ^ 39
            r8 = r8 & 39
            r8 = r8 | r9
            int r8 = r8 << r14
            int r9 = -r9
            r15 = r8 & r9
            r8 = r8 | r9
            int r15 = r15 + r8
            int r8 = r15 % 128
            f589 = r8
            int r15 = r15 % r13
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            boolean r8 = r8.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            if (r8 != 0) goto L_0x007b
            r8 = 0
            goto L_0x007c
        L_0x007b:
            r8 = 1
        L_0x007c:
            if (r8 == 0) goto L_0x007f
            goto L_0x00ae
        L_0x007f:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_DEBUG     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r8 = 38
            if (r4 != 0) goto L_0x008c
            r4 = 38
            goto L_0x008e
        L_0x008c:
            r4 = 61
        L_0x008e:
            if (r4 == r8) goto L_0x00b8
            int r4 = f587
            int r4 = r4 + 8
            int r7 = ~r4
            r4 = r4 & -1
            int r4 = r4 << r14
            int r7 = r7 + r4
            int r4 = r7 % 128
            f589 = r4
            int r7 = r7 % r13
            if (r7 == 0) goto L_0x00a2
            r4 = 0
            goto L_0x00a3
        L_0x00a2:
            r4 = 1
        L_0x00a3:
            if (r4 == 0) goto L_0x00ac
            super.hashCode()     // Catch:{ all -> 0x00a9 }
            goto L_0x00ac
        L_0x00a9:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x00ac:
            r7 = r10
            goto L_0x00b8
        L_0x00ae:
            int r4 = f589
            int r4 = r4 + r14
            int r7 = r4 % 128
            f587 = r7
            int r4 = r4 % r13
            java.lang.String r7 = "android-staging"
        L_0x00b8:
            java.lang.String r4 = "clientId"
            r6.put(r4, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r4.<init>()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            android.content.Context r7 = r1.f591     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.Utils.getNetworkType(r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            if (r8 == 0) goto L_0x00d0
            r8 = 1
            goto L_0x00d1
        L_0x00d0:
            r8 = 0
        L_0x00d1:
            if (r8 == r14) goto L_0x0105
            int r8 = f589
            int r8 = r8 + 2
            int r9 = ~r8
            r8 = r8 & -1
            int r8 = r8 << r14
            int r9 = r9 + r8
            int r8 = r9 % 128
            f587 = r8
            int r9 = r9 % r13
            if (r9 != 0) goto L_0x00e5
            r8 = 1
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            java.lang.String r9 = "networkType"
            if (r8 == 0) goto L_0x00ee
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            goto L_0x00f4
        L_0x00ee:
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            super.hashCode()     // Catch:{ all -> 0x0102 }
        L_0x00f4:
            int r7 = f589
            r8 = r7 & 1
            r7 = r7 | r14
            int r7 = ~r7
            int r8 = r8 - r7
            int r8 = r8 - r14
            int r7 = r8 % 128
            f587 = r7
            int r8 = r8 % r13
            goto L_0x0105
        L_0x0102:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0105:
            java.lang.String r7 = "timestamp"
            r8 = r20
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "userFacing"
            r4.put(r7, r12)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "uri"
            r4.put(r7, r0)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = "responseCode"
            r8 = r22
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            android.content.Context r7 = r1.f591     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            android.content.Context r8 = r1.f591     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r12)     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            java.lang.String r8 = "appVersionCode"
            int r9 = r7.versionCode     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            r4.put(r8, r9)     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            java.lang.String r8 = "appVersion"
            java.lang.String r7 = r7.versionName     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            r4.put(r8, r7)     // Catch:{ Exception -> 0x014c, JSONException -> 0x0355 }
            int r7 = f587
            int r7 = r7 + 38
            int r7 = r7 - r12
            int r7 = r7 - r14
            int r8 = r7 % 128
            f589 = r8
            int r7 = r7 % r13
            if (r7 == 0) goto L_0x014a
            r7 = 0
            goto L_0x0150
        L_0x014a:
            r7 = 1
            goto L_0x0150
        L_0x014c:
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x0150:
            java.lang.String r7 = "verticalName"
            java.lang.String r8 = "visa-scp"
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r7 = 12
            if (r17 != 0) goto L_0x015e
            r8 = 80
            goto L_0x0160
        L_0x015e:
            r8 = 12
        L_0x0160:
            java.lang.String r9 = "eventType"
            if (r8 == r7) goto L_0x0176
            java.lang.String r7 = "localLog"
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            int r7 = f587
            r8 = r7 & 17
            r7 = r7 | 17
            int r8 = r8 + r7
            int r7 = r8 % 128
            f589 = r7
            int r8 = r8 % r13
            goto L_0x018c
        L_0x0176:
            int r7 = f589
            r8 = r7 & 25
            r7 = r7 | 25
            int r8 = r8 + r7
            int r7 = r8 % 128
            f587 = r7
            int r8 = r8 % r13
            if (r8 != 0) goto L_0x0186
            r7 = 0
            goto L_0x0187
        L_0x0186:
            r7 = 1
        L_0x0187:
            java.lang.String r7 = "localError"
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x018c:
            boolean r7 = android.text.TextUtils.isEmpty(r21)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            if (r7 == 0) goto L_0x0194
            r7 = 1
            goto L_0x0195
        L_0x0194:
            r7 = 0
        L_0x0195:
            if (r7 == r14) goto L_0x01bf
            int r7 = f587
            r8 = r7 & 115(0x73, float:1.61E-43)
            r7 = r7 ^ 115(0x73, float:1.61E-43)
            r7 = r7 | r8
            int r8 = r8 + r7
            int r7 = r8 % 128
            f589 = r7
            int r8 = r8 % r13
            java.lang.String r7 = "responseTime"
            r8 = r21
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            int r7 = f589
            int r7 = r7 + 37
            int r7 = r7 - r14
            r8 = r7 | -1
            int r8 = r8 << r14
            int r7 = ~r7
            int r8 = r8 - r7
            int r7 = r8 % 128
            f587 = r7
            int r8 = r8 % r13
            if (r8 != 0) goto L_0x01be
            r7 = 0
            goto L_0x01bf
        L_0x01be:
            r7 = 1
        L_0x01bf:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            r7.<init>()     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            java.lang.String r8 = "responseType"
            java.lang.String r9 = "nonJson"
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            boolean r8 = android.text.TextUtils.isEmpty(r23)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            r9 = 60
            if (r8 == 0) goto L_0x01d6
            r8 = 60
            goto L_0x01d8
        L_0x01d6:
            r8 = 62
        L_0x01d8:
            if (r8 == r9) goto L_0x01f7
            int r8 = f589
            int r8 = r8 + 5
            int r10 = r8 % 128
            f587 = r10
            int r8 = r8 % r13
            java.lang.String r8 = "responseMessage"
            r10 = r23
            r7.put(r8, r10)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            int r8 = f587
            r10 = r8 | 67
            int r10 = r10 << r14
            r8 = r8 ^ 67
            int r10 = r10 - r8
            int r8 = r10 % 128
            f589 = r8
            int r10 = r10 % r13
        L_0x01f7:
            boolean r8 = android.text.TextUtils.isEmpty(r24)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            if (r8 == 0) goto L_0x0200
            r8 = 76
            goto L_0x0202
        L_0x0200:
            r8 = 21
        L_0x0202:
            r10 = 21
            if (r8 == r10) goto L_0x0207
            goto L_0x0238
        L_0x0207:
            int r8 = f589
            r10 = r8 | 63
            int r10 = r10 << r14
            r8 = r8 ^ 63
            int r10 = r10 - r8
            int r8 = r10 % 128
            f587 = r8
            int r10 = r10 % r13
            if (r10 != 0) goto L_0x0218
            r8 = 0
            goto L_0x0219
        L_0x0218:
            r8 = 1
        L_0x0219:
            java.lang.String r8 = "cardAlias"
            r7.put(r8, r2)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            int r2 = f587
            r8 = r2 & -86
            int r10 = ~r2
            r10 = r10 & 85
            r8 = r8 | r10
            r2 = r2 & 85
            int r2 = r2 << r14
            int r2 = -r2
            int r2 = -r2
            int r2 = ~r2
            int r8 = r8 - r2
            int r8 = r8 - r14
            int r2 = r8 % 128
            f589 = r2
            int r8 = r8 % r13
            if (r8 == 0) goto L_0x0237
            r2 = 1
            goto L_0x0238
        L_0x0237:
            r2 = 0
        L_0x0238:
            boolean r2 = android.text.TextUtils.isEmpty(r25)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            if (r2 == 0) goto L_0x0241
            r2 = 74
            goto L_0x0243
        L_0x0241:
            r2 = 60
        L_0x0243:
            if (r2 == r9) goto L_0x0246
            goto L_0x0268
        L_0x0246:
            int r2 = f589
            int r2 = r2 + 106
            int r2 = r2 - r14
            int r8 = r2 % 128
            f587 = r8
            int r2 = r2 % r13
            if (r2 != 0) goto L_0x0254
            r2 = 1
            goto L_0x0255
        L_0x0254:
            r2 = 0
        L_0x0255:
            if (r2 == r14) goto L_0x0263
            java.lang.String r2 = "data"
            r7.put(r2, r3)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            super.hashCode()     // Catch:{ all -> 0x0260 }
            goto L_0x0268
        L_0x0260:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0263:
            java.lang.String r2 = "data"
            r7.put(r2, r3)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
        L_0x0268:
            android.content.Context r2 = r1.f591     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.Utils.getMerchantAppId(r2)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            r7.put(r5, r2)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            java.lang.String r2 = "responseType"
            java.lang.String r3 = r7.toString()     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x0297, Exception -> 0x0350 }
            int r2 = f589
            r3 = r2 ^ 5
            r5 = r2 & 5
            r3 = r3 | r5
            int r3 = r3 << r14
            int r5 = ~r5
            r2 = r2 | 5
            r2 = r2 & r5
            int r2 = -r2
            r5 = r3 | r2
            int r5 = r5 << r14
            r2 = r2 ^ r3
            int r5 = r5 - r2
            int r2 = r5 % 128
            f587 = r2
            int r5 = r5 % r13
            if (r5 != 0) goto L_0x0295
            r2 = 1
            goto L_0x029b
        L_0x0295:
            r2 = 0
            goto L_0x029b
        L_0x0297:
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x029b:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r2.<init>()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r2.put(r4)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r3 = "events"
            r6.put(r3, r2)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            net.one97.paytm.payments.visascp.network.VolleyRequest r2 = new net.one97.paytm.payments.visascp.network.VolleyRequest     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r3 = 1
            java.lang.String r4 = r1.f592     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r5 = r6.toString()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r1.f593     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            net.one97.paytm.payments.visascp.network.model.BaseModel r7 = new net.one97.paytm.payments.visascp.network.model.BaseModel     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r7.<init>()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ all -> 0x0347 }
            r8[r14] = r0     // Catch:{ all -> 0x0347 }
            r8[r12] = r1     // Catch:{ all -> 0x0347 }
            r9 = 59470(0xe84e, float:8.3335E-41)
            r10 = 55
            r11 = 286(0x11e, float:4.01E-43)
            java.lang.Object r9 = net.one97.paytm.payments.visascp.network.If.m692(r9, r10, r11)     // Catch:{ all -> 0x0347 }
            java.lang.Class r9 = (java.lang.Class) r9     // Catch:{ all -> 0x0347 }
            java.lang.Class[] r10 = new java.lang.Class[r13]     // Catch:{ all -> 0x0347 }
            java.lang.Class<net.one97.paytm.payments.visascp.network.HawkEyeEvent> r11 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.class
            r10[r12] = r11     // Catch:{ all -> 0x0347 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r14] = r11     // Catch:{ all -> 0x0347 }
            java.lang.reflect.Constructor r9 = r9.getDeclaredConstructor(r10)     // Catch:{ all -> 0x0347 }
            java.lang.Object r8 = r9.newInstance(r8)     // Catch:{ all -> 0x0347 }
            com.android.volley.Response$Listener r8 = (com.android.volley.Response.Listener) r8     // Catch:{ all -> 0x0347 }
            java.lang.Object[] r9 = new java.lang.Object[r13]     // Catch:{ all -> 0x033e }
            r9[r14] = r0     // Catch:{ all -> 0x033e }
            r9[r12] = r1     // Catch:{ all -> 0x033e }
            r0 = 55
            r10 = 341(0x155, float:4.78E-43)
            java.lang.Object r0 = net.one97.paytm.payments.visascp.network.If.m692(r12, r0, r10)     // Catch:{ all -> 0x033e }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x033e }
            java.lang.Class[] r10 = new java.lang.Class[r13]     // Catch:{ all -> 0x033e }
            java.lang.Class<net.one97.paytm.payments.visascp.network.HawkEyeEvent> r11 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.class
            r10[r12] = r11     // Catch:{ all -> 0x033e }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r14] = r11     // Catch:{ all -> 0x033e }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r10)     // Catch:{ all -> 0x033e }
            java.lang.Object r0 = r0.newInstance(r9)     // Catch:{ all -> 0x033e }
            com.android.volley.Response$ErrorListener r0 = (com.android.volley.Response.ErrorListener) r0     // Catch:{ all -> 0x033e }
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            com.android.volley.DefaultRetryPolicy r0 = new com.android.volley.DefaultRetryPolicy     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r3 = 20000(0x4e20, float:2.8026E-41)
            r4 = 0
            r0.<init>(r3, r13, r4)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r2.setRetryPolicy(r0)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            android.content.Context r0 = r1.f591     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            java.lang.String r3 = r1.f592     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            com.android.volley.RequestQueue r0 = net.one97.paytm.payments.visascp.network.VolleyWrapper.newRequestQueue(r0, r3)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            r0.add(r2)     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            int r0 = f587
            r2 = r0 & 81
            r0 = r0 ^ 81
            r0 = r0 | r2
            r3 = r2 | r0
            int r3 = r3 << r14
            r0 = r0 ^ r2
            int r3 = r3 - r0
            int r0 = r3 % 128
            f589 = r0
            int r3 = r3 % r13
            return
        L_0x033e:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            if (r2 == 0) goto L_0x0346
            throw r2     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x0346:
            throw r0     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x0347:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
            if (r2 == 0) goto L_0x034f
            throw r2     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x034f:
            throw r0     // Catch:{ JSONException -> 0x0355, Exception -> 0x0350 }
        L_0x0350:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return
        L_0x0355:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.HawkEyeEvent.logLocalEvent(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
