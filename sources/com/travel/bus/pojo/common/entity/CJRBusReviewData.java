package com.travel.bus.pojo.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusReviewData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    CJRBusCommentBody busCommentBody;

    public CJRBusCommentBody getBusCommentBody() {
        return this.busCommentBody;
    }
}
