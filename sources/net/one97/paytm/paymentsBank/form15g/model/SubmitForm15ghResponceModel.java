package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class SubmitForm15ghResponceModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "documentation")
    String documentation;
    @b(a = "errorCode")
    int errorCode;
    @b(a = "errorMessage")
    String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public void setDocumentation(String str) {
        this.documentation = str;
    }
}
