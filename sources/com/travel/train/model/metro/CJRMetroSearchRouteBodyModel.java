package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroSearchRouteBodyModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "routes")
    public List<CJRMetroRouteModel> routes;
}
