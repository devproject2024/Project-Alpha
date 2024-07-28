package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRProductLikes extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "statistics")
    private CJRProductStatistics mProductStatistics;

    public CJRProductStatistics getProductStatistics() {
        return this.mProductStatistics;
    }
}
