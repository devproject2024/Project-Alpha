package com.paytmmall.clpartifact.modal.cart;

import android.text.TextUtils;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class CJRCartItem implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "delivery_type")
    private int deliveryType;
    @c(a = "exchange")
    private CartItemExchange exchange;
    @c(a = "validations")
    private IMEIValidation imeiValidation;
    @c(a = "installation_eligible")
    private boolean isInstallationEligible;
    @c(a = "is_pfa")
    private int isPFA;
    @c(a = "item_id")
    private String itemID;
    @c(a = "available_quantity")
    private String mAvlbleQuantity;
    @c(a = "categoryMap")
    private ArrayList<CJRCategoryMap> mCategoryMap;
    @c(a = "discounted_price")
    private double mDiscountedPrice;
    @c(a = "error")
    private String mError;
    @c(a = "error_code")
    private String mErrorCode;
    @c(a = "error_title")
    private String mErrorTitle;
    @c(a = "image_url")
    private String mImageUrl;
    @c(a = "instock")
    private boolean mIsInstock;
    @c(a = "more_sellers")
    private Boolean mIsMoreSellers;
    @c(a = "aggregate_item_price")
    private double mItemAggregateItemPrice;
    @c(a = "merchant_id")
    private long mMerchantId;
    @c(a = "merchant_name")
    private String mMerchantName;
    @c(a = "mrp")
    private double mMrp;
    @c(a = "newurl")
    private String mNewUrl;
    @c(a = "offer_text")
    private String mOfferText;
    @c(a = "pp_logo_url")
    private String mPPLogoUrl;
    private Long mParentID;
    @c(a = "price")
    private double mPrice;
    @c(a = "product_config_name")
    private String mProductConfigName;
    @c(a = "product_id")
    private long mProductId;
    @c(a = "promocode")
    private String mPromoCode;
    @c(a = "promostatus")
    private String mPromoStatus;
    @c(a = "promotext")
    private String mPromoText;
    @c(a = "quantity")
    private int mQuantity;
    @c(a = "return_policy")
    private ReturnPolicy mReturnPolicy;
    @c(a = "selling_price")
    private double mSellingPrice;
    @c(a = "shipping_charges")
    private double mShippingCharges = -1.0d;
    @c(a = "shipping_cost")
    private double mShippingCost;
    @c(a = "title")
    private String mTitle;
    @c(a = "total_price")
    private double mTotalPrice;
    @c(a = "tracking_info")
    private CJRTrackingInfo mTrackingInfo;
    @c(a = "url")
    private String mUrl;
    @c(a = "parent_id")
    private String mUrlType = "product";
    @c(a = "vertical_label")
    private String mVerticalLabel;
    @c(a = "max_purchasable_qty")
    private long maximumPurchasableQty;
    @c(a = "warehouse_address")
    private CJRCartItemMerchantAddress merchantAddress;
    @c(a = "need_shipping")
    private boolean needShipping;
    @c(a = "return_policy_label")
    private String returnPolicyLabel;
    @c(a = "return_policy_summary")
    private String returnPolicySummary;
    @c(a = "return_policy_text")
    private String returnPolicyText;
    @c(a = "seourl")
    private String seourl;
    @c(a = "vertical_id")
    private long verticalId;

    public String getUrlType() {
        return "product";
    }

    public CartItemExchange getExchange() {
        return this.exchange;
    }

    public void setExchange(CartItemExchange cartItemExchange) {
        this.exchange = cartItemExchange;
    }

    public boolean isNeedShipping() {
        return this.needShipping;
    }

    public void setNeedShipping(boolean z) {
        this.needShipping = z;
    }

    public long getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(long j) {
        this.verticalId = j;
    }

    public double getItemAggregateItemPrice() {
        return this.mItemAggregateItemPrice;
    }

    public long getMaximumPurchasableQty() {
        return this.maximumPurchasableQty;
    }

    public void setMaximumPurchasableQty(long j) {
        this.maximumPurchasableQty = j;
    }

    public int getQuantity() {
        return this.mQuantity;
    }

    public void setQuantity(int i2) {
        this.mQuantity = i2;
    }

    public String getItemId() {
        return this.itemID;
    }

    public void setItemId(String str) {
        this.itemID = str;
    }

    public long getProductId() {
        return this.mProductId;
    }

    public void setProductId(long j) {
        this.mProductId = j;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getUrl() {
        return getProductUrl();
    }

    private String getProductUrl() {
        if (!TextUtils.isEmpty(this.mNewUrl)) {
            return this.mNewUrl;
        }
        if (!TextUtils.isEmpty(this.seourl)) {
            return this.seourl;
        }
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = this.mUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public Long getParentID() {
        return this.mParentID;
    }

    public void setParentID(long j) {
        this.mParentID = Long.valueOf(j);
    }

    public class ReturnPolicy implements Serializable {
        @c(a = "cancellation_policy_icon")
        private String mCancellationPolicyIcon;
        @c(a = "cancellation_policy_text")
        private String mCancellationPolicyText;
        @c(a = "cancellation_policy_title")
        private String mCancellationPolicyTitle;
        @c(a = "return_policy_icon")
        private String mReturnPolicyIcon;
        @c(a = "return_policy_text")
        private String mReturnPolicyText;
        @c(a = "return_policy_title")
        private String mReturnPolicyTitle;

        public ReturnPolicy() {
        }

        public String getReturnPolicyTitle() {
            return this.mReturnPolicyTitle;
        }

        public String getReturnPolicyText() {
            return this.mReturnPolicyText;
        }

        public String getCancellationPolicyTitle() {
            return this.mCancellationPolicyTitle;
        }

        public String getCancellationPolicyText() {
            return this.mCancellationPolicyText;
        }

        public String getCancellationPolicyIcon() {
            return this.mCancellationPolicyIcon;
        }

        public String getReturnPolicyIcon() {
            return this.mReturnPolicyIcon;
        }

        public void setmReturnPolicyTitle(String str) {
            this.mReturnPolicyTitle = str;
        }

        public void setmReturnPolicyText(String str) {
            this.mReturnPolicyText = str;
        }

        public void setmReturnPolicyIcon(String str) {
            this.mReturnPolicyIcon = str;
        }

        public void setmCancellationPolicyTitle(String str) {
            this.mCancellationPolicyTitle = str;
        }

        public void setmCancellationPolicyText(String str) {
            this.mCancellationPolicyText = str;
        }

        public void setmCancellationPolicyIcon(String str) {
            this.mCancellationPolicyIcon = str;
        }
    }

    public class IMEIValidation implements Serializable {
        @c(a = "imei")
        private IMEIInfo imeiInfo;
        private boolean isImeiVerified;

        public IMEIValidation() {
        }

        public IMEIInfo getImeiInfo() {
            return this.imeiInfo;
        }

        public boolean isImeiVerified() {
            return this.isImeiVerified;
        }

        public void setImeiVerified(boolean z) {
            this.isImeiVerified = z;
        }
    }

    public class IMEIInfo implements Serializable {
        @c(a = "is_verified")
        private String isVerified;
        @c(a = "number")
        private String mImeinumber;

        public IMEIInfo() {
        }

        public String getIMEINumber() {
            return this.mImeinumber;
        }

        public String getIsIMEIverified() {
            return this.isVerified;
        }
    }
}
