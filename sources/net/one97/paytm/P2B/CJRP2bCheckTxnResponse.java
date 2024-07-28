package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRP2bCheckTxnResponse extends IJRPaytmDataModel {
    @b(a = "txnList")
    ArrayList<CJRP2bTransaction> txnList;

    public ArrayList<CJRP2bTransaction> getTxnList() {
        return this.txnList;
    }

    public void setTxnList(ArrayList<CJRP2bTransaction> arrayList) {
        this.txnList = arrayList;
    }
}
