package net.one97.paytm.phoenix.d;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.provider.PhoenixTitleLoadingProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

public final class bc extends a {
    public bc() {
        super("showTitleLoading", H5Plugin.CommonEvents.HIDE_TITLE_LOADING);
    }

    public final boolean a(H5Event h5Event, b bVar) {
        Object obj;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        f b2 = c.f59399a.b();
        if (b2 != null) {
            String name = PhoenixTitleLoadingProvider.class.getName();
            k.a((Object) name, "PhoenixTitleLoadingProvider::class.java.name");
            obj = b2.a(name);
        } else {
            obj = null;
        }
        PhoenixTitleLoadingProvider phoenixTitleLoadingProvider = (PhoenixTitleLoadingProvider) obj;
        if (phoenixTitleLoadingProvider == null) {
            a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'PhoenixLoadingViewProvider'");
        } else {
            CharSequence action$phoenix_debug = h5Event.getAction$phoenix_debug();
            if (TextUtils.equals(action$phoenix_debug, "showTitleLoading")) {
                if (h5Event.getActivity() != null) {
                    phoenixTitleLoadingProvider.showTitleLoading(h5Event.getActivity());
                    a("success", (Object) "true");
                    a.a(this, h5Event, (Object) null, true, 2);
                }
                return true;
            } else if (TextUtils.equals(action$phoenix_debug, H5Plugin.CommonEvents.HIDE_TITLE_LOADING) && (h5Event.getActivity() instanceof PhoenixActivity) && h5Event.getActivity() != null) {
                phoenixTitleLoadingProvider.hideTitleLoading(h5Event.getActivity());
                a("success", (Object) "true");
                a.a(this, h5Event, (Object) null, true, 2);
            }
        }
        return true;
    }
}
