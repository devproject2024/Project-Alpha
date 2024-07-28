package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class TravelPassData extends IJRPaytmDataModel {
    @b(a = "error")
    private String error;
    @b(a = "maxPurchaseCount")
    private int maxPurchaseCount;
    @b(a = "message")
    private String message;
    @b(a = "meta")
    private TravelPassMetaData metadata;
    @b(a = "status")
    private String status;
    @b(a = "data")
    private List<VerticalPassesData> verticalPassesData;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public List<VerticalPassesData> getVerticalPassesData() {
        return this.verticalPassesData;
    }

    public String getError() {
        return this.error;
    }

    public TravelPassMetaData getMetadata() {
        return this.metadata;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }

    public int getMaxPurchaseCount() {
        return this.maxPurchaseCount;
    }
}
