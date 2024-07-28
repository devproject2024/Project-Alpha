package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryPayments implements IJRDataModel {
    private String bank_transaction_id;
    private String created_at;
    private String gateway;
    private String id;
    private String kind;
    private String kind_text;
    private String mid;
    private String order_id;
    private String payment_bank;
    private String payment_method;
    private String pg_amount;
    private String pg_response_code;
    private String provider;
    private String status;
    private String status_text;
    private String transaction_number;

    public String getGateway() {
        return this.gateway;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public String getKind_text() {
        return this.kind_text;
    }

    public void setKind_text(String str) {
        this.kind_text = str;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String getStatus_text() {
        return this.status_text;
    }

    public void setStatus_text(String str) {
        this.status_text = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPg_amount() {
        return this.pg_amount;
    }

    public void setPg_amount(String str) {
        this.pg_amount = str;
    }

    public String getPg_response_code() {
        return this.pg_response_code;
    }

    public void setPg_response_code(String str) {
        this.pg_response_code = str;
    }

    public String getBank_transaction_id() {
        return this.bank_transaction_id;
    }

    public void setBank_transaction_id(String str) {
        this.bank_transaction_id = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getTransaction_number() {
        return this.transaction_number;
    }

    public void setTransaction_number(String str) {
        this.transaction_number = str;
    }

    public String getPayment_method() {
        return this.payment_method;
    }

    public void setPayment_method(String str) {
        this.payment_method = str;
    }

    public String getPayment_bank() {
        return this.payment_bank;
    }

    public void setPayment_bank(String str) {
        this.payment_bank = str;
    }
}
