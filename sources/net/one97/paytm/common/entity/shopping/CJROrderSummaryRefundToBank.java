package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryRefundToBank implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "bankRefund")
    private boolean mBankRefundButtons;
    @b(a = "message")
    private String mMessage;
    @b(a = "title")
    private String mTitle;
    @b(a = "walletGuId")
    private String mWalletGuid;

    public String getTitle() {
        return this.mTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getWalletGuid() {
        return this.mWalletGuid;
    }

    public boolean getBankRefundButtons() {
        return this.mBankRefundButtons;
    }
}
