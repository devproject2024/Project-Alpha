package com.paytm.utility;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.b.a.a;
import com.paytm.network.a;

public class d {
    public static String a(Context context) {
        return a.q(context);
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = a.a(context.getApplicationContext(), a.c.UTILITY).b("cart_id", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static boolean c(Context context) {
        return !TextUtils.isEmpty(a.q(context));
    }
}
