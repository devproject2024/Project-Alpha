package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightMBRoute extends IJRPaytmDataModel {
    @b(a = "flight")
    private CJRFlightMBChargeFlightItem flight;
    @b(a = "modify_charges")
    private CJRFlightMBCharge modify_charges;
    @b(a = "passenger_info")
    private CJRFlightMBPassengerDetails passenger_info;

    public CJRFlightMBRoute() {
        this((CJRFlightMBChargeFlightItem) null, (CJRFlightMBCharge) null, (CJRFlightMBPassengerDetails) null, 7, (g) null);
    }

    public final CJRFlightMBChargeFlightItem getFlight() {
        return this.flight;
    }

    public final void setFlight(CJRFlightMBChargeFlightItem cJRFlightMBChargeFlightItem) {
        this.flight = cJRFlightMBChargeFlightItem;
    }

    public final CJRFlightMBCharge getModify_charges() {
        return this.modify_charges;
    }

    public final void setModify_charges(CJRFlightMBCharge cJRFlightMBCharge) {
        this.modify_charges = cJRFlightMBCharge;
    }

    public CJRFlightMBRoute(CJRFlightMBChargeFlightItem cJRFlightMBChargeFlightItem, CJRFlightMBCharge cJRFlightMBCharge, CJRFlightMBPassengerDetails cJRFlightMBPassengerDetails) {
        this.flight = cJRFlightMBChargeFlightItem;
        this.modify_charges = cJRFlightMBCharge;
        this.passenger_info = cJRFlightMBPassengerDetails;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBRoute(CJRFlightMBChargeFlightItem cJRFlightMBChargeFlightItem, CJRFlightMBCharge cJRFlightMBCharge, CJRFlightMBPassengerDetails cJRFlightMBPassengerDetails, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRFlightMBChargeFlightItem, (i2 & 2) != 0 ? null : cJRFlightMBCharge, (i2 & 4) != 0 ? null : cJRFlightMBPassengerDetails);
    }

    public final CJRFlightMBPassengerDetails getPassenger_info() {
        return this.passenger_info;
    }

    public final void setPassenger_info(CJRFlightMBPassengerDetails cJRFlightMBPassengerDetails) {
        this.passenger_info = cJRFlightMBPassengerDetails;
    }
}
