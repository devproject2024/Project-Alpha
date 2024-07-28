package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.flightticket.CJRStatus;
import kotlin.g.b.g;

public final class CJRFlightMBChargesRoot extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRFlightMBChargesBody body;
    @b(a = "error")
    private String error;
    @b(a = "status")
    private CJRStatus status;

    public CJRFlightMBChargesRoot() {
        this((CJRStatus) null, (CJRFlightMBChargesBody) null, (String) null, 7, (g) null);
    }

    public final CJRStatus getStatus() {
        return this.status;
    }

    public final void setStatus(CJRStatus cJRStatus) {
        this.status = cJRStatus;
    }

    public final CJRFlightMBChargesBody getBody() {
        return this.body;
    }

    public final void setBody(CJRFlightMBChargesBody cJRFlightMBChargesBody) {
        this.body = cJRFlightMBChargesBody;
    }

    public CJRFlightMBChargesRoot(CJRStatus cJRStatus, CJRFlightMBChargesBody cJRFlightMBChargesBody, String str) {
        this.status = cJRStatus;
        this.body = cJRFlightMBChargesBody;
        this.error = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBChargesRoot(CJRStatus cJRStatus, CJRFlightMBChargesBody cJRFlightMBChargesBody, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRStatus, (i2 & 2) != 0 ? null : cJRFlightMBChargesBody, (i2 & 4) != 0 ? null : str);
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }
}
