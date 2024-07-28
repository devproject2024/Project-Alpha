package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRoute extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "change_line")
    public CJRChangeLineModel change_line;
    @b(a = "distance")
    public String distance;
    @b(a = "lineinfo")
    public CJRLineModel lineinfo;
    @b(a = "stations")
    public List<CJRStationModel> stations;
    @b(a = "time")
    public String time;
    @b(a = "towards")
    public String towards;
}
