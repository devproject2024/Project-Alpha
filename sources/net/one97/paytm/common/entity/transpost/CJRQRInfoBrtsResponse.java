package net.one97.paytm.common.entity.transpost;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRQRInfoBrtsResponse extends CJRWalletDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }
}
