package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsurancePriceDetail implements IJRDataModel {
    @b(a = "passenger_type")
    private String passengerType;
    @b(a = "premium_per_passenger")
    private String premiumPerPassenger;

    public String getPassengerType() {
        return this.passengerType;
    }

    public String getPremiumPerPassenger() {
        return this.premiumPerPassenger;
    }
}
