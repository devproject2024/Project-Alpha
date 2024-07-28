package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRPincode extends IJRPaytmDataModel {
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
