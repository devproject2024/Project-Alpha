package c.a.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.android.chat.utils.ChatConfigUtil;
import com.paytm.utility.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public final class r {
    public static String a(String str, List<m> list, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        int i2 = 0;
        if (stringBuffer.indexOf("?", 0) < 0 && list.size() > 0) {
            stringBuffer.append("?");
        }
        for (m next : list) {
            String str2 = next.f5602a;
            String str3 = next.f5603b;
            if (z) {
                try {
                    str2 = URLEncoder.encode(str2, AppConstants.UTF_8);
                    str3 = URLEncoder.encode(str3, AppConstants.UTF_8);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            stringBuffer.append(str2);
            stringBuffer.append("=");
            stringBuffer.append(str3);
            i2++;
            if (i2 != list.size()) {
                stringBuffer.append(AppConstants.AND_SIGN);
            }
        }
        return a(stringBuffer.toString());
    }

    public static String a(String str) {
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            Map<String, String> b2 = c.b((Context) com.paytm.android.chat.c.a(), false);
            for (String next : b2.keySet()) {
                String str2 = b2.get(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str2)) {
                    buildUpon.appendQueryParameter(next, str2);
                }
            }
            return buildUpon.build().toString() + "&site_id=" + ChatConfigUtil.Companion.getInstance().getActiveSiteID();
        } catch (Exception unused) {
            return str;
        }
    }
}
