package net.one97.paytm.dynamic.module.creditcard.helper;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TokenizationApiResponse extends IJRPaytmDataModel {
    @a
    @b(a = "body")
    public TokenizationBody body;

    public TokenizationBody getBody() {
        return this.body;
    }
}
