package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsTxnInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "intermediate_stops")
    private List<CJRBrtsIntermediateStop> intermediateStops;
    @b(a = "destination")
    private String mDestination;
    @b(a = "destination_id")
    private String mDestinationId;
    @b(a = "destination_name")
    private String mDestinationName;
    @b(a = "pax_info")
    private ArrayList<CJRBrtsPaxInfo> mPaxInfo;
    @b(a = "route_id")
    private String mRouteId;
    @b(a = "source")
    private String mSource;
    @b(a = "source_id")
    private String mSourceId;
    @b(a = "source_name")
    private String mSourceName;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "noOfStops")
    private int numberOfStops;

    public String getSource() {
        String str = this.mSource;
        if (str != null) {
            return str;
        }
        String str2 = this.mSourceName;
        if (str2 != null) {
            return str2;
        }
        return this.mSourceId;
    }

    public String getRouteId() {
        return this.mRouteId;
    }

    public String getDestination() {
        String str = this.mDestination;
        if (str != null) {
            return str;
        }
        String str2 = this.mDestinationName;
        if (str2 != null) {
            return str2;
        }
        return this.mDestinationId;
    }

    public ArrayList<CJRBrtsPaxInfo> getmPaxInfo() {
        return this.mPaxInfo;
    }

    public int getNumberOfStops() {
        return this.numberOfStops;
    }

    public List<CJRBrtsIntermediateStop> getIntermediateStops() {
        return this.intermediateStops;
    }

    public String getMerchantName() {
        return this.merchantName;
    }
}
