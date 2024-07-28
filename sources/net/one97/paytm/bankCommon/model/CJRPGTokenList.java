package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPGTokenList extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "tokens")
    private ArrayList<CJRPGToken> mPGTokenList;
    private transient String serverTime;

    public ArrayList<CJRPGToken> getPGTokenList() {
        return this.mPGTokenList;
    }

    public void setPGTokenList(ArrayList<CJRPGToken> arrayList) {
        this.mPGTokenList = arrayList;
    }

    public String getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(String str) {
        this.serverTime = str;
    }
}
