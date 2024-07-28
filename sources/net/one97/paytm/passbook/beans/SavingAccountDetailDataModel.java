package net.one97.paytm.passbook.beans;

import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class SavingAccountDetailDataModel extends IJRDataModel {
    private String message;
    private String response_code;
    private String status;
    private String textForShare;
    private Integer totalCount;
    private ArrayList<Transaction> transactions;
    private String txn_id;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getResponse_code() {
        return this.response_code;
    }

    public void setResponse_code(String str) {
        this.response_code = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer num) {
        this.totalCount = num;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> arrayList) {
        this.transactions = arrayList;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String str) {
        this.txn_id = str;
    }

    public String getTextForShare() {
        return this.textForShare;
    }

    public void setTextForShare(String str) {
        this.textForShare = str;
    }
}
