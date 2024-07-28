package net.one97.paytm.wifi.background.wifi.filters;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class AllSSIDJsonModel extends IJRPaytmDataModel {
    @c(a = "wifiProviders")
    private List<WifiProvider> wifiProviders;

    public final List<WifiProvider> getWifiProviders() {
        return this.wifiProviders;
    }

    public final void setWifiProviders(List<WifiProvider> list) {
        this.wifiProviders = list;
    }
}
