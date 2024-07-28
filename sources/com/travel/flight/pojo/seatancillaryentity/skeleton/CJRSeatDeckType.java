package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvail;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatPClass;
import java.util.HashMap;

public class CJRSeatDeckType extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "widgets")
    private final CJRSeatWidgets CJRSeatWidgets;
    @a
    @b(a = "availability")
    private final HashMap<String, CJRSeatAvail> availabilty;
    @a
    @b(a = "groups")
    private final HashMap<String, CJRSeatPClass> groups;
    @a
    @b(a = "meta")
    private final CJRSeatWidgetMeta meta;

    public CJRSeatDeckType(CJRSeatWidgets cJRSeatWidgets, CJRSeatWidgetMeta cJRSeatWidgetMeta, HashMap<String, CJRSeatAvail> hashMap, HashMap<String, CJRSeatPClass> hashMap2) {
        this.CJRSeatWidgets = cJRSeatWidgets;
        this.meta = cJRSeatWidgetMeta;
        this.availabilty = hashMap;
        this.groups = hashMap2;
    }

    public CJRSeatWidgets getCJRSeatWidgets() {
        return this.CJRSeatWidgets;
    }

    public CJRSeatWidgetMeta getWidgetMeta() {
        return this.meta;
    }

    public HashMap<String, CJRSeatAvail> getAvailibility() {
        return this.availabilty;
    }

    public HashMap<String, CJRSeatPClass> getGroups() {
        return this.groups;
    }

    public String toString() {
        return "Lower{widgets=" + this.CJRSeatWidgets + ", meta=" + this.meta + ", availabilty=" + this.availabilty + '}';
    }
}
