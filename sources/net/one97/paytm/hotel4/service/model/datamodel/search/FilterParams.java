package net.one97.paytm.hotel4.service.model.datamodel.search;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class FilterParams extends IJRPaytmDataModel {
    private String hotelId;
    private final Locations location;

    public FilterParams() {
        this((String) null, (Locations) null, 3, (g) null);
    }

    public final String getHotelId() {
        return this.hotelId;
    }

    public final void setHotelId(String str) {
        k.c(str, "<set-?>");
        this.hotelId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterParams(String str, Locations locations, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new Locations((String) null, (String) null, (String) null, 7, (g) null) : locations);
    }

    public final Locations getLocation() {
        return this.location;
    }

    public FilterParams(String str, Locations locations) {
        k.c(str, "hotelId");
        k.c(locations, "location");
        this.hotelId = str;
        this.location = locations;
    }
}
