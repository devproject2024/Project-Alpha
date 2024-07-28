package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTravellerMessage extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "enabled")
    private boolean mEnable;
    @b(a = "message_text")
    private String mMessage;
    @b(a = "traveller_message")
    private String mTravellerMessage;
    @b(a = "traveller_message_enabled")
    private boolean mTravellerMessageEnable;

    public boolean isEnable() {
        return this.mEnable;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getTravellerMessage() {
        return this.mTravellerMessage;
    }

    public boolean isTravellerMessageEnable() {
        return this.mTravellerMessageEnable;
    }
}
