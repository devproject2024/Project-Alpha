package net.one97.paytm.acceptPayment.webviewutils.b;

import android.net.Uri;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class d {
    public static String a(String str, Map<String, String> map) {
        int lastIndexOf = str.lastIndexOf("redirectUrl=");
        if (lastIndexOf < 0) {
            return str;
        }
        int i2 = lastIndexOf + 12;
        Uri.Builder buildUpon = Uri.parse(str.substring(i2)).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String builder = buildUpon.toString();
        String substring = str.substring(0, i2);
        try {
            String encode = URLEncoder.encode(builder, AppConstants.UTF_8);
            return substring + encode;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return substring;
        }
    }
}
