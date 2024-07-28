package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class BusEcosystemOfferInfo implements IJRDataModel {
    @b(a = "offer")
    private BusEcosystemOffer busEcosystemOffer;
    @b(a = "campaign_type")
    private String campaignType;

    public BusEcosystemOffer getBusEcosystemOffer() {
        return this.busEcosystemOffer;
    }

    public String getCampaignType() {
        return this.campaignType;
    }
}
