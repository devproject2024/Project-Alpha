package net.one97.paytm.wifi.background.wifi.filters;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;
import net.one97.paytm.wifi.models.WifiAccessPoint;
import net.one97.paytm.wifi.models.WifiConnection;

public interface d extends a {
    List<WifiAccessPoint> a(List<? extends ScanResult> list, WifiInfo wifiInfo);

    WifiConnection a(WifiInfo wifiInfo);
}
