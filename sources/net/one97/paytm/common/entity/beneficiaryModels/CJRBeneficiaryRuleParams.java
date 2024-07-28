package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBeneficiaryRuleParams implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "duration")
    private String duration;
    @b(a = "durationUnit")
    private String durationUnit;
    @b(a = "txn")
    private String txn;

    public String getTxn() {
        return this.txn;
    }

    public void setTxn(String str) {
        this.txn = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getDurationUnit() {
        return this.durationUnit;
    }

    public void setDurationUnit(String str) {
        this.durationUnit = str;
    }
}
