package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMadeForYouUserPlanResponse implements IJRDataModel {
    @b(a = "customer_type")
    private String customerType;
    @b(a = "deducedStatus")
    private boolean deducedStatus;
    @b(a = "plansArray")
    private List<CJRMadeForYouPlans> plansArray;

    public List<CJRMadeForYouPlans> getPlansArray() {
        return this.plansArray;
    }

    public String getCustomerType() {
        return this.customerType;
    }
}
