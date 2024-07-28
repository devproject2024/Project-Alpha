package net.one97.paytm.paymentsBank.chequebook.model;

import com.paytm.network.model.IJRPaytmDataModel;

public final class CbAddressModel extends IJRPaytmDataModel {
    private String address1;

    public final String getAddress1() {
        return this.address1;
    }

    public final void setAddress1(String str) {
        this.address1 = str;
    }
}
