package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Build;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class x extends net.one97.paytm.phoenix.core.a {
    public x() {
        super("paytmAuthenticateOnDevice");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        Intent intent = null;
        String optString = params != null ? params.optString("title") : null;
        String optString2 = params != null ? params.optString(RequestConfirmationDialogFragment.KEY_DESCRIPTION) : null;
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return true;
        }
        Object systemService = activity.getSystemService("keyguard");
        if (systemService != null) {
            KeyguardManager keyguardManager = (KeyguardManager) systemService;
            if (!keyguardManager.isKeyguardSecure()) {
                a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "Secure lock screen hasn't set up.");
                return true;
            } else if (!(activity instanceof PhoenixActivity)) {
                return true;
            } else {
                PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
                if (Build.VERSION.SDK_INT >= 21) {
                    intent = keyguardManager.createConfirmDeviceCredentialIntent(optString, optString2);
                }
                if (intent == null) {
                    return true;
                }
                phoenixActivity.t.addObserver(new a(this, h5Event, phoenixActivity));
                String str = this.k;
                if (str == null) {
                    str = "";
                }
                phoenixActivity.a(intent, 65535, str);
                return true;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.app.KeyguardManager");
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f59572a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59573b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59574c;

        a(x xVar, H5Event h5Event, PhoenixActivity phoenixActivity) {
            this.f59572a = xVar;
            this.f59573b = h5Event;
            this.f59574c = phoenixActivity;
        }

        public final void update(Observable observable, Object obj) {
            x xVar = this.f59572a;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                xVar.a(this.f59573b, net.one97.paytm.phoenix.api.a.NOT_FOUND, "Authentication failed.");
            } else {
                xVar.a("success", (Object) Boolean.TRUE);
                net.one97.paytm.phoenix.core.a.a(xVar, this.f59573b, (Object) null, false, 6);
            }
            this.f59574c.t.deleteObservers();
        }
    }
}
