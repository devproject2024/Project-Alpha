package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJREventsConvenienceFee extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "paytmCommission")
    private double paytmCommission;
    @b(a = "prices")
    private CJREventsPricesModel prices;
    @b(a = "tax")
    private ArrayList<CJRTaxInfo> taxList;
    private String ticketInfo;
    @b(a = "totalCommision")
    private double totalCommision;
    @b(a = "totalTax")
    private ArrayList<CJRTaxInfo> totalTaxList;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CJREventsPricesModel getPrices() {
        return this.prices;
    }

    public double getTotalCommision() {
        return this.totalCommision;
    }

    public double getPaytmCommission() {
        return this.paytmCommission;
    }

    public ArrayList<CJRTaxInfo> getTotalTaxList() {
        return this.totalTaxList;
    }

    public ArrayList<CJRTaxInfo> getTaxList() {
        return this.taxList;
    }

    public String getTicketInfo() {
        return this.ticketInfo;
    }

    public void setTicketInfo(String str) {
        this.ticketInfo = str;
    }

    public void setPrices(CJREventsPricesModel cJREventsPricesModel) {
        this.prices = cJREventsPricesModel;
    }
}
