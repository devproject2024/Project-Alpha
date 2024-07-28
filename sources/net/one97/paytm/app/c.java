package net.one97.paytm.app;

import android.app.Activity;
import java.util.HashSet;
import net.one97.paytm.c.a;
import net.one97.paytm.c.b;

public final class c {
    public static void a(Activity activity) {
        int t;
        net.one97.paytm.j.c.a();
        HashSet<String> ao = net.one97.paytm.j.c.ao();
        if (activity != null && ao.contains(activity.getClass().getName()) && (t = CJRJarvisApplication.t()) > 0) {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("in_app_latest_available_v_code", 0) > t) {
                net.one97.paytm.j.c.a();
                if (net.one97.paytm.j.c.a("in_app_is_soft_update", true)) {
                    new a(activity).a();
                } else {
                    new b(activity).a();
                }
            }
        }
    }
}
