package net.one97.paytm.common.entity.insurance;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class InsuranceBuyPayViewData extends IJRPaytmDataModel implements IJRDataModel {
    private final String extra_description;
    private final List<InsuranceBuyPayOptionModel> rc_info;

    public InsuranceBuyPayViewData(List<InsuranceBuyPayOptionModel> list, String str) {
        this.rc_info = list;
        this.extra_description = str;
    }

    public final String getExtra_description() {
        return this.extra_description;
    }

    public final List<InsuranceBuyPayOptionModel> getRc_info() {
        return this.rc_info;
    }
}
