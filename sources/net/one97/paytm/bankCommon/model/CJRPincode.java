package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.bankCommon.model.auth.CJRDataModelItem;

public class CJRPincode extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "city")
    private String mCity;
    @b(a = "pincode")
    private String mPincode;
    @b(a = "state")
    private String mState;

    public String getName() {
        return null;
    }

    public String getPincode() {
        return this.mPincode;
    }

    public String getState() {
        return this.mState;
    }

    public String getCity() {
        return this.mCity;
    }
}
