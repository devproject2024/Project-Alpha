package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRepriceFlightFare implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "breakup")
    private List<Object> breakup = new ArrayList();
    @b(a = "convenience_fee")
    private CJRConvenienceFee mConvenienceFee;
    @b(a = "totaltax")
    private String mTax;
    @b(a = "totalfare")
    private String mTotalFare;
    private String mTotalFee;
    @b(a = "totalModifyCharges")
    private Integer totalModifyCharges;

    public String getmTotalFare() {
        return this.mTotalFare;
    }

    public void setmTotalFare(String str) {
        this.mTotalFare = str;
    }

    public String getmTax() {
        return this.mTax;
    }

    public void setmTax(String str) {
        this.mTax = str;
    }

    public String getTotalFee() {
        return this.mTotalFee;
    }

    public void setTotalFee(String str) {
        this.mTotalFee = str;
    }

    public List<Object> getBreakup() {
        return this.breakup;
    }

    public void setBreakup(List<Object> list) {
        this.breakup = list;
    }

    public CJRConvenienceFee getmConvenienceFee() {
        return this.mConvenienceFee;
    }

    public Integer getTotalModifyCharges() {
        return this.totalModifyCharges;
    }

    public void setmConvenienceFee(CJRConvenienceFee cJRConvenienceFee) {
        this.mConvenienceFee = cJRConvenienceFee;
    }
}
