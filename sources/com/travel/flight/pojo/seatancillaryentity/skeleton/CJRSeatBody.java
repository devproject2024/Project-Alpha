package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatNotes;
import java.util.List;

public class CJRSeatBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "notes")
    private final CJRSeatNotes CJRSeatNotes;
    @a
    @b(a = "onward")
    private final List<CJRSeatJourneyType> onward;
    @a
    @b(a = "return")
    private final List<CJRSeatJourneyType> return_;

    public CJRSeatBody(List<CJRSeatJourneyType> list, List<CJRSeatJourneyType> list2, CJRSeatNotes cJRSeatNotes) {
        this.onward = list;
        this.return_ = list2;
        this.CJRSeatNotes = cJRSeatNotes;
    }

    public List<CJRSeatJourneyType> getOnward() {
        return this.onward;
    }

    public CJRSeatNotes getCJRSeatNotes() {
        return this.CJRSeatNotes;
    }

    public List<CJRSeatJourneyType> getReturn_() {
        return this.return_;
    }
}
