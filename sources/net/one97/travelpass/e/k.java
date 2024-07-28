package net.one97.travelpass.e;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.DecimalFormat;
import kotlin.m.p;
import net.one97.travelpass.e.i;

public final class k {
    public static String a(Context context, String str) {
        if (str == null || !URLUtil.isValidUrl(str)) {
            return str;
        }
        if (b(context) != null) {
            str = v.a(str, AppConstants.AND_SIGN, "user_email", "=", b(context));
        }
        if (c(context) == null) {
            return str;
        }
        return v.a(str, AppConstants.AND_SIGN, "user_mobile", "=", c(context));
    }

    private static String b(Context context) {
        i.a aVar = i.f30333a;
        if (context == null) {
            kotlin.g.b.k.a();
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        return i.a.a(applicationContext).b(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, "", true);
    }

    private static String c(Context context) {
        i.a aVar = i.f30333a;
        if (context == null) {
            kotlin.g.b.k.a();
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        return i.a.a(applicationContext).b("mobile", "", true);
    }

    public static boolean a(Context context) {
        i.a aVar = i.f30333a;
        if (context == null) {
            kotlin.g.b.k.a();
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
        if (i.a.a(applicationContext).b("sso_token=", "", true).length() > 0) {
            return true;
        }
        return false;
    }

    public static String a(double d2) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        String format = decimalFormat.format(d2);
        kotlin.g.b.k.a((Object) format, "formattedVal");
        return p.a(format, AppConstants.COMMA, "", false);
    }
}
