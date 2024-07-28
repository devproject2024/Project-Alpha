package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CashbackCardList extends IJRPaytmDataModel {
    @b(a = "beforeTime")
    public long beforeTime;
    @b(a = "excludedIds")
    public ArrayList<Long> excludedIds;
    @b(a = "isNext")
    public boolean isNext;
    @b(a = "scratchCardList")
    public ArrayList<ScratchCard> scratchCardList;
}
