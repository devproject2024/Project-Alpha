package net.one97.paytm.common.entity.SellerRating;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJROrderSummarySellarRating extends IJRPaytmDataModel {
    @b(a = "items")
    private ArrayList<CJROrderSummaryRatingModel> mSellarRatingModel;

    public ArrayList<CJROrderSummaryRatingModel> getSellarRatingModel() {
        return this.mSellarRatingModel;
    }

    public void setSellarRatingModel(ArrayList<CJROrderSummaryRatingModel> arrayList) {
        this.mSellarRatingModel = arrayList;
    }
}
