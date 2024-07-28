package net.one97.paytm.hotel4.service.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ProcessToPay extends IJRPaytmDataModel {
    private String MID;
    private String ORDER_ID;
    private String THEME;
    private String TOKEN_TYPE;
    private Integer TXN_AMOUNT;
    @b(a = "code")
    private Integer code;
    private String hitPG;
    @b(a = "message")
    private String message;
    private String native_withdraw;
    private NativeWithdrawDetails native_withdraw_details;
    @b(a = "requestId")
    private String requestId;
    private String status;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final String getHitPG() {
        return this.hitPG;
    }

    public final void setHitPG(String str) {
        this.hitPG = str;
    }

    public final String getORDER_ID() {
        return this.ORDER_ID;
    }

    public final void setORDER_ID(String str) {
        this.ORDER_ID = str;
    }

    public final Integer getTXN_AMOUNT() {
        return this.TXN_AMOUNT;
    }

    public final void setTXN_AMOUNT(Integer num) {
        this.TXN_AMOUNT = num;
    }

    public final String getTHEME() {
        return this.THEME;
    }

    public final void setTHEME(String str) {
        this.THEME = str;
    }

    public final String getNative_withdraw() {
        return this.native_withdraw;
    }

    public final void setNative_withdraw(String str) {
        this.native_withdraw = str;
    }

    public final String getMID() {
        return this.MID;
    }

    public final void setMID(String str) {
        this.MID = str;
    }

    public final String getTOKEN_TYPE() {
        return this.TOKEN_TYPE;
    }

    public final void setTOKEN_TYPE(String str) {
        this.TOKEN_TYPE = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final NativeWithdrawDetails getNative_withdraw_details() {
        return this.native_withdraw_details;
    }

    public final void setNative_withdraw_details(NativeWithdrawDetails nativeWithdrawDetails) {
        this.native_withdraw_details = nativeWithdrawDetails;
    }
}
