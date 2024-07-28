package net.one97.paytm.wifi.background.wifi;

import android.net.wifi.WifiManager;
import androidx.lifecycle.LiveData;
import java.util.List;
import net.one97.paytm.wifi.background.wifi.filters.a;
import net.one97.paytm.wifi.models.WifiAccessPoint;
import net.one97.paytm.wifi.models.WifiConnection;
import net.one97.paytm.wifi.models.WifiConnectionStatus;

public interface e extends a {
    WifiManager a();

    LiveData<WifiConnectionStatus> a(WifiAccessPoint wifiAccessPoint);

    boolean b();

    boolean c();

    LiveData<List<WifiAccessPoint>> d();

    LiveData<WifiConnection> e();

    void g();

    void h();
}
