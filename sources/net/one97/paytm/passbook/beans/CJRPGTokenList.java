package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRPGTokenList extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "tokens")
    private ArrayList<CJRPGToken> mPGTokenList;
    private transient String serverTime;

    public void setPGTokenList(ArrayList<CJRPGToken> arrayList) {
        this.mPGTokenList = arrayList;
    }

    public ArrayList<CJRPGToken> getPGTokenList() {
        return this.mPGTokenList;
    }

    public String getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(String str) {
        this.serverTime = str;
    }
}
