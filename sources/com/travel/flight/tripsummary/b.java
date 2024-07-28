package com.travel.flight.tripsummary;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    String f25558a;

    /* renamed from: b  reason: collision with root package name */
    private a f25559b;

    public b(a aVar) {
        k.c(aVar, "listener");
        this.f25559b = aVar;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f25559b.a(iJRPaytmDataModel);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f25559b.a(i2, networkCustomError);
    }
}
