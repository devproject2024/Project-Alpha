package net.one97.paytm.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.ae;
import net.one97.paytm.wallet.communicator.b;

public interface a {

    /* renamed from: net.one97.paytm.base.a$a  reason: collision with other inner class name */
    public static final class C0880a {
        public static boolean a(Activity activity, int i2, NetworkCustomError networkCustomError, Bundle bundle, String str) {
            k.c(activity, "activity");
            k.c(networkCustomError, "networkCustomError");
            ae aeVar = ae.f69602a;
            boolean a2 = ae.a(i2);
            if (a2) {
                ae aeVar2 = ae.f69602a;
                ae.a(activity, i2, networkCustomError, bundle, str);
            }
            return a2;
        }

        public static void a(String str, String str2, String str3, String str4, Context context, String str5) {
            k.c(str, "eventCategory");
            k.c(str2, "event_action");
            k.c(str3, "event_label");
            k.c(str4, "event_value");
            k.c(context, "context");
            k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
            b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, str5, str5);
        }
    }
}
