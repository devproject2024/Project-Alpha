package net.one97.paytm.o;

import android.app.Activity;
import android.content.Context;
import com.paytm.utility.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.b.b;
import net.one97.paytm.h.a;
import net.one97.paytm.h.d;
import net.one97.paytm.j.c;

public final class a implements net.one97.paytm.paymentslimit.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static a f12660a;

    public final Context a() {
        return CJRJarvisApplication.getAppContext();
    }

    public final Class<? extends Activity> b() {
        return d.b().a().get(a.C0908a.AuthActivity);
    }

    public final String c() {
        c.a();
        return c.a("paymentLimitDetailURL", (String) null);
    }

    public final String d() {
        c.a();
        return c.a("paymentLimitValidateTransactionURL", (String) null);
    }

    public final String e() {
        c.a();
        return c.a("paymentLimitUpdateURl", (String) null);
    }

    public final String f() {
        c.a();
        return c.x();
    }

    public final boolean g() {
        c.a();
        String a2 = c.a("p2mLimitValidStates", (String) null);
        if (a2 != null) {
            String d2 = net.one97.paytm.wallet.utility.a.d(CJRJarvisApplication.getAppContext());
            e.a[] values = e.a.values();
            int i2 = 0;
            while (i2 < values.length) {
                e.a aVar = values[i2];
                if (d2 == null || (!d2.equalsIgnoreCase(aVar.getWalletUserState()) && !d2.equalsIgnoreCase(aVar.getv2UserState()))) {
                    i2++;
                } else {
                    String str = aVar.getv2UserState();
                    new ArrayList();
                    return Arrays.asList(a2.split(AppConstants.COMMA)).contains(str);
                }
            }
        }
        return false;
    }

    public final boolean h() {
        c.a();
        String a2 = c.a("p2pLimitValidStates", (String) null);
        if (a2 != null) {
            String d2 = net.one97.paytm.wallet.utility.a.d(CJRJarvisApplication.getAppContext());
            e.a[] values = e.a.values();
            int i2 = 0;
            while (i2 < values.length) {
                e.a aVar = values[i2];
                if (d2 == null || (!d2.equalsIgnoreCase(aVar.getWalletUserState()) && !d2.equalsIgnoreCase(aVar.getv2UserState()))) {
                    i2++;
                } else {
                    String str = aVar.getv2UserState();
                    new ArrayList();
                    return Arrays.asList(a2.split(AppConstants.COMMA)).contains(str);
                }
            }
        }
        return false;
    }

    public final boolean i() {
        c.a();
        String a2 = c.a("p2bLimitValidStates", (String) null);
        if (a2 != null) {
            String d2 = net.one97.paytm.wallet.utility.a.d(CJRJarvisApplication.getAppContext());
            e.a[] values = e.a.values();
            int i2 = 0;
            while (i2 < values.length) {
                e.a aVar = values[i2];
                if (d2 == null || (!d2.equalsIgnoreCase(aVar.getWalletUserState()) && !d2.equalsIgnoreCase(aVar.getv2UserState()))) {
                    i2++;
                } else {
                    String str = aVar.getv2UserState();
                    new ArrayList();
                    return Arrays.asList(a2.split(AppConstants.COMMA)).contains(str);
                }
            }
        }
        return false;
    }

    public final String j() {
        c.a();
        return c.a("paymentLimitResendOtpURL", (String) null);
    }

    public final void a(Activity activity) {
        b.a(activity, false);
    }
}
