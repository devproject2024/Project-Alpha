package com.travel.flight.flightticket.h;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.flightticket.FlightBundle;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.travel.flight.flightticket.f.b f25040a;

    public a(com.travel.flight.flightticket.f.b bVar) {
        this.f25040a = bVar;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        com.travel.flight.flightticket.f.b bVar;
        if ((iJRPaytmDataModel instanceof FlightBundle) && (bVar = this.f25040a) != null) {
            bVar.onReviewItenaryBundleResponseSuccess((FlightBundle) iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.travel.flight.flightticket.f.b bVar = this.f25040a;
        if (bVar != null) {
            bVar.onReviewItenaryBundleResponseFail(iJRPaytmDataModel, networkCustomError);
        }
    }
}
