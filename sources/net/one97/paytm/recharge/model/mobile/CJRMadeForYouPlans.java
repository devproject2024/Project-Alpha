package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMadeForYouPlans implements IJRDataModel {
    @b(a = "made_for_you")
    private CJRMadeForYouObject madeForYouPlan;
    @b(a = "Order")
    private List<String> order;

    public CJRMadeForYouObject getMadeForYouPlan() {
        return this.madeForYouPlan;
    }
}
