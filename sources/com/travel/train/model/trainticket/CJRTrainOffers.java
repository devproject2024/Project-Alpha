package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOffers extends IJRPaytmDataModel implements IJRDataModel {
    private CJRTrainOffersBody body;
    private String code;
    private String error;
    private a meta;
    private CJRTrainOfferStatus status;

    class a {
    }

    public CJRTrainOffersBody getBody() {
        return this.body;
    }

    public String getError() {
        return this.error;
    }

    public CJRTrainOfferStatus getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public a getMeta() {
        return this.meta;
    }
}
