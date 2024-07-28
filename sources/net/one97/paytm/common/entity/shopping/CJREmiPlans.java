package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREmiPlans implements IJRDataModel {
    @b(a = "plan_id")
    private int plan_id;

    public int getPlan_id() {
        return this.plan_id;
    }

    public void setPlan_id(int i2) {
        this.plan_id = i2;
    }
}
