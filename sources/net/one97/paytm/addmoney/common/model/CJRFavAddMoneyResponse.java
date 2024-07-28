package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFavAddMoneyResponse implements IJRDataModel {
    @b(a = "favouriteAmounts")
    private ArrayList<String> mFavouriteAmounts;

    public ArrayList<String> getFavouriteAmounts() {
        return this.mFavouriteAmounts;
    }
}
