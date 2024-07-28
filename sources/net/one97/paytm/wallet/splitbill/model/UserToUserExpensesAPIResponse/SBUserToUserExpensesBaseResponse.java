package net.one97.paytm.wallet.splitbill.model.UserToUserExpensesAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserToUserExpensesBaseResponse extends CJRWalletDataModel {
    @c(a = "code")
    @a
    private String code;
    @c(a = "message")
    @a
    private String message;
    @c(a = "response")
    @a
    private SBUserToUserExpensesResponse response;
    @c(a = "selfUser")
    @a
    private a selfUser;
    @c(a = "status")
    @a
    private String status;
    @c(a = "success")
    @a
    private Boolean success;

    public a getSelfUser() {
        return this.selfUser;
    }

    public void setSelfUser(a aVar) {
        this.selfUser = aVar;
    }

    public SBUserToUserExpensesResponse getResponse() {
        return this.response;
    }

    public void setResponse(SBUserToUserExpensesResponse sBUserToUserExpensesResponse) {
        this.response = sBUserToUserExpensesResponse;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
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
}
