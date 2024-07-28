package net.one97.paytm.moneytransfer.utils;

import android.content.Context;
import com.paytm.utility.b;
import net.one97.paytm.moneytransfer.d.d;

public final class f {
    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            d.c().a(context, str, str2, str4, str5, "", str3, "wallet");
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            d.c().a(context, str, str2, str4, str5, str6, str3, "wallet");
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            d.c().a(str, "wallet", context);
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }
}
