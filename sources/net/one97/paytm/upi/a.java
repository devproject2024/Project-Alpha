package net.one97.paytm.upi;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.crashlytics.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;

public final class a {
    static String a(String str) {
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    static /* synthetic */ void a(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            ag.a(context.getApplicationContext()).a(UpiConstants.EXTRA_UPI_REFER_DEEPLINK, str.replace("deeplink=", ""), true);
        }
    }

    static /* synthetic */ void b(String str) {
        HashMap hashMap = new HashMap();
        try {
            String decode = URLDecoder.decode(str, AppConstants.UTF_8);
            if (!decode.contains("?")) {
                decode = "?".concat(String.valueOf(decode));
            }
            Uri parse = Uri.parse(decode);
            for (String next : parse.getQueryParameterNames()) {
                String queryParameter = parse.getQueryParameter(next);
                if (!next.equalsIgnoreCase("utm_source") && !next.equalsIgnoreCase("utm_medium") && !next.equalsIgnoreCase("utm_campaign")) {
                    next = next.startsWith("utm") ? next.replace("utm_", "fai_") : "fai_".concat(String.valueOf(next));
                }
                hashMap.put(next, queryParameter);
            }
            hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "freshAppInstalls");
            net.one97.paytm.j.a.a(hashMap, "freshAppInstalls");
        } catch (UnsupportedEncodingException e2) {
            c.a().a("referrerUrl1:" + str + e2.getMessage());
            c.a().a("referrerUrl2:" + str + e2.toString());
        } catch (Exception e3) {
            c.a().a("referrerUrl1:" + str + e3.getMessage());
            c.a().a("referrerUrl2:" + str + e3.toString());
        }
    }
}
