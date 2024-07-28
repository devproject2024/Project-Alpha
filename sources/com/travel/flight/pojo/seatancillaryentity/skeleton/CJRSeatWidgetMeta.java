package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRSeatWidgetMeta extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "images")
    private CJRSeatImages CJRSeatImages;
    @a
    @b(a = "layout")
    private CJRSeatLayout CJRSeatLayout;
    @a
    @b(a = "aircraft_type")
    private String aircraftType;
    @a
    @b(a = "seat_types")
    private HashMap<String, CJRSeatLayout> seatTypes;
    @a
    @b(a = "show_column_number")
    private Boolean showColumnNumber;
    @a
    @b(a = "show_row_number")
    private Boolean showRowNumber;

    public Boolean getShowRowNumber() {
        return this.showRowNumber;
    }

    public void setShowRowNumber(Boolean bool) {
        this.showRowNumber = bool;
    }

    public Boolean getShowColumnNumber() {
        return this.showColumnNumber;
    }

    public void setShowColumnNumber(Boolean bool) {
        this.showColumnNumber = bool;
    }

    public String getAircraftType() {
        return this.aircraftType;
    }

    public void setAircraftType(String str) {
        this.aircraftType = str;
    }

    public CJRSeatImages getCJRSeatImages() {
        return this.CJRSeatImages;
    }

    public void setCJRSeatImages(CJRSeatImages cJRSeatImages) {
        this.CJRSeatImages = cJRSeatImages;
    }

    public HashMap<String, CJRSeatLayout> getSeatTypes() {
        return this.seatTypes;
    }

    public void setSeatTypes(HashMap<String, CJRSeatLayout> hashMap) {
        this.seatTypes = hashMap;
    }

    public CJRSeatLayout getCJRSeatLayout() {
        return this.CJRSeatLayout;
    }

    public void setCJRSeatLayout(CJRSeatLayout cJRSeatLayout) {
        this.CJRSeatLayout = cJRSeatLayout;
    }
}
