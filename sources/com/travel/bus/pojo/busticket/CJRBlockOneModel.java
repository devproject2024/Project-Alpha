package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBlockOneModel implements IJRDataModel {
    @b(a = "grand_total")
    private double grandTotal;
    @b(a = "onward_leg")
    private CJRBusOnwardLeg onwardLeg;
    @b(a = "request_id")
    private String requestId;
    @b(a = "ticket_id")
    private String ticketId;

    public CJRBusOnwardLeg getOnwardLeg() {
        return this.onwardLeg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }
}
