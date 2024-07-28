package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class GetVIPCashBackErrorModal extends IJRPaytmDataModel {
    @a
    @b(a = "code")
    private String code;
    @a
    @b(a = "errorCode")
    private String errorCode;
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "status")
    private Integer status;
    @a
    @b(a = "title")
    private String title;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
