package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TxnLinked extends IJRPaytmDataModel {
    @b(a = "id")
    private String id;
    @b(a = "stage")
    private String stage;

    public String getStage() {
        return this.stage;
    }

    public String getId() {
        return this.id;
    }
}
