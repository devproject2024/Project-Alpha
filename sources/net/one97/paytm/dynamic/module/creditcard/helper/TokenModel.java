package net.one97.paytm.dynamic.module.creditcard.helper;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class TokenModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "access_token")
    private String access_token;
    @b(a = "error")
    private String error;
    @b(a = "errorCode")
    private int errorCode;
    @b(a = "productId")
    private String productId;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }
}
