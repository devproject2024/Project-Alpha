package net.one97.paytm.wifi.background.wifiScan;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.wifi.a.a;
import net.one97.paytm.wifi.a.b;
import net.one97.paytm.wifi.background.wifiScan.WifiScanReceiver;

public final class WiFiScanServiceV26 extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21151a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private WifiScanReceiver f21152b;

    public final void onCreate() {
        super.onCreate();
        q.d("Service created");
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        Application application = getApplication();
        k.a((Object) application, "application");
        a.C0409a.a(application, new b((byte) 0));
        a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
        this.f21152b = new WifiScanReceiver(a.C0409a.a().f21071b);
        WifiScanReceiver wifiScanReceiver = this.f21152b;
        if (wifiScanReceiver == null) {
            k.a("receiver");
        }
        WifiScanReceiver.a aVar3 = WifiScanReceiver.f21153a;
        registerReceiver(wifiScanReceiver, WifiScanReceiver.a.a());
        q.d("Registered Receiver");
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        q.d("onStartJob");
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        q.d("WiFiScanServiceV26's onStopJob");
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        q.d("'onDestroy");
        WifiScanReceiver wifiScanReceiver = this.f21152b;
        if (wifiScanReceiver == null) {
            k.a("receiver");
        }
        unregisterReceiver(wifiScanReceiver);
        q.d("Unregistered the wifi receiver");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
