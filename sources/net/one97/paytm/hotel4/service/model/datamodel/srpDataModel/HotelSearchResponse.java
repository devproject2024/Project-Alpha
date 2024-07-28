package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class HotelSearchResponse extends IJRPaytmDataModel {
    private final List<SRPDataItem> data;
    private final Extra extra;
    private final String requestId = "";

    public final List<SRPDataItem> getData() {
        return this.data;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
        k.a((Object) parseResponse, "super.parseResponse(p0, p1)");
        return parseResponse;
    }
}
