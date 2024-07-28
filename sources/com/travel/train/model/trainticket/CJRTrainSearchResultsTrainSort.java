package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsTrainSort extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "default_order")
    private Integer defaultOrder;
    @b(a = "default_type")
    private Integer defaultType;

    public CJRTrainSearchResultsTrainSort() {
        this((Integer) null, (Integer) null, 3, (g) null);
    }

    public final Integer getDefaultType() {
        return this.defaultType;
    }

    public final void setDefaultType(Integer num) {
        this.defaultType = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTrainSearchResultsTrainSort(Integer num, Integer num2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2);
    }

    public final Integer getDefaultOrder() {
        return this.defaultOrder;
    }

    public final void setDefaultOrder(Integer num) {
        this.defaultOrder = num;
    }

    public CJRTrainSearchResultsTrainSort(Integer num, Integer num2) {
        this.defaultType = num;
        this.defaultOrder = num2;
    }
}
