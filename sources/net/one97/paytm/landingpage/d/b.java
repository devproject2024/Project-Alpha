package net.one97.paytm.landingpage.d;

import android.content.Context;
import android.os.Build;
import androidx.core.app.a;
import net.one97.paytm.common.b.d;

public final class b {
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context a2 = d.b().a();
        if (a.a(a2, "android.permission.ACCESS_FINE_LOCATION") == 0 && a.a(a2, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }
}
