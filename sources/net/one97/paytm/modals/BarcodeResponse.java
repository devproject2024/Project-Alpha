package net.one97.paytm.modals;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class BarcodeResponse extends CJRWalletDataModel implements IJRDataModel {
    @Deprecated
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String error;
    @b(a = "status")
    private BarcodeStatus status;

    public BarcodeStatus getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }
}
