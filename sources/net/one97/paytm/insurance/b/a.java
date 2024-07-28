package net.one97.paytm.insurance.b;

import android.content.Context;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.paytm.utility.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13988a;

    public static a a() {
        if (f13988a == null) {
            f13988a = new a();
        }
        return f13988a;
    }

    public static String a(String str) {
        return c.a().getStringFromGTM(str);
    }

    public static boolean b(String str) {
        return c.a().getBooleanFromGTM(str, false);
    }

    public static String a(String str, String str2) {
        return c.a().getStringFromGTM(str, str2);
    }

    public static String c(String str) {
        return c.a().getStringFromGTMContainer4(str);
    }

    public static String a(Context context) {
        return a("androidDCATInsuranceVersion", b.Q(context));
    }

    public static String b(Context context) {
        return a("androidAutopayInsuranceVersion", b.Q(context));
    }

    public static String b() {
        return a("insuranceCategory");
    }

    public static String c(Context context) {
        if (f.a.b.a(a(context), context)) {
            return a("insuranceBuyPayDigitalCatelog");
        }
        return a("insuranceBuyPayCatelog");
    }

    public static long c() {
        return Long.parseLong(a("app_rating_thank_you_expire_time", Constants.RESULT_STATUS_SUCCESS));
    }

    public static long d() {
        return Long.parseLong(a("app_rating_5_star_time_gap", "0"));
    }

    public static long e() {
        return Long.parseLong(a("app_rating_less_than_5_star_time_gap", "0"));
    }

    public static long f() {
        return Long.parseLong(a("app_rating_not_now_time_gap", "0"));
    }
}
