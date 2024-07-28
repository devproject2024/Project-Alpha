package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightEnabledFeatures implements IJRDataModel {
    private boolean minirules;

    public boolean isMinirules() {
        return this.minirules;
    }

    public void setMinirules(boolean z) {
        this.minirules = z;
    }
}
