package net.one97.paytm.o2o.amusementpark.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.f.a;

public final class d {
    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x002d
            java.lang.String r1 = r3.trim()     // Catch:{ Exception -> 0x002d }
            int r1 = r1.length()     // Catch:{ Exception -> 0x002d }
            if (r1 <= 0) goto L_0x002d
            java.util.Locale r1 = new java.util.Locale     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x002d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002d }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x002d }
            r2.<init>(r4, r1)     // Catch:{ Exception -> 0x002d }
            r4 = 0
            java.util.Date r4 = r2.parse(r3)     // Catch:{ ParseException -> 0x0021 }
        L_0x0021:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x002d }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x002d }
            r3.<init>(r5, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.String r3 = r3.format(r4)     // Catch:{ Exception -> 0x002d }
            return r3
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.utils.d.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            String[] split = str.split(AppConstants.COLON);
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 0 || parseInt == 24) {
                return "12:" + split[1] + " " + context.getString(R.string.in_am);
            } else if (parseInt == 12) {
                return split[0] + AppConstants.COLON + split[1] + " " + context.getString(R.string.in_pm);
            } else if (parseInt < 12) {
                return split[0] + AppConstants.COLON + split[1] + " " + context.getString(R.string.in_am);
            } else {
                return String.valueOf(parseInt - 12) + AppConstants.COLON + split[1] + " " + context.getString(R.string.in_pm);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context, String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        String[] strArr = {"th", H5Param.SHOW_TITLEBAR, "nd", "rd", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", H5Param.SHOW_TITLEBAR, "nd", "rd", "th", "th", "th", "th", "th", "th", "th", H5Param.SHOW_TITLEBAR};
        try {
            String a2 = a(str2, "yyyy-MM-dd", "MMM");
            String[] split = str2.split("-");
            int i2 = 1;
            if (split.length > 1) {
                i2 = Integer.parseInt(split[2]);
            } else if (split.length == 1) {
                i2 = Integer.parseInt(split[0]);
            }
            String str3 = strArr[i2];
            return String.valueOf(i2) + str3 + " " + a2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context) {
        String b2 = a.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2.equals("") || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String a(String str) {
        return str != null ? str.replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1") : str;
    }
}
