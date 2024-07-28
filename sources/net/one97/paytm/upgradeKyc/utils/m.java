package net.one97.paytm.upgradeKyc.utils;

import android.content.Context;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.utility.i;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66342a = new a((byte) 0);

    public static final boolean a(Context context) {
        return a.a(context);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(Context context) {
            String b2 = b(context);
            CharSequence charSequence = b2;
            return !(charSequence == null || charSequence.length() == 0) && p.a(b2, "device_binding", true) && a();
        }

        private static String b(Context context) {
            i.a aVar = i.f49618a;
            if (context == null) {
                k.a();
            }
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context!!.applicationContext");
            com.paytm.b.a.a a2 = i.a.a(applicationContext);
            if (a2 != null) {
                return a2.b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "", true);
            }
            return null;
        }

        private static boolean a() {
            d.a aVar = d.f66026a;
            if (d.a.a() != null) {
                return d.a("isMinKycOTPRequired", false);
            }
            return false;
        }
    }
}
