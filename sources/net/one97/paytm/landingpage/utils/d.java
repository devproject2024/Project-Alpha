package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.utility.q;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f53011a;

    public d(Context context) {
        this.f53011a = context;
    }

    public static int a() {
        try {
            return net.one97.paytm.common.b.d.a().x();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    public static void a(Bundle bundle, Activity activity) {
        Intent b2 = net.one97.paytm.common.b.d.a().b(activity);
        b2.putExtras(bundle);
        activity.startActivity(b2);
    }

    public static float a(Context context) {
        float f2;
        if (context == null) {
            return 0.0f;
        }
        try {
            f2 = Float.parseFloat(net.one97.paytm.common.b.d.a().a("travelImageDensity"));
        } catch (Exception unused) {
            f2 = 0.75f;
        }
        return f2 * context.getResources().getDisplayMetrics().density;
    }

    public static String a(String str) {
        if (str == null || str.length() <= 4) {
            return str;
        }
        return "XX " + str.substring(str.length() - 4);
    }
}
