package net.one97.paytm.paymentsBank.model.nach;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class NachTransactionDetailResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "montranTransactionDataList")
    private List<MontranTransactionDataList> montranTransactionDataList = null;
    @b(a = "response_code")
    private Integer responseCode;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txnId;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<MontranTransactionDataList> getMontranTransactionDataList() {
        return this.montranTransactionDataList;
    }

    public void setMontranTransactionDataList(List<MontranTransactionDataList> list) {
        this.montranTransactionDataList = list;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }
}
