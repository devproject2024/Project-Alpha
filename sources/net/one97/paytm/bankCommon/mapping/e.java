package net.one97.paytm.bankCommon.mapping;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.d.c;

public final class e extends b {
    public static String v() {
        return "?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE";
    }

    public static String Z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static String aa(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length() - 4; i2++) {
            sb.append("X");
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    public static void a(Context context, double d2) {
        try {
            String d3 = Double.toString(d2);
            if (context != null) {
                c.a(context.getApplicationContext()).a("pref_key_wallet_balance", d3, true);
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean ab(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() >= 6 && str.trim().length() <= 18 && str.trim().replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]", "").length() == 0;
    }

    public static Dialog f(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.pb_lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
