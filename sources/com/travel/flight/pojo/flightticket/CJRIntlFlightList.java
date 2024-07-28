package com.travel.flight.pojo.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIntlFlightList implements Cloneable, IJRDataModel {
    private ArrayList<CJRIntlFlightMapping> childItems;
    private String mDisplayPrice;
    private CJRIntlFlightMapping mFlightMapping;
    private ArrayList<CJRFlightDetailsItem> mIntOnwardFlightList;
    private ArrayList<CJRFlightDetailsItem> mIntReturnFlightList;
    private CJRIntlFlightPricing mMappedPrice;
    private CJRFlightDetailsItem mOnwardFlights;
    private String mParentIdForChildBucket;
    private CJRFlightDetailsItem mReturnFlights;
    private String mTotalPrice;

    public CJRIntlFlightMapping getmFlightMapping() {
        return this.mFlightMapping;
    }

    public void setmFlightMapping(CJRIntlFlightMapping cJRIntlFlightMapping) {
        this.mFlightMapping = cJRIntlFlightMapping;
    }

    public CJRIntlFlightPricing getMappedPrice() {
        return this.mMappedPrice;
    }

    public void setMappedPrice(CJRIntlFlightPricing cJRIntlFlightPricing) {
        this.mMappedPrice = cJRIntlFlightPricing;
    }

    public CJRFlightDetailsItem getmOnwardFlights() {
        return this.mOnwardFlights;
    }

    public void setmOnwardFlights(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.mOnwardFlights = cJRFlightDetailsItem;
    }

    public CJRFlightDetailsItem getmReturnFlights() {
        return this.mReturnFlights;
    }

    public void setmReturnFlights(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.mReturnFlights = cJRFlightDetailsItem;
    }

    public String getmTotalPrice() {
        return this.mTotalPrice;
    }

    public String getmDisplayPrice() {
        return this.mDisplayPrice;
    }

    public void setmDisplayPrice(String str) {
        this.mDisplayPrice = str;
    }

    public void setmTotalPrice(String str) {
        this.mTotalPrice = str;
    }

    public ArrayList<CJRFlightDetailsItem> getmIntOnwardFlightList() {
        return this.mIntOnwardFlightList;
    }

    public void setmIntOnwardFlightList(ArrayList<CJRFlightDetailsItem> arrayList) {
        this.mIntOnwardFlightList = arrayList;
    }

    public ArrayList<CJRFlightDetailsItem> getmIntReturnFlightList() {
        return this.mIntReturnFlightList;
    }

    public void setmIntReturnFlightList(ArrayList<CJRFlightDetailsItem> arrayList) {
        this.mIntReturnFlightList = arrayList;
    }

    public ArrayList<CJRIntlFlightMapping> getChildItems() {
        return this.childItems;
    }

    public void setChildItems(ArrayList<CJRIntlFlightMapping> arrayList) {
        this.childItems = arrayList;
    }

    public void setParentIdForChildBucket(String str) {
        this.mParentIdForChildBucket = str;
    }

    public String getParentIdForChildBucket() {
        return this.mParentIdForChildBucket;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
