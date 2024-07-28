package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStationModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "img_url")
    public String img_url;
    @b(a = "name")
    public String name;
    @b(a = "stationid")
    public String stationid;
}
