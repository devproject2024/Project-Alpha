package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickBookFavourites extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainQuickBookFavouritesBody body;
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private Object error;
    @b(a = "status")
    private CJRTrainStatus status;

    public Object getError() {
        return this.error;
    }

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainQuickBookFavouritesBody getBody() {
        return this.body;
    }

    public Integer getCode() {
        return this.code;
    }
}
