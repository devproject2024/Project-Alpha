package net.one97.paytm.oauth;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f52464a;

    public static a a() {
        if (f52464a == null) {
            f52464a = new a();
        }
        return f52464a;
    }

    public static String a(String str) {
        String stringFromGTM = OauthModule.b().getStringFromGTM(str);
        if (stringFromGTM != null && !stringFromGTM.trim().isEmpty()) {
            return stringFromGTM;
        }
        net.one97.paytm.oauth.b.a aVar = net.one97.paytm.oauth.b.a.f52572a;
        return net.one97.paytm.oauth.b.a.a(str, OauthModule.a().f52578e);
    }

    public static int a(String str, int i2) {
        int i3;
        try {
            i3 = OauthModule.b().getIntFromGTM(str, i2);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i3 = 0;
        }
        if (i3 != 0) {
            return i3;
        }
        net.one97.paytm.oauth.b.a aVar = net.one97.paytm.oauth.b.a.f52572a;
        return net.one97.paytm.oauth.b.a.a(str, i2);
    }

    public static boolean a(String str, boolean z) {
        return OauthModule.b().getBooleanFromGTM(str, z);
    }

    public static int b() {
        int a2 = a("authOtpTimer", 20);
        if (a2 == 0) {
            return 20;
        }
        return a2;
    }

    public static int c() {
        int a2 = a("authOtpCallTimer", 30);
        if (a2 == 0) {
            return 30;
        }
        return a2;
    }

    public static boolean d() {
        return a("enableOauthCryptography", true);
    }

    public static boolean e() {
        return a("oauthEnableSavedCardFlow", true);
    }

    public static boolean f() {
        return a("oauthEnableAppLock", true);
    }

    public static boolean g() {
        return a("showMobilePrefillHint", true);
    }

    public static boolean h() {
        return a("emailOtpLoginEnable", false);
    }

    public static boolean i() {
        return a("emailOtpLogoutEnable", false);
    }

    public static String j() {
        return a("oauthDebVmnNumbers");
    }

    public static int k() {
        return a("oauthDebVerifyCross", 10);
    }

    public static String l() {
        return a("oauthLocationPermissionVersion");
    }

    public static String m() {
        return a("oauthLocationRollOutSet");
    }

    public static String n() {
        return a("oauthDebAutoReadOtpVersion");
    }

    public static int o() {
        return a("oauthDebAutoReadTimer", 30);
    }

    public static boolean p() {
        return a("oauthCheckboxPassword", true);
    }

    public static boolean q() {
        return a("oauthCheckSmsSendReceipt", true);
    }

    public static boolean r() {
        return a("oauthSendSmsSequential", false);
    }

    public static int s() {
        return a("oauthSendSmsSequentialDelay", 0);
    }

    public static int t() {
        return a("oauthTotalSmsToSend", 2);
    }
}
