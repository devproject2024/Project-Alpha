package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class bd extends net.one97.paytm.phoenix.core.a {
    public bd() {
        super("paytmChangeWebSetting");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        if (!a(h5Event)) {
            return true;
        }
        JSONObject params = h5Event.getParams();
        Boolean valueOf = params != null ? Boolean.valueOf(params.optBoolean("mediaPlaybackRequiresUserGesture")) : null;
        if (valueOf != null) {
            Activity activity = h5Event.getActivity();
            if (activity == null) {
                return true;
            }
            activity.runOnUiThread(new a(valueOf, h5Event, this, h5Event));
            return true;
        }
        net.one97.paytm.phoenix.api.a aVar = net.one97.paytm.phoenix.api.a.INVALID_PARAM;
        a(h5Event, aVar, aVar.toString());
        return true;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Boolean f59542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bd f59544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59545d;

        a(Boolean bool, H5Event h5Event, bd bdVar, H5Event h5Event2) {
            this.f59542a = bool;
            this.f59543b = h5Event;
            this.f59544c = bdVar;
            this.f59545d = h5Event2;
        }

        public final void run() {
            Activity activity = this.f59543b.getActivity();
            if (activity != null) {
                WebView webView = (WebView) ((PhoenixActivity) activity).a(R.id.webView);
                k.a((Object) webView, "(it.getActivity() as PhoenixActivity).getWebview()");
                WebSettings settings = webView.getSettings();
                k.a((Object) settings, "(it.getActivity() as Pho…                .settings");
                settings.setMediaPlaybackRequiresUserGesture(this.f59542a.booleanValue());
                this.f59544c.a("success", (Object) Boolean.TRUE);
                net.one97.paytm.phoenix.core.a.a(this.f59544c, this.f59545d, (Object) null, false, 6);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
        }
    }
}
