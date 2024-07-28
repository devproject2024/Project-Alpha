package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSendMoneyResponse extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private boolean isBeneficiaryAdded;
    @b(a = "bankTransactionId")
    private String mBankTransactionId;
    @b(a = "heading")
    private String mHeading;
    @b(a = "displayName")
    private String mName;
    @b(a = "state")
    private String mState;
    @b(a = "payeeSsoId")
    private String payeeSsoId;
    @b(a = "walletSysTransactionId")
    private String walletSysTransactionID;

    public boolean isBeneficiaryAdded() {
        return this.isBeneficiaryAdded;
    }

    public void setBeneficiaryAdded(boolean z) {
        this.isBeneficiaryAdded = z;
    }

    public String getWalletSysTransactionID() {
        return this.walletSysTransactionID;
    }

    public void setWalletSysTransactionID(String str) {
        this.walletSysTransactionID = str;
    }

    public String getmBankTransactionId() {
        return this.mBankTransactionId;
    }

    public void setmBankTransactionId(String str) {
        this.mBankTransactionId = str;
    }

    public String getState() {
        return this.mState;
    }

    public String getHeading() {
        return this.mHeading;
    }

    public String getwalletSysTransactionID() {
        return this.walletSysTransactionID;
    }

    public String getpayeeSsoId() {
        return this.payeeSsoId;
    }

    public String getName() {
        return this.mName;
    }

    public String getBankTransactionId() {
        return this.mBankTransactionId;
    }
}
