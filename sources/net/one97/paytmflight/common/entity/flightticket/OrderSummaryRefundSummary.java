package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class OrderSummaryRefundSummary implements IJRDataModel {
    private OrderSummaryRefundFail booking_fail;
    private ArrayList<FlightOrderRefundSummary> summary;

    public ArrayList<FlightOrderRefundSummary> getSummary() {
        return this.summary;
    }

    public void setSummary(ArrayList<FlightOrderRefundSummary> arrayList) {
        this.summary = arrayList;
    }

    public OrderSummaryRefundFail getBooking_fail() {
        return this.booking_fail;
    }

    public void setBooking_fail(OrderSummaryRefundFail orderSummaryRefundFail) {
        this.booking_fail = orderSummaryRefundFail;
    }
}
