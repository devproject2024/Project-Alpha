package net.one97.paytm.wifi.background.wifi.filters;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class WifiProvider extends IJRPaytmDataModel {
    @c(a = "name")
    private String name;
    @c(a = "pID")
    private String pID;
    @c(a = "ssids")
    private List<String> ssids;
    @c(a = "vendorIcon")
    private String vendorIcon;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPID() {
        return this.pID;
    }

    public final void setPID(String str) {
        this.pID = str;
    }

    public final String getVendorIcon() {
        return this.vendorIcon;
    }

    public final void setVendorIcon(String str) {
        this.vendorIcon = str;
    }

    public final List<String> getSsids() {
        return this.ssids;
    }

    public final void setSsids(List<String> list) {
        this.ssids = list;
    }
}
