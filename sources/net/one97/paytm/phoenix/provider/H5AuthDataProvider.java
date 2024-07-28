package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.b;
import com.paytm.utility.h;
import java.util.HashMap;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.phoenix.provider.PhoenixAuthProvider;

public class H5AuthDataProvider implements PhoenixAuthProvider {
    public Intent login(Activity activity, HashMap<String, Object> hashMap) {
        if (activity != null) {
            return new Intent(activity, AJRAuthActivity.class);
        }
        return null;
    }

    private void showPopUp(Activity activity) {
        h hVar = new h(activity);
        hVar.setTitle("Session Time Out");
        hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
        hVar.setCancelable(false);
        hVar.a(-3, Payload.RESPONSE_OK, new View.OnClickListener(activity) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                H5AuthDataProvider.lambda$showPopUp$0(h.this, this.f$1, view);
            }
        });
        hVar.show();
    }

    static /* synthetic */ void lambda$showPopUp$0(h hVar, Activity activity, View view) {
        hVar.cancel();
        h.a aVar = net.one97.paytm.deeplink.h.f50349a;
        h.a.a(activity, "paytmmp://login?screen=signOutLogin", (Bundle) null);
    }

    public PhoenixAuthProvider.AuthData provideAuthToken(Activity activity) {
        if (activity != null) {
            return new PhoenixAuthProvider.AuthData(u.b(activity), u.b());
        }
        return null;
    }

    public boolean logoutAllDevices(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        o oVar = o.f56791a;
        o.b(b.ab(activity));
        net.one97.paytm.auth.b.b.a(activity, false);
        return true;
    }

    public boolean logout(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        net.one97.paytm.auth.b.b.a(activity, false);
        return true;
    }

    public boolean sessionExpired(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        net.one97.paytm.auth.b.b.a(activity, false);
        if (!hashMap.containsKey("isShowSessionExpirePopUp")) {
            return true;
        }
        showPopUp(activity);
        return true;
    }
}
