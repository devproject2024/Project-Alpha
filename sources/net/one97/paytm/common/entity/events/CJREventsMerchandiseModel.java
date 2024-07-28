package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJREventsMerchandiseModel implements IJRDataModel {
    @b(a = "basePrice")
    private CJRTaxInfo basePrice;
    @b(a = "convFeeBreakUp")
    private ArrayList<CJRTaxInfo> convFeeBreakUp;
    @b(a = "heading")
    private String heading;
    @b(a = "items")
    private ArrayList<CJREventsItemDetail> items;
    @b(a = "taxBreakup")
    private ArrayList<CJRTaxInfo> taxBreakup;
    @b(a = "totalCommission")
    private CJRTaxInfo totalCommission;
    @b(a = "totalPrice")
    private CJRTaxInfo totalPrice;
    @b(a = "totalTax")
    private CJRTaxInfo totalTax;

    public CJRTaxInfo getTotalPrice() {
        return this.totalPrice;
    }

    public CJRTaxInfo getBasePrice() {
        return this.basePrice;
    }

    public CJRTaxInfo getTotalCommission() {
        return this.totalCommission;
    }

    public CJRTaxInfo getTotalTax() {
        return this.totalTax;
    }

    public ArrayList<CJRTaxInfo> getTaxBreakup() {
        return this.taxBreakup;
    }

    public ArrayList<CJRTaxInfo> getConvFeeBreakUp() {
        return this.convFeeBreakUp;
    }

    public String getHeading() {
        return this.heading;
    }

    public ArrayList<CJREventsItemDetail> getItems() {
        return this.items;
    }
}
