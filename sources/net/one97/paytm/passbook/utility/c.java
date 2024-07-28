package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f59230a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f59231b = -1;

    public static String a(String str) {
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

    public static String b(String str) {
        DecimalFormat decimalFormat;
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        try {
            DecimalFormat decimalFormat2 = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            if (Long.parseLong(str) % 100 == 0) {
                decimalFormat2.applyPattern(AppConstants.PRICE_PATTERN);
            } else {
                decimalFormat2.applyPattern("##,##,##,##,##0.00");
            }
            return decimalFormat2.format(Double.parseDouble(str) / 100.0d);
        } catch (Exception unused) {
            new DecimalFormat("##,##,##,##,##0.00");
            if (Long.parseLong(str) % 100 == 0) {
                decimalFormat = new DecimalFormat(AppConstants.PRICE_PATTERN);
            } else {
                decimalFormat = new DecimalFormat("##,##,##,##,##0.00");
            }
            return decimalFormat.format(Double.parseDouble(str) / 100.0d);
        }
    }

    private static String a(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    private static String b(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    public static String c(String str) {
        String replaceAll = str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
        try {
            if (TextUtils.isEmpty(replaceAll)) {
                return "";
            }
            if (!replaceAll.contains(AppUtility.CENTER_DOT)) {
                return b(Double.valueOf(Double.parseDouble(replaceAll)));
            }
            return new DecimalFormat("##,##,##,##,##0.00").format(Double.valueOf(Double.parseDouble(replaceAll)));
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public static String d(String str) {
        try {
            Double valueOf = Double.valueOf(Double.parseDouble(str));
            if (b(valueOf).indexOf(AppUtility.CENTER_DOT) > 0) {
                if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                    return a(valueOf);
                }
                return "0" + a(valueOf);
            } else if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                return b(valueOf);
            } else {
                return "0" + b(valueOf);
            }
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    public static int a(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static final boolean a(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
