package net.one97.paytm.hotels2.utils;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import java.text.DecimalFormat;
import net.one97.paytm.hotel4.utils.d;

public class CJRHotelsUtilsLib {
    public static String a() {
        return d.a(c.b().a().getApplicationContext()).b("UTM_STRING_HOTEL", "", false);
    }

    public static String a(String str) {
        try {
            Double valueOf = Double.valueOf(Double.parseDouble(str));
            if (a(valueOf).indexOf(AppUtility.CENTER_DOT) > 0) {
                if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                    return b(valueOf);
                }
                return "0" + b(valueOf);
            } else if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                return a(valueOf);
            } else {
                return "0" + a(valueOf);
            }
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    private static String a(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    private static String b(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    public static void a(Context context) {
        try {
            Class.forName("net.one97.paytm.dynamic.module.hotels.HotelJarvisHelper").getMethod("initHotelLib", new Class[]{Context.class}).invoke("null", new Object[]{context});
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
