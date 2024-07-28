package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroRouteModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "additional_info")
    public List<CJRMetroRouteAdditionalInfoModel> additional_info;
    @b(a = "heading")
    public CJRMetroRouteHeadingModel heading;
    @b(a = "is_specialine")
    public Boolean is_specialine;
    @b(a = "route")
    public List<CJRRoute> route;
    @b(a = "specialline")
    public String specialline;
}
