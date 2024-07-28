package net.one97.paytm.wallet.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

public final class l {
    public static String a(Context context) {
        int i2 = context.getResources().getDisplayMetrics().densityDpi;
        if (i2 != 240) {
            if (i2 == 320) {
                return "XHDPI";
            }
            if (i2 == 480 || i2 == 640) {
                return "XXHDPI";
            }
        }
        return "HDPI";
    }

    public static int a(int i2) {
        try {
            return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.insert(5, " ");
        return sb.toString();
    }
}
