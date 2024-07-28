package net.one97.paytm.hotel4.service.model.promocode;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class PromocodeResponse extends IJRPaytmDataModel {
    private final List<PromocodeDataItem> codes;

    public final List<PromocodeDataItem> getCodes() {
        return this.codes;
    }
}
