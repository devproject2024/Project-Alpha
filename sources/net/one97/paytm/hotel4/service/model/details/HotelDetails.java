package net.one97.paytm.hotel4.service.model.details;

import com.paytm.network.model.IJRPaytmDataModel;

public final class HotelDetails extends IJRPaytmDataModel {
    private Data data;
    private Extra extra;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final void setExtra(Extra extra2) {
        this.extra = extra2;
    }
}
