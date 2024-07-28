package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConvenienceFeeDetail implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "pax_number")
    private String mPaxNumber;
    @b(a = "total_conv_fee")
    private String mTotalConvFee;
    @b(a = "text")
    private ArrayList<String> mtext = new ArrayList<>();

    public String getmConvFee() {
        return this.mConvFee;
    }

    public void setmConvFee(String str) {
        this.mConvFee = str;
    }

    public String getmPaxNumber() {
        return this.mPaxNumber;
    }

    public void setmPaxNumber(String str) {
        this.mPaxNumber = str;
    }

    public String getmTotalConvFee() {
        return this.mTotalConvFee;
    }

    public void setmTotalConvFee(String str) {
        this.mTotalConvFee = str;
    }

    public ArrayList<String> getMtext() {
        return this.mtext;
    }

    public void setMtext(ArrayList<String> arrayList) {
        this.mtext = arrayList;
    }

    public void setMtext(String str) {
        this.mtext.add(str);
    }
}
