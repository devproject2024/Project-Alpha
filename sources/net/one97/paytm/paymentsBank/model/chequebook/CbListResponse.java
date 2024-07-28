package net.one97.paytm.paymentsBank.model.chequebook;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public class CbListResponse {
    @a
    @b(a = "accountNumber")
    private String accountNumber;
    @a
    @b(a = "awbNumber")
    private String awbNumber;
    @a
    @b(a = "chequeBookNumber")
    private String chequeBookNumber;
    @a
    @b(a = "custId")
    private String custId;
    @a
    @b(a = "firstChequeNumber")
    private String firstChequeNumber;
    @a
    @b(a = "lastChequeNumber")
    private String lastChequeNumber;
    @a
    @b(a = "orderId")
    private String orderId;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "variant")
    private String variant;

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getChequeBookNumber() {
        return this.chequeBookNumber;
    }

    public void setChequeBookNumber(String str) {
        this.chequeBookNumber = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setVariant(String str) {
        this.variant = str;
    }

    public String getFirstChequeNumber() {
        return this.firstChequeNumber;
    }

    public void setFirstChequeNumber(String str) {
        this.firstChequeNumber = str;
    }

    public String getLastChequeNumber() {
        return this.lastChequeNumber;
    }

    public void setLastChequeNumber(String str) {
        this.lastChequeNumber = str;
    }

    public String getAwbNumber() {
        return this.awbNumber;
    }

    public void setAwbNumber(String str) {
        this.awbNumber = str;
    }
}
