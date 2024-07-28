package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroRouteHeadingModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "info")
    public String info;
    @b(a = "tag")
    public String tag;
    @b(a = "title")
    public String title;
}
