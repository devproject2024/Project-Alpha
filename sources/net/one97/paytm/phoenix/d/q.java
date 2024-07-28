package net.one97.paytm.phoenix.d;

import android.app.Activity;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.json.JSONObject;

public final class q extends net.one97.paytm.phoenix.core.a {
    public q() {
        super("PaytmSetScreenshotStatus");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity != null && (bridgeName = h5Event.getBridgeName()) != null && bridgeName.hashCode() == -1268690247 && bridgeName.equals("PaytmSetScreenshotStatus")) {
            x.e eVar = new x.e();
            T t = null;
            eVar.element = null;
            JSONObject params = h5Event.getParams();
            if (params != null && params.has("isEnable")) {
                JSONObject params2 = h5Event.getParams();
                if (params2 != null) {
                    t = params2.get("isEnable");
                }
                eVar.element = t;
            }
            if (eVar.element == null || k.a((Object) eVar.element, (Object) "")) {
                a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Key not found");
            } else {
                activity.runOnUiThread(new a(eVar, activity));
                net.one97.paytm.phoenix.core.a.a(this, h5Event, "success", false, 4);
            }
        }
        return true;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f19854a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19855b;

        a(x.e eVar, Activity activity) {
            this.f19854a = eVar;
            this.f19855b = activity;
        }

        public final void run() {
            if (k.a((Object) this.f19854a.element, (Object) Boolean.FALSE)) {
                this.f19855b.getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            } else {
                this.f19855b.getWindow().clearFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
        }
    }
}
