package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRWalletServices extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "response")
    private CJRWalletServicesResponse mWalletServicesResponse;

    public String getName() {
        return null;
    }

    public CJRWalletServicesResponse getWalletServicesResponse() {
        return this.mWalletServicesResponse;
    }
}
