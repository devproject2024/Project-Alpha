package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class ExtendedTxnInfo extends IJRDataModel {
    @b(a = "closingBalance")
    private String closingBalance;
    @b(a = "expiryTimeStamp")
    private String expiryTimeStamp;
    @b(a = "amount")
    private double mAmount;
    @b(a = "displayName")
    private String mDisplayName;
    @b(a = "subWalletType")
    private String mSubWalletType;
    @b(a = "walletId")
    private String walletId;
    @b(a = "walletLogo")
    private String walletLogo;

    public String getWalletId() {
        return this.walletId;
    }

    public void setWalletId(String str) {
        this.walletId = str;
    }

    public String getClosingBalance() {
        return this.closingBalance;
    }

    public void setClosingBalance(String str) {
        this.closingBalance = str;
    }

    public String getName() {
        return getName();
    }

    public String getSubWalletType() {
        return this.mSubWalletType;
    }

    public void setSubWalletType(String str) {
        this.mSubWalletType = str;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public double getAmount() {
        return this.mAmount;
    }

    public void setAmount(double d2) {
        this.mAmount = d2;
    }

    public String getExpiryTimeStamp() {
        return this.expiryTimeStamp;
    }

    public void setExpiryTimeStamp(String str) {
        this.expiryTimeStamp = str;
    }

    public String toString() {
        return super.toString();
    }

    public String getWalletLogo() {
        return this.walletLogo;
    }

    public void setWalletLogo(String str) {
        this.walletLogo = str;
    }
}
