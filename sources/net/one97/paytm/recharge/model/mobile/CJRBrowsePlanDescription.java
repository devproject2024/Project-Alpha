package net.one97.paytm.recharge.model.mobile;

import android.content.Context;
import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.R;

public class CJRBrowsePlanDescription implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String TransactionType;
    @b(a = "attributes")
    private AttributesObject attributes;
    private boolean isOTC;
    @b(a = "actual_price")
    private String mActualPrice;
    @b(a = "brand")
    private String mBrand;
    private HashMap<String, String> mDynamicDataObject;
    @b(a = "long_rich_desc")
    private ArrayList<CJRBrowsePlansRichDesc> mLongRichDesc;
    @b(a = "merchant_name")
    private String mMerchantName;
    @b(a = "name")
    private String mName;
    @b(a = "offer_price")
    private String mOfferPrice;
    @b(a = "PlanDescription")
    private String mPlanDescription;
    @b(a = "PlanGuiId")
    private String mPlanGuiId;
    @b(a = "PlanName")
    private String mPlanName;
    @b(a = "PlanValidity")
    private String mPlanValidity;
    @b(a = "")
    private String mProductId;
    @b(a = "promo_text")
    private String mPromoText;
    @b(a = "seourl")
    private String mSeoUrl;
    @b(a = "short_desc")
    private String mShortDesc;
    @b(a = "tag")
    private String mTag;
    @b(a = "url")
    private String mUrl;

    public boolean isOTC() {
        return this.isOTC;
    }

    public void setOTC(boolean z) {
        this.isOTC = z;
    }

    public String getmPlanDescription() {
        return this.mPlanDescription;
    }

    public void setmPlanDescription(String str) {
        this.mPlanDescription = str;
    }

    public HashMap<String, String> getmDynamicDataObject() {
        return this.mDynamicDataObject;
    }

    public void setmDynamicDataObject(HashMap<String, String> hashMap) {
        this.mDynamicDataObject = hashMap;
    }

    public String getTransactionType() {
        return this.TransactionType;
    }

    public void setTransactionType(String str) {
        this.TransactionType = str;
    }

    public AttributesObject getAttributes() {
        return this.attributes;
    }

    public void setAttributes(AttributesObject attributesObject) {
        this.attributes = attributesObject;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getName() {
        return this.mName;
    }

    public String getShortDesc() {
        return this.mShortDesc;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getSeoUrl() {
        return this.mSeoUrl;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public String getOfferPrice() {
        return this.mOfferPrice;
    }

    public void setmOfferPrice(String str) {
        this.mOfferPrice = str;
    }

    public void setmLongRichDesc(ArrayList<CJRBrowsePlansRichDesc> arrayList) {
        this.mLongRichDesc = arrayList;
    }

    public String getmPlanName() {
        return this.mPlanName;
    }

    public void setmPlanName(String str) {
        this.mPlanName = str;
    }

    public String getmPlanGuiId() {
        return this.mPlanGuiId;
    }

    public void setmPlanGuiId(String str) {
        this.mPlanGuiId = str;
    }

    public void setmProductId(String str) {
        this.mProductId = str;
    }

    public String getActualPrice() {
        return this.mActualPrice;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public String getTag() {
        return this.mTag;
    }

    public ArrayList<CJRBrowsePlansRichDesc> getLongRichDesc() {
        return this.mLongRichDesc;
    }

    public String getmPlanValidity() {
        return this.mPlanValidity;
    }

    public void setmPlanValidity(String str) {
        this.mPlanValidity = str;
    }

    public String getPlanValidityDisplayString(Context context) {
        return context.getResources().getString(R.string.validity_browse_plan) + " " + getmPlanValidity();
    }

    public class AttributesObject implements IJRDataModel {
        @b(a = "producttype")
        private String productType;

        public AttributesObject() {
        }

        public String getProductType() {
            return this.productType;
        }

        public boolean isTopUp() {
            return !TextUtils.isEmpty(this.productType) && this.productType.equalsIgnoreCase("Topup");
        }

        public void setProductType(String str) {
            this.productType = str;
        }
    }
}
