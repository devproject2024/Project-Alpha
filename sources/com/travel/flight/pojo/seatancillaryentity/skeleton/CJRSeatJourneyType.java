package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRSeatJourneyType extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "destination")
    private final String destination;
    @a
    @b(a = "flight_number")
    private final String flightNumber;
    @a
    @b(a = "is_combo_available")
    private final boolean isCombinationAvailable;
    @a
    @b(a = "lower")
    private final CJRSeatDeckType lower;
    @a
    @b(a = "origin")
    private final String origin;
    @a
    @b(a = "pre_select")
    private final ArrayList<com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.a> preselects;
    @a
    @b(a = "upper")
    private final CJRSeatDeckType upper;

    public CJRSeatJourneyType(String str, String str2, String str3, CJRSeatDeckType cJRSeatDeckType, CJRSeatDeckType cJRSeatDeckType2, ArrayList<com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.a> arrayList, boolean z) {
        this.flightNumber = str;
        this.origin = str2;
        this.destination = str3;
        this.lower = cJRSeatDeckType;
        this.upper = cJRSeatDeckType2;
        this.preselects = arrayList;
        this.isCombinationAvailable = z;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public CJRSeatDeckType getLower() {
        return this.lower;
    }

    public CJRSeatDeckType getUpper() {
        return this.upper;
    }

    public ArrayList<com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.a> getPreselects() {
        return this.preselects;
    }

    public boolean isCombinationAvailable() {
        return this.isCombinationAvailable;
    }
}
