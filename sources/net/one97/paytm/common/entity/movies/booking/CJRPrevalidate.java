package net.one97.paytm.common.entity.movies.booking;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPrevalidate extends IJRPaytmDataModel implements IJRDataModel {
    private String cartBody;

    public void setCartBody(String str) {
        this.cartBody = str;
    }

    public String getCartBody() {
        return this.cartBody;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRPrevalidate cJRPrevalidate = new CJRPrevalidate();
        cJRPrevalidate.setCartBody(str);
        return cJRPrevalidate;
    }
}
