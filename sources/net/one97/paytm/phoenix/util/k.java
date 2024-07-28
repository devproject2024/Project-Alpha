package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.u;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f59648a = new k();

    public enum a {
        NETWORK_WIFI,
        NETWORK_MOBILE_FAST,
        NETWORK_MOBILE_MIDDLE,
        NETWORK_MOBILE_SLOW,
        NETWORK_NO_CONNECTION,
        NETWORK_TYPE_UNKNOWN
    }

    private k() {
    }

    public static final synchronized a a(Context context) {
        a a2;
        synchronized (k.class) {
            kotlin.g.b.k.c(context, "context");
            try {
                Object systemService = context.getSystemService("connectivity");
                if (systemService != null) {
                    a2 = a(((ConnectivityManager) systemService).getActiveNetworkInfo());
                } else {
                    throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
            } catch (Throwable th) {
                j jVar = j.f59646a;
                j.a("PhoenixNetworkUtil", "exception detail", th);
                return a.NETWORK_TYPE_UNKNOWN;
            }
        }
        return a2;
    }

    private static a a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            try {
                return a.NETWORK_NO_CONNECTION;
            } catch (Exception e2) {
                j jVar = j.f59646a;
                j.a("PhoenixNetworkUtil", "", e2);
                return a.NETWORK_TYPE_UNKNOWN;
            }
        } else if (!networkInfo.isConnected()) {
            return a.NETWORK_NO_CONNECTION;
        } else {
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            j jVar2 = j.f59646a;
            j.b("PhoenixNetworkUtil", "type: " + type + " subType: " + subtype);
            if (type == 1 || type == 9) {
                return a.NETWORK_WIFI;
            }
            if (type != 0) {
                return a.NETWORK_TYPE_UNKNOWN;
            }
            switch (subtype) {
                case 0:
                    return a.NETWORK_TYPE_UNKNOWN;
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return a.NETWORK_MOBILE_SLOW;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                    return a.NETWORK_MOBILE_MIDDLE;
                case 13:
                    return a.NETWORK_MOBILE_FAST;
                default:
                    return a.NETWORK_MOBILE_MIDDLE;
            }
        }
    }
}
