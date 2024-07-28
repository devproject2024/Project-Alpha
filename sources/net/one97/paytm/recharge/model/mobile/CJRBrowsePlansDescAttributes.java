package net.one97.paytm.recharge.model.mobile;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.R;

public class CJRBrowsePlansDescAttributes implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category_name")
    private String mCategoryName;
    @b(a = "Circle")
    private String mCircle;
    @b(a = "Disclaimer")
    private String mDisclaimer;
    @b(a = "Operator")
    private String mOperator;
    @b(a = "PlanDescription")
    private String mPlanDesc;
    @b(a = "PlanType")
    private String mPlanType;
    @b(a = "Talktime")
    private String mTalktime;
    @b(a = "Validity")
    private String mValidity;

    public String getOperator() {
        return this.mOperator;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public String getTalktime() {
        return this.mTalktime;
    }

    public String getValidity() {
        return this.mValidity;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public String getDisclaimer() {
        return this.mDisclaimer;
    }

    public void setmTalktime(String str) {
        this.mTalktime = str;
    }

    public void setmValidity(String str) {
        this.mValidity = str;
    }

    public void setmCategoryName(String str) {
        this.mCategoryName = str;
    }

    public String getPlanType() {
        return this.mPlanType;
    }

    public void setPlanType(String str) {
        this.mPlanType = str;
    }

    public String getPlanDescription() {
        return this.mPlanDesc;
    }

    public void setPlanDescription(String str) {
        this.mPlanDesc = str;
    }

    public String getValidityDisplayString(Context context) {
        return context.getResources().getString(R.string.validity_browse_plan) + " " + getValidity();
    }

    public String getTalkTimeDisplayString(Context context) {
        if (TextUtils.isEmpty(getTalktime()) || getTalktime().equalsIgnoreCase("null") || getTalktime().equalsIgnoreCase("NA")) {
            return null;
        }
        String string = context.getResources().getString(R.string.recharge_rs, new Object[]{getTalktime()});
        return context.getResources().getString(R.string.talk_time) + " " + string;
    }

    public String getPlanTypeDisplayString(Activity activity) {
        return activity.getString(R.string.plan_type, new Object[]{this.mCategoryName});
    }
}
