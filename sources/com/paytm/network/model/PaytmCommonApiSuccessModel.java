package com.paytm.network.model;

import com.paytm.network.listener.b;

public class PaytmCommonApiSuccessModel extends PaytmCommonApiResponseModel {
    public IJRPaytmDataModel mDataModel;

    public PaytmCommonApiSuccessModel(b bVar, IJRPaytmDataModel iJRPaytmDataModel) {
        super(bVar);
        this.mDataModel = iJRPaytmDataModel;
    }

    public IJRPaytmDataModel getDataModel() {
        return this.mDataModel;
    }

    public void setDataModel(IJRPaytmDataModel iJRPaytmDataModel) {
        this.mDataModel = iJRPaytmDataModel;
    }
}
