package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class Amenities extends IJRPaytmDataModel {
    private final List<AmenitiesItemDetail> basic;
    private final List<AmenitiesItemDetail> more;

    public final List<AmenitiesItemDetail> getBasic() {
        return this.basic;
    }

    public final List<AmenitiesItemDetail> getMore() {
        return this.more;
    }

    public Amenities(List<AmenitiesItemDetail> list, List<AmenitiesItemDetail> list2) {
        this.basic = list;
        this.more = list2;
    }
}
