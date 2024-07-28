package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCityAutoSuggestResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRCityAutoSuggestModel response;

    public CJRCityAutoSuggestModel getResponse() {
        return this.response;
    }

    public void setResponse(CJRCityAutoSuggestModel cJRCityAutoSuggestModel) {
        this.response = cJRCityAutoSuggestModel;
    }
}
