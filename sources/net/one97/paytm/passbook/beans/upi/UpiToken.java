package net.one97.paytm.passbook.beans.upi;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class UpiToken extends IJRDataModel {
    private String mUpiToken;

    public String getUpiToken() {
        return this.mUpiToken;
    }

    public void setUpiToken(String str) {
        this.mUpiToken = str;
    }
}
