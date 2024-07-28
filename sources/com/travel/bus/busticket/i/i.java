package com.travel.bus.busticket.i;

import android.text.TextUtils;
import com.paytm.utility.q;
import java.text.DecimalFormat;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f22442a = "CJRBusDecimalUtils";

    public static String a(double d2) {
        try {
            return new DecimalFormat("##,##,##,##,##,##,###").format(d2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return String.valueOf(d2);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public static String b(double d2) {
        try {
            return new DecimalFormat("##,##,##,##,##,##,###.#").format(d2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return String.valueOf(d2);
        }
    }
}
