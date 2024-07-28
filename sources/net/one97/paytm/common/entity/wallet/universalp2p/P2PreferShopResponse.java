package net.one97.paytm.common.entity.wallet.universalp2p;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class P2PreferShopResponse extends CJRWalletDataModel implements IJRDataModel {
    @c(a = "displayMessage")
    private String displayMessage;
    @c(a = "statusCode")
    private int statusCode;

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }
}
