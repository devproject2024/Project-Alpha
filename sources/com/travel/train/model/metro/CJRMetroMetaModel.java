package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroMetaModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "query")
    public Object query;
    @b(a = "requestid")
    public String requestid;
}
