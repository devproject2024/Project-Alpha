package net.one97.paytm.upgradeKyc.utils;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytmmall.clpartifact.utils.Utils;
import net.one97.paytm.common.utility.i;
import net.one97.paytm.upgradeKyc.f.c;
import net.one97.paytm.upgradeKyc.f.f;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.kycV3.c.g;

public final class j {
    public static void a() {
        e.a aVar = e.f66028b;
        a a2 = i.a(e.a.b().a());
        a2.a("min_kyc_pop_n", a2.b("min_kyc_pop_n", 1, false) + 1, false);
    }

    public static void b() {
        e.a aVar = e.f66028b;
        a a2 = i.a(e.a.b().a());
        a2.a("full_kyc_pop_n", a2.b("full_kyc_pop_n", 1, false) + 1, false);
    }

    public static void a(Context context) {
        a a2 = i.a(context.getApplicationContext());
        a2.a("min_kyc_pop_n", -1, false);
        a2.a("full_kyc_pop_n", -1, false);
        a2.a(Utils.KEY_KYC_NAME, "", true);
        a2.a("aadhaar_verified", false, false);
        a2.a("kycPrimeUserStatus", -1, false);
        a2.a("isMinKyc", false, false);
        a2.a("kycType", "", true);
        a2.a("isExpired", 0, false);
        a2.a("keyKycExpiryDate", "", false);
        a2.a("isMinor", "", false);
        a2.a("expiryType", "", false);
        a2.a("is_min_kyc_eligible", false);
        a2.a("isPanSubmitted", false);
        a2.a("isPanVerified", false);
        a2.a("isForm60", false);
        a2.a("cstPriorityCustomerTimestamp", false);
        c.a().b();
        f.a().b();
        g.a aVar = g.f66236a;
        g.f66237d = null;
        a.C1325a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
        a.C1325a.a();
    }

    public static void a(Context context, String str) {
        i.a(context.getApplicationContext()).a("aadhaar_number", str, false);
    }

    public static void b(Context context, String str) {
        i.a(context.getApplicationContext()).a("pan_number", str, true);
    }

    public static int b(Context context) {
        if (context != null) {
            return i.a(context.getApplicationContext()).b("kycPrimeUserStatus", -1, false);
        }
        return -1;
    }

    public static void a(Context context, int i2) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("kycPrimeUserStatus", i2, false);
        }
    }

    public static void c(Context context, String str) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("kycType", str, true);
        }
    }

    public static String c(Context context) {
        return i.a(context.getApplicationContext()).b("kycType", "", true);
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("isMinKyc", z, false);
        }
    }

    public static int d(Context context) {
        return i.a(context.getApplicationContext()).b("isExpired", 0, false);
    }

    public static void b(Context context, int i2) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("isExpired", i2, false);
        }
    }

    public static void a(String str) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("isPanSubmitted", str != null && str.equalsIgnoreCase("AdditionalDoc"), false);
    }

    public static void a(boolean z) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("isPanVerified", z, false);
    }

    public static void b(boolean z) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("isForm60", z, false);
    }

    public static boolean e(Context context) {
        if (context != null) {
            return i.a(context.getApplicationContext()).b("isPanSubmitted", false, false);
        }
        return false;
    }

    public static boolean f(Context context) {
        if (context != null) {
            return i.a(context.getApplicationContext()).b("isForm60", false, false);
        }
        return false;
    }

    public static String g(Context context) {
        if (context != null) {
            return i.a(context.getApplicationContext()).b("keyKycExpiryDate", "", false);
        }
        return "";
    }

    public static void d(Context context, String str) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("keyKycExpiryDate", str, false);
        }
    }

    public static String h(Context context) {
        return i.a(context.getApplicationContext()).b("isMinor", "", false);
    }

    public static void e(Context context, String str) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("isMinor", str, false);
        }
    }

    public static boolean i(Context context) {
        return i.a(context.getApplicationContext()).b("is_min_kyc_eligible", false, false);
    }

    public static void b(Context context, boolean z) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("is_min_kyc_eligible", z, false);
        }
    }

    public static boolean j(Context context) {
        return i.a(context.getApplicationContext()).b("isMinKyc", false, false);
    }

    public static boolean k(Context context) {
        if (b(context) == 1 && d(context) == 0) {
            return true;
        }
        if (!j(context) || d(context) != 0) {
            return false;
        }
        return true;
    }

    public static void f(Context context, String str) {
        i.a(context.getApplicationContext()).a(Utils.KEY_KYC_NAME, str, true);
    }

    public static String l(Context context) {
        return i.a(context.getApplicationContext()).b(Utils.KEY_KYC_NAME, "", true);
    }

    public static boolean m(Context context) {
        if (context != null) {
            return i.a(context.getApplicationContext()).b("aadhaar_verified", false, false);
        }
        return false;
    }

    public static void c(Context context, boolean z) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("aadhaar_verified", z, false);
        }
    }

    public static void a(int i2) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("isKYCDone", i2, true);
    }

    public static void b(String str) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("aadhaarSubmittedAs", str, false);
    }

    public static int c() {
        e.a aVar = e.f66028b;
        return i.a(e.a.b().a()).b("isKYCDone", -1, true);
    }

    public static boolean c(Context context, int i2) {
        int b2 = i.a(context.getApplicationContext()).b("kyc_expired_pop_n", -1, false);
        if (b2 == -1) {
            d();
            return true;
        } else if (b2 < i2) {
            return false;
        } else {
            o(context);
            return true;
        }
    }

    public static void d() {
        e.a aVar = e.f66028b;
        com.paytm.b.a.a a2 = i.a(e.a.b().a());
        a2.a("kyc_expired_pop_n", a2.b("kyc_expired_pop_n", 1, false) + 1, false);
    }

    private static void o(Context context) {
        i.a(context.getApplicationContext()).a("kyc_expired_pop_n", 0, false);
    }

    public static void g(Context context, String str) {
        if (context != null) {
            i.a(context.getApplicationContext()).a("expiryType", str, false);
        }
    }

    public static String n(Context context) {
        return i.a(context.getApplicationContext()).b("expiryType", "", false);
    }

    public static void a(Long l) {
        e.a aVar = e.f66028b;
        i.a(e.a.b().a()).a("cstPriorityCustomerTimestamp", l.longValue(), false);
    }

    public static long e() {
        e.a aVar = e.f66028b;
        return i.a(e.a.b().a()).b("cstPriorityCustomerTimestamp", -1, false);
    }
}
