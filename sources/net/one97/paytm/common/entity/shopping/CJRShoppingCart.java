package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRShoppingCart extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "address")
    private CJRAddressList mAddress;
    @b(a = "cart")
    private CJRCart mCart;
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRCartStatus mStatus;
    @b(a = "code")
    private int mStatusCode;

    public String getmError() {
        return this.mError;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public CJRCartStatus getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public CJRCart getCart() {
        return this.mCart;
    }

    public CJRAddressList getAddress() {
        return this.mAddress;
    }
}
