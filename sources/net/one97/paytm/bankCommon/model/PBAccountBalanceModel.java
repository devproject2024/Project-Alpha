package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBAccountBalanceModel extends CJRSubWallet implements IJRDataModel {
    @b(a = "effectiveBalance")
    private double mEffectiveBalance;
    @b(a = "slfdBalance")
    private double mSlfdBalance;
    @b(a = "status")
    private String status;
    @b(a = "totalBalance")
    private double totalBalance;

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

    public double getTotalBalance() {
        return this.totalBalance;
    }
}
