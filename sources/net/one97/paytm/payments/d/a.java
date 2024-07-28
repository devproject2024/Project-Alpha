package net.one97.paytm.payments.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.one97.paytm.deeplink.h;

public final class a {
    public static String a() {
        return "paytmmp://";
    }

    public static void a(Activity activity, String str) {
        h.a aVar = h.f50349a;
        h.a.a(activity, str, (Bundle) null);
    }

    public static void a(Context context, String str) {
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        return a() + "min_kyc?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2;
    }
}
