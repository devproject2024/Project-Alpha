package net.one97.paytm.wifi.background.wifi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final d f21129a;

    /* renamed from: b  reason: collision with root package name */
    private final e f21130b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(d dVar, e eVar, Looper looper) {
        super(looper);
        k.c(dVar, "wifiProcessorService");
        k.c(eVar, "wifiService");
        k.c(looper, "looper");
        this.f21129a = dVar;
        this.f21130b = eVar;
    }

    public final void handleMessage(Message message) {
        Bundle bundle;
        if (message != null) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f21129a.f();
            } else if (i2 == 2) {
                Object obj = message.obj;
                if (obj != null) {
                    this.f21129a.b((WifiAccessPoint) obj);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.wifi.models.WifiAccessPoint");
            } else if (i2 == 3) {
                Bundle bundle2 = (Bundle) message.obj;
                if (bundle2 != null) {
                    this.f21129a.a(bundle2.getInt("previous_wifi_state"), bundle2.getInt("wifi_state"));
                }
            } else if (i2 == 5 && (bundle = (Bundle) message.obj) != null && bundle.containsKey("newRssi")) {
                this.f21129a.a(bundle.getInt("newRssi", -100));
            }
        }
    }

    public final Message a(int i2, Object obj) {
        k.c(obj, "data");
        Message obtainMessage = obtainMessage(i2, obj);
        k.a((Object) obtainMessage, "obtainMessage(what, data)");
        return obtainMessage;
    }
}
