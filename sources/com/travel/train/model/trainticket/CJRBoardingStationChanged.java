package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBoardingStationChanged extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "text_holder")
    private CJRTrainOrderTextHolder textHolder;
    @b(a = "visible")
    private boolean visible;

    public boolean getVisible() {
        return this.visible;
    }

    public CJRTrainOrderTextHolder getTextHolder() {
        return this.textHolder;
    }
}
