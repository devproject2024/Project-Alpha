package net.one97.paytm.upi.common.upi;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiToken implements UpiBaseDataModel {
    private String mUpiToken;

    public String getUpiToken() {
        return this.mUpiToken;
    }

    public void setUpiToken(String str) {
        this.mUpiToken = str;
    }
}
