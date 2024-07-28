package net.one97.paytm.h5paytmsdk.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class b {
    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }
}
