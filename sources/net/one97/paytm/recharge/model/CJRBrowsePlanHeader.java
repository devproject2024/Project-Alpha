package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlanHeader implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isHidden = false;
    private boolean isMadeForYouPlan = false;
    private boolean isOtc;
    @b(a = "category_id")
    private String mCategoryId;
    @b(a = "name")
    private String mName;
    @b(a = "seourl")
    private String mSeourl;
    @b(a = "url")
    private String mUrl;

    public boolean isOtc() {
        return this.isOtc;
    }

    public void setOtc(boolean z) {
        this.isOtc = z;
    }

    public String getName() {
        return this.mName;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getSeourl() {
        return this.mSeourl;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public boolean isMadeForYouPlan() {
        return this.isMadeForYouPlan;
    }

    public void setMadeForYouPlan(boolean z) {
        this.isMadeForYouPlan = z;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public void setHidden(boolean z) {
        this.isHidden = z;
    }
}
