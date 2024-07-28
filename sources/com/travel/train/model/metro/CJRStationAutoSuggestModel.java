package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStationAutoSuggestModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "is_junction")
    public Boolean is_junction;
    @b(a = "line_info")
    public List<CJRSearchedMetroLineModel> line_info;
    @b(a = "modeid")
    public String modeid;
    @b(a = "name")
    public String name;
    @b(a = "stationid")
    public String stationid;
}
