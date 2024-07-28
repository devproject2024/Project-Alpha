package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPromoValidateResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cart")
    private CJRPrevalidateInputModel cart;
    @b(a = "status")
    private CJRAmParkPromoStatus status;

    public CJRPrevalidateInputModel getCart() {
        return this.cart;
    }

    public CJRAmParkPromoStatus getStatus() {
        return this.status;
    }
}
