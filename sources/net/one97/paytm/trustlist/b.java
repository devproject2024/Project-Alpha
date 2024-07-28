package net.one97.paytm.trustlist;

import android.text.TextUtils;

public final class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String trim = str.trim();
        if (!trim.endsWith(".0") && !trim.endsWith(".00")) {
            return trim;
        }
        String[] split = trim.split("\\.");
        return split.length > 0 ? split[0] : trim;
    }
}
