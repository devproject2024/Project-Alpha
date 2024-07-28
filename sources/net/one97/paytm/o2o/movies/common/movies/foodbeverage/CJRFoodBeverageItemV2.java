package net.one97.paytm.o2o.movies.common.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRFoodBeverageItem;

public class CJRFoodBeverageItemV2 extends CJRFoodBeverageItem {
    public static final String FOOD_VOUCHER = "food_voucher";
    @b(a = "max_order_count")
    private Integer maxOrderCount;
    @b(a = "term_condition_redeem_process")
    private String termConditionRedeemProcess;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public String getTermConditionRedeemProcess() {
        return this.termConditionRedeemProcess;
    }

    public Integer getMaxOrderCount() {
        return this.maxOrderCount;
    }
}
