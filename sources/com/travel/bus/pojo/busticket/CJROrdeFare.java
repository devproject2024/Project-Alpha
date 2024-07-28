package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrdeFare implements IJRDataModel {
    @b(a = "base_fare")
    private String baseFare;
    @b(a = "conv_fee")
    private String convFee;
    @b(a = "grand_total")
    private String grandTotal;
    @b(a = "insurance_fee")
    private String insuranceFee;
    @b(a = "operator_discount")
    public String operatorDiscount;
    @b(a = "gst")
    public String operatorGst;
    @b(a = "other_fee")
    public String otherFee;
    @b(a = "tax")
    private String tax;

    public String getBaseFare() {
        return this.baseFare;
    }

    public String getConvFee() {
        return this.convFee;
    }

    public String getGrandTotal() {
        return this.grandTotal;
    }

    public String getInsuranceFee() {
        return this.insuranceFee;
    }

    public String getTax() {
        return this.tax;
    }
}
