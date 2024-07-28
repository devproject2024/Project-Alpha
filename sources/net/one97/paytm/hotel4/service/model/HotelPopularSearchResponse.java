package net.one97.paytm.hotel4.service.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class HotelPopularSearchResponse extends IJRPaytmDataModel {
    private final List<PopularRecentDataItem> data;

    public final List<PopularRecentDataItem> getData() {
        return this.data;
    }
}
