package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryFareDetails implements IJRDataModel {
    private String cgst;
    private String convenience_fee;
    private String grand_total;
    private String gst_state_of_residence;
    private String gstno;
    private String price;
    private String sgst;
    private String tax;
    private CJROrderSummaryTaxBreakUpFareDetails tax_break_up;

    public CJROrderSummaryTaxBreakUpFareDetails getTax_break_up() {
        return this.tax_break_up;
    }

    public void setTax_break_up(CJROrderSummaryTaxBreakUpFareDetails cJROrderSummaryTaxBreakUpFareDetails) {
        this.tax_break_up = cJROrderSummaryTaxBreakUpFareDetails;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String str) {
        this.tax = str;
    }

    public String getCgst() {
        return this.cgst;
    }

    public void setCgst(String str) {
        this.cgst = str;
    }

    public String getGst_state_of_residence() {
        return this.gst_state_of_residence;
    }

    public void setGst_state_of_residence(String str) {
        this.gst_state_of_residence = str;
    }

    public String getSgst() {
        return this.sgst;
    }

    public void setSgst(String str) {
        this.sgst = str;
    }

    public String getGstno() {
        return this.gstno;
    }

    public void setGstno(String str) {
        this.gstno = str;
    }

    public String getConvenience_fee() {
        return this.convenience_fee;
    }

    public void setConvenience_fee(String str) {
        this.convenience_fee = str;
    }

    public String getGrand_total() {
        return this.grand_total;
    }

    public void setGrand_total(String str) {
        this.grand_total = str;
    }
}
