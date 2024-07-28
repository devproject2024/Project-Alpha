package com.paytm.network.model;

import com.paytm.network.listener.c;

public class PaytmMultipartApiSuccessModel extends PaytmMultipartApiResponseModel {
    public IJRPaytmDataModel mDataModel;

    public PaytmMultipartApiSuccessModel(c cVar, IJRPaytmDataModel iJRPaytmDataModel) {
        super(cVar);
        this.mDataModel = iJRPaytmDataModel;
    }

    public IJRPaytmDataModel getDataModel() {
        return this.mDataModel;
    }

    public void setDataModel(IJRPaytmDataModel iJRPaytmDataModel) {
        this.mDataModel = iJRPaytmDataModel;
    }
}
