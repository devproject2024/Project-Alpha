package com.paytmmall.artifact.d;

import android.content.Context;
import android.net.Uri;
import com.business.merchant_payments.common.utility.AppConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15702a = e.class.getSimpleName();

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

    public static int a(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static String b(String str) {
        return str != null ? Uri.parse(str).buildUpon().appendQueryParameter("views_per_page", "10").toString() : str;
    }
}
