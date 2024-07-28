package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFrequentOrderProduct implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public final String TAG_BANK_CODE = "bank_code";
    public final String TAG_CARD_TYPE = "card_network";
    public final String TAG_CIRCLE = "circle";
    public final String TAG_OPERATOR_DISPLAY_LABEL = "operator_display_label";
    public final String TAG_OPERATOR_LABEL = "operator_label";
    public final String TAG_PAY_OPERATOR = StringSet.operator;
    public final String TAG_PAY_TYPE = "paytype";
    public final String TAG_PAY_TYPE_DISPLAY_LABEL = "paytype_display_label";
    public final String TAG_PAY_TYPE_LABE = "paytype_label";
    public final String TAG_PLANS = "plans";
    public final String TAG_REMINDABLE_TYPE_LABEL = "remindable";
    public final String TAG_SERVICE = "service";
    private int category_id;
    @b(a = "attributes")
    private Map<String, String> mAttributes;
    @b(a = "brand")
    private String mFrequentOrderBrand;
    private int schedulable;

    public String getPlans() {
        if (this.mAttributes.containsKey("plans")) {
            return this.mAttributes.get("plans");
        }
        return new StringBuilder().toString();
    }

    public String getService() {
        if (this.mAttributes.containsKey("service")) {
            return this.mAttributes.get("service");
        }
        return new StringBuilder().toString();
    }

    public String getPaytype() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("paytype")) {
            return null;
        }
        return this.mAttributes.get("paytype");
    }

    public String getOperator() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey(StringSet.operator)) {
            return null;
        }
        return this.mAttributes.get(StringSet.operator);
    }

    public String getRemindable() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("remindable")) {
            return null;
        }
        return this.mAttributes.get("remindable");
    }

    public String getFrequentOrderBrand() {
        return this.mFrequentOrderBrand;
    }

    public boolean isSchedulable() {
        return this.schedulable == 1;
    }

    public Map<String, String> getAttributes() {
        return this.mAttributes;
    }

    public String getOperatorLabel() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("operator_label")) {
            return null;
        }
        return this.mAttributes.get("operator_label");
    }

    public String getOperatorDisplayLabel() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("operator_display_label")) {
            return null;
        }
        return this.mAttributes.get("operator_display_label");
    }

    public String getCircle() {
        if (this.mAttributes.containsKey("circle")) {
            return this.mAttributes.get("circle");
        }
        return new StringBuilder().toString();
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public String getPaytypeLabel() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("paytype_label")) {
            return null;
        }
        return this.mAttributes.get("paytype_label");
    }

    public String getPayTypeDisplayLabel() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("paytype_display_label")) {
            return null;
        }
        return this.mAttributes.get("paytype_display_label");
    }

    public String getBankCode() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("bank_code")) {
            return null;
        }
        return this.mAttributes.get("bank_code");
    }

    public String getCardType() {
        Map<String, String> map = this.mAttributes;
        if (map == null || !map.containsKey("card_network")) {
            return null;
        }
        return this.mAttributes.get("card_network");
    }

    public void setService(String str) {
        this.mAttributes = new HashMap();
        this.mAttributes.put("service", str);
    }
}
