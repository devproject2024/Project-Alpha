package net.one97.paytm.quickpay.utilities;

import android.text.TextUtils;

public final class g {
    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String[] split = str.toLowerCase().split("\\s+");
            for (int i2 = 0; i2 < split.length; i2++) {
                String str3 = split[i2];
                if (i2 > 0 && str3.length() > 0) {
                    sb.append(" ");
                }
                if (str3.length() > 0) {
                    str2 = str3.substring(0, 1).toUpperCase() + str3.substring(1);
                } else {
                    str2 = str3.toUpperCase();
                }
                sb.append(str2);
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
