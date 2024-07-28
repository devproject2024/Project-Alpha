package net.one97.paytm.common.entity.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryMetaDataResponse implements IJRDataModel {
    @b(a = "baggage_unit")
    private String baggageUnit;
    @b(a = "hops")
    private ArrayList<CJRAncillaryOrderHopsDetails> hops;
    @b(a = "total_ancillary_price")
    private double totalAncillaryPrice;
    @b(a = "total_baggage_weight")
    private int total_baggage_weight;

    public double getTotalAncillaryPrice() {
        return this.totalAncillaryPrice;
    }

    public void setTotalAncillaryPrice(double d2) {
        this.totalAncillaryPrice = d2;
    }

    public int getTotal_baggage_weight() {
        return this.total_baggage_weight;
    }

    public void setTotal_baggage_weight(int i2) {
        this.total_baggage_weight = i2;
    }

    public String getBaggageUnit() {
        return this.baggageUnit;
    }

    public void setBaggageUnit(String str) {
        this.baggageUnit = str;
    }

    public ArrayList<CJRAncillaryOrderHopsDetails> getHops() {
        return this.hops;
    }

    public void setHops(ArrayList<CJRAncillaryOrderHopsDetails> arrayList) {
        this.hops = arrayList;
    }
}
