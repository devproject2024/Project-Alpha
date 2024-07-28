package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRClaimCashbackDataModel extends IJRPaytmDataModel {
    double amount;
    String code;
    String message;
    String scratchCardId;
    String status;
    String txnId;

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getScratchCardId() {
        return this.scratchCardId;
    }

    public double getAmount() {
        return this.amount;
    }
}
