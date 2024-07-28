package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRSellerRatingList extends IJRPaytmDataModel {
    @b(a = "orders")
    private ArrayList<CJRSellerRatings> mRatingList = new ArrayList<>();

    public ArrayList<CJRSellerRatings> getRatingList() {
        return this.mRatingList;
    }

    public void setRatingList(ArrayList<CJRSellerRatings> arrayList) {
        this.mRatingList = arrayList;
    }
}
