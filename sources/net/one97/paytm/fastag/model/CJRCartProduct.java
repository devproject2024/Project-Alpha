package net.one97.paytm.fastag.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CJRCartProduct extends CJRProduct {
    private static final long serialVersionUID = 1;
    @b(a = "attributes_dim_values")
    private Map<String, String> cartItemAttribute;
    @b(a = "cashback_text")
    private String cashbackText;
    @b(a = "conv_fee_map")
    HashMap<String, String> convenienceFeeMap;
    @b(a = "delivery_text")
    private String deliveryText;
    @b(a = "delivery_type")
    private int deliveryType;
    @b(a = "validations")
    private IMEIValidation imeiValidation;
    @b(a = "installation_url")
    private String installationUrl;
    private boolean isFirstCartItem;
    @b(a = "installation_eligible")
    private boolean isInstallationEligible;
    @b(a = "non_returnable")
    private boolean isNonReturnable;
    @b(a = "is_pfa")
    private int isPFA;
    private boolean isScanResult;
    @b(a = "item_id")
    private String itemID;
    @b(a = "available_quantity")
    private String mAvlbleQuantity;
    @b(a = "categoryMap")
    private ArrayList<CJRCategoryMap> mCategoryMap;
    public String mContainerInstanceID;
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "estimated_delivery_range")
    private ArrayList<String> mDates;
    @b(a = "paytm_discount")
    private String mDiscount;
    @b(a = "discounted_price")
    private String mDiscountedPrice;
    private int mDisplayValueIndex;
    @b(a = "error")
    private String mError;
    @b(a = "error_code")
    private String mErrorCode;
    @b(a = "error_title")
    private String mErrorTitle;
    @b(a = "estimated_delivery")
    private String mEstimatedDelivery;
    @b(a = "ga_key")
    private String mGAkey;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "instock")
    private boolean mIsInstock;
    @b(a = "more_sellers")
    private Boolean mIsMoreSellers;
    @b(a = "aggregate_item_price")
    private String mItemAggregateItemPrice;
    @b(a = "merchant_id")
    private String mMerchantId;
    @b(a = "merchant_name")
    private String mMerchantName;
    private MerchantRatingNew mMerchantRating;
    @b(a = "meta_data")
    public Object mMetaDataResponse;
    @b(a = "mrp")
    private String mMrp;
    @b(a = "need_shipping")
    private boolean mNeedShipping;
    @b(a = "offer_text")
    private String mOfferText;
    @b(a = "offer_url")
    private String mOffersUrl;
    @b(a = "pp_logo_url")
    private String mPPLogoUrl;
    @b(a = "parent_id")
    private String mParentID;
    @b(a = "paytm_cashback")
    private String mPaytmCashBack;
    @b(a = "price")
    private String mPrice;
    @b(a = "product_config_name")
    private String mProductConfigName;
    @b(a = "product_id")
    private String mProductId;
    @b(a = "promocode")
    private String mPromoCode;
    @b(a = "promostatus")
    private String mPromoStatus;
    @b(a = "promotext")
    private String mPromoText;
    private String mQRScanedCode;
    @b(a = "quantity")
    private String mQuantity;
    @b(a = "configuration")
    private Map<String, String> mRechargeConfigList;
    @b(a = "return_policy")
    private ReturnPolicy mReturnPolicy;
    @b(a = "selling_price")
    private String mSellingPrice;
    @b(a = "shipping_charges")
    private int mShippingCharges = -1;
    @b(a = "shipping_cost")
    private String mShippingCost;
    @b(a = "title")
    private String mTitle;
    @b(a = "total_price")
    private String mTotalPrice;
    @b(a = "tracking_info")
    private CJRTrackingInfo mTrackingInfo;
    @b(a = "url")
    private String mUrl;
    @b(a = "vertical_id")
    private String mVerticalId;
    @b(a = "vertical_label")
    private String mVerticalLabel;
    @b(a = "other_taxes")
    private ArrayList<CJROtherTaxes> otherTaxes;
    @b(a = "return_policy_label")
    private String returnPolicyLabel;
    @b(a = "return_policy_summary")
    private String returnPolicySummary;
    @b(a = "return_policy_text")
    private String returnPolicyText;
    @b(a = "seourl")
    private String seourl;
    private boolean showMerchantView = false;

    public boolean isInstallationEligible() {
        return false;
    }

    public MerchantRatingNew getmMerchantRating() {
        return this.mMerchantRating;
    }

    public void setmMerchantRating(MerchantRatingNew merchantRatingNew) {
        this.mMerchantRating = merchantRatingNew;
    }

    public String getmPromoCode() {
        return this.mPromoCode;
    }

    public void setmPromoCode(String str) {
        this.mPromoCode = str;
    }

    public void setmPromoStatus(String str) {
        this.mPromoStatus = str;
    }

    public String getmPromoText() {
        return this.mPromoText;
    }

    public void setmPromoText(String str) {
        this.mPromoText = str;
    }

    public String getmItemAggregateItemPrice() {
        return this.mItemAggregateItemPrice;
    }

    public String getReturnPolicyLabel() {
        return this.returnPolicyLabel;
    }

    public String getReturnPolicySummary() {
        return this.returnPolicySummary;
    }

    public String getReturnPolicyText() {
        return this.returnPolicyText;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getmPPLogoUrl() {
        return this.mPPLogoUrl;
    }

    public int getIsPFA() {
        return this.isPFA;
    }

    public int getDeliveryType() {
        return this.deliveryType;
    }

    public String getParentID() {
        return this.mParentID;
    }

    public String getVerticalId() {
        return this.mVerticalId;
    }

    public void setVerticalId(String str) {
        this.mVerticalId = str;
    }

    public void setTrackingInfo(CJRTrackingInfo cJRTrackingInfo) {
        this.mTrackingInfo = cJRTrackingInfo;
    }

    public CJRTrackingInfo getTrackingInfo() {
        return this.mTrackingInfo;
    }

    public String getCategoryPathForGTM() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mCategoryMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mCategoryMap.get(i2).getName());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public String getLastItemInCategoryMap() {
        StringBuilder sb = new StringBuilder();
        try {
            if (this.mCategoryMap.size() > 0) {
                sb.append(this.mCategoryMap.get(this.mCategoryMap.size() - 1).getCategoryId());
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public ArrayList<CJRCategoryMap> getCategoryMap() {
        return this.mCategoryMap;
    }

    public Map<String, String> getConfigurationList() {
        return this.mRechargeConfigList;
    }

    public boolean getNeedShipping() {
        return this.mNeedShipping;
    }

    public String getName() {
        return this.mName;
    }

    public String getError() {
        return this.mError;
    }

    public String getErrorTitle() {
        return this.mErrorTitle;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public String getProductConfigName() {
        return this.mProductConfigName;
    }

    public String getQuantity() {
        return this.mQuantity;
    }

    public String getPrice() {
        return TextUtils.isEmpty(this.mPrice) ? "0" : this.mPrice;
    }

    public String getDiscountedPrice() {
        return TextUtils.isEmpty(this.mDiscountedPrice) ? "0" : this.mDiscountedPrice;
    }

    public String getShippingCost() {
        return this.mShippingCost;
    }

    public String getPromoCode() {
        return this.mPromoCode;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getMerchantId() {
        return this.mMerchantId;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getMrp() {
        return TextUtils.isEmpty(this.mMrp) ? "0" : this.mMrp;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setmDisplayValueIndex(int i2) {
        this.mDisplayValueIndex = i2;
    }

    public void setmShippingCharges(int i2) {
        this.mShippingCharges = i2;
    }

    public int getShippingCharges() {
        return this.mShippingCharges;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getSellingPrice() {
        return TextUtils.isEmpty(this.mSellingPrice) ? "0" : this.mSellingPrice;
    }

    public String getmOfferText() {
        return this.mOfferText;
    }

    public String getTotalPrice() {
        return TextUtils.isEmpty(this.mTotalPrice) ? "0" : this.mTotalPrice;
    }

    public String getAvlbleQuantity() {
        return this.mAvlbleQuantity;
    }

    public String getVerticalLabel() {
        return this.mVerticalLabel;
    }

    public String getmPromoStatus() {
        return this.mPromoStatus;
    }

    public void setmQuantity(String str) {
        this.mQuantity = str;
    }

    public ArrayList<String> getDates() {
        return this.mDates;
    }

    public String getmEstimatedDelivery() {
        String str;
        String str2 = null;
        if (getDates() == null || getDates().size() <= 0) {
            return null;
        }
        String str3 = new String();
        if (getDates().get(1) != null) {
            str = getDates().get(1);
            if (str.contains("T")) {
                str = str.substring(0, str.indexOf("T"));
            }
        } else {
            str = null;
        }
        if (getDates().get(0) != null) {
            str2 = getDates().get(0);
            if (str2.contains("T")) {
                str2 = str2.substring(0, str2.indexOf("T"));
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM");
        if (str2 == null || str == null) {
            return str3;
        }
        try {
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse2);
            Integer valueOf = Integer.valueOf(instance.get(53));
            String format = simpleDateFormat2.format(instance.getTime());
            instance.setTime(parse);
            Integer valueOf2 = Integer.valueOf(instance.get(53));
            String format2 = simpleDateFormat2.format(instance.getTime());
            if (format2.equals(format)) {
                return str3 + valueOf + "-" + valueOf2 + " " + format2;
            }
            return str3 + valueOf + " " + format + "-" + valueOf2 + " " + format2;
        } catch (Exception unused) {
            return str3;
        }
    }

    public Map<String, String> getCartItemAttribute() {
        return this.cartItemAttribute;
    }

    public String getmConvFee() {
        return this.mConvFee;
    }

    public void setmConvFee(String str) {
        this.mConvFee = str;
    }

    public String getPaytmCashBack() {
        return this.mPaytmCashBack;
    }

    public String getmDiscount() {
        return this.mDiscount;
    }

    public String getOffersUrl() {
        return this.mOffersUrl;
    }

    public String getGAkey() {
        return this.mGAkey;
    }

    public boolean getIsInstock() {
        return this.mIsInstock;
    }

    public int getDisplayArrayIndex() {
        return this.mDisplayValueIndex;
    }

    public void setDisplayItemIndex(int i2) {
        this.mDisplayValueIndex = i2;
    }

    public Object getMetaDataResponse() {
        return this.mMetaDataResponse;
    }

    public void setMetaDataResponse(Object obj) {
        this.mMetaDataResponse = obj;
    }

    public ArrayList<CJROtherTaxes> getOtherTaxes() {
        return this.otherTaxes;
    }

    public String getmContainerInstanceID() {
        return this.mContainerInstanceID;
    }

    public void setmContainerInstanceID(String str) {
        this.mContainerInstanceID = str;
    }

    public String getCategoryIdForGTM() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRCategoryMap> arrayList = this.mCategoryMap;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mCategoryMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mCategoryMap.get(i2).getCategoryId());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public Boolean ismIsMoreSellers() {
        return this.mIsMoreSellers;
    }

    public void setmIsMoreSellers(Boolean bool) {
        this.mIsMoreSellers = bool;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public HashMap<String, String> getConvenienceFeeMap() {
        return this.convenienceFeeMap;
    }

    public void setConvenienceFeeMap(HashMap<String, String> hashMap) {
        this.convenienceFeeMap = hashMap;
    }

    public boolean isFirstCartItem() {
        return this.isFirstCartItem;
    }

    public void setFirstCartItem(boolean z) {
        this.isFirstCartItem = z;
    }

    public String getDeliveryText() {
        return this.deliveryText;
    }

    public boolean isShowMerchantView() {
        return this.showMerchantView;
    }

    public void setShowMerchantView(boolean z) {
        this.showMerchantView = z;
    }

    public String getInstallationUrl() {
        return this.installationUrl;
    }

    public boolean isNonReturnable() {
        return this.isNonReturnable;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public String getImeiNumber() {
        return this.mQRScanedCode;
    }

    public void setImeiNumber(String str) {
        this.mQRScanedCode = str;
    }

    public void setIsScanResult(boolean z) {
        this.isScanResult = z;
    }

    public boolean isScanResult() {
        return this.isScanResult;
    }

    public IMEIValidation getImeiValidation() {
        return this.imeiValidation;
    }

    public ReturnPolicy getmReturnPolicy() {
        return this.mReturnPolicy;
    }

    public void setmRechargeConfigList(Map<String, String> map) {
        this.mRechargeConfigList = map;
    }

    public void setmProductId(String str) {
        this.mProductId = str;
    }

    public class ReturnPolicy extends IJRPaytmDataModel {
        @b(a = "cancellation_policy_icon")
        private String mCancellationPolicyIcon;
        @b(a = "cancellation_policy_text")
        private String mCancellationPolicyText;
        @b(a = "cancellation_policy_title")
        private String mCancellationPolicyTitle;
        @b(a = "return_policy_icon")
        private String mReturnPolicyIcon;
        @b(a = "return_policy_text")
        private String mReturnPolicyText;
        @b(a = "return_policy_title")
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

    public class IMEIValidation extends IJRPaytmDataModel {
        @b(a = "imei")
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

    public class IMEIInfo extends IJRPaytmDataModel {
        @b(a = "is_verified")
        private String isVerified;
        @b(a = "number")
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
