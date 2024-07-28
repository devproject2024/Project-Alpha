package com.alipay.imobile.network.quake.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.imobile.network.quake.c;

public final class a {
    public static boolean a(Context context) {
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo == null) {
                String str = c.f14737a;
                com.alipay.iap.android.common.b.c.e();
                return false;
            }
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (com.alipay.iap.android.common.b.c.a()) {
                    String str2 = c.f14737a;
                    com.alipay.iap.android.common.b.c.a("Detailed=%s, Extra=%s, Reason=%s, State=%s, Subtype=%s, stN=%s, Type=%s, tN=%s, isA=%s, isC=%s, isConing=%s, isF=%s, isR=%s, des=%s, toS=%s", networkInfo.getDetailedState().toString(), networkInfo.getExtraInfo(), networkInfo.getReason(), networkInfo.getState(), Integer.valueOf(networkInfo.getSubtype()), networkInfo.getSubtypeName(), Integer.valueOf(networkInfo.getType()), networkInfo.getTypeName(), Boolean.valueOf(networkInfo.isAvailable()), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isFailover()), Boolean.valueOf(networkInfo.isRoaming()), Integer.valueOf(networkInfo.describeContents()), networkInfo.toString());
                    com.alipay.iap.android.common.b.c.e();
                }
                if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            String str3 = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            return false;
        }
    }
}
