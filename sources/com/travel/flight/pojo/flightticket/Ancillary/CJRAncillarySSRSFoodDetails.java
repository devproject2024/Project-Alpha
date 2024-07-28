package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySSRSFoodDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRAncillarySSRSFoodItem> items;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRAncillarySSRSFoodItem> getItems() {
        return this.items;
    }
}
