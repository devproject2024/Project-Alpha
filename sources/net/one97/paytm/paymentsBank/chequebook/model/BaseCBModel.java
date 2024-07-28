package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class BaseCBModel extends IJRPaytmDataModel {
    @c(a = "documentation")
    @a
    private String documentation;
    @c(a = "errorCode")
    @a
    private Integer errorCode;
    @c(a = "errorMessage")
    @a
    private String errorMessage;

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public final String getDocumentation() {
        return this.documentation;
    }

    public final void setDocumentation(String str) {
        this.documentation = str;
    }
}
