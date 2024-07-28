package net.one97.paytm.paymentsBank.slfd.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class RedeemFixedDepositModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cbsTransactionId")
    private String mCbsTransactionId;
    @b(a = "message")
    private String mMessage;
    @b(a = "response_code")
    private String mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "transactionDate")
    private String mTransactionDate;
    @b(a = "txn_id")
    private String mTransactionId;

    public String getTransactionId() {
        return this.mTransactionId;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getCbsTransactionId() {
        return this.mCbsTransactionId;
    }

    public String getTransactionDate() {
        return this.mTransactionDate;
    }
}
