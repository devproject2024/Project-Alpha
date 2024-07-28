package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRCSTTransactionDetail extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "merchantCategory")
    private String merchantCategory;
    @b(a = "walletTxnId")
    private String walletTxnId;

    public String getWalletTxnId() {
        return this.walletTxnId;
    }

    public void setWalletTxnId(String str) {
        this.walletTxnId = str;
    }

    public String getMerchantCategory() {
        return this.merchantCategory;
    }

    public void setMerchantCategory(String str) {
        this.merchantCategory = str;
    }
}
