package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConvenienceFee implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "adult")
    private CJRConvenienceFeeDetail adultDetail;
    @b(a = "child")
    private CJRConvenienceFeeDetail childDetail;
    @b(a = "infant")
    private CJRConvenienceFeeDetail infantDetail;
    @b(a = "notes")
    private ArrayList<String> mNotes = new ArrayList<>();
    @b(a = "order_conv_fee")
    private Double mtotalConFee;

    public static long getSerialVersionUID() {
        return 1;
    }

    public Double getMtotalConFee() {
        return this.mtotalConFee;
    }

    public void setMtotalConFee(double d2) {
        this.mtotalConFee = Double.valueOf(d2);
    }

    public ArrayList<String> getmNotes() {
        return this.mNotes;
    }

    public void setmNotes(ArrayList<String> arrayList) {
        this.mNotes = arrayList;
    }

    public void setmNotes(String str) {
        this.mNotes.add(str);
    }

    public CJRConvenienceFeeDetail getAdultDetail() {
        return this.adultDetail;
    }

    public void setAdultDetail(CJRConvenienceFeeDetail cJRConvenienceFeeDetail) {
        this.adultDetail = cJRConvenienceFeeDetail;
    }

    public CJRConvenienceFeeDetail getChildDetail() {
        return this.childDetail;
    }

    public void setChildDetail(CJRConvenienceFeeDetail cJRConvenienceFeeDetail) {
        this.childDetail = cJRConvenienceFeeDetail;
    }

    public CJRConvenienceFeeDetail getInfantDetail() {
        return this.infantDetail;
    }

    public void setInfantDetail(CJRConvenienceFeeDetail cJRConvenienceFeeDetail) {
        this.infantDetail = cJRConvenienceFeeDetail;
    }
}
