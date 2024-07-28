package com.paytm.analytics.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.alipay.mobile.nebula.util.H5Utils;
import kotlin.g.b.k;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f40946a = new b();

    private b() {
    }

    public static String a(Context context) {
        String str;
        k.c(context, "context");
        k.c(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    k.a((Object) activeNetwork, "connectivityManager.activeNetwork ?: return false");
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    if (networkCapabilities != null) {
                        k.a((Object) networkCapabilities, "connectivityManager.getN…ities(nw) ?: return false");
                        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2)) {
                            z = true;
                        }
                    }
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    k.a((Object) activeNetworkInfo, "connectivityManager.acti…tworkInfo ?: return false");
                    z = activeNetworkInfo.isConnected();
                }
            }
            if (!z) {
                return null;
            }
            try {
                Object systemService2 = context.getSystemService("connectivity");
                if (systemService2 != null) {
                    NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) systemService2).getActiveNetworkInfo();
                    if (activeNetworkInfo2 == null) {
                        return null;
                    }
                    k.a((Object) activeNetworkInfo2, "cm.activeNetworkInfo?: return null");
                    int type = activeNetworkInfo2.getType();
                    if (type == 0) {
                        switch (activeNetworkInfo2.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                str = H5Utils.NETWORK_TYPE_2G;
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                str = H5Utils.NETWORK_TYPE_3G;
                                break;
                            case 13:
                                str = H5Utils.NETWORK_TYPE_4G;
                                break;
                            default:
                                return null;
                        }
                    } else if (type != 1) {
                        return null;
                    } else {
                        str = H5Utils.NETWORK_TYPE_WIFI;
                    }
                    return str;
                }
                throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
            } catch (Exception e2) {
                com.paytm.a.a.b.f40832a.a((Throwable) e2);
                return null;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }
}
