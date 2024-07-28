package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRPGTokenList extends IJRPaytmDataModel implements IJRDataModel {
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

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) fVar.a(str, getClass());
        cJRPGTokenList.setServerTime(getNetworkResponse().headers.get("Date"));
        return cJRPGTokenList;
    }
}
