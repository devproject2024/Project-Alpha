package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SearchParams {
    private final String checkInDate;
    private final String checkOutDate;

    public SearchParams() {
        this((String) null, (String) null, 3, (g) null);
    }

    public SearchParams(String str, String str2) {
        k.c(str, "checkOutDate");
        k.c(str2, "checkInDate");
        this.checkOutDate = str;
        this.checkInDate = str2;
    }

    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchParams(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getCheckInDate() {
        return this.checkInDate;
    }
}
