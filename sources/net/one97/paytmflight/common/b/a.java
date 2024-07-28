package net.one97.paytmflight.common.b;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import com.business.merchant_payments.common.utility.AppConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Deprecated
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f30009a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f30010b = -1;

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

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }
}
