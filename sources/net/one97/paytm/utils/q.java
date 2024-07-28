package net.one97.paytm.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class q {
    public static String a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat2.format(parse);
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
            return "";
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    public static String a(int i2) {
        String str;
        int i3 = i2 >= 60 ? i2 / 60 : 0;
        int i4 = i2 % 60;
        if (i3 > 0) {
            str = i3 + "Hrs ";
        } else {
            str = "";
        }
        if (i4 <= 0) {
            return str;
        }
        return str + i4 + "Mins";
    }
}
