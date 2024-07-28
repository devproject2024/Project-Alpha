package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventCPInsuranceDetail implements IJRDataModel {
    @b(a = "insurance_id")
    private int insuranceId;
    @b(a = "premium")
    private int premium;
    @b(a = "price")
    private int price;
    @b(a = "premium_tax_details")
    private CJREventCPPremiumTaxDetail taxDetail;
    @b(a = "ticket_id")
    private long ticketId;

    public long getTicketId() {
        return this.ticketId;
    }

    public int getInsuranceId() {
        return this.insuranceId;
    }

    public int getPremium() {
        return this.premium;
    }

    public CJREventCPPremiumTaxDetail getTaxDetail() {
        return this.taxDetail;
    }

    public int getPrice() {
        return this.price;
    }
}
