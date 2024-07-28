package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickBookFavouritesBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "match_rules")
    public CJRTravelDetails matchRules;
    @b(a = "user_favourites")
    public ArrayList<CJRTrainUserFavourite> userFavourites;

    public ArrayList<CJRTrainUserFavourite> getUserFavourites() {
        return this.userFavourites;
    }

    public CJRTravelDetails getMatchRules() {
        return this.matchRules;
    }
}
