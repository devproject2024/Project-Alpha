package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrandStoreResultArray implements IJRDataModel {
    @b(a = "auth_level")
    private String mAuthLevel;
    @b(a = "brand_id")
    private String mBrandId;
    @b(a = "category_id")
    private String mCategoryId;
    @b(a = "merchant_id")
    private String mMerchantId;
    @b(a = "status")
    private String mStatus;

    public String getBrandId() {
        return this.mBrandId;
    }

    public void setBrandId(String str) {
        this.mBrandId = str;
    }

    public String getMerchantId() {
        return this.mMerchantId;
    }

    public void setMerchantId(String str) {
        this.mMerchantId = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public String getAuthLevel() {
        return this.mAuthLevel;
    }

    public void setAuthLevel(String str) {
        this.mAuthLevel = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }
}
