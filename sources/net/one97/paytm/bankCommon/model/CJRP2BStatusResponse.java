package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRP2BStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "validForTxn")
    private boolean isValidForTxn;
    @b(a = "txnWiseResponse")
    private CJRP2BStatusTxnWiseResponse mStatusTxnWiseResponse;
    @b(a = "txnWiseMessages")
    private ArrayList<String> mTxnWiseMessages;

    public CJRP2BStatusTxnWiseResponse getStatusTxnWiseResponse() {
        return this.mStatusTxnWiseResponse;
    }

    public ArrayList<String> getTxnWiseMessages() {
        return this.mTxnWiseMessages;
    }

    public boolean isValidForTxn() {
        return this.isValidForTxn;
    }
}
