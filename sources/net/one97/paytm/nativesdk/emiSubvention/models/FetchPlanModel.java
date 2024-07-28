package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class FetchPlanModel extends BaseModel {
    @c(a = "cart_items")
    @a
    private List<CartItem> cartItems = null;
    @c(a = "emi_plan")
    @a
    private EmiValidatePlan emiPlan;
    @c(a = "emi_plans")
    @a
    private EmiPlan emiPlans;

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCartItems(List<CartItem> list) {
        this.cartItems = list;
    }

    public EmiPlan getEmiPlans() {
        return this.emiPlans;
    }

    public void setEmiPlans(EmiPlan emiPlan2) {
        this.emiPlans = emiPlan2;
    }

    public EmiValidatePlan getEmiValidatePlans() {
        return this.emiPlan;
    }

    public void setEmiPlans(EmiValidatePlan emiValidatePlan) {
        this.emiPlan = emiValidatePlan;
    }
}
