package net.one97.paytm.paymentslimit.b;

import android.content.Context;
import com.paytm.utility.b;
import net.one97.paytm.utils.be;

public final class d extends b {
    public static String ao(Context context) {
        return be.a(context.getApplicationContext()).b("kyc_state", "", true);
    }

    public static void z(Context context, String str) {
        be.a(context.getApplicationContext()).a("kyc_state", str, true);
    }
}
