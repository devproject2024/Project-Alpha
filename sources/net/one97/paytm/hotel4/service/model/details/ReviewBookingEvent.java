package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ReviewBookingEvent extends IJRPaytmDataModel {
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        return this;
    }
}
