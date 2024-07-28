package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryAllStates implements IJRDataModel {
    private String ancillary;
    private int booking;
    private String cashback;
    private String cp;
    private String pymnt_summary;
    private String refund;
    private String travel_insurance;

    public int getBooking() {
        return this.booking;
    }

    public void setBooking(int i2) {
        this.booking = i2;
    }

    public String getTravel_insurance() {
        return this.travel_insurance;
    }

    public void setTravel_insurance(String str) {
        this.travel_insurance = str;
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public String getPymnt_summary() {
        return this.pymnt_summary;
    }

    public void setPymnt_summary(String str) {
        this.pymnt_summary = str;
    }

    public String getRefund() {
        return this.refund;
    }

    public void setRefund(String str) {
        this.refund = str;
    }

    public String getCashback() {
        return this.cashback;
    }

    public void setCashback(String str) {
        this.cashback = str;
    }

    public String getAncillary() {
        return this.ancillary;
    }

    public void setAncillary(String str) {
        this.ancillary = str;
    }

    public String toString() {
        return "ClassPojo [booking = " + this.booking + ", travel_insurance = " + this.travel_insurance + ", cp = " + this.cp + ", pymnt_summary = " + this.pymnt_summary + ", refund = " + this.refund + ", cashback = " + this.cashback + ", ancillary = " + this.ancillary + "]";
    }
}
