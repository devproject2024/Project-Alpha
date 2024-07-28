package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSavedCards extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "BIN_DETAILS")
    private ArrayList<CJRSavedCard> mSavedCardList = new ArrayList<>();
    @b(a = "SIZE")
    private int mSize;
    @b(a = "STATUS")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public int getSize() {
        return this.mSize;
    }

    public ArrayList<CJRSavedCard> getSavedCardList() {
        return this.mSavedCardList;
    }
}
