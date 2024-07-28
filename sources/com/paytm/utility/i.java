package com.paytm.utility;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class i {
    public static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String b2 = b(str);
            if (b2.contains(AppUtility.CENTER_DOT)) {
                b2 = b2.substring(0, b2.indexOf(46));
            }
            if (b2.contains("T")) {
                return b2.replaceAll("T", " ");
            }
            return b2;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat2.format(parse);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }
}
