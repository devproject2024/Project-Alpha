package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherSellersMain implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "any_pick_at_store")
    private int mAnyPickAtStore;
    @b(a = "min_offer_price")
    private int mMinimumOfferPrice;
    @b(a = "pagination_url")
    private String mMoreSellerURL;
    @b(a = "count")
    private int mMoreSellersCount;
    @b(a = "values")
    private ArrayList<CJROtherSellers> mOtherSellersList = new ArrayList<>();
    @b(a = "pick_at_store")
    private boolean mPickAtStore;

    public ArrayList<CJROtherSellers> getmOtherSellers() {
        return this.mOtherSellersList;
    }

    public void setmOtherSellers(ArrayList<CJROtherSellers> arrayList) {
        this.mOtherSellersList = arrayList;
    }

    public int getmMoreSellersCount() {
        return this.mMoreSellersCount;
    }

    public int getmMinimumOfferPrice() {
        return this.mMinimumOfferPrice;
    }

    public boolean ismPickAtStore() {
        return this.mPickAtStore;
    }

    public String getmMoreSellerURL() {
        return this.mMoreSellerURL;
    }

    public int getmAnyPickAtStore() {
        return this.mAnyPickAtStore;
    }
}
