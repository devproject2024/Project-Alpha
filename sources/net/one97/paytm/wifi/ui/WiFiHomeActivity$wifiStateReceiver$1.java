package net.one97.paytm.wifi.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Parcelable;
import android.widget.FrameLayout;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.wifi.R;
import net.one97.paytm.wifi.a.a;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class WiFiHomeActivity$wifiStateReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WiFiHomeActivity f21204a;

    WiFiHomeActivity$wifiStateReceiver$1(WiFiHomeActivity wiFiHomeActivity) {
        this.f21204a = wiFiHomeActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        k.c(context, "context");
        k.c(intent, "intent");
        String action = intent.getAction();
        String unused = this.f21204a.f21160e;
        q.d("onReceive Called with action ".concat(String.valueOf(action)));
        if (intent.getExtras() == null) {
            String unused2 = this.f21204a.f21160e;
            q.b("Empty extras in WIFI receiver broadcast");
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1875733435:
                    str = "android.net.wifi.WIFI_STATE_CHANGED";
                    break;
                case -385684331:
                    str = "android.net.wifi.RSSI_CHANGED";
                    break;
                case -343630553:
                    if (action.equals("android.net.wifi.STATE_CHANGE")) {
                        Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                        k.a((Object) parcelableExtra, "intent.getParcelableExtr…nager.EXTRA_NETWORK_INFO)");
                        if (((NetworkInfo) parcelableExtra).isConnected()) {
                            new Handler().postDelayed(a.f21205a, 2000);
                            break;
                        }
                    }
                    break;
                case -20031181:
                    str = "android.net.wifi.NETWORK_IDS_CHANGED";
                    break;
                case 1878357501:
                    str = "android.net.wifi.SCAN_RESULTS";
                    break;
            }
            boolean equals = action.equals(str);
        }
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        if (!a.C0409a.a().f21070a.b()) {
            FrameLayout frameLayout = (FrameLayout) this.f21204a.a(R.id.wifiTurnOffFrame);
            k.a((Object) frameLayout, "wifiTurnOffFrame");
            frameLayout.setVisibility(0);
        } else {
            FrameLayout frameLayout2 = (FrameLayout) this.f21204a.a(R.id.wifiTurnOffFrame);
            k.a((Object) frameLayout2, "wifiTurnOffFrame");
            frameLayout2.setVisibility(8);
        }
        String unused3 = this.f21204a.f21160e;
        q.d("change received");
        WifiAccessPoint unused4 = this.f21204a.f21158c;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21205a = new a();

        a() {
        }

        public final void run() {
            a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.g();
        }
    }
}
