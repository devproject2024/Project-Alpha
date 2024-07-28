package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsiderCityResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    public CJRInsiderCityData data;
}
