package com.paytm.utility;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.regex.Pattern;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class p {
    public static boolean a(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 6 && a("^[1-9][0-9]{5}$", str);
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 15 && a("^[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[A-Z0-9]{1}[zZ]{1}[A-Za-z0-9]{1}$", str);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(AppConstants.EMAIL_REG_EX).matcher(str).find();
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).matches();
    }
}
