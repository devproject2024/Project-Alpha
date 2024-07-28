package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySSRSBaggageDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRAncillarySSRSBaggageItem> items;
    @b(a = "notes")
    private ArrayList<String> notes;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRAncillarySSRSBaggageItem> getItems() {
        return this.items;
    }

    public String getNotes() {
        ArrayList<String> arrayList = this.notes;
        return (arrayList == null || arrayList.size() <= 0) ? "" : this.notes.get(0);
    }
}
