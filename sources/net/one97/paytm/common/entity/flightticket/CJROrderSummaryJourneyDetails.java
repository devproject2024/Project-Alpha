package net.one97.paytm.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryJourneyDetails implements IJRDataModel {
    private String flight_id;
    private ArrayList<CJROrderSummaryFlights> flights;
    private String refundable;
    private String seller;
    private String type;

    public String getRefundable() {
        return this.refundable;
    }

    public void setRefundable(String str) {
        this.refundable = str;
    }

    public ArrayList<CJROrderSummaryFlights> getFlights() {
        return this.flights;
    }

    public void setFlights(ArrayList<CJROrderSummaryFlights> arrayList) {
        this.flights = arrayList;
    }

    public String getFlight_id() {
        return this.flight_id;
    }

    public void setFlight_id(String str) {
        this.flight_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String str) {
        this.seller = str;
    }

    public String toString() {
        return "ClassPojo [refundable = " + this.refundable + ", flights = " + this.flights + ", flight_id = " + this.flight_id + ", type = " + this.type + ", seller = " + this.seller + "]";
    }
}
