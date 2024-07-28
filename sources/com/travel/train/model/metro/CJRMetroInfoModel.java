package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroInfoModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "debugMessage")
    public String debugMessage;
    @b(a = "message")
    public String message;
}
