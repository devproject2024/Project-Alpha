package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMadeForYouPlan implements IJRDataModel {
    @b(a = "Data")
    private List<CJRMadeForYouPlanData> planDataList;

    public List<CJRMadeForYouPlanData> getPlanDataList() {
        return this.planDataList;
    }
}
