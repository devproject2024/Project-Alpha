package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CBTrackingOrderUserDetails extends IJRPaytmDataModel {
    @a
    @b(a = "phoneNumber")
    private String phoneNumber;
    @a
    @b(a = "userAddress")
    private CBTrackingOrderUserAddress userAddress;

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public CBTrackingOrderUserAddress getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(CBTrackingOrderUserAddress cBTrackingOrderUserAddress) {
        this.userAddress = cBTrackingOrderUserAddress;
    }
}
