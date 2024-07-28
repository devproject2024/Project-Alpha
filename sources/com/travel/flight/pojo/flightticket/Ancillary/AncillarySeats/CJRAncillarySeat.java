package com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAncillarySeat extends IJRPaytmDataModel {
    @b(a = "description")
    private String description;
    @b(a = "icon")
    private String icon;

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
