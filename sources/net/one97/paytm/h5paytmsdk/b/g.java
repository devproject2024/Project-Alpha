package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Build;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class g extends ad {
    public g() {
        super("paytmAuthenticateOnDevice");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        e param = h5Event.getParam();
        String string = param.getString("title");
        String string2 = param.getString(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return true;
        }
        Object systemService = activity.getSystemService("keyguard");
        if (systemService != null) {
            KeyguardManager keyguardManager = (KeyguardManager) systemService;
            if (!keyguardManager.isKeyguardSecure()) {
                a(H5Event.Error.FORBIDDEN, "Secure lock screen hasn't set up.");
                return true;
            } else if (!(activity instanceof PaytmH5Activity)) {
                return true;
            } else {
                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                Intent createConfirmDeviceCredentialIntent = Build.VERSION.SDK_INT >= 21 ? keyguardManager.createConfirmDeviceCredentialIntent(string, string2) : null;
                if (createConfirmDeviceCredentialIntent == null) {
                    return true;
                }
                paytmH5Activity.f17109g.addObserver(new a(this, paytmH5Activity));
                String str = this.f16978c;
                if (str == null) {
                    str = "";
                }
                paytmH5Activity.a(createConfirmDeviceCredentialIntent, 65535, str);
                return true;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.app.KeyguardManager");
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f17000b;

        a(g gVar, PaytmH5Activity paytmH5Activity) {
            this.f16999a = gVar;
            this.f17000b = paytmH5Activity;
        }

        public final void update(Observable observable, Object obj) {
            g gVar = this.f16999a;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                gVar.a(H5Event.Error.NOT_FOUND, "Authentication failed.");
            } else {
                gVar.a("success", (Object) Boolean.TRUE);
                gVar.a((Object) null);
            }
            this.f17000b.f17109g.deleteObservers();
        }
    }
}
