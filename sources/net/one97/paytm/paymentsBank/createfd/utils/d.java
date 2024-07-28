package net.one97.paytm.paymentsBank.createfd.utils;

import com.business.merchant_payments.common.utility.AppConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class d {
    public static String a(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format(Double.parseDouble(str));
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }
}
