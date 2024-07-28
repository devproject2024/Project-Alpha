package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBooking extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private CJRTrainConfirmation mConfirmation;

    public CJRTrainConfirmation getmConfirmation() {
        return this.mConfirmation;
    }

    public void setConfirmation(CJRTrainConfirmation cJRTrainConfirmation) {
        this.mConfirmation = cJRTrainConfirmation;
    }
}
