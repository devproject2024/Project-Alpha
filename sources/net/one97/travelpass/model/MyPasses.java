package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class MyPasses extends IJRPaytmDataModel {
    @b(a = "error")
    private String error;
    @b(a = "message")
    private String message;
    @b(a = "meta")
    private TravelPassMetaData metadata;
    @b(a = "status")
    private String status;
    @b(a = "body")
    private List<PassData> verticalPassesData;

    public String getStatus() {
        return this.status;
    }

    public List<PassData> getVerticalPassesData() {
        return this.verticalPassesData;
    }

    public TravelPassMetaData getMetadata() {
        return this.metadata;
    }

    public String getMessage() {
        return this.message;
    }

    public String getError() {
        return this.error;
    }
}
