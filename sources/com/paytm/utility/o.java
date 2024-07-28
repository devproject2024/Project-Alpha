package com.paytm.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.app.a;
import com.paytm.contactsSdk.database.ContactColumn;
import kotlin.g.b.k;
import kotlin.u;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f43848a = new o();

    static int a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
                return 3;
            default:
                return 0;
        }
    }

    private o() {
    }

    public static NetworkInfo a(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return ((ConnectivityManager) systemService).getActiveNetworkInfo();
        }
        throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    static int b(Context context) {
        if (a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return 0;
        }
        Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
        if (systemService != null) {
            return ((TelephonyManager) systemService).getNetworkType();
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static String c(Context context) {
        int i2;
        k.c(context, "context");
        if (a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (systemService != null) {
                i2 = ((TelephonyManager) systemService).getDataNetworkType();
            } else {
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
        } else {
            Object systemService2 = context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (systemService2 != null) {
                i2 = ((TelephonyManager) systemService2).getNetworkType();
            } else {
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
        }
        switch (i2) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "RTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EGRPD";
            case 15:
                return "HSPAP";
            default:
                return "";
        }
    }
}
