package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightReturnItem implements IJRDataModel {
    @b(a = "flights")
    private List<CJRFlightItem> flights = new ArrayList();
    @b(a = "refundable")
    private Boolean refundable;
    @b(a = "type")
    private String type;

    public List<CJRFlightItem> getFlights() {
        return this.flights;
    }

    public void setFlights(List<CJRFlightItem> list) {
        this.flights = list;
    }

    public Boolean getRefundable() {
        return this.refundable;
    }

    public void setRefundable(Boolean bool) {
        this.refundable = bool;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
