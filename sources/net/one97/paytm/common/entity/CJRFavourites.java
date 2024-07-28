package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;

public class CJRFavourites extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public final String TAG_PAY_TYPE_PREPAID = "prepaid";
    @b(a = "code")
    private int mCode;
    @b(a = "data")
    private ArrayList<CJRFrequentOrder> mFavoriteNumberList;
    @b(a = "message")
    private String mMessage;

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ArrayList<CJRFrequentOrder> getFavoriteNumberList() {
        return this.mFavoriteNumberList;
    }
}
