package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRP2BStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "displayMsg")
    private String displayMessage;
    @b(a = "feeDescriptionText")
    private String feeDescriptionText;
    @b(a = "validForTxn")
    private boolean isValidForTxn;
    @b(a = "txnWiseResponse")
    private CJRP2BStatusTxnWiseResponse mStatusTxnWiseResponse;
    @b(a = "txnWiseMessages")
    private ArrayList<String> mTxnWiseMessages;
    @b(a = "commissionMetaObject")
    private P2BCommissionMetaObject p2BCommissionMetaObject;

    public P2BCommissionMetaObject getP2BCommissionMetaObject() {
        return this.p2BCommissionMetaObject;
    }

    public void setP2BCommissionMetaObject(P2BCommissionMetaObject p2BCommissionMetaObject2) {
        this.p2BCommissionMetaObject = p2BCommissionMetaObject2;
    }

    public CJRP2BStatusTxnWiseResponse getStatusTxnWiseResponse() {
        return this.mStatusTxnWiseResponse;
    }

    public ArrayList<String> getTxnWiseMessages() {
        return this.mTxnWiseMessages;
    }

    public boolean isValidForTxn() {
        return this.isValidForTxn;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public String getFeeDescriptionText() {
        return this.feeDescriptionText;
    }

    public void setFeeDescriptionText(String str) {
        this.feeDescriptionText = str;
    }
}
