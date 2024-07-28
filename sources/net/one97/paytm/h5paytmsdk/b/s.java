package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.c.w;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class s extends ad {
    public s() {
        super("showLoading", H5Plugin.CommonEvents.HIDE_LOADING, "paytmHideLoadingView");
    }

    public final boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5ProviderManager providerManager = Nebula.getProviderManager();
        w wVar = (w) (providerManager != null ? providerManager.getProvider(w.class.getName()) : null);
        if (wVar == null) {
            a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5LoadingViewProvider'");
        } else {
            if (h5Event == null) {
                k.a();
            }
            CharSequence action = h5Event.getAction();
            if (TextUtils.equals(action, "showLoading")) {
                Activity activity = h5Event.getActivity();
                k.a((Object) activity, "event.activity");
                wVar.b(activity);
                return true;
            } else if (TextUtils.equals(action, H5Plugin.CommonEvents.HIDE_LOADING)) {
                if (h5Event.getActivity() instanceof PaytmH5Activity) {
                    Activity activity2 = h5Event.getActivity();
                    if (activity2 == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
                    } else if (!((PaytmH5Activity) activity2).m) {
                        Activity activity3 = h5Event.getActivity();
                        k.a((Object) activity3, "event.activity");
                        wVar.a(activity3);
                    }
                } else {
                    Activity activity4 = h5Event.getActivity();
                    k.a((Object) activity4, "event.activity");
                    wVar.a(activity4);
                }
                return true;
            } else if (TextUtils.equals(action, "paytmHideLoadingView")) {
                Activity activity5 = h5Event.getActivity();
                k.a((Object) activity5, "event.activity");
                wVar.a(activity5);
            }
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }
}
