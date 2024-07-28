package net.one97.paytm.recharge.model.mobile;

import android.content.Context;
import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.R;

public class CJRMadeForYouPlanData implements IJRDataModel {
    @b(a = "actual_price")
    private String actualPrice;
    @b(a = "name")
    private String name;
    @b(a = "talktime")
    private String talktime;
    @b(a = "validity")
    private String validity;

    public String getActualPrice() {
        return this.actualPrice;
    }

    public String getName() {
        return this.name;
    }

    public String getTalktime() {
        return this.talktime;
    }

    public void setTalktime(String str) {
        this.talktime = str;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String str) {
        this.validity = str;
    }

    public String getValidityDisplayString(Context context) {
        return context.getResources().getString(R.string.validity_browse_plan) + " " + getValidity();
    }

    public String getTalkTimeDisplayString(Context context) {
        if (TextUtils.isEmpty(getTalktime()) || getTalktime().equalsIgnoreCase("null") || getTalktime().equalsIgnoreCase("NA")) {
            return null;
        }
        String string = context.getResources().getString(R.string.recharge_rs, new Object[]{getTalktime()});
        return context.getResources().getString(R.string.talk_time) + ": " + string;
    }
}
