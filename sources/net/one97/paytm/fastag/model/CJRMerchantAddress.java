package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRMerchantAddress extends IJRPaytmDataModel {
    @b(a = "address")
    private String mAddress;
    @b(a = "city")
    private String mCity;
    @b(a = "id")
    private long mId;
    @b(a = "merchant_id")
    private long mMerchantId;
    @b(a = "pin_code")
    private String mPinCode;
    @b(a = "state")
    private String mState;
    @b(a = "type")
    private int mType;
    @b(a = "updated_at")
    private String mUpdatedAt;

    public String getAddress() {
        return this.mAddress;
    }
}
