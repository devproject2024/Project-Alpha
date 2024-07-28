package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSellerRatingList extends CJRDataModelItem {
    @b(a = "orders")
    private ArrayList<CJRSellerRatings> mRatingList = new ArrayList<>();

    public String getName() {
        return null;
    }

    public ArrayList<CJRSellerRatings> getRatingList() {
        return this.mRatingList;
    }

    public void setRatingList(ArrayList<CJRSellerRatings> arrayList) {
        this.mRatingList = arrayList;
    }
}
