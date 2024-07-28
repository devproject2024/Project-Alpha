package com.travel.flight.flightticket.f;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.flightticket.FlightBundle;

public interface b {
    void onReviewItenaryBundleResponseFail(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void onReviewItenaryBundleResponseSuccess(FlightBundle flightBundle);
}
