package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoVerify extends IJRPaytmDataModel implements IJRDataModel {
    private CJRTrainPromoVerifyBody body;
    private String code;
    private String error;
    private CJRTrainOfferStatus status;

    public CJRTrainPromoVerifyBody getBody() {
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
}
