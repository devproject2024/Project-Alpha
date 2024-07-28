package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.o;

public final class i extends ad {
    public i() {
        super("paytmOpenDeeplink");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        H5ProviderManager providerManager = Nebula.getProviderManager();
        o oVar = (o) (providerManager != null ? providerManager.getProvider(o.class.getName()) : null);
        if (oVar == null) {
            a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5DeeplinkHandlerProvider'");
            return false;
        }
        if (h5Event == null) {
            k.a();
        }
        String string = h5Event.getParam().getString("deeplink");
        if (!TextUtils.isEmpty(string)) {
            Activity activity = h5Event.getActivity();
            k.a((Object) activity, "event.activity");
            k.a((Object) string, "deeplink");
            if (oVar.a(activity, string)) {
                a("success", (Object) Boolean.TRUE);
                a((Object) null);
                return true;
            }
            a(H5Event.Error.NOT_FOUND, "cannot handle deeplink");
            return true;
        }
        a(H5Event.Error.INVALID_PARAM, "invalid params");
        return true;
    }
}
