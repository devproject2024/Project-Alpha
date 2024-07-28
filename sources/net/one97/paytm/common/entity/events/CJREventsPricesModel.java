package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJREventsPricesModel implements IJRDataModel {
    @b(a = "deliveryCharges")
    private CJRTaxInfo deliveryCharges;
    @b(a = "F_B")
    private CJREventsFnBModel fnb;
    @b(a = "grandConvFee")
    private CJREventsGrandConvenienceFeeModel grandConvFee;
    @b(a = "grantTotal")
    private CJRTaxInfo grantTotal;
    @b(a = "merchandise")
    private CJREventsMerchandiseModel merchandise;
    @b(a = "ticket")
    private CJREventsTicketModel ticket;

    public CJREventsTicketModel getTicket() {
        return this.ticket;
    }

    public CJREventsFnBModel getFnb() {
        return this.fnb;
    }

    public CJREventsMerchandiseModel getMerchandise() {
        return this.merchandise;
    }

    public CJREventsGrandConvenienceFeeModel getGrandConvFee() {
        return this.grandConvFee;
    }

    public CJRTaxInfo getDeliveryCharges() {
        return this.deliveryCharges;
    }

    public CJRTaxInfo getGrantTotal() {
        return this.grantTotal;
    }
}
