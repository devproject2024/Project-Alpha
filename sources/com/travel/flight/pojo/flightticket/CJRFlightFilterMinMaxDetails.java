package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightFilterMinMaxDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "airlineNames")
    private Map<String, String> airlineNames = new HashMap();
    @b(a = "arrival")
    private CJRFlightSRPMetaArrivalDeparture arrival;
    @b(a = "departure")
    private CJRFlightSRPMetaArrivalDeparture departure;
    @b(a = "airlines")
    private String[] mAirlines;
    @b(a = "card_info")
    private ArrayList<CJRFlightCardInfo> mCardInfo;
    @b(a = "duration")
    private CJRFilterMinMaxItem mDuration;
    @b(a = "fare_config")
    private c mFareConfig;
    @b(a = "filters_and_banners_info")
    private ArrayList<CJRFilterAndBannerInfoItem> mFilterAndBannerInfo;
    @b(a = "price")
    private CJRFilterMinMaxItem mPrice;
    @b(a = "provider_order")
    private ArrayList<String> mServiceProviderName;
    @b(a = "stops")
    private CJRFilterMinMaxItem mStops;
    @b(a = "tab_items")
    private ArrayList<Object> mTabitems;

    public void setCardInfo(ArrayList<CJRFlightCardInfo> arrayList) {
        this.mCardInfo = arrayList;
    }

    public ArrayList<CJRFlightCardInfo> getCardInfo() {
        return this.mCardInfo;
    }

    public void setFilterAndBannerInfo(ArrayList<CJRFilterAndBannerInfoItem> arrayList) {
        this.mFilterAndBannerInfo = arrayList;
    }

    public ArrayList<CJRFilterAndBannerInfoItem> getFilterAndBannerInfo() {
        return this.mFilterAndBannerInfo;
    }

    public ArrayList<String> getmServiceProviderName() {
        return this.mServiceProviderName;
    }

    public void setmServiceProviderName(ArrayList<String> arrayList) {
        this.mServiceProviderName = arrayList;
    }

    public CJRFilterMinMaxItem getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(CJRFilterMinMaxItem cJRFilterMinMaxItem) {
        this.mPrice = cJRFilterMinMaxItem;
    }

    public CJRFilterMinMaxItem getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(CJRFilterMinMaxItem cJRFilterMinMaxItem) {
        this.mDuration = cJRFilterMinMaxItem;
    }

    public CJRFilterMinMaxItem getmStops() {
        return this.mStops;
    }

    public void setmStops(CJRFilterMinMaxItem cJRFilterMinMaxItem) {
        this.mStops = cJRFilterMinMaxItem;
    }

    public String[] getmAirlines() {
        return this.mAirlines;
    }

    public void setmAirlines(String[] strArr) {
        this.mAirlines = strArr;
    }

    public c getmFareConfig() {
        return this.mFareConfig;
    }

    public void setmFareConfig(c cVar) {
        this.mFareConfig = cVar;
    }

    public ArrayList<Object> getmTabitems() {
        return this.mTabitems;
    }

    public void setmTabitems(ArrayList<Object> arrayList) {
        this.mTabitems = arrayList;
    }

    public CJRFlightSRPMetaArrivalDeparture getArrival() {
        return this.arrival;
    }

    public void setArrival(CJRFlightSRPMetaArrivalDeparture cJRFlightSRPMetaArrivalDeparture) {
        this.arrival = cJRFlightSRPMetaArrivalDeparture;
    }

    public CJRFlightSRPMetaArrivalDeparture getDeparture() {
        return this.departure;
    }

    public void setDeparture(CJRFlightSRPMetaArrivalDeparture cJRFlightSRPMetaArrivalDeparture) {
        this.departure = cJRFlightSRPMetaArrivalDeparture;
    }

    public Map<String, String> getAirlineNames() {
        return this.airlineNames;
    }
}
