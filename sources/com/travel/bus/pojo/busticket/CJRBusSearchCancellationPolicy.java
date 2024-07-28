package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchCancellationPolicy implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "departure_heading")
    private String departure_heading;
    @b(a = "policy_heading")
    private String policy_heading;

    public String getDeparture_heading() {
        return this.departure_heading;
    }

    public void setDeparture_heading(String str) {
        this.departure_heading = str;
    }

    public String getPolicy_heading() {
        return this.policy_heading;
    }

    public void setPolicy_heading(String str) {
        this.policy_heading = str;
    }
}
