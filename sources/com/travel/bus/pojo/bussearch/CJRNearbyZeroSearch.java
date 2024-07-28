package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRNearbyZeroSearch extends IJRPaytmDataModel {
    @b(a = "suggestions")
    private List<List<CJRSuggestionZeroSearch>> suggestions = null;

    public List<List<CJRSuggestionZeroSearch>> getSuggestions() {
        return this.suggestions;
    }
}
