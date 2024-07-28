package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRChangeLineModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    public String message;
    @b(a = "title")
    public String title;
}
