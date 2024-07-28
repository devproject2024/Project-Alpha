package net.one97.paytm.recharge.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import java.util.Objects;
import net.one97.paytm.recharge.widgets.c.d;

public class CJRContributionData extends IJRPaytmDataModel {
    @b(a = "data")
    private Object data;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public String getTotalContributedAmount(String str) {
        if (this.data == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = this.data;
        if (!(obj instanceof Map) || !((Map) obj).containsKey(str)) {
            return null;
        }
        try {
            Object obj2 = ((Map) this.data).get(str);
            if (!(obj2 instanceof Map) || !((Map) obj2).containsKey("totalAmountRaised")) {
                return null;
            }
            return Objects.requireNonNull(((Map) obj2).get("totalAmountRaised")).toString();
        } catch (Exception unused) {
            d dVar = d.f64967a;
            d.a("Unable to find contribution-data for: ".concat(String.valueOf(str)));
            return null;
        }
    }
}
