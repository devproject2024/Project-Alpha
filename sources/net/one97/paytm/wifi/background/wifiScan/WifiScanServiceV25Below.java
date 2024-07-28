package net.one97.paytm.wifi.background.wifiScan;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.wifi.a.a;
import net.one97.paytm.wifi.a.b;
import net.one97.paytm.wifi.background.wifiScan.WifiScanReceiver;

public final class WifiScanServiceV25Below extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21155a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private WifiScanReceiver f21156b;

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }

    public final void onCreate() {
        super.onCreate();
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        Application application = getApplication();
        k.a((Object) application, "application");
        a.C0409a.a(application, new b((byte) 0));
        a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
        this.f21156b = new WifiScanReceiver(a.C0409a.a().f21071b);
        WifiScanReceiver wifiScanReceiver = this.f21156b;
        if (wifiScanReceiver == null) {
            k.a("receiver");
        }
        WifiScanReceiver.a aVar3 = WifiScanReceiver.f21153a;
        registerReceiver(wifiScanReceiver, WifiScanReceiver.a.a());
        q.d(" WifiScanReceiver Registered");
    }

    public final void onDestroy() {
        q.d(" WifiScanReceiver Unregistered");
        WifiScanReceiver wifiScanReceiver = this.f21156b;
        if (wifiScanReceiver == null) {
            k.a("receiver");
        }
        unregisterReceiver(wifiScanReceiver);
        super.onDestroy();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
