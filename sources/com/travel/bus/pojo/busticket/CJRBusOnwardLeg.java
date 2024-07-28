package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.travel.bus.pojo.bussearch.CJRDealDecorator;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOnwardLeg implements IJRDataModel {
    @b(a = "block_expiry_time")
    private int blockExpiryTime;
    @b(a = "block_key")
    private String blockKey;
    @b(a = "deal_text_obj")
    public CJRDealDecorator dealTextObj;
    @b(a = "fare_breakup")
    private CJRBusFareBreakUp fareBreakup;
    @b(a = "other_tax_details")
    private List<CJRTaxItem> otherTaxDetails = null;
    @b(a = "tax_details")
    private List<CJRTaxItem> taxDetails = null;
    @b(a = "total_base_fare")
    private double totalBaseFare;
    @b(a = "total_fare")
    private double totalFare;
    @b(a = "total_tax")
    private double totalTax;
    @b(a = "travel_date")
    private String travelDate;

    public String getBlockKey() {
        return this.blockKey;
    }

    public void setBlockKey(String str) {
        this.blockKey = str;
    }

    public int getBlockExpiryTime() {
        return this.blockExpiryTime;
    }

    public void setBlockExpiryTime(int i2) {
        this.blockExpiryTime = i2;
    }

    public double getTotalFare() {
        return this.totalFare;
    }

    public void setTotalFare(double d2) {
        this.totalFare = d2;
    }

    public double getTotalBaseFare() {
        return this.totalBaseFare;
    }

    public void setTotalBaseFare(double d2) {
        this.totalBaseFare = d2;
    }

    public double getTotalTax() {
        return this.totalTax;
    }

    public void setTotalTax(double d2) {
        this.totalTax = d2;
    }

    public List<CJRTaxItem> getTaxDetails() {
        return this.taxDetails;
    }

    public void setTaxDetails(List<CJRTaxItem> list) {
        this.taxDetails = list;
    }

    public List<CJRTaxItem> getOtherTaxDetails() {
        return this.otherTaxDetails;
    }

    public void setOtherTaxDetails(List<CJRTaxItem> list) {
        this.otherTaxDetails = list;
    }

    public CJRBusFareBreakUp getFareBreakup() {
        return this.fareBreakup;
    }

    public void setFareBreakup(CJRBusFareBreakUp cJRBusFareBreakUp) {
        this.fareBreakup = cJRBusFareBreakUp;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
    }
}
