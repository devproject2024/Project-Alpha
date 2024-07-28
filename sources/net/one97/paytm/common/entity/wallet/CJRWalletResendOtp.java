package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRWalletResendOtp extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }
}
