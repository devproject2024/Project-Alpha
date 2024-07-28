package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMadeForYouObject implements IJRDataModel {
    @b(a = "Label")
    private String label;
    @b(a = "Plans")
    private CJRMadeForYouPlan plans;

    public String getLabel() {
        return this.label;
    }

    public CJRMadeForYouPlan getPlans() {
        return this.plans;
    }
}
