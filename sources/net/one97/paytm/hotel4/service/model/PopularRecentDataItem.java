package net.one97.paytm.hotel4.service.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PopularRecentDataItem extends IJRPaytmDataModel {
    private String city;
    private final String deeplink;
    private String name;
    private int viewType;

    public PopularRecentDataItem() {
        this((String) null, (String) null, (String) null, 0, 15, (g) null);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        k.c(str, "<set-?>");
        this.city = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopularRecentDataItem(String str, String str2, String str3, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0 : i2);
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void setViewType(int i2) {
        this.viewType = i2;
    }

    public PopularRecentDataItem(String str, String str2, String str3, int i2) {
        k.c(str, "name");
        k.c(str2, "deeplink");
        k.c(str3, "city");
        this.name = str;
        this.deeplink = str2;
        this.city = str3;
        this.viewType = i2;
    }
}
