package com.travel.flight.pojo.seatancillaryentity;

import android.view.View;
import java.io.Serializable;

public final class a implements Serializable {
    private b CJRSeatInfo;
    private int travellerSelection;
    private View view;

    public final View getView() {
        return this.view;
    }

    public final void setView(View view2) {
        this.view = view2;
    }

    public final b getCJRSeatInfo() {
        return this.CJRSeatInfo;
    }

    public final void setCJRSeatInfo(b bVar) {
        this.CJRSeatInfo = bVar;
    }

    public final int getTravellerSelection() {
        return this.travellerSelection;
    }

    public final void setTravellerSelection(int i2) {
        this.travellerSelection = i2;
    }
}
