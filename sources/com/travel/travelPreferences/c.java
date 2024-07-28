package com.travel.travelPreferences;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.travel.utils.r;

@Deprecated
public final class c {
    public static String a(Context context) {
        return r.a(context.getApplicationContext()).b(AppConstants.KEY_EMAIL, "", true);
    }

    public static String b(Context context) {
        return r.a(context.getApplicationContext()).b("mobile", "", true);
    }

    public static String c(Context context) {
        return r.a(context.getApplicationContext()).b("sso_token=", "", true);
    }
}
