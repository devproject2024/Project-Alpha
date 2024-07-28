package net.one97.paytm.bankCommon.h;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.utility.f;
import net.one97.paytm.bankCommon.model.AccountStatus;
import net.one97.paytm.bankOpen.d.c;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f16278a = "bioEncypData";

    /* renamed from: b  reason: collision with root package name */
    public static String f16279b = "bioEncypIv";

    /* renamed from: c  reason: collision with root package name */
    public static String f16280c = "isTurnedOn";

    /* renamed from: d  reason: collision with root package name */
    private static String f16281d = "ISA";

    public static boolean a(Context context) {
        return e(context, true).b("is_passcode_set", false, true);
    }

    public static String b(Context context) {
        String b2 = e(context, true).b("ppb_bank_type", "ISA", true);
        f16281d = b2;
        return b2;
    }

    public static void a(Context context, String str) {
        f16281d = str;
        e(context.getApplicationContext(), true).a("ppb_bank_type", str, true);
    }

    public static void a(Context context, boolean z) {
        e(context.getApplicationContext(), true).a("is_passcode_set", z, true);
    }

    public static String c(Context context) {
        return e(context, true).b("is_bank_kyc", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void b(Context context, String str) {
        e(context.getApplicationContext(), true).a("is_bank_kyc", str, true);
    }

    public static boolean d(Context context) {
        return e(context, false).b("is_bank_lead", false, true);
    }

    public static void b(Context context, boolean z) {
        e(context.getApplicationContext(), false).a("is_bank_lead", z, true);
    }

    public static boolean e(Context context) {
        return e(context, false).b("open_bank_invite", false, true);
    }

    public static void c(Context context, boolean z) {
        e(context.getApplicationContext(), false).a("open_bank_invite", z, true);
    }

    public static boolean f(Context context) {
        return h(context) == AccountStatus.ISSUED;
    }

    public static boolean g(Context context) {
        return e(context, false).b("acc_status", 0, true) == AccountStatus.ISSUED.getNumVal();
    }

    public static AccountStatus h(Context context) {
        int b2 = e(context, false).b("acc_status", 0, true);
        if (b2 == AccountStatus.NOT_APPLIED.getNumVal()) {
            return AccountStatus.NOT_APPLIED;
        }
        if (b2 == AccountStatus.PROCESSING.getNumVal()) {
            return AccountStatus.PROCESSING;
        }
        if (b2 == AccountStatus.ISSUED.getNumVal()) {
            return AccountStatus.ISSUED;
        }
        return AccountStatus.DEFAULT;
    }

    public static int i(Context context) {
        int b2 = e(context, false).b("acc_status", 0, true);
        if (b2 == AccountStatus.NOT_APPLIED.getNumVal()) {
            return AccountStatus.NOT_APPLIED.getNumVal();
        }
        if (b2 == AccountStatus.PROCESSING.getNumVal()) {
            return AccountStatus.PROCESSING.getNumVal();
        }
        if (b2 == AccountStatus.ISSUED.getNumVal()) {
            return AccountStatus.ISSUED.getNumVal();
        }
        return AccountStatus.DEFAULT.getNumVal();
    }

    public static void a(Context context, AccountStatus accountStatus) {
        a e2 = e(context.getApplicationContext(), false);
        if (accountStatus == AccountStatus.NOT_APPLIED) {
            e2.a("acc_status", 1, true);
        } else if (accountStatus == AccountStatus.PROCESSING) {
            e2.a("acc_status", 2, true);
        } else if (accountStatus == AccountStatus.ISSUED) {
            e2.a("acc_status", 3, true);
        }
    }

    public static void c(Context context, String str) {
        e(context.getApplicationContext(), false).a("acc_nu", str, false);
    }

    public static void a(Context context, int i2) {
        a e2 = e(context.getApplicationContext(), false);
        if (i2 == AccountStatus.NOT_APPLIED.getNumVal()) {
            e2.a("acc_status", 1, true);
        } else if (i2 == AccountStatus.PROCESSING.getNumVal()) {
            e2.a("acc_status", 2, true);
        } else if (i2 == AccountStatus.ISSUED.getNumVal()) {
            e2.a("acc_status", 3, true);
        }
    }

    public static void j(Context context) {
        e(context.getApplicationContext(), false).a("acc_status", 1, true);
    }

    public static void k(Context context) {
        e(context.getApplicationContext(), false).a("acc_status", 2, true);
    }

    public static void l(Context context) {
        e(context.getApplicationContext(), false).a("acc_status", 3, true);
    }

    public static String m(Context context) {
        return e(context, false).b("nominee_status", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void d(Context context, String str) {
        e(context, false).a("nominee_status", str, true);
    }

    public static String n(Context context) {
        return e(context, false).b("is_aadhaar", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void e(Context context, String str) {
        e(context.getApplicationContext(), false).a("is_aadhaar", str, true);
    }

    public static String o(Context context) {
        return e(context.getApplicationContext(), false).b("is_pan", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void f(Context context, String str) {
        e(context.getApplicationContext(), false).a("is_pan", str, true);
    }

    public static boolean p(Context context) {
        return e(context.getApplicationContext(), false).b("pan_status_landing", true, false);
    }

    public static String q(Context context) {
        return e(context.getApplicationContext(), false).b("is_form60", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void g(Context context, String str) {
        e(context.getApplicationContext(), false).a("is_form60", str, true);
    }

    public static void r(Context context) {
        f.b().cancelBankDebitCardHandler();
        a e2 = e(context.getApplicationContext(), false);
        e2.a("is_bank_user", false, true);
        e2.a("is_bank_lead", false, true);
        e2.a("open_bank_invite", false, true);
        e2.a("is_pan", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        e2.a("is_form60", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        e2.a("nominee_status", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        e2.a("is_aadhaar", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        e2.a("show_bank_pop_up", true, true);
        e2.a("acc_status", AccountStatus.DEFAULT.getNumVal(), true);
        e2.a("show_open_bank_acc_bottom_sheet_count", 1, true);
        e2.a("show_pdc_activate_popup", false, true);
        e2.a(f16278a, "", true);
        e2.a(f16279b, "", true);
        e2.a(f16280c, "", true);
        a e3 = e(context.getApplicationContext(), true);
        e3.a("is_passcode_set", false, true);
        e3.a("is_bank_kyc", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
    }

    public static void d(Context context, boolean z) {
        e(context.getApplicationContext(), false).a("ppb_customer", z, true);
    }

    public static boolean s(Context context) {
        return e(context, false).b("ppb_customer", false, true);
    }

    public static void t(Context context) {
        e(context.getApplicationContext(), false).a("show_pdc_activate_popup", true, true);
    }

    public static boolean u(Context context) {
        return e(context, false).b("show_pdc_activate_popup", false, true);
    }

    public static void v(Context context) {
        a e2 = e(context.getApplicationContext(), false);
        e2.a("show_open_bank_acc_bottom_sheet_count", e2.b("show_open_bank_acc_bottom_sheet_count", 1, true) + 1, true);
    }

    public static int w(Context context) {
        return e(context.getApplicationContext(), false).b("show_open_bank_acc_bottom_sheet_count", 0, true);
    }

    public static void x(Context context) {
        e(context.getApplicationContext(), false).a("show_open_bank_acc_bottom_sheet_count", 1, true);
    }

    public static int y(Context context) {
        return e(context.getApplicationContext(), false).b("show_bank_tab_popup_count", 0, true);
    }

    public static void z(Context context) {
        a e2 = e(context.getApplicationContext(), false);
        e2.a("show_bank_tab_popup_count", e2.b("show_bank_tab_popup_count", 1, true) + 1, true);
    }

    public static void A(Context context) {
        e(context.getApplicationContext(), false).a("show_bank_tab_popup_count", 1, true);
    }

    public static boolean B(Context context) {
        return e(context, false).b("is_upi_user", false, true);
    }

    public static String C(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = e(context, false).b("pref_key_wallet_balance", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void h(Context context, String str) {
        e(context.getApplicationContext(), false).a("slfd_meta_response_s", str, false);
    }

    public static String D(Context context) {
        if (context != null) {
            try {
                String b2 = e(context, false).b("slfd_meta_response_s", "", false);
                if (b2.equals("")) {
                    return null;
                }
                return b2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void a(double d2, Context context) {
        e(context.getApplicationContext(), false).a("CURRENT_LATITUDE", String.valueOf(d2), false);
    }

    public static void b(double d2, Context context) {
        e(context.getApplicationContext(), false).a("CURRENT_LONGITUDE", String.valueOf(d2), false);
    }

    public static double E(Context context) {
        String b2 = e(context.getApplicationContext(), false).b("CURRENT_LATITUDE", "", false);
        if (b2 == "") {
            return 0.0d;
        }
        return Double.valueOf(b2).doubleValue();
    }

    public static double F(Context context) {
        String b2 = e(context.getApplicationContext(), false).b("CURRENT_LONGITUDE", "", false);
        if (b2 == "") {
            return 0.0d;
        }
        return Double.valueOf(b2).doubleValue();
    }

    private static a e(Context context, boolean z) {
        if ("ISA".equalsIgnoreCase(f16281d) || z) {
            return c.a(context.getApplicationContext());
        }
        return c.a(context.getApplicationContext(), f.a.PPB_ICA);
    }

    public static boolean G(Context context) {
        return e(context.getApplicationContext(), false).b("bankDrawerOpened", false, false);
    }

    public static void H(Context context) {
        e(context.getApplicationContext(), false).a("bankDrawerOpened", true, false);
    }

    public static boolean I(Context context) {
        return e(context.getApplicationContext(), false).b("pb_show_cash_withdrawal", false, false);
    }

    public static void J(Context context) {
        e(context.getApplicationContext(), false).a("pb_show_cash_withdrawal", true, false);
    }

    public static void i(Context context, String str) {
        a a2 = c.a(context.getApplicationContext());
        a2.a(f16278a, "", true);
        a2.a(f16279b, "", true);
        a2.a(f16280c, str, true);
    }

    public static String j(Context context, String str) {
        return e(context.getApplicationContext(), true).b(f16280c, str, true);
    }

    public static void a(Context context, String str, String str2, String str3) {
        a a2 = c.a(context.getApplicationContext());
        a2.a(f16278a, str2, true);
        a2.a(f16279b, str, true);
        a2.a(f16280c, str3, true);
    }

    public static String K(Context context) {
        String b2 = c.a(context.getApplicationContext()).b(f16279b, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String L(Context context) {
        String b2 = c.a(context.getApplicationContext()).b(f16278a, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void k(Context context, String str) {
        c.a(context.getApplicationContext()).a(f16280c, str, true);
    }
}
