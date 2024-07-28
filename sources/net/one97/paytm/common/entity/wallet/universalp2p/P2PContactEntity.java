package net.one97.paytm.common.entity.wallet.universalp2p;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class P2PContactEntity {
    private ArrayList<IJRDataModel> mContactList;
    private String mHeader;

    public P2PContactEntity(String str, ArrayList<IJRDataModel> arrayList) {
        this.mHeader = str;
        this.mContactList = arrayList;
    }

    public String getmHeader() {
        return this.mHeader;
    }

    public void setmHeader(String str) {
        this.mHeader = str;
    }

    public ArrayList<IJRDataModel> getmContactList() {
        return this.mContactList;
    }

    public void setmContactList(ArrayList<IJRDataModel> arrayList) {
        this.mContactList = arrayList;
    }
}
