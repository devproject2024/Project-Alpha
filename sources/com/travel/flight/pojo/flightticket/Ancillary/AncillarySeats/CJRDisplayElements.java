package com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRDisplayElements extends IJRPaytmDataModel {
    private CJRComboSeat[] combo_seat;
    private CJRAncillarySeat seat;

    public CJRAncillarySeat getSeat() {
        return this.seat;
    }

    public void setSeat(CJRAncillarySeat cJRAncillarySeat) {
        this.seat = cJRAncillarySeat;
    }

    public CJRComboSeat[] getCombo_seat() {
        return this.combo_seat;
    }
}
