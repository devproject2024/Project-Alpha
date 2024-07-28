package net.one97.paytm.paymentsBank.si.g;

import android.net.Uri;
import android.text.TextUtils;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class a {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            g.a();
            String a2 = d.a(UpiConstantServiceApi.GTM_KEY_UPI_BANK_LOGO_URL);
            String substring = str.substring(0, 4);
            try {
                Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
                return buildUpon.appendPath(substring + ".png").build().toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
