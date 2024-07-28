package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRWalletServicesResponse extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "paytmWalletServices")
    private ArrayList<CJRPaytmWalletService> mPaytmWalletService;

    public String getName() {
        return null;
    }

    public ArrayList<CJRPaytmWalletService> getPaytmWalletService() {
        return this.mPaytmWalletService;
    }
}
