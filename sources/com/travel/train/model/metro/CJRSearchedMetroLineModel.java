package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSearchedMetroLineModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "color")
    public String color;
    @b(a = "lineid")
    public String lineid;
    @b(a = "linename")
    public String linename;
}
