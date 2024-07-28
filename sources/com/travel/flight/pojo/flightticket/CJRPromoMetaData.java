package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPromoMetaData implements IJRDataModel {
    @b(a = "campData")
    private HashMap<String, CJRFlightCampaign> campData;
    @b(a = "paymentData")
    private CJRFlightPaymentData paymentData;

    public HashMap<String, CJRFlightCampaign> getCampData() {
        return this.campData;
    }

    public CJRFlightPaymentData getPaymentData() {
        return this.paymentData;
    }
}
