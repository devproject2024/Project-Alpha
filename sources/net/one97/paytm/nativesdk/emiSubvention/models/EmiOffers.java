package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class EmiOffers extends BaseModel {
    @c(a = "plan_id")
    @a
    private ItemBreakup plan;

    public ItemBreakup getPlan() {
        return this.plan;
    }

    public void setPlan(ItemBreakup itemBreakup) {
        this.plan = itemBreakup;
    }
}
