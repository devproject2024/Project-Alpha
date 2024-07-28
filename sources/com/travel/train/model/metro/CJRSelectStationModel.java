package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSelectStationModel extends IJRPaytmDataModel implements IJRDataModel {
    private Object data;
    private int type;

    public CJRSelectStationModel(int i2, Object obj) {
        k.c(obj, "data");
        this.type = i2;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public final void setData(Object obj) {
        k.c(obj, "<set-?>");
        this.data = obj;
    }

    public final void setType(int i2) {
        this.type = i2;
    }
}
