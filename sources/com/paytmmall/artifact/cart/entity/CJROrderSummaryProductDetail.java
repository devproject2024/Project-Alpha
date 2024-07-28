package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJROrderSummaryProductDetail extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    public double discountedPrice;
    @b(a = "brand")
    private String mBrandName;
    @b(a = "category_id")
    private long mCategoryId;
    @b(a = "categoryMap")
    private ArrayList<CJRCategoryMap> mCategoryMap;
    @b(a = "category_path")
    private String mCategoryPath;
    @b(a = "ga_key")
    private String mGAkey;
    @b(a = "id")
    private long mId;
    @b(a = "image")
    private String mImageUrl;
    @b(a = "merchant_name")
    private String mMerchantName;
    @b(a = "name")
    private String mName;
    @b(a = "need_shipping")
    private String mNeedShipping;
    @b(a = "parent_id")
    public String mParentId;
    @b(a = "price")
    private double mPrice;
    @b(a = "product_type")
    private String mProductType;
    @b(a = "promo_text")
    private String mPromoText;
    private String mRedeemText;
    @b(a = "thumbnail")
    private String mThumnail;
    @b(a = "thumbnail_base64")
    private String mThumnailBase64;
    @b(a = "url")
    private String mURL;
    @b(a = "vertical_label")
    private String mVertical;
    @b(a = "vertical_id")
    private long mVerticalId;
    @b(a = "return_policy_text")
    private String returnPolicyText;

    public String getGAkey() {
        return this.mGAkey;
    }

    public String getName() {
        return this.mName;
    }

    public long getId() {
        return this.mId;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public String getURL() {
        return this.mURL;
    }

    public String getThumbnail() {
        return this.mThumnail;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getThumnailBase64() {
        return this.mThumnailBase64;
    }

    public String getVertical() {
        return this.mVertical;
    }

    public long getVerticalId() {
        return this.mVerticalId;
    }

    public String getNeedShipping() {
        return this.mNeedShipping;
    }

    public long getCategoryId() {
        return this.mCategoryId;
    }

    public String getCategoryPath() {
        return this.mCategoryPath;
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(double d2) {
        this.discountedPrice = d2;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public CJRCategoryMap getImmidiateCategory() {
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList == null || arrayList.size() - 2 < 0) {
            return null;
        }
        ArrayList<CJRCategoryMap> arrayList2 = this.mCategoryMap;
        CJRCategoryMap cJRCategoryMap = arrayList2.get(arrayList2.size() - 2);
        if (cJRCategoryMap != null) {
            return cJRCategoryMap;
        }
        return null;
    }

    public String getReturnPolicyText() {
        return this.returnPolicyText;
    }

    public String getRedeemText() {
        return this.mRedeemText;
    }

    public void setRedeemText(String str) {
        this.mRedeemText = str;
    }
}
