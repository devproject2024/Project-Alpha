package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemFeature implements IJRDataModel {
    @b(a = "collect_location_points")
    private Boolean collectLocationPoints;
    @b(a = "concession")
    private Boolean concession;
    @b(a = "extra_traveller_details")
    private Boolean extraTravellerDetails;
    @b(a = "single_lady")
    private Boolean singleLady;

    public Boolean getSingleLady() {
        return this.singleLady;
    }

    public void setSingleLady(Boolean bool) {
        this.singleLady = bool;
    }

    public void setExtraTravellerDetails(Boolean bool) {
        this.extraTravellerDetails = bool;
    }

    public Boolean getCollectLocationPoints() {
        return this.collectLocationPoints;
    }

    public void setCollectLocationPoints(Boolean bool) {
        this.collectLocationPoints = bool;
    }

    public void setConcession(Boolean bool) {
        this.concession = bool;
    }
}
