package com.travel.flight.pojo.flightticket.Ancillary.request;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySsrsReqBody implements IJRDataModel {
    @c(a = "items")
    private ArrayList<CJRAncillarySelectedItem> items = new ArrayList<>();
    @c(a = "passenger_id")
    private int passenger_id = 0;

    public int getPassenger_id() {
        int i2 = this.passenger_id;
        return i2 > 0 ? i2 - 1 : i2;
    }

    public void setPassenger_id(int i2) {
        this.passenger_id = i2 + 1;
    }

    public ArrayList<CJRAncillarySelectedItem> getItems() {
        return this.items;
    }

    public void setItems(CJRAncillarySelectedItem cJRAncillarySelectedItem) {
        this.items.add(cJRAncillarySelectedItem);
    }
}
