package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightJourney implements IJRDataModel {
    @b(a = "return")
    private CJRFlightReturnItem cjrFlightReturnItem;
    @b(a = "flights")
    private List<CJRFlightItem> flights = new ArrayList();
    @b(a = "refundable")
    private Boolean refundable;
    @b(a = "seller")
    private String seller;
    @b(a = "type")
    private String type;

    public CJRFlightReturnItem getCjrFlightReturnItem() {
        return this.cjrFlightReturnItem;
    }

    public void setCjrFlightReturnItem(CJRFlightReturnItem cJRFlightReturnItem) {
        this.cjrFlightReturnItem = cJRFlightReturnItem;
    }

    public List<CJRFlightItem> getFlights() {
        return this.flights;
    }

    public void setFlights(List<CJRFlightItem> list) {
        this.flights = list;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String str) {
        this.seller = str;
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
