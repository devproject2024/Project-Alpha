package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ErrorInfo extends IJRPaytmDataModel {
    @b(a = "errorMessageCode")
    private int errorMessageCode;
    @b(a = "errorPopup")
    private ErrorDesc errorPopup;

    public int getErrorCode() {
        return this.errorMessageCode;
    }

    public void setErrorCode(int i2) {
        this.errorMessageCode = i2;
    }

    public ErrorDesc getErrorDesc() {
        return this.errorPopup;
    }
}
