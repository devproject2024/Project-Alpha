package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRSeatWidgets extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "exits")
    private final List<CJRSeatExit> CJRSeatExits;
    @a
    @b(a = "texts")
    private final List<CJRSeatText> CJRSeatTexts;
    @a
    @b(a = "wings")
    private final List<CJRSeatWing> CJRSeatWings;
    @a
    @b(a = "seats")
    private final List<CJRSeat> CJRSeats;

    public CJRSeatWidgets(List<CJRSeat> list, List<CJRSeatExit> list2, List<CJRSeatText> list3, List<CJRSeatWing> list4) {
        this.CJRSeats = list;
        this.CJRSeatExits = list2;
        this.CJRSeatTexts = list3;
        this.CJRSeatWings = list4;
    }

    public List<CJRSeat> getCJRSeats() {
        return this.CJRSeats;
    }

    public List<CJRSeatExit> getCJRSeatExits() {
        return this.CJRSeatExits;
    }

    public List<CJRSeatText> getCJRSeatTexts() {
        return this.CJRSeatTexts;
    }

    public List<CJRSeatWing> getCJRSeatWings() {
        return this.CJRSeatWings;
    }
}
