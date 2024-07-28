package net.one97.paytm.wifi.background.wifi.connector;

import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.paytm.utility.q;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.wifi.background.wifi.g;
import net.one97.paytm.wifi.models.BSSIDData;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class c {
    public static final WifiConfiguration a(List<? extends WifiConfiguration> list, WifiConfiguration wifiConfiguration) {
        k.c(wifiConfiguration, "toFind");
        String str = wifiConfiguration.SSID;
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return null;
        }
        String str2 = wifiConfiguration.BSSID;
        String a2 = a(wifiConfiguration);
        if (list == null) {
            q.d("NULL configs");
            return null;
        }
        for (WifiConfiguration wifiConfiguration2 : list) {
            if (((!TextUtils.isEmpty(wifiConfiguration2.BSSID) && k.a((Object) str2, (Object) wifiConfiguration2.BSSID)) || (!TextUtils.isEmpty(wifiConfiguration2.SSID) && k.a((Object) str, (Object) wifiConfiguration2.SSID))) && k.a((Object) a2, (Object) a(wifiConfiguration2))) {
                return wifiConfiguration2;
            }
        }
        q.d("Couldn't find ".concat(String.valueOf(str)));
        return null;
    }

    public static final WifiConfiguration a(List<? extends WifiConfiguration> list, WifiAccessPoint wifiAccessPoint) {
        k.c(wifiAccessPoint, "accessPoint");
        if (!p.a(wifiAccessPoint.getSSID()) && !wifiAccessPoint.getBssids().isEmpty() && list != null) {
            String b2 = g.b(wifiAccessPoint.getSSID());
            String a2 = a(wifiAccessPoint);
            for (WifiConfiguration wifiConfiguration : list) {
                if ((a(wifiConfiguration.BSSID, wifiAccessPoint.getBssids()) || (!TextUtils.isEmpty(wifiConfiguration.SSID) && k.a((Object) b2, (Object) wifiConfiguration.SSID))) && k.a((Object) a2, (Object) a(wifiConfiguration))) {
                    return wifiConfiguration;
                }
            }
        }
        return null;
    }

    public static final boolean a(String str, List<BSSIDData> list) {
        if (!(str == null || list == null || list.isEmpty())) {
            for (BSSIDData bssid : list) {
                if (k.a((Object) bssid.getBssid(), (Object) str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final String a(WifiAccessPoint wifiAccessPoint) {
        k.c(wifiAccessPoint, "accessPoint");
        String str = "WEP";
        if (!p.a((CharSequence) wifiAccessPoint.getCapabilities(), (CharSequence) str, false)) {
            str = "OPEN";
        }
        if (p.a((CharSequence) wifiAccessPoint.getCapabilities(), (CharSequence) "PSK", false)) {
            str = "PSK";
        }
        if (p.a((CharSequence) wifiAccessPoint.getCapabilities(), (CharSequence) "EAP", false)) {
            str = "EAP";
        }
        q.d("AccessPoint " + wifiAccessPoint.getSSID() + "'s capabilities " + wifiAccessPoint.getCapabilities());
        q.d("Got security via AccessPoint ".concat(str));
        return str;
    }

    public static final String a(WifiConfiguration wifiConfiguration) {
        k.c(wifiConfiguration, Constants.EASY_PAY_CONFIG_PREF_KEY);
        ArrayList arrayList = new ArrayList();
        String str = "OPEN";
        if (wifiConfiguration.allowedKeyManagement.get(0)) {
            if (wifiConfiguration.wepKeys[0] != null) {
                str = "WEP";
            }
            arrayList.add(str);
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            str = "EAP";
            arrayList.add(str);
        }
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            str = "PSK";
            arrayList.add(str);
        }
        q.d("Got Security Via WifiConfiguration ".concat(String.valueOf(arrayList)));
        return str;
    }
}
