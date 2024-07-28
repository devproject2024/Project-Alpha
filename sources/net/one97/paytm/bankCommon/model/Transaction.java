package net.one97.paytm.bankCommon.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class Transaction implements IJRDataModel {
    private String currency;
    private String currencyCode;
    private String imageUrl;
    private String message;
    private String mw_ext_txn_id;
    private String mw_int_txn_id;
    private String narration;
    private String report_code;
    private String response_code;
    private String rrn;
    private String transactionID;
    private String txnDesc0;
    private String txnDesc1;
    private String txnDesc2Key;
    private String txnDesc2Value;
    private String txnDesc3Key;
    private String txnDesc3Value;
    private String txnDesc4Key;
    private String txnDesc4Value;
    private String txnDesc5Key;
    private String txnDesc5Value;
    private String txnDesc6;
    private String txnDesc6Value;
    private String txnExternalTxnId;
    private String txnStatus;
    private String txnamount;
    private String txndate;
    private String txnpostdate;
    private String txntype;

    public String getTxnpostdate() {
        return this.txnpostdate;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getMw_ext_txn_id() {
        return this.mw_ext_txn_id;
    }

    public void setMw_ext_txn_id(String str) {
        this.mw_ext_txn_id = str;
    }

    public String getMw_int_txn_id() {
        return this.mw_int_txn_id;
    }

    public void setMw_int_txn_id(String str) {
        this.mw_int_txn_id = str;
    }

    public String getNarration() {
        return this.narration;
    }

    public void setNarration(String str) {
        this.narration = str;
    }

    public String getReport_code() {
        return this.report_code;
    }

    public void setReport_code(String str) {
        this.report_code = str;
    }

    public String getResponse_code() {
        return this.response_code;
    }

    public void setResponse_code(String str) {
        this.response_code = str;
    }

    public String getRrn() {
        return this.rrn;
    }

    public void setRrn(String str) {
        this.rrn = str;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String str) {
        this.transactionID = str;
    }

    public String getTxnDesc0() {
        return this.txnDesc0;
    }

    public void setTxnDesc0(String str) {
        this.txnDesc0 = str;
    }

    public String getTxnDesc1() {
        return this.txnDesc1;
    }

    public void setTxnDesc1(String str) {
        this.txnDesc1 = str;
    }

    public String getTxnDesc2Key() {
        return this.txnDesc2Key;
    }

    public void setTxnDesc2Key(String str) {
        this.txnDesc2Key = str;
    }

    public String getTxnDesc2Value() {
        return this.txnDesc2Value;
    }

    public void setTxnDesc2Value(String str) {
        this.txnDesc2Value = str;
    }

    public String getTxnDesc3Key() {
        return this.txnDesc3Key;
    }

    public void setTxnDesc3Key(String str) {
        this.txnDesc3Key = str;
    }

    public String getTxnDesc3Value() {
        return this.txnDesc3Value;
    }

    public void setTxnDesc3Value(String str) {
        this.txnDesc3Value = str;
    }

    public String getTxnDesc4Key() {
        return this.txnDesc4Key;
    }

    public void setTxnDesc4Key(String str) {
        this.txnDesc4Key = str;
    }

    public String getTxnDesc4Value() {
        return this.txnDesc4Value;
    }

    public void setTxnDesc4Value(String str) {
        this.txnDesc4Value = str;
    }

    public String getTxnDesc5Key() {
        return this.txnDesc5Key;
    }

    public void setTxnDesc5Key(String str) {
        this.txnDesc5Key = str;
    }

    public String getTxnDesc5Value() {
        return this.txnDesc5Value;
    }

    public void setTxnDesc5Value(String str) {
        this.txnDesc5Value = str;
    }

    public String getTxnExternalTxnId() {
        return this.txnExternalTxnId;
    }

    public void setTxnExternalTxnId(String str) {
        this.txnExternalTxnId = str;
    }

    public String getTxnStatus() {
        return this.txnStatus;
    }

    public void setTxnStatus(String str) {
        this.txnStatus = str;
    }

    public String getTxnamount() {
        return this.txnamount;
    }

    public void setTxnamount(String str) {
        this.txnamount = str;
    }

    public String getTxndate() {
        return this.txndate;
    }

    public void setTxndate(String str) {
        this.txndate = str;
    }

    public String getTxntype() {
        return this.txntype;
    }

    public void setTxntype(String str) {
        this.txntype = str;
    }

    public String getTxndesc6() {
        return this.txnDesc6;
    }

    public String getTxnDesc6Value() {
        return this.txnDesc6Value;
    }

    public void setTxnDesc6Value(String str) {
        this.txnDesc6Value = str;
    }
}
