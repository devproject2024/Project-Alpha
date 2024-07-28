package com.travel.bus.pojo.mapmyindia;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRSearchListLocation extends IJRPaytmDataModel {
    @a
    @b(a = "suggestedLocations")
    private List<CJRSuggestedLocation> suggestedLocations = null;

    public List<CJRSuggestedLocation> getSuggestedLocations() {
        return this.suggestedLocations;
    }
}
