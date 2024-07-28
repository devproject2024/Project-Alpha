package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRBusSearchMetaDataV3 extends IJRPaytmDataModel {
    @b(a = "actions")
    private List<Object> actions = null;
    @b(a = "destination_city_name")
    private String destinationCity = null;
    @b(a = "message")
    private String message = null;
    @b(a = "requestid")
    private String requestid;
    @b(a = "source_city_name")
    private String sourceCity = null;
    @b(a = "travel_routes")
    private CJRTravelRoutesZeroSearch travelRoutes;

    public String getSourceCity() {
        return this.sourceCity;
    }

    public String getDestinationCity() {
        return this.destinationCity;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public String getMessage() {
        return this.message;
    }

    public CJRTravelRoutesZeroSearch getTravelRoutes() {
        return this.travelRoutes;
    }
}
