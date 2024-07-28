package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCityResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRCityModel response;

    public CJRCityModel getResponse() {
        return this.response;
    }

    public void setResponse(CJRCityModel cJRCityModel) {
        this.response = cJRCityModel;
    }
}
