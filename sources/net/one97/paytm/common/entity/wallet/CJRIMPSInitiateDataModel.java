package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIMPSInitiateDataModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    protected String amount;
    protected String cst_ifsc;
    @b(a = "externalTransactionId")
    protected String externalTransactionId;
    @b(a = "extra_info")
    private CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel;
    @b(a = "status")
    protected String mStatus;
    @b(a = "message")
    protected String message;
    @b(a = "mw_txn_id")
    protected String mw_txn_id;
    @b(a = "response_code")
    protected int response_code;
    @b(a = "resume_id")
    protected int resume_id;
    @b(a = "rrn")
    protected String rrn;
    @b(a = "target_account")
    protected String target_account;
    @b(a = "transactionDate")
    protected String transactionDate;
    @b(a = "txn_id")
    protected String txn_id;

    public int getResume_id() {
        return this.resume_id;
    }

    public int getResponse_code() {
        return this.response_code;
    }

    public String getRrn() {
        return this.rrn;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public String getIFSC() {
        return this.cst_ifsc;
    }

    public void setIFSC(String str) {
        this.cst_ifsc = str;
    }

    public String getTargetAccount() {
        return this.target_account;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getMwTxnId() {
        return this.mw_txn_id;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public CJRIMPSInitiateExtraInfoDataModel getExtraInfoDataModel() {
        return this.extraInfoDataModel;
    }

    public void setExtraInfoDataModel(CJRIMPSInitiateExtraInfoDataModel cJRIMPSInitiateExtraInfoDataModel) {
        this.extraInfoDataModel = cJRIMPSInitiateExtraInfoDataModel;
    }

    public String getExternalTransactionId() {
        return this.externalTransactionId;
    }

    public void setExternalTransactionId(String str) {
        this.externalTransactionId = str;
    }
}
