package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusTicketFareDetails implements IJRDataModel {
    @b(a = "tax_details")
    private List<CJRTaxItem> taxDetails = null;

    public List<CJRTaxItem> getTaxDetails() {
        return this.taxDetails;
    }
}
