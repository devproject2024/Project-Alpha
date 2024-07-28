package net.one97.paytm.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;

public final class s {
    public static String a(Context context) {
        String a2 = a(b.ac(context), b.ad(context));
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.trim().length() <= 0) {
            return (TextUtils.isEmpty(str2) || str2.trim().length() <= 0) ? "" : str2;
        }
        if (TextUtils.isEmpty(str2) || str2.trim().length() <= 0) {
            return str;
        }
        return str + " " + str2;
    }
}
