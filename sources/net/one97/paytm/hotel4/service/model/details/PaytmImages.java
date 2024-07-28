package net.one97.paytm.hotel4.service.model.details;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class PaytmImages extends IJRPaytmDataModel {
    private List<String> full;

    public final List<String> getFull() {
        return this.full;
    }

    public final void setFull(List<String> list) {
        this.full = list;
    }
}
