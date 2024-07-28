package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class WishList extends IJRPaytmDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "items")
    private ArrayList<WishListProduct> mProduct;

    public String getmMessage() {
        return this.mMessage;
    }

    public ArrayList<WishListProduct> getmProduct() {
        return this.mProduct;
    }
}
