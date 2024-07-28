package net.one97.paytm.InAppPushNotification;

import android.net.Uri;
import com.paytm.utility.v;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {
    static Uri a(String str, String str2, String str3, String str4) {
        return Uri.parse(v.a("paytmmp://", str, "?", "utm_medium", "=", SDKConstants.PUSH_FROM_PUSH, "$", "utm_source", "=", str3, "$", "utm_term", "=", str4, "$", "utm_campaign", "=", str2));
    }
}
