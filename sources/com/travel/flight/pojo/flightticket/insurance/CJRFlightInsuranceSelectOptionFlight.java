package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightInsuranceSelectOptionFlight implements IJRDataModel {
    @b(a = "opt_in")
    private CJRFlightOptionSelectionFlight optionIn;
    @b(a = "opt_out")
    private CJRFlightOptionSelectionFlight optionOut;
    @b(a = "component_title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public CJRFlightOptionSelectionFlight getOptionOut() {
        return this.optionOut;
    }

    public CJRFlightOptionSelectionFlight getOptionIn() {
        return this.optionIn;
    }
}
