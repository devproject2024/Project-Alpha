package net.one97.paytm.recharge.legacy.catalog.model.v2;

import android.text.TextUtils;
import net.one97.paytm.common.entity.IJRDataModel;

public class RechargeProductListKeyV2 implements IJRDataModel {
    private String circle;
    private String operator;

    public RechargeProductListKeyV2(String str, String str2) {
        this.operator = str;
        this.circle = str2;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public String getCircle() {
        return this.circle;
    }

    public void setCircle(String str) {
        this.circle = str;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.operator) || TextUtils.isEmpty(this.circle)) {
            return super.hashCode();
        }
        return this.operator.hashCode() << (this.circle.hashCode() + 16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RechargeProductListKeyV2)) {
            return false;
        }
        RechargeProductListKeyV2 rechargeProductListKeyV2 = (RechargeProductListKeyV2) obj;
        return this.operator.equals(rechargeProductListKeyV2.operator) && this.circle.equals(rechargeProductListKeyV2.circle);
    }
}
