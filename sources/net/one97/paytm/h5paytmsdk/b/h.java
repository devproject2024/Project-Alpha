package net.one97.paytm.h5paytmsdk.b;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.webview.APWebSettings;
import com.alipay.mobile.nebula.webview.APWebView;
import kotlin.g.b.k;

public final class h extends ad {
    public h() {
        super("paytmChangeWebSetting");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Boolean bool;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        if (!(h5Event == null || (bool = h5Event.getParam().getBoolean("mediaPlaybackRequiresUserGesture")) == null)) {
            bool.booleanValue();
            H5Page h5page = h5Event.getH5page();
            k.a((Object) h5page, "it.h5page");
            APWebView webView = h5page.getWebView();
            k.a((Object) webView, "it.h5page.webView");
            APWebSettings settings = webView.getSettings();
            k.a((Object) settings, "it.h5page.webView.settings");
            settings.setMediaPlaybackRequiresUserGesture(bool.booleanValue());
            a("success", (Object) Boolean.TRUE);
            a((Object) null);
        }
        a(H5Event.Error.INVALID_PARAM, "Message empty!");
        return true;
    }
}
