package com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRComboSeat extends IJRPaytmDataModel {
    private String[] description;
    private String icon;
    private String section_heading;
    private String sub_heading;

    public String getSub_heading() {
        return this.sub_heading;
    }

    public String getSection_heading() {
        return this.section_heading;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String[] getDescription() {
        return this.description;
    }

    public void setDescription(String[] strArr) {
        this.description = strArr;
    }
}
