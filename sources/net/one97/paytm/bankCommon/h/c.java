package net.one97.paytm.bankCommon.h;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.utility.f;

public final class c {
    public static void a(Context context) {
        e(context.getApplicationContext()).a("acc_status", 1, true);
    }

    public static void b(Context context) {
        e(context.getApplicationContext()).a("acc_status", 2, true);
    }

    public static void c(Context context) {
        e(context.getApplicationContext()).a("acc_status", 3, true);
    }

    private static a e(Context context) {
        return net.one97.paytm.bankOpen.d.c.a(context.getApplicationContext(), f.a.PPB_ICA);
    }

    public static void a(String str, Context context) {
        e(context.getApplicationContext()).a("ca_id", str, false);
    }

    public static String d(Context context) {
        return e(context.getApplicationContext()).b("ca_id", "", false);
    }
}
