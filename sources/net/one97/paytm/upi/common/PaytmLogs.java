package net.one97.paytm.upi.common;

import android.text.TextUtils;
import net.one97.paytm.upi.i;

public class PaytmLogs {
    private static int MAX_LOG_LENGTH = 1000;

    public static void i(String str, String str2) {
        if (i.a().f66987h) {
            longLogI(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        i.a();
    }

    public static void e(String str, String str2) {
        if (i.a().f66987h) {
            longLogE(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        i.a();
    }

    public static void d(String str, String str2) {
        if (i.a().f66987h && !TextUtils.isEmpty(str2)) {
            longLogD(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        i.a();
    }

    public static void v(String str, String str2) {
        i.a();
    }

    public static void v(String str, String str2, Throwable th) {
        i.a();
    }

    public static void w(String str, String str2) {
        i.a();
    }

    public static void w(String str, String str2, Throwable th) {
        i.a();
    }

    private static void longLogD(String str, String str2) {
        if (str2 != null) {
            for (int i2 = 0; i2 < str2.length(); i2 += MAX_LOG_LENGTH) {
                if (MAX_LOG_LENGTH + i2 < str2.length()) {
                    str2.substring(i2, MAX_LOG_LENGTH + i2);
                } else {
                    str2.substring(i2);
                }
            }
        }
    }

    private static void longLogI(String str, String str2) {
        int i2;
        if (str2 != null && str2.length() > (i2 = MAX_LOG_LENGTH)) {
            str2.substring(0, i2);
            longLogD(str, str2.substring(MAX_LOG_LENGTH));
        }
    }

    private static void longLogE(String str, String str2) {
        int i2;
        if (str2 != null && str2.length() > (i2 = MAX_LOG_LENGTH)) {
            str2.substring(0, i2);
            longLogD(str, str2.substring(MAX_LOG_LENGTH));
        }
    }
}
