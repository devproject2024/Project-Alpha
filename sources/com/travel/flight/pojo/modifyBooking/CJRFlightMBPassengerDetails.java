package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class CJRFlightMBPassengerDetails extends IJRPaytmDataModel {
    @b(a = "notes")
    private List<String> notes;
    @b(a = "passenger_details")
    private List<CJRFlightMBPassenger> passenger_details;
    @b(a = "title")
    private String title;

    public CJRFlightMBPassengerDetails() {
        this((String) null, (List) null, (List) null, 7, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<String> getNotes() {
        return this.notes;
    }

    public final void setNotes(List<String> list) {
        this.notes = list;
    }

    public CJRFlightMBPassengerDetails(String str, List<String> list, List<CJRFlightMBPassenger> list2) {
        this.title = str;
        this.notes = list;
        this.passenger_details = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBPassengerDetails(String str, List list, List list2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2);
    }

    public final List<CJRFlightMBPassenger> getPassenger_details() {
        return this.passenger_details;
    }

    public final void setPassenger_details(List<CJRFlightMBPassenger> list) {
        this.passenger_details = list;
    }
}
