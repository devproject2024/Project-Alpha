package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AmenitiesItemDetail extends IJRPaytmDataModel {
    private final String facilityImageUrl;
    private final String name;

    public AmenitiesItemDetail() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmenitiesItemDetail(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getFacilityImageUrl() {
        return this.facilityImageUrl;
    }

    public AmenitiesItemDetail(String str, String str2) {
        k.c(str, "name");
        k.c(str2, "facilityImageUrl");
        this.name = str;
        this.facilityImageUrl = str2;
    }
}
