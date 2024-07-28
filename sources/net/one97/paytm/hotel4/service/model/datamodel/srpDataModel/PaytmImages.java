package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import java.util.List;

public final class PaytmImages {
    private final List<String> full;

    public PaytmImages(List<String> list) {
        this.full = list;
    }

    public final List<String> getFull() {
        return this.full;
    }
}
