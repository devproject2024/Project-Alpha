package net.one97.paytm.bankCommon.model.nominee;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class NomineeUpdateResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String documentation;
    private int errorCode;
    private String errorMessage;
    private String response;
    private boolean success;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
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
