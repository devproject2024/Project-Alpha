package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.g;
import com.google.android.gms.location.f;

public class LocationManager implements e.b, e.c {
    private static LocationManager instance;
    private static e mGoogleApiClient;

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onConnectionSuspended(int i2) {
    }

    public static LocationManager getManger() {
        if (instance == null) {
            instance = new LocationManager();
        }
        return instance;
    }

    public void buildGoogleApiClient(Context context) {
        if (isGooglePlayServicesAvailable(context)) {
            try {
                e a2 = new e.a(context).a((e.b) this).a((e.c) this).a((a<? extends a.d.C0127d>) f.f11372a).a();
                mGoogleApiClient = a2;
                a2.d();
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public boolean isGooglePlayServicesAvailable(Context context) {
        try {
            return g.a(context) == 0;
        } catch (Exception unused) {
        }
    }

    public Location getLocation(Context context) {
        try {
            if (mGoogleApiClient != null) {
                if (Build.VERSION.SDK_INT < 23 || b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    return f.f11373b.a(mGoogleApiClient);
                }
                return null;
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
        return null;
    }

    public void onConnected(Bundle bundle) {
        LogUtility.d("", "");
    }
}
