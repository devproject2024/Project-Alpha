package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNotification extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "enabled")
    private String mIsEnabled;
    @b(a = "message")
    private String mMessage;
    @b(a = "priority")
    private String mPriority;
    @b(a = "type")
    private String mType;

    public String getmMessage() {
        return this.mMessage;
    }

    public String getmPriority() {
        return this.mPriority;
    }

    public String getmIsEnabled() {
        return this.mIsEnabled;
    }

    public String getmType() {
        return this.mType;
    }
}
