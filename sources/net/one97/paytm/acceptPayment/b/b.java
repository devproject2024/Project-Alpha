package net.one97.paytm.acceptPayment.b;

import net.one97.paytm.acceptPayment.configs.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f52045a;

    private b() {
    }

    public static b a() {
        if (f52045a == null) {
            f52045a = new b();
        }
        return f52045a;
    }

    public static String b() {
        return a("merchantOnBoardingUrlV2");
    }

    public static String c() {
        return a("ap_x_app_client");
    }

    public static String d() {
        return a("accept_payment_merchant_context");
    }

    public static String e() {
        return a("ump_base_url");
    }

    public static String f() {
        return a("limits_and_charges_flow_url");
    }

    public static String c(String str) {
        return a(str);
    }

    public static String g() {
        return a("forceUpdateAppUrl");
    }

    public static boolean h() {
        return b("is_force_upgrade_enabled");
    }

    public static String i() {
        return a("urlAPStatementDownloadV2");
    }

    public static String a(String str) {
        return a.f52046a.f52049d.a(str);
    }

    public static boolean b(String str) {
        return a.f52046a.f52049d.a(str, false);
    }
}
