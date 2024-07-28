package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsiderCityData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cities")
    public List<CJRInsiderCityModel> cities;
}
