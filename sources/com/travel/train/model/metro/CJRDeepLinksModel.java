package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDeepLinksModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "deeplink_url")
    public String deeplink_url;
    @b(a = "info")
    public String info;
    @b(a = "title")
    public String title;
}
