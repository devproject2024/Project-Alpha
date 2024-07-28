package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRPincodeCheck extends IJRPaytmDataModel {
    private static final long serialVersionUID = 6385089574864398425L;
    @b(a = "estimate_delivery_range")
    private List<String> estimateDeliveryRange = new ArrayList();
    int id;
    private boolean isBrandAuthorised;
    @b(a = "enabled")
    private boolean isEnabled;
    private boolean isSelectedImage = false;
    @b(a = "actual_price")
    private double mACtualPrice;
    @b(a = "cod_text")
    private String mCODText;
    @b(a = "cod_enabled")
    private boolean mCodEnabled;
    @b(a = "delivery_type")
    private int mDeliveryType;
    @b(a = "discount")
    private String mDiscountPrice;
    @b(a = "display_text")
    private String mDisplayText;
    @b(a = "error")
    private String mError;
    @b(a = "is_pfa")
    private int mIsPFA;
    @b(a = "pick_at_store")
    private boolean mIsPickAtStoreAvailable;
    @b(a = "locality")
    private String mLocality;
    private double mOfferPrice;
    @b(a = "pincode")
    private String mPincode;
    private String mProductID;
    @b(a = "product_promise_logo_url")
    private String mProductPromiseLogoUrl;
    private String mSellerName;
    @b(a = "shipping_charges")
    private int mShippingCharges;
    @b(a = "shipping_charges_rule_id")
    private int mShippingChargesRuleID;
    @b(a = "status")
    private CJRCartStatus mStatus;
    @b(a = "wid")
    private String mWID;

    public int getmShippingChargesRuleID() {
        return this.mShippingChargesRuleID;
    }

    public List<String> getEstimateDeliveryRange() {
        return this.estimateDeliveryRange;
    }

    public String getmPincode() {
        return this.mPincode;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean ismCodEnabled() {
        return this.mCodEnabled;
    }

    public int getmShippingCharges() {
        return this.mShippingCharges;
    }

    public int getmIsPFA() {
        return this.mIsPFA;
    }

    public int getmDeliveryType() {
        return this.mDeliveryType;
    }

    public String getmError() {
        return this.mError;
    }

    public String getmProductPromiseLogoUrl() {
        return this.mProductPromiseLogoUrl;
    }

    public String getmWID() {
        return this.mWID;
    }

    public String getmCODText() {
        return this.mCODText;
    }

    public String getmDisplayText() {
        return this.mDisplayText;
    }

    public boolean ismIsPickAtStoreAvailable() {
        return this.mIsPickAtStoreAvailable;
    }

    public String getmProductID() {
        return this.mProductID;
    }

    public void setmProductID(String str) {
        this.mProductID = str;
    }

    public boolean isSelectedImage() {
        return this.isSelectedImage;
    }

    public void setSelectedImage(boolean z) {
        this.isSelectedImage = z;
    }

    public String getmSellerName() {
        return this.mSellerName;
    }

    public void setmSellerName(String str) {
        this.mSellerName = str;
    }

    public double getmOfferPrice() {
        return this.mOfferPrice;
    }

    public void setmOfferPrice(double d2) {
        this.mOfferPrice = d2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public double getmACtualPrice() {
        return this.mACtualPrice;
    }

    public void setmACtualPrice(double d2) {
        this.mACtualPrice = d2;
    }

    public String getmDiscountPrice() {
        return this.mDiscountPrice;
    }

    public void setmDiscountPrice(String str) {
        this.mDiscountPrice = str;
    }

    public boolean isBrandAuthorised() {
        return this.isBrandAuthorised;
    }

    public void setBrandAuthorised(boolean z) {
        this.isBrandAuthorised = z;
    }

    public String getmLocality() {
        return this.mLocality;
    }

    public void setmShippingCharges(int i2) {
        this.mShippingCharges = i2;
    }

    public void setmDisplayText(String str) {
        this.mDisplayText = str;
    }

    public CJRCartStatus getStatus() {
        return this.mStatus;
    }
}
