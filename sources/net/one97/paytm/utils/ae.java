package net.one97.paytm.utils;

import android.app.Activity;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.communicator.b;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final ae f69602a = new ae();

    public static boolean a(int i2) {
        return i2 == 401 || i2 == 410 || i2 == 403;
    }

    private ae() {
    }

    public static boolean a(String str) {
        k.c(str, "statusCode");
        return k.a((Object) UpiUtils.AUTHENTICATION_FAILURE_401, (Object) str) || k.a((Object) "410", (Object) str) || k.a((Object) "403", (Object) str);
    }

    public static void a(Activity activity, int i2, NetworkCustomError networkCustomError, Bundle bundle, String str) {
        k.c(activity, "activity");
        k.c(networkCustomError, "networkCustomError");
        if (a(i2)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            if (str != null) {
                bundle2.putString("key_relogin_tag_for_relogin", str);
            }
            b.a().handleSessionTimeout(activity, networkCustomError, (String) null, bundle2, str != null, str == null);
        }
    }
}
