package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class AccountBalanceModel extends CJRSubWallet implements UpiBaseDataModel {
    @c(a = "effectiveBalance")
    private double mEffectiveBalance;
    @c(a = "slfdBalance")
    private double mSlfdBalance;
    @c(a = "status")
    private String status;
    @c(a = "totalBalance")
    private double totalBalance;

    public double getEffectiveBalance() {
        return this.mEffectiveBalance;
    }

    public double getTotalBalance() {
        return this.totalBalance;
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

    public void setTotalBalance(double d2) {
        this.totalBalance = d2;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
