package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;

public class AccountBalanceModel extends CJRSubWallet {
    @b(a = "effectiveBalance")
    private double mEffectiveBalance;
    @b(a = "slfdBalance")
    private double mSlfdBalance;
    @b(a = "totalBalance")
    private String mTotalBalance;
    @b(a = "status")
    private String status;

    public double getEffectiveBalance() {
        return this.mEffectiveBalance;
    }

    public double getSlfdBalance() {
        return this.mSlfdBalance;
    }

    public String getStatus() {
        return this.status;
    }

    public void setmEffectiveBalance(double d2) {
        this.mEffectiveBalance = d2;
    }

    public void setmSlfdBalance(double d2) {
        this.mSlfdBalance = d2;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getmTotalBalance() {
        return this.mTotalBalance;
    }

    public void setmTotalBalance(String str) {
        this.mTotalBalance = str;
    }
}
