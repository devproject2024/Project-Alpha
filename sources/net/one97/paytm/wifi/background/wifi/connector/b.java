package net.one97.paytm.wifi.background.wifi.connector;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.wifi.background.wifi.g;
import net.one97.paytm.wifi.models.BSSIDData;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class b {
    public static final boolean a(WifiManager wifiManager, List<BSSIDData> list) {
        k.c(wifiManager, "receiver$0");
        if (list == null || wifiManager.getConnectionInfo() == null) {
            return false;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        k.a((Object) connectionInfo, "connectionInfo");
        if (connectionInfo.getBSSID() == null) {
            return false;
        }
        WifiInfo connectionInfo2 = wifiManager.getConnectionInfo();
        k.a((Object) connectionInfo2, "connectionInfo");
        if (connectionInfo2.getIpAddress() == 0) {
            return false;
        }
        WifiInfo connectionInfo3 = wifiManager.getConnectionInfo();
        k.a((Object) connectionInfo3, "connectionInfo");
        if (!c.a(connectionInfo3.getBSSID(), list)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Already connected to: ");
        WifiInfo connectionInfo4 = wifiManager.getConnectionInfo();
        k.a((Object) connectionInfo4, "connectionInfo");
        sb.append(connectionInfo4.getSSID());
        sb.append(" BSSID:  ");
        WifiInfo connectionInfo5 = wifiManager.getConnectionInfo();
        k.a((Object) connectionInfo5, "connectionInfo");
        sb.append(connectionInfo5.getBSSID());
        q.d(sb.toString());
        return true;
    }

    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(((WifiConfiguration) t).priority), Integer.valueOf(((WifiConfiguration) t2).priority));
        }
    }

    /* renamed from: net.one97.paytm.wifi.background.wifi.connector.b$b  reason: collision with other inner class name */
    public static final class C0414b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(((WifiConfiguration) t).priority), Integer.valueOf(((WifiConfiguration) t2).priority));
        }
    }

    public static final boolean a(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        boolean z = false;
        if (!(configuredNetworks == null || wifiConfiguration == null || configuredNetworks.isEmpty())) {
            for (WifiConfiguration next : configuredNetworks) {
                if (next.networkId == wifiConfiguration.networkId) {
                    z = wifiManager.enableNetwork(next.networkId, true);
                } else {
                    wifiManager.disableNetwork(next.networkId);
                }
            }
            q.d("disableAllButOne ".concat(String.valueOf(z)));
        }
        return z;
    }

    public static final int a(WifiManager wifiManager) {
        int i2 = 0;
        for (WifiConfiguration next : wifiManager.getConfiguredNetworks()) {
            if (next.priority > i2) {
                i2 = next.priority;
            }
        }
        return i2;
    }

    public static final boolean a(WifiManager wifiManager, WifiAccessPoint wifiAccessPoint) {
        k.c(wifiManager, "receiver$0");
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        boolean z = false;
        if (!(configuredNetworks == null || wifiAccessPoint == null || configuredNetworks.isEmpty())) {
            Iterator<WifiConfiguration> it2 = configuredNetworks.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WifiConfiguration next = it2.next();
                if (c.a(next.BSSID, wifiAccessPoint.getBssids()) && k.a((Object) wifiAccessPoint.getSSID(), (Object) g.c(next.SSID))) {
                    z = wifiManager.enableNetwork(next.networkId, true);
                    break;
                }
            }
            q.d("reEnable Network If Possible ".concat(String.valueOf(z)));
        }
        return z;
    }

    public static final void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        k.c(context, "context");
        k.c(intentFilter, StringSet.filter);
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            q.b(String.valueOf(e2));
        }
    }

    public static final boolean a(ContentResolver contentResolver, WifiManager wifiManager, List<WifiConfiguration> list) {
        if (list.size() > 1) {
            kotlin.a.k.a(list, new a());
        }
        int i2 = Build.VERSION.SDK_INT;
        int i3 = Settings.Secure.getInt(contentResolver, "wifi_num_open_networks_kept", 10);
        boolean z = false;
        int i4 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            WifiConfiguration wifiConfiguration = list.get(size);
            if (k.a((Object) "OPEN", (Object) c.a(wifiConfiguration)) && (i4 = i4 + 1) >= i3) {
                wifiManager.removeNetwork(wifiConfiguration.networkId);
                z = true;
            }
        }
        return z;
    }

    public static final int b(WifiManager wifiManager, List<WifiConfiguration> list) {
        if (list.size() > 1) {
            kotlin.a.k.a(list, new C0414b());
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            WifiConfiguration wifiConfiguration = list.get(i2);
            wifiConfiguration.priority = i2;
            wifiManager.updateNetwork(wifiConfiguration);
        }
        return size;
    }
}
