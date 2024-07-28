package net.one97.paytm.nativesdk.common.model;

import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public class CreateOrderResponse implements IJRDataModel {
    private String MID;
    private String ORDER_ID;
    private String TOKEN_TYPE;
    private String TXN_AMOUNT;
    private String message;
    private String native_withdraw;
    private NativeWithdrawDetails native_withdraw_details;
    private String status;

    public static class NativeWithdrawDetails implements BaseDataModel {
        private boolean authenticated;
        private String txnToken;

        public String getTxnToken() {
            return this.txnToken;
        }

        public void setTxnToken(String str) {
            this.txnToken = str;
        }

        public boolean isAuthenticated() {
            return this.authenticated;
        }

        public void setAuthenticated(boolean z) {
            this.authenticated = z;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getORDER_ID() {
        return this.ORDER_ID;
    }

    public void setORDER_ID(String str) {
        this.ORDER_ID = str;
    }

    public String getMID() {
        return this.MID;
    }

    public void setMID(String str) {
        this.MID = str;
    }

    public String getTXN_AMOUNT() {
        return this.TXN_AMOUNT;
    }

    public void setTXN_AMOUNT(String str) {
        this.TXN_AMOUNT = str;
    }

    public String getTOKEN_TYPE() {
        return this.TOKEN_TYPE;
    }

    public void setTOKEN_TYPE(String str) {
        this.TOKEN_TYPE = str;
    }

    public String getNative_withdraw() {
        return this.native_withdraw;
    }

    public void setNative_withdraw(String str) {
        this.native_withdraw = str;
    }

    public NativeWithdrawDetails getNative_withdraw_details() {
        return this.native_withdraw_details;
    }

    public void setNative_withdraw_details(NativeWithdrawDetails nativeWithdrawDetails) {
        this.native_withdraw_details = nativeWithdrawDetails;
    }
}
