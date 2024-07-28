package net.one97.paytm.phoenix.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5Utils;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class ad extends net.one97.paytm.phoenix.core.a {
    public ad() {
        super("paytmOsVersion", "paytmGetAppInfo", "paytmDeviceManufacturer", "paytmNetworkType", H5Plugin.CommonEvents.GET_NETWORK_TYPE, "paytmDeviceName", "paytmDeviceLocale", "paytmDeviceImei", "paytmAppVersion", "paytmH5Version", "paytmIsPlaystoreInstall");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r14, net.one97.paytm.phoenix.api.b r15) {
        /*
            r13 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r15, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.b) r15)
            b(r14, r15)
            net.one97.paytm.phoenix.core.c r15 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r15 = r15.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider> r0 = net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixAppInfoProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r15 = r15.a(r0)
            net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider r15 = (net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider) r15
            android.app.Activity r0 = r14.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x004c
            android.app.Activity r0 = r14.getActivity()
            if (r0 != 0) goto L_0x0037
            kotlin.g.b.k.a()
        L_0x0037:
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r0 == 0) goto L_0x004c
            android.app.Activity r0 = r14.getActivity()
            if (r0 == 0) goto L_0x0044
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
            goto L_0x004d
        L_0x0044:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r14.<init>(r15)
            throw r14
        L_0x004c:
            r0 = r1
        L_0x004d:
            r2 = 0
            if (r0 != 0) goto L_0x0051
            return r2
        L_0x0051:
            java.lang.String r3 = r14.getAction$phoenix_debug()
            r4 = 1
            if (r3 != 0) goto L_0x005a
            goto L_0x025c
        L_0x005a:
            int r5 = r3.hashCode()
            r6 = 6
            java.lang.String r7 = "1.0.0-9.1.0-CA-83248-RC2"
            java.lang.String r8 = "android.permission.ACCESS_NETWORK_STATE"
            java.lang.String r9 = "Permission denied"
            java.lang.String r10 = ""
            java.lang.String r11 = "it.applicationContext"
            r12 = 4
            switch(r5) {
                case -1659987207: goto L_0x0247;
                case -947307865: goto L_0x0229;
                case -831844280: goto L_0x021b;
                case -405839855: goto L_0x01d3;
                case -74041558: goto L_0x01c6;
                case 136081978: goto L_0x0175;
                case 674346047: goto L_0x0111;
                case 674483714: goto L_0x0102;
                case 838737459: goto L_0x00f3;
                case 1377607544: goto L_0x00b9;
                case 1714085202: goto L_0x006f;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x025c
        L_0x006f:
            java.lang.String r15 = "getNetworkType"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            android.content.Context r0 = (android.content.Context) r0
            int r15 = androidx.core.content.b.a((android.content.Context) r0, (java.lang.String) r8)
            if (r15 != 0) goto L_0x00b2
            net.one97.paytm.phoenix.d.ad$a r15 = a(r0)
            java.lang.String r0 = r15.f59456a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "network_type:"
            java.lang.String r0 = r2.concat(r0)
            java.lang.String r2 = "err_msg"
            r13.a((java.lang.String) r2, (java.lang.Object) r0)
            boolean r0 = r15.f59457b
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r2 = "networkAvailable"
            r13.a((java.lang.String) r2, (java.lang.Object) r0)
            java.lang.String r0 = r15.f59458c
            java.lang.String r2 = "networkInfo"
            r13.a((java.lang.String) r2, (java.lang.Object) r0)
            java.lang.String r15 = r15.f59459d
            java.lang.String r0 = "networkType"
            r13.a((java.lang.String) r0, (java.lang.Object) r15)
            r13.a((net.one97.paytm.phoenix.api.H5Event) r14, (java.lang.Object) r1, (boolean) r4)
            goto L_0x025c
        L_0x00b2:
            net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            r13.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r9)
            goto L_0x025c
        L_0x00b9:
            java.lang.String r15 = "paytmAppVersion"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            android.content.pm.PackageManager r15 = r0.getPackageManager()
            android.content.Context r0 = r0.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r0 = r0.getPackageName()
            android.content.pm.PackageInfo r15 = r15.getPackageInfo(r0, r4)
            long r7 = androidx.core.content.a.a.a(r15)
            int r0 = (int) r7
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "versionCode"
            r13.a((java.lang.String) r3, (java.lang.Object) r0)
            java.lang.String r15 = r15.versionName
            java.lang.String r0 = "info.versionName"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            java.lang.String r0 = "versionName"
            r13.a((java.lang.String) r0, (java.lang.Object) r15)
            net.one97.paytm.phoenix.core.a.a(r13, r14, r1, r2, r6)
            goto L_0x025c
        L_0x00f3:
            java.lang.String r15 = "paytmOsVersion"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            java.lang.String r15 = android.os.Build.VERSION.RELEASE
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
            goto L_0x025c
        L_0x0102:
            java.lang.String r15 = "paytmDeviceName"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            java.lang.String r15 = android.os.Build.MODEL
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
            goto L_0x025c
        L_0x0111:
            java.lang.String r15 = "paytmDeviceImei"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            r15 = r0
            android.content.Context r15 = (android.content.Context) r15
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r15 = androidx.core.content.b.a((android.content.Context) r15, (java.lang.String) r1)
            if (r15 != 0) goto L_0x016e
            java.lang.String r15 = "phone"
            java.lang.Object r15 = r0.getSystemService(r15)     // Catch:{ Exception -> 0x0148 }
            android.telephony.TelephonyManager r15 = (android.telephony.TelephonyManager) r15     // Catch:{ Exception -> 0x0148 }
            if (r15 != 0) goto L_0x0131
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0148 }
        L_0x0131:
            java.lang.String r1 = r15.getDeviceId()     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x013d
            java.lang.String r15 = r15.getDeviceId()     // Catch:{ Exception -> 0x0148 }
        L_0x013b:
            r10 = r15
            goto L_0x0169
        L_0x013d:
            android.content.ContentResolver r15 = r0.getContentResolver()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r0 = "android_id"
            java.lang.String r15 = android.provider.Settings.Secure.getString(r15, r0)     // Catch:{ Exception -> 0x0148 }
            goto L_0x013b
        L_0x0148:
            r15 = move-exception
            net.one97.paytm.phoenix.util.j r0 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r0 = "PhoenixDeviceInfoPlugin"
            java.lang.String r1 = "This paytmDeviceImei bridge is been deprecated due to Android 10 restriction"
            net.one97.paytm.phoenix.util.j.b(r0, r1)
            net.one97.paytm.phoenix.util.j r1 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "exception: "
            r1.<init>(r3)
            java.lang.String r15 = r15.getMessage()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            net.one97.paytm.phoenix.util.j.b(r0, r15)
        L_0x0169:
            net.one97.paytm.phoenix.core.a.a(r13, r14, r10, r2, r12)
            goto L_0x025c
        L_0x016e:
            net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            r13.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r9)
            goto L_0x025c
        L_0x0175:
            java.lang.String r5 = "paytmGetAppInfo"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x025c
            if (r15 != 0) goto L_0x0188
            net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            java.lang.String r0 = "Unable to fetch app info"
            r13.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r0)
            goto L_0x025c
        L_0x0188:
            android.content.Context r3 = r0.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r11)
            java.lang.String r3 = r15.getVersionName(r3)
            android.content.Context r5 = r0.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            int r5 = r15.getVersionCode(r5)
            android.content.Context r0 = r0.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            org.json.JSONObject r15 = r15.getDefaultParams(r0)
            java.lang.String r0 = "app_info_pt"
            r13.a((java.lang.String) r0, (java.lang.Object) r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r5)
            java.lang.String r0 = "appVersionCode"
            r13.a((java.lang.String) r0, (java.lang.Object) r15)
            java.lang.String r15 = "appVersionName"
            r13.a((java.lang.String) r15, (java.lang.Object) r3)
            java.lang.String r15 = "h5Version"
            r13.a((java.lang.String) r15, (java.lang.Object) r7)
            net.one97.paytm.phoenix.core.a.a(r13, r14, r1, r2, r6)
            goto L_0x025c
        L_0x01c6:
            java.lang.String r15 = "paytmH5Version"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            net.one97.paytm.phoenix.core.a.a(r13, r14, r7, r2, r12)
            goto L_0x025c
        L_0x01d3:
            java.lang.String r15 = "paytmDeviceLocale"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            int r15 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r15 < r0) goto L_0x0200
            android.content.res.Resources r15 = android.content.res.Resources.getSystem()
            if (r15 == 0) goto L_0x0216
            android.content.res.Configuration r15 = r15.getConfiguration()
            if (r15 == 0) goto L_0x0216
            android.os.LocaleList r15 = r15.getLocales()
            if (r15 == 0) goto L_0x0216
            java.util.Locale r15 = r15.get(r2)
            if (r15 == 0) goto L_0x0216
            java.lang.String r15 = r15.getLanguage()
            if (r15 != 0) goto L_0x0217
            goto L_0x0216
        L_0x0200:
            android.content.res.Resources r15 = android.content.res.Resources.getSystem()
            if (r15 == 0) goto L_0x0216
            android.content.res.Configuration r15 = r15.getConfiguration()
            if (r15 == 0) goto L_0x0216
            java.util.Locale r15 = r15.locale
            if (r15 == 0) goto L_0x0216
            java.lang.String r15 = r15.getLanguage()
            if (r15 != 0) goto L_0x0217
        L_0x0216:
            r15 = r10
        L_0x0217:
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
            goto L_0x025c
        L_0x021b:
            java.lang.String r15 = "paytmDeviceManufacturer"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            java.lang.String r15 = android.os.Build.MANUFACTURER
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
            goto L_0x025c
        L_0x0229:
            java.lang.String r15 = "paytmNetworkType"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            android.content.Context r0 = (android.content.Context) r0
            int r15 = androidx.core.content.b.a((android.content.Context) r0, (java.lang.String) r8)
            if (r15 != 0) goto L_0x0241
            java.lang.String r15 = b(r0)
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
            goto L_0x025c
        L_0x0241:
            net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            r13.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r9)
            goto L_0x025c
        L_0x0247:
            java.lang.String r15 = "paytmIsPlaystoreInstall"
            boolean r15 = r3.equals(r15)
            if (r15 == 0) goto L_0x025c
            android.content.Context r0 = (android.content.Context) r0
            boolean r15 = c(r0)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            net.one97.paytm.phoenix.core.a.a(r13, r14, r15, r2, r12)
        L_0x025c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ad.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    private static a a(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return new a(SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL, false, H5Utils.NETWORK_TYPE_NOTREACHABLE, SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL);
                }
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? new a(H5Utils.NETWORK_TYPE_UNKNOWN, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_UNKNOWN, SDKConstants.UNKNOWN) : new a(H5Utils.NETWORK_TYPE_WIFI, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_WIFI, "wifi");
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return new a(H5Utils.NETWORK_TYPE_2G, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_2G, H5Utils.NETWORK_TYPE_2G);
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return new a(H5Utils.NETWORK_TYPE_3G, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_3G, H5Utils.NETWORK_TYPE_3G);
                    case 13:
                        return new a(H5Utils.NETWORK_TYPE_4G, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_4G, H5Utils.NETWORK_TYPE_4G);
                    default:
                        return new a(H5Utils.NETWORK_TYPE_UNKNOWN, activeNetworkInfo.isConnected(), H5Utils.NETWORK_TYPE_UNKNOWN, SDKConstants.UNKNOWN);
                }
            } else {
                throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
        } catch (Exception unused) {
            return new a(SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL, false, H5Utils.NETWORK_TYPE_NOTREACHABLE, SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL);
        }
    }

    private static String b(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return H5Utils.NETWORK_TYPE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return H5Utils.NETWORK_TYPE_3G;
                            case 13:
                                return H5Utils.NETWORK_TYPE_4G;
                        }
                    } else if (type != 1) {
                        return "Unknown";
                    } else {
                        return H5Utils.NETWORK_TYPE_WIFI;
                    }
                }
                return "Unknown";
            }
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f59456a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f59457b;

        /* renamed from: c  reason: collision with root package name */
        final String f59458c;

        /* renamed from: d  reason: collision with root package name */
        final String f59459d;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (k.a((Object) this.f59456a, (Object) aVar.f59456a)) {
                        if (!(this.f59457b == aVar.f59457b) || !k.a((Object) this.f59458c, (Object) aVar.f59458c) || !k.a((Object) this.f59459d, (Object) aVar.f59459d)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f59456a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.f59457b;
            if (z) {
                z = true;
            }
            int i3 = (hashCode + (z ? 1 : 0)) * 31;
            String str2 = this.f59458c;
            int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f59459d;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "Network(msg=" + this.f59456a + ", networkAvailable=" + this.f59457b + ", networkInfo=" + this.f59458c + ", networkType=" + this.f59459d + ")";
        }

        public a(String str, boolean z, String str2, String str3) {
            k.c(str, "msg");
            k.c(str2, "networkInfo");
            k.c(str3, "networkType");
            this.f59456a = str;
            this.f59457b = z;
            this.f59458c = str2;
            this.f59459d = str3;
        }
    }

    private static boolean c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return p.a("com.android.vending", installerPackageName, true);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
