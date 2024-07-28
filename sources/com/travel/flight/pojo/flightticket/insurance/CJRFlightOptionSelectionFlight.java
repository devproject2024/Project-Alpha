package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightOptionSelectionFlight implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "refund_title")
    private String refunadTitle;
    @b(a = "refund_amount")
    private String refundAmount;
    @b(a = "title")
    private String title;

    public String getRefunadTitle() {
        return this.refunadTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRefundAmount() {
        return this.refundAmount;
    }
}
