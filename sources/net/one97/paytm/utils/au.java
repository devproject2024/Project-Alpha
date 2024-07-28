package net.one97.paytm.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import java.util.List;
import net.one97.paytm.p2mNewDesign.models.QrData;

public class au {

    public static class a {
        @com.google.gson.a.c(a = "moduleName")

        /* renamed from: a  reason: collision with root package name */
        public String f69670a;
        @com.google.gson.a.c(a = "moduleSize")

        /* renamed from: b  reason: collision with root package name */
        public String f69671b;
        @com.google.gson.a.c(a = "statusCode")

        /* renamed from: c  reason: collision with root package name */
        public String f69672c;
        @com.google.gson.a.c(a = "errorCode")

        /* renamed from: d  reason: collision with root package name */
        public String f69673d;
        @com.google.gson.a.c(a = "downloadTime")

        /* renamed from: e  reason: collision with root package name */
        public String f69674e;
        @com.google.gson.a.c(a = "exception")

        /* renamed from: f  reason: collision with root package name */
        public String f69675f;
        @com.google.gson.a.c(a = "availableInternalMemory")

        /* renamed from: g  reason: collision with root package name */
        public float f69676g;
    }

    public static class b {
        @com.google.gson.a.c(a = "deepLinkUrl")

        /* renamed from: a  reason: collision with root package name */
        public String f69677a;
        @com.google.gson.a.c(a = "gtmKey")

        /* renamed from: b  reason: collision with root package name */
        public String f69678b;
        @com.google.gson.a.c(a = "urlType")

        /* renamed from: c  reason: collision with root package name */
        public String f69679c;
        @com.google.gson.a.c(a = "isComingFromNotification")

        /* renamed from: d  reason: collision with root package name */
        public boolean f69680d;
        @com.google.gson.a.c(a = "resId")

        /* renamed from: e  reason: collision with root package name */
        public String f69681e;
        @com.google.gson.a.c(a = "value")

        /* renamed from: f  reason: collision with root package name */
        public String f69682f;
        @com.google.gson.a.c(a = "exceptionType")

