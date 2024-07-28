package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventCPPremiumTaxDetail implements IJRDataModel {
    @b(a = "cgst")
    private double cgst;
    @b(a = "net_premium")
    private String netPremium;
    @b(a = "sgst")
    private double sgst;
    @b(a = "total_premium")
    private int totalPremium;

    public int getTotalPremium() {
        return this.totalPremium;
    }

    public String getNetPremium() {
        return this.netPremium;
    }

    public double getCgst() {
        return this.cgst;
    }

    public double getSgst() {
        return this.sgst;
    }
}
