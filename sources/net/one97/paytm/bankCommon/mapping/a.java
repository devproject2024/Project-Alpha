package net.one97.paytm.bankCommon.mapping;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class a extends b {
    public static boolean Z(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@");
    }

    public static String aa(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        while (i2 < str.length() / 4) {
            int i3 = i2 + 1;
            sb.insert((i3 * 4) + i2, ' ');
            i2 = i3;
        }
        return sb.toString();
    }

    public static String ab(String str) {
        return str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public static String ac(String str) {
        try {
            return c(Double.valueOf(Double.parseDouble(str)));
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    public static String c(Double d2) {
        if (e(d2).indexOf(AppUtility.CENTER_DOT) > 0) {
            if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
                return d(d2);
            }
            return "0" + d(d2);
        } else if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
            return e(d2);
        } else {
            return "0" + e(d2);
        }
    }

    private static String d(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    private static String e(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    public static String ad(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }
}
