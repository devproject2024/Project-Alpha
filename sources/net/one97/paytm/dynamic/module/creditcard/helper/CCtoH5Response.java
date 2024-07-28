package net.one97.paytm.dynamic.module.creditcard.helper;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CCtoH5Response extends IJRPaytmDataModel {
    @b(a = "data")
    private TokenModel data;

    public void setData(TokenModel tokenModel) {
        this.data = tokenModel;
    }
}
