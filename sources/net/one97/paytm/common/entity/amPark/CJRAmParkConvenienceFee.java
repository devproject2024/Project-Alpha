package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJRAmParkConvenienceFee extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "paytmCommission")
    private double paytmCommission;
    @b(a = "tax")
    private ArrayList<CJRTaxInfo> taxList;
    @b(a = "totalCommision")
    private double totalCommision;
    @b(a = "totalTax")
    private ArrayList<CJRTaxInfo> totalTaxList;

    public double getPaytmCommission() {
        return this.paytmCommission;
    }

    public void setPaytmCommission(double d2) {
        this.paytmCommission = d2;
    }

    public ArrayList<CJRTaxInfo> getTotalTaxList() {
        return this.totalTaxList;
    }

    public void setTotalTaxList(ArrayList<CJRTaxInfo> arrayList) {
        this.totalTaxList = arrayList;
    }

    public ArrayList<CJRTaxInfo> getTaxList() {
        return this.taxList;
    }

    public void setTaxList(ArrayList<CJRTaxInfo> arrayList) {
        this.taxList = arrayList;
    }

    public double getTotalCommision() {
        return this.totalCommision;
    }

    public void setTotalCommision(double d2) {
        this.totalCommision = d2;
    }
}
