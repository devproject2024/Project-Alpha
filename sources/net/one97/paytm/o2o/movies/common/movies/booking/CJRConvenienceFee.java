package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJRConvenienceFee extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "tax")
    private ArrayList<CJRTaxInfo> taxList;
    @b(a = "totalCommision")
    private String totalCommision;
    @b(a = "totalTax")
    private ArrayList<CJRTaxInfo> totalTaxList;

    public String getTotalCommision() {
        return this.totalCommision;
    }

    public void setTotalCommision(String str) {
        this.totalCommision = str;
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
}
