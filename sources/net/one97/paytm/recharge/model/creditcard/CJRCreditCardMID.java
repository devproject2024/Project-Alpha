package net.one97.paytm.recharge.model.creditcard;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRCreditCardMID extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "mid")
    private String mid;
    private String productId;
    @b(a = "rule_id")
    private String ruleId;

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(String str) {
        this.ruleId = str;
    }

    public String getProductId() {
        return this.ruleId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void parseJSONObject(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(this.productId)) {
                String optString = jSONObject.optString(this.productId);
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    this.mid = jSONObject2.optString("mid");
                    this.ruleId = jSONObject2.optString("rule_id");
                }
            }
        } catch (JSONException e2) {
            q.d(e2.getMessage());
        }
    }
}
