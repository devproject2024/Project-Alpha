package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightMBTravelerCharges extends IJRPaytmDataModel {
    @b(a = "modification_charge")
    private int modificationCharge;
    @b(a = "paytm_modification_convenience")
    private int paytm_modification_convenience;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBTravelerCharges(int i2, int i3, int i4, g gVar) {
        this((i4 & 1) != 0 ? 0 : i2, i3);
    }

    public final int getModificationCharge() {
        return this.modificationCharge;
    }

    public final void setModificationCharge(int i2) {
        this.modificationCharge = i2;
    }

    public CJRFlightMBTravelerCharges(int i2, int i3) {
        this.modificationCharge = i2;
        this.paytm_modification_convenience = i3;
    }

    public final int getPaytm_modification_convenience() {
        return this.paytm_modification_convenience;
    }

    public final void setPaytm_modification_convenience(int i2) {
        this.paytm_modification_convenience = i2;
    }
}
