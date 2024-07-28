package net.one97.paytm.h5.b;

import android.app.Activity;
import android.content.Intent;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.h5paytmsdk.c.k;
import net.one97.paytm.oauth.utils.o;

public final class b implements k {
    public final Intent a(Activity activity) {
        if (activity != null) {
            return new Intent(activity, AJRAuthActivity.class);
        }
        return null;
    }

    public final k.a d(Activity activity) {
        if (activity != null) {
            return new k.a(u.b(activity), u.b());
        }
        return null;
    }

    public final boolean e(Activity activity) {
        if (activity == null) {
            return false;
        }
        o oVar = o.f56791a;
        o.b(com.paytm.utility.b.ab(activity));
        net.one97.paytm.auth.b.b.a(activity, false);
        return true;
    }

    public final boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        net.one97.paytm.auth.b.b.a(activity, false);
        return true;
    }

    public final boolean c(Activity activity) {
        if (activity == null) {
            return false;
        }
        net.one97.paytm.auth.b.b.a(activity, false);
        return true;
    }
}
