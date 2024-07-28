package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.appsflyer.AFLogger;
import com.paytm.contactsSdk.database.ContactColumn;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class s {

    public static final class d {

        /* renamed from: ι  reason: contains not printable characters */
        public static final s f295 = new s();
    }

    s() {
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m196(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static final class a {

        /* renamed from: ı  reason: contains not printable characters */
        public final String f292;

        /* renamed from: ɩ  reason: contains not printable characters */
        public final String f293;

        /* renamed from: ι  reason: contains not printable characters */
        public final String f294;

        a(String str, String str2, String str3) {
            this.f292 = str;
            this.f293 = str2;
            this.f294 = str3;
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static a m195(Context context) {
        String str;
        String str2 = SDKConstants.UNKNOWN;
        String str3 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int i2 = 0;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i2]);
                        if (!m196(networkInfo)) {
                            i2++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else if (!m196(connectivityManager.getNetworkInfo(1))) {
                    if (!m196(connectivityManager.getNetworkInfo(0))) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (m196(activeNetworkInfo)) {
                            if (1 != activeNetworkInfo.getType()) {
                                if (activeNetworkInfo.getType() == 0) {
                                }
                            }
                        }
                    }
                    str2 = "MOBILE";
                }
                str2 = H5Utils.NETWORK_TYPE_WIFI;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            str = telephonyManager.getSimOperatorName();
            try {
                str3 = telephonyManager.getNetworkOperatorName();
                if ((str3 == null || str3.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str3 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                return new a(str2, str3, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            return new a(str2, str3, str);
        }
        return new a(str2, str3, str);
    }
}
