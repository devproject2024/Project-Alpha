package com.business.merchant_payments.payment.model;

import com.alipay.mobile.nebulacore.wallet.H5Logger;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AdapterMarkerModels {
    public HomeTabsModel header;

    public AdapterMarkerModels() {
        this((HomeTabsModel) null, 1, (g) null);
    }

    public static /* synthetic */ AdapterMarkerModels copy$default(AdapterMarkerModels adapterMarkerModels, HomeTabsModel homeTabsModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            homeTabsModel = adapterMarkerModels.header;
        }
        return adapterMarkerModels.copy(homeTabsModel);
    }

    public final HomeTabsModel component1() {
        return this.header;
    }

    public final AdapterMarkerModels copy(HomeTabsModel homeTabsModel) {
        k.d(homeTabsModel, H5Logger.HEADER);
        return new AdapterMarkerModels(homeTabsModel);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AdapterMarkerModels) && k.a((Object) this.header, (Object) ((AdapterMarkerModels) obj).header);
        }
        return true;
    }

    public final int hashCode() {
        HomeTabsModel homeTabsModel = this.header;
        if (homeTabsModel != null) {
            return homeTabsModel.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "AdapterMarkerModels(header=" + this.header + ")";
    }

    public AdapterMarkerModels(HomeTabsModel homeTabsModel) {
        k.d(homeTabsModel, H5Logger.HEADER);
        this.header = homeTabsModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdapterMarkerModels(HomeTabsModel homeTabsModel, int i2, g gVar) {
        this((i2 & 1) != 0 ? new HomeTabsModel() : homeTabsModel);
    }

    public final HomeTabsModel getHeader() {
        return this.header;
    }

    public final void setHeader(HomeTabsModel homeTabsModel) {
        k.d(homeTabsModel, "<set-?>");
        this.header = homeTabsModel;
    }
}
