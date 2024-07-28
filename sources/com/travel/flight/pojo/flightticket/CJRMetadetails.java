package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetadetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "arrival")
    private CJRFlightSRPMetaArrivalDeparture arrival;
    @b(a = "departure")
    private CJRFlightSRPMetaArrivalDeparture departure;
    @b(a = "display_sold_by")
    private Boolean displaySoldBy;
    @b(a = "enabled_features")
    CJRFlightEnabledFeatures enabledFeatures;
    @b(a = "isAndFlowEnabled")
    private boolean isAndFlowEnabled;
    @b(a = "price_list")
    private CJRPriceList mPriceListObj;
    @b(a = "requestid")
    private String mRequestId;
    @a
    @b(a = "seats_color_code")
    private ArrayList<CJRSeatsColorCode> mSeatsColorCode = null;
    @b(a = "tooltip_message")
    private String mToolTipMesage;
    @b(a = "modification_search_message")
    private ModifySearchMessage modifySearchMessage;
    @b(a = "multi_airline_messages")
    private g multiAirlineMessages;
    private FlightSearchResultMetaQuery query;

    public void setColorCode(ArrayList<CJRSeatsColorCode> arrayList) {
        this.mSeatsColorCode = arrayList;
    }

    public ArrayList<CJRSeatsColorCode> getSeatsColorCode() {
        return this.mSeatsColorCode;
    }

    public String getmRequestId() {
        return this.mRequestId;
    }

    public void setmRequestId(String str) {
        this.mRequestId = str;
    }

    public CJRPriceList getmPriceListObj() {
        return this.mPriceListObj;
    }

    public void setmPriceListObj(CJRPriceList cJRPriceList) {
        this.mPriceListObj = cJRPriceList;
    }

    public Boolean isDisplaySoldBy() {
        return this.displaySoldBy;
    }

    public void setDisplaySoldBy(Boolean bool) {
        this.displaySoldBy = bool;
    }

    public CJRFlightEnabledFeatures getEnabledFeatures() {
        return this.enabledFeatures;
    }

    public void setEnabledFeatures(CJRFlightEnabledFeatures cJRFlightEnabledFeatures) {
        this.enabledFeatures = cJRFlightEnabledFeatures;
    }

    public CJRFlightSRPMetaArrivalDeparture getmArrival() {
        return this.arrival;
    }

    public void setmArrival(CJRFlightSRPMetaArrivalDeparture cJRFlightSRPMetaArrivalDeparture) {
        this.arrival = cJRFlightSRPMetaArrivalDeparture;
    }

    public CJRFlightSRPMetaArrivalDeparture getmDeparture() {
        return this.departure;
    }

    public void setmDeparture(CJRFlightSRPMetaArrivalDeparture cJRFlightSRPMetaArrivalDeparture) {
        this.departure = cJRFlightSRPMetaArrivalDeparture;
    }

    public ModifySearchMessage getModifySearchMessage() {
        return this.modifySearchMessage;
    }

    public String getmToolTipMesage() {
        return this.mToolTipMesage;
    }

    public void setmToolTipMesage(String str) {
        this.mToolTipMesage = str;
    }

    public g getMultiAirlineMessages() {
        return this.multiAirlineMessages;
    }

    public void setMultiAirlineMessages(g gVar) {
        this.multiAirlineMessages = gVar;
    }

    public FlightSearchResultMetaQuery getQuery() {
        return this.query;
    }

    public void setQuery(FlightSearchResultMetaQuery flightSearchResultMetaQuery) {
        this.query = flightSearchResultMetaQuery;
    }

    public boolean isAndFlowEnabled() {
        return this.isAndFlowEnabled;
    }
}
