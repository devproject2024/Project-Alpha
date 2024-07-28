package net.one97.paytm.common.entity.SellerRating;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSellerRatingArray implements IJRDataModel {
    ArrayList<MerchantRatingNew> mMerchantRating;

    public ArrayList<MerchantRatingNew> getmMerchantRating() {
        return this.mMerchantRating;
    }

    public void setmMerchantRating(ArrayList<MerchantRatingNew> arrayList) {
        this.mMerchantRating = arrayList;
    }
}
