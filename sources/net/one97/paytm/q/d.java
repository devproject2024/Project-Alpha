package net.one97.paytm.q;

import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;

public final class d {
    public static String a(String str) {
        String str2;
        if (str == null || str.contains("&site_id=")) {
            return str;
        }
        try {
            if (str.contains("?")) {
                str2 = str + "&child_site_id=" + URLEncoder.encode("1", AppConstants.UTF_8);
            } else {
                str2 = str + "&child_site_id=".replace(AppConstants.AND_SIGN, "?") + URLEncoder.encode("1", AppConstants.UTF_8);
            }
            return str2 + "&site_id=" + URLEncoder.encode("1", AppConstants.UTF_8);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }
}