        /* renamed from: g  reason: collision with root package name */
        public String f69683g;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(21:1|2|(1:4)|5|(2:7|(2:9|(2:11|(2:13|(2:15|(1:17)(1:18)))(2:19|20))(2:21|22)))|23|(1:25)(1:26)|(1:28)|29|(1:31)|32|(1:34)|35|(2:(1:38)(1:39)|40)|41|(2:43|(1:45)(1:46))|47|48|49|50|51) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x017e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void a(T r9, java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "context"
            net.one97.paytm.utils.au$e r9 = (net.one97.paytm.utils.au.e) r9     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r1 = com.paytm.utility.a.g(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r2 = com.paytm.utility.a.h(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = "9.1.3"
            r9.f69687b = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = "720656"
            r9.f69688c = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.f69690e = r10     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r3 = com.paytm.erroranalytics.b.b.c(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.k = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r3 = com.paytm.erroranalytics.b.b.a()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.j = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = com.paytm.erroranalytics.b.b.b(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.f69693h = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm:ss"
            r3.<init>(r4)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.util.Date r4 = new java.util.Date     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r4.<init>()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = r3.format(r4)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.f69689d = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = a(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.f69692g = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            float r3 = com.paytm.utility.m.c(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.J = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            float r3 = com.paytm.utility.m.b(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.I = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            boolean r3 = com.paytm.utility.m.a((android.content.Context) r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.N = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r3 = com.paytm.utility.m.e(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.O = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r3 = com.paytm.utility.m.b()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.V = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            boolean r3 = com.paytm.utility.m.f(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.U = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.util.List r3 = com.paytm.utility.m.g(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r4 = r3.size()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r5 = 3
            r6 = 0
            r7 = 1
            if (r4 != r5) goto L_0x00a0
            java.lang.Object r4 = r3.get(r6)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Object r5 = r3.get(r7)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r8 = 2
            java.lang.Object r3 = r3.get(r8)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.P = r4     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.R = r5     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.Q = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x00a0:
            com.paytm.utility.m r3 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            android.content.Context r3 = r11.getApplicationContext()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            kotlin.g.b.k.c(r3, r0)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            boolean r4 = com.paytm.utility.m.f43842b     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r4 != 0) goto L_0x0101
            com.paytm.utility.m.f43842b = r7     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            kotlin.g.b.k.c(r3, r0)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            boolean r0 = com.paytm.utility.m.f43842b     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 != 0) goto L_0x0101
            boolean r0 = r3 instanceof android.app.Activity     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 != 0) goto L_0x00f7
            com.paytm.utility.m.f43843c = r3     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 == 0) goto L_0x00ef
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r4 = "android.permission.ACCESS_NETWORK_STATE"
            int r4 = androidx.core.content.b.a((android.content.Context) r3, (java.lang.String) r4)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r4 != 0) goto L_0x0101
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r5 = 24
            if (r4 < r5) goto L_0x00da
            android.net.ConnectivityManager$NetworkCallback r4 = com.paytm.utility.m.f43844d     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r0.registerDefaultNetworkCallback(r4)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            goto L_0x0101
        L_0x00da:
            android.net.NetworkRequest$Builder r4 = new android.net.NetworkRequest$Builder     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r4.<init>()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r5 = 12
            android.net.NetworkRequest$Builder r4 = r4.addCapability(r5)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            android.net.NetworkRequest r4 = r4.build()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            android.net.ConnectivityManager$NetworkCallback r5 = com.paytm.utility.m.f43844d     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r0.registerNetworkCallback(r4, r5)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            goto L_0x0101
        L_0x00ef:
            kotlin.u r9 = new kotlin.u     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r10 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            r9.<init>(r10)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            throw r9     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x00f7:
            java.security.InvalidParameterException r9 = new java.security.InvalidParameterException     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r10 = "Context is Activity."
            r9.<init>(r10)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            throw r9     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x0101:
            java.lang.String r0 = com.paytm.utility.m.f43841a     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = r0.length()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 != 0) goto L_0x010d
            r0 = 1
            goto L_0x010e
        L_0x010d:
            r0 = 0
        L_0x010e:
            if (r0 == 0) goto L_0x0116
            java.lang.String r0 = com.paytm.utility.m.h(r3)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m.f43841a = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x0116:
            java.lang.String r0 = com.paytm.utility.m.f43841a     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.T = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = r0.availableProcessors()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.S = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = com.paytm.utility.m.i(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r3 = -1
            if (r0 == r3) goto L_0x012f
            r9.L = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x012f:
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r0 = com.paytm.utility.m.a()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.K = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = com.paytm.utility.m.d(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 == r3) goto L_0x0141
            r9.M = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x0141:
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = com.paytm.utility.m.d()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.X = r0     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            int r0 = com.paytm.utility.m.e()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r0 == r3) goto L_0x0157
            if (r0 != r7) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r7 = 0
        L_0x0155:
            r9.W = r7     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x0157:
            com.paytm.utility.m r0 = com.paytm.utility.m.f43845e     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            java.lang.String r11 = com.paytm.utility.m.j(r11)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.aa = r11     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            boolean r11 = r1.isEmpty()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r11 != 0) goto L_0x017b
            boolean r11 = r2.isEmpty()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            if (r11 == 0) goto L_0x016c
            goto L_0x017b
        L_0x016c:
            net.one97.paytm.utils.au$d r11 = new net.one97.paytm.utils.au$d     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            float r0 = java.lang.Float.parseFloat(r1)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            float r1 = java.lang.Float.parseFloat(r2)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r11.<init>(r0, r1, r6)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r9.f69691f = r11     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
        L_0x017b:
            com.paytm.erroranalytics.e.a()     // Catch:{ IllegalStateException -> 0x017e }
        L_0x017e:
            com.paytm.erroranalytics.c.a.b$a r11 = new com.paytm.erroranalytics.c.a.b$a     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r11.<init>(r10)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r11.f42752d = r9     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.erroranalytics.c.a.b r9 = r11.a()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            com.paytm.erroranalytics.a r10 = com.paytm.erroranalytics.e.b()     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            r10.a(r9)     // Catch:{ a -> 0x019a, Exception -> 0x0191 }
            return
        L_0x0191:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.paytm.utility.q.b(r9)
            return
        L_0x019a:
            java.lang.Class<net.one97.paytm.utils.au> r9 = net.one97.paytm.utils.au.class
            r9.getName()
            java.lang.String r9 = "Paytm error sdk not initialized"
            com.paytm.utility.q.d(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.au.a(java.lang.Object, java.lang.String, android.content.Context):void");
    }

    private static String a(Context context) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                SubscriptionManager from = SubscriptionManager.from(context);
                if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") != 0 || from == null || (activeSubscriptionInfoList = from.getActiveSubscriptionInfoList()) == null) {
                    return "";
                }
                for (SubscriptionInfo next : activeSubscriptionInfoList) {
                    if (next.getSimSlotIndex() == 0) {
                        return next.getCarrierName().toString();
                    }
                }
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") == 0 && telephonyManager != null) {
                return telephonyManager.getSimOperatorName();
            }
            return "";
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public enum f {
        NONE("None"),
        USER_FACING("true"),
        SILENT("false");
        
        private final String stringValue;

        private f(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }

    public enum c {
        ApiError("apiError"),
        LocalError("localError"),
        ApiLog("apiLog"),
        DeepLinkLog("deepLinkLog"),
        DFMLog("dfmLog"),
        ImgLog("imgLog");
        
        public final String stringValue;

        private c(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }

    public static class e {
        @com.google.gson.a.c(a = "categoryId")
        @com.google.gson.a.a
        public String A;
        @com.google.gson.a.c(a = "PID")
        @com.google.gson.a.a
        public String B;
        @com.google.gson.a.c(a = "metricConnectionTime")
        @com.google.gson.a.a
        double C;
        @com.google.gson.a.c(a = "metricDomainLookupTime")
        @com.google.gson.a.a
        double D;
        @com.google.gson.a.c(a = "metricRequestTime")
        @com.google.gson.a.a
        double E;
        @com.google.gson.a.c(a = "metricResponseTime")
        @com.google.gson.a.a
        double F;
        @com.google.gson.a.c(a = "metricSecureConnectionTime")
        @com.google.gson.a.a
        double G;
        @com.google.gson.a.c(a = "metricTotalTime")
        @com.google.gson.a.a
        double H;
        public String I;
        public String J;
        public String K;
        public int L;
        public int M;
        public boolean N;
        public String O;
        public Double P;
        public Double Q;
        public Double R;
        public int S;
        String T;
        public boolean U;
        public int V;
        public boolean W;
        public int X;
        public long Y;
        public long Z;
        @com.google.gson.a.c(a = "qrData")

        /* renamed from: a  reason: collision with root package name */
        public QrData f69686a;
        public String aa;
        @com.google.gson.a.c(a = "customMessage")
        @com.google.gson.a.a
        private String ab;
        @com.google.gson.a.c(a = "appVersion")
        @com.google.gson.a.a

        /* renamed from: b  reason: collision with root package name */
        public String f69687b;
        @com.google.gson.a.c(a = "appVersionCode")
        @com.google.gson.a.a

        /* renamed from: c  reason: collision with root package name */
        public String f69688c;
        @com.google.gson.a.c(a = "timestamp")
        @com.google.gson.a.a

        /* renamed from: d  reason: collision with root package name */
        public String f69689d;
        @com.google.gson.a.c(a = "eventType")
        @com.google.gson.a.a

        /* renamed from: e  reason: collision with root package name */
        public String f69690e;
        @com.google.gson.a.c(a = "location")
        @com.google.gson.a.a

        /* renamed from: f  reason: collision with root package name */
        d f69691f;
        @com.google.gson.a.c(a = "networkCarrier")
        @com.google.gson.a.a

        /* renamed from: g  reason: collision with root package name */
        String f69692g;
        @com.google.gson.a.c(a = "networkType")
        @com.google.gson.a.a

        /* renamed from: h  reason: collision with root package name */
        public String f69693h;
        @com.google.gson.a.c(a = "networkStrength")
        @com.google.gson.a.a

        /* renamed from: i  reason: collision with root package name */
        double f69694i;
        @com.google.gson.a.c(a = "storageFreePercentage")
        @com.google.gson.a.a
        public int j;
        @com.google.gson.a.c(a = "batteryPercentage")
        @com.google.gson.a.a
        public int k;
        @com.google.gson.a.c(a = "verticalName")
        @com.google.gson.a.a
        public String l;
        @com.google.gson.a.c(a = "screenName")
        @com.google.gson.a.a
        public String m;
        @com.google.gson.a.c(a = "flowName")
        @com.google.gson.a.a
        public String n;
        @com.google.gson.a.c(a = "uri")
        @com.google.gson.a.a
        public String o;
        @com.google.gson.a.c(a = "responseCode")
        @com.google.gson.a.a
        public int p;
        @com.google.gson.a.c(a = "responseTime")
        @com.google.gson.a.a
        public long q;
        @com.google.gson.a.c(a = "responseSize")
        @com.google.gson.a.a
        public int r;
        @com.google.gson.a.c(a = "responseType")
        @com.google.gson.a.a
        public String s;
        @com.google.gson.a.c(a = "userFacing")
        @com.google.gson.a.a
        public String t;
        @com.google.gson.a.c(a = "errorMsg")
        @com.google.gson.a.a
        public String u;
        @com.google.gson.a.c(a = "mid")
        @com.google.gson.a.a
        public String v;
        @com.google.gson.a.c(a = "transactionId")
        @com.google.gson.a.a
        public String w;
        @com.google.gson.a.c(a = "dfmData")
        @com.google.gson.a.a
        public a x;
        @com.google.gson.a.c(a = "deepLinkLogData")
        @com.google.gson.a.a
        public b y;
        @com.google.gson.a.c(a = "x-app-rid")
        @com.google.gson.a.a
        String z;

        public final void a(String str) {
            this.f69690e = str;
        }

        public final void b(String str) {
            this.l = str;
        }

        public final void c(String str) {
            this.n = str;
        }

        public final void d(String str) {
            this.o = str;
        }

        public final void e(String str) {
            this.t = str;
        }

        public final void f(String str) {
            this.v = str;
        }

        public final void g(String str) {
            this.ab = str.substring(0, Math.min(str.length(), 1023));
        }
    }

    static class d {
        @com.google.gson.a.c(a = "lat")

        /* renamed from: a  reason: collision with root package name */
        private float f69684a;
        @com.google.gson.a.c(a = "lon")

        /* renamed from: b  reason: collision with root package name */
        private float f69685b;

        /* synthetic */ d(float f2, float f3, byte b2) {
            this(f2, f3);
        }

        private d(float f2, float f3) {
            this.f69684a = f2;
            this.f69685b = f3;
        }
    }
}
