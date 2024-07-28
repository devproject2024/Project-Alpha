package net.one97.paytm.locale;

import android.content.Context;
import com.paytm.b.a.a;
import net.one97.paytm.utils.ag;

public final class d {
    public static void a(Context context, String str) {
        ag.a(context.getApplicationContext()).a("cjrpaytmlocalization_device_lang", str, true);
    }

    public static void b(Context context, String str) {
        a a2 = ag.a(context.getApplicationContext());
        if (str == null) {
            a2.a("cjrpaytmlocalization_is_skipped", true);
        } else {
            a2.a("cjrpaytmlocalization_is_skipped", str, true);
        }
    }

    public static String a(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("hi") || language.equalsIgnoreCase("ta") || language.equalsIgnoreCase("te") || language.equalsIgnoreCase("kn") || language.equalsIgnoreCase("pa") || language.equalsIgnoreCase("mr") || language.equalsIgnoreCase("gu") || language.equalsIgnoreCase("bn") || language.equalsIgnoreCase("ml") || language.equalsIgnoreCase("or")) {
            return language;
        }
        return "en";
    }
}
