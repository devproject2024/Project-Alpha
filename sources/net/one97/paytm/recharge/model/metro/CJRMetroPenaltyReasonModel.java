package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroPenaltyReasonModel implements IJRDataModel {
    @b(a = "amount")
    private float amount;
    @b(a = "maxAllowedTime")
    private String maxAllowedTime;
    @b(a = "overTime")
    private String overTime;
    @b(a = "reason")
    private String reason;

    public CJRMetroPenaltyReasonModel(String str, float f2, String str2) {
        this.reason = str;
        this.amount = f2;
        this.overTime = str2;
    }

    public String getReason() {
        return this.reason;
    }

    public float getAmount() {
        return this.amount;
    }

    public String getOverTime() {
        return this.overTime;
    }

    public String getMaxAllowedTime() {
        return this.maxAllowedTime;
    }
}
