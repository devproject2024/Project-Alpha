package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class RedemptionDelay extends CashBackBaseModal {
    @b(a = "delay")
    private String delay;
    @b(a = "delayUnit")
    private String delayUnit;

    public String getDelay() {
        return this.delay;
    }

    public void setDelay(String str) {
        this.delay = str;
    }

    public String getDelayUnit() {
        return this.delayUnit;
    }

    public void setDelayUnit(String str) {
        this.delayUnit = str;
    }
}
