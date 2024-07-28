package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.provider.PhoenixLoadingViewProvider;
import net.one97.paytm.phoenix.provider.SplashIconViewProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class al extends a {
    public al() {
        super("showLoading", H5Plugin.CommonEvents.HIDE_LOADING, "paytmHideLoadingView");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "context");
        f b2 = c.f59399a.b();
        String name = PhoenixLoadingViewProvider.class.getName();
        k.a((Object) name, "PhoenixLoadingViewProvider::class.java.name");
        PhoenixLoadingViewProvider phoenixLoadingViewProvider = (PhoenixLoadingViewProvider) b2.a(name);
        f b3 = c.f59399a.b();
        String name2 = SplashIconViewProvider.class.getName();
        k.a((Object) name2, "SplashIconViewProvider::class.java.name");
        SplashIconViewProvider splashIconViewProvider = (SplashIconViewProvider) b3.a(name2);
        if (phoenixLoadingViewProvider == null) {
            a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'PhoenixLoadingViewProvider'");
        } else {
            CharSequence action$phoenix_debug = h5Event.getAction$phoenix_debug();
            if (TextUtils.equals(action$phoenix_debug, "showLoading")) {
                if (h5Event.getActivity() != null) {
                    Activity activity = h5Event.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    phoenixLoadingViewProvider.showLoadingView(activity);
                }
                return true;
            } else if (TextUtils.equals(action$phoenix_debug, H5Plugin.CommonEvents.HIDE_LOADING)) {
                if (h5Event.getActivity() instanceof PhoenixActivity) {
                    if (h5Event.getActivity() != null) {
                        Activity activity2 = h5Event.getActivity();
                        if (activity2 != null) {
                            if (((PhoenixActivity) activity2).f59610h && splashIconViewProvider != null) {
                                splashIconViewProvider.hideSplashView();
                            }
                            Activity activity3 = h5Event.getActivity();
                            if (activity3 == null) {
                                k.a();
                            }
                            phoenixLoadingViewProvider.hideLoadingView(activity3);
                            a("success", (Object) Boolean.TRUE);
                            a.a(this, h5Event, (Object) null, false, 6);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                        }
                    }
                } else if (h5Event.getActivity() != null) {
                    Activity activity4 = h5Event.getActivity();
                    if (activity4 == null) {
                        k.a();
                    }
                    phoenixLoadingViewProvider.hideLoadingView(activity4);
                    a("success", (Object) Boolean.TRUE);
                    a.a(this, h5Event, (Object) null, false, 6);
                }
            } else if (TextUtils.equals(action$phoenix_debug, "paytmHideLoadingView") && h5Event.getActivity() != null) {
                JSONObject params = h5Event.getParams();
                boolean z = (params == null || !params.has("isResultRequired")) ? true : params.getBoolean("isResultRequired");
                Activity activity5 = h5Event.getActivity();
                if (activity5 == null) {
                    k.a();
                }
                phoenixLoadingViewProvider.hideLoadingView(activity5);
                if (z) {
                    a("success", (Object) Boolean.TRUE);
                    a.a(this, h5Event, (Object) null, false, 6);
                }
            }
        }
        return true;
    }
}
