package net.one97.paytm.utils.a;

import android.content.Context;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.a;
import net.one97.paytm.utils.ag;

public final class b {
    public static boolean a(Context context) {
        return ag.a(context.getApplicationContext()).b("is_passcode_set", false, true);
    }

    public static boolean b(Context context) {
        return ag.a(context.getApplicationContext()).b("acc_status", 0, true) == a.ISSUED.getNumVal();
    }

    public static void a(Context context, int i2) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        if (i2 == a.NOT_APPLIED.getNumVal()) {
            a2.a("acc_status", 1, true);
        } else if (i2 == a.PROCESSING.getNumVal()) {
            a2.a("acc_status", 2, true);
        } else if (i2 == a.ISSUED.getNumVal()) {
            a2.a("acc_status", 3, true);
        }
    }

    public static void c(Context context) {
        ag.a(context.getApplicationContext()).a("is_bank_lead", true, true);
    }

    public static void a(Context context, boolean z) {
        ag.a(context.getApplicationContext()).a("open_bank_invite", z, true);
    }

    public static a d(Context context) {
        int b2 = ag.a(context.getApplicationContext()).b("acc_status", 0, true);
        if (b2 == a.NOT_APPLIED.getNumVal()) {
            return a.NOT_APPLIED;
        }
        if (b2 == a.PROCESSING.getNumVal()) {
            return a.PROCESSING;
        }
        return b2 == a.ISSUED.getNumVal() ? a.ISSUED : a.DEFAULT;
    }

    public static boolean e(Context context) {
        return ag.a(context.getApplicationContext()).b("ppb_customer", false, true);
    }

    public static boolean f(Context context) {
        return d(context) == a.ISSUED;
    }

    public static void g(Context context) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        a2.a("is_bank_user", false, true);
        a2.a("is_passcode_set", false, true);
        a2.a("is_bank_lead", false, true);
        a2.a("open_bank_invite", false, true);
        a2.a("is_bank_kyc", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_pan", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_form60", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("nominee_status", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_aadhaar", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("show_bank_pop_up", true, true);
        a2.a("acc_status", a.DEFAULT.getNumVal(), true);
        a2.a("show_open_bank_acc_bottom_sheet_count", 1, true);
        a2.a("show_pdc_activate_popup", false, true);
        a2.a("bank_item_first_click", false, true);
    }

    public static void b(Context context, boolean z) {
        ag.a(context.getApplicationContext()).a("is_passcode_set", z, true);
    }

    public static void h(Context context) {
        ag.a(context.getApplicationContext()).a("acc_status", 1, true);
    }

    public static void i(Context context) {
        ag.a(context.getApplicationContext()).a("acc_status", 2, true);
    }

    public static void j(Context context) {
        ag.a(context.getApplicationContext()).a("acc_status", 3, true);
    }

    public static void b(Context context, int i2) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        if (i2 == a.NOT_APPLIED.getNumVal()) {
            a2.a("acc_status", 1, true);
        } else if (i2 == a.PROCESSING.getNumVal()) {
            a2.a("acc_status", 2, true);
        } else if (i2 == a.ISSUED.getNumVal()) {
            a2.a("acc_status", 3, true);
        }
    }
}
