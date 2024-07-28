package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPGToken;

public class CJRBusPGTokenList extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "tokens")
    private ArrayList<CJRPGToken> mPGTokenList;
    private transient String serverTime;

    public ArrayList<CJRPGToken> getPGTokenList() {
        return this.mPGTokenList;
    }
}
