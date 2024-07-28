package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class EmiType extends BaseModel {
    @c(a = "label")
    @a
    private String label;
    @c(a = "planDetails")
    @a
    private List<PlanDetail> planDetails = null;
    @c(a = "type")
    @a
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public List<PlanDetail> getPlanDetails() {
        return this.planDetails;
    }

    public void setPlanDetails(List<PlanDetail> list) {
        this.planDetails = list;
    }
}
