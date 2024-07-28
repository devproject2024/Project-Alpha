package net.one97.paytm.recharge.model.mobile;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMadeForYouResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "operator")
    private String operator;
    @b(a = "planFetchSuccessful")
    private boolean planFetchSuccessful;
    @b(a = "userplansGwResponse")
    private CJRMadeForYouUserPlanResponse userPlanResponse;

    public String getHeaderTitle() {
        CJRMadeForYouUserPlanResponse cJRMadeForYouUserPlanResponse = this.userPlanResponse;
        return (cJRMadeForYouUserPlanResponse == null || cJRMadeForYouUserPlanResponse.getPlansArray() == null || this.userPlanResponse.getPlansArray().size() <= 0 || this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan() == null || TextUtils.isEmpty(this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan().getLabel())) ? "" : this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan().getLabel();
    }

    public List<CJRMadeForYouPlanData> getPlansData() {
        CJRMadeForYouUserPlanResponse cJRMadeForYouUserPlanResponse = this.userPlanResponse;
        if (cJRMadeForYouUserPlanResponse == null || cJRMadeForYouUserPlanResponse.getPlansArray() == null || this.userPlanResponse.getPlansArray().size() <= 0 || this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan() == null || this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan().getPlans() == null || this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan().getPlans().getPlanDataList() == null) {
            return new ArrayList();
        }
        return this.userPlanResponse.getPlansArray().get(0).getMadeForYouPlan().getPlans().getPlanDataList();
    }

    public String getCustomerType() {
        CJRMadeForYouUserPlanResponse cJRMadeForYouUserPlanResponse = this.userPlanResponse;
        if (cJRMadeForYouUserPlanResponse != null) {
            return cJRMadeForYouUserPlanResponse.getCustomerType();
        }
        return null;
    }
}
