package com.paytmmall.artifact.cart.entity;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRLongRichDesc;
import com.paytmmall.artifact.grid.entity.CJRAncestor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CJRDetailProduct extends CJRProduct {
    private static final String ESTIMATED_ARRIVAL = "Estimated Arrival";
    private static final String SHIPPING_DETAIL = "Shipping Details";
    private static final long serialVersionUID = 1;
    @b(a = "contextParams")
    private HashMap<String, String> contextParam;
    @b(a = "convenience_fee")
    private String convenienceFee;
    private LinkedHashMap<String, String> filterSelectMap = new LinkedHashMap<>();
    private String finalPrice;
    @b(a = "installation_eligible")
    private boolean hasInstallationServices;
    @b(a = "installation_charge")
    private String installationCharge;
    @b(a = "bargainable")
    private boolean isBargainable;
    @b(a = "bargained")
    private String isBargained;
    @b(a = "emi_enabled")
    private boolean isEmiEnabled;
    @b(a = "qty_pdp")
    private boolean isFmcgProduct;
    @b(a = "action_id")
    private String mActionId;
    @b(a = "action_text")
    private String mActionText;
    @b(a = "actual_price")
    private String mActualPrice;
    @b(a = "add_to_cart_url")
    private String mAddToCartUrl;
    @b(a = "ancestors")
    private ArrayList<CJRAncestor> mAncestors;
    @b(a = "attribute_chart")
    private Map<String, CJRFilterValue> mAttributeChart;
    @b(a = "attributes")
    private Map<String, String> mAttributes;
    @b(a = "bargain_name")
    private String mBargainName;
    @b(a = "brand_id")
    private String mBrandId;
    @b(a = "brand_logo")
    private String mBrandLogo;
    @b(a = "brand_seller_url")
    private String mBrandSellerUrl;
    public String mCartNotificationValue;
    @b(a = "cart_price")
    private String mCartPrice;
    @b(a = "cart_text")
    private String mCartText;
    @b(a = "category")
    private String mCategory;
    private String mCategoryId;
    @b(a = "category_ids")
    private ArrayList<String> mCategoryIds;
    private String mCategoryName;
    @b(a = "configuration_caption")
    private String mConfigurationCaption;
    @b(a = "configuration_name")
    private String mConfigurationName;
    @b(a = "delete_url")
    private String mDeleteUrl;
    @b(a = "discount")
    private String mDiscount;
    @b(a = "offer_price")
    private String mDiscountedPrice;
    @b(a = "emi_url")
    private String mEMIUrl;
    @b(a = "error")
    private String mError;
    private String mFilterAppliedUrl;
    @b(a = "filters")
    private ArrayList<CJRFilterItem> mFilterList = new ArrayList<>();
    @b(a = "footer_image_url")
    private String mFooterImageUrl;
    @b(a = "fulfilled_by_paytm")
    private int mFullFilledByPaytm;
    @b(a = "ga_key")
    private String mGAKey;
    @b(a = "image_data")
    private String mImageData;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "instock")
    private boolean mInStock;
    @b(a = "installation_url")
    private String mInstallationUrl;
    @b(a = "sequential_dimension")
    private boolean mIsSequential;
    @b(a = "item_id")
    private String mItemId;
    @b(a = "long_rich_desc")
    private ArrayList<CJRLongRichDesc> mLongRichDesc;
    @b(a = "max_qty_allowed")
    private int mMaxQuantityAllowed;
    @b(a = "merchant")
    private CJRMerchant mMerchant;
    @b(a = "merchant_sku")
    private String mMerchantSKU;
    @b(a = "need_shipping")
    private boolean mNeedShipping;
    @b(a = "newurl")
    private String mNewUrl;
    @b(a = "offer_url")
    private String mOfferUrl;
    @b(a = "other_images")
    private ArrayList<String> mOtherMedia;
    @b(a = "other_rich_desc")
    private String mOtherRichDesc;
    @b(a = "parent_id")
    private String mParentID;
    @b(a = "pincode")
    private String mPinCode;
    @b(a = "preorder")
    private boolean mPreorder;
    @b(a = "product_id")
    private String mProductID;
    @b(a = "productName")
    private String mProductName;
    @b(a = "product_rating")
    private String mProductRating;
    @b(a = "product_sku_id")
    private String mProductSkuID;
    @b(a = "product_url")
    private String mProductUrl;
    @b(a = "promo_text")
    private String mPromoText;
    @b(a = "promocode_url")
    private String mPromocodeUrl;
    @b(a = "protection_url")
    private String mProtectionUrl;
    @b(a = "quantity")
    private int mQuantity;
    @b(a = "selected_configuration")
    private int mSelectedConfiguration;
    private int mSelectedQuantity;
    @b(a = "seourl")
    private String mSeoUrl;
    @b(a = "shareurl")
    private String mShareUrl;
    @b(a = "shipping_charge")
    private Double mShippingCharge;
    @b(a = "shipping_cost")
    private String mShippingCost;
    private String mShortDesc;
    @b(a = "showMrpTag")
    private boolean mShowMrpTag;
    private String mSource;
    @b(a = "status")
    private boolean mStatus;
    @b(a = "title")
    private String mTitle;
    @b(a = "totalScore")
    private String mTotalScore;
    @b(a = "update_quantity_url")
    private String mUpdateQuantityUrl;
    @b(a = "url")
    private String mUrl;
    @b(a = "vertical_id")
    private String mVerticalID;
    @b(a = "vertical_label")
    private String mVerticalLabel;
    @b(a = "max_quantity")
    private int maxQuantity;
    @b(a = "min_quantity")
    private int minQuantity;
    @b(a = "return_policy")
    private CJRReturnPolicy returnPolicy;
    private boolean show;
    private boolean showEmiInfo;
    @b(a = "warranty_details")
    private LinkedHashMap<String, String> warrantyDetails;

    public String getmSource() {
        return this.mSource;
    }

    public void setmSource(String str) {
        this.mSource = str;
    }

    public String getmPinCode() {
        return this.mPinCode;
    }

    public boolean ismIsSequential() {
        return this.mIsSequential;
    }

    public CJRReturnPolicy getReturnPolicy() {
        return this.returnPolicy;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public void setContextParams(HashMap<String, String> hashMap) {
        this.contextParam = hashMap;
    }

    public HashMap<String, String> getContextParams() {
        return this.contextParam;
    }

    public LinkedHashMap<String, String> getWarrantyDetails() {
        return this.warrantyDetails;
    }

    public void setWarrantyDetails(LinkedHashMap<String, String> linkedHashMap) {
        this.warrantyDetails = linkedHashMap;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getShareUrl() {
        return this.mShareUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getBargainName() {
        return this.mBargainName;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public String getmActualPrice() {
        return this.mActualPrice;
    }

    public String getmAddToCartUrl() {
        return this.mAddToCartUrl;
    }

    public boolean getIsBargainable() {
        return this.isBargainable;
    }

    public String getIsBargained() {
        return this.isBargained;
    }

    public String getmCartPrice() {
        return this.mCartPrice;
    }

    public String getmCartText() {
        return this.mCartText;
    }

    public String getmDeleteUrl() {
        return this.mDeleteUrl;
    }

    public String getmDiscountedPrice() {
        return this.mDiscountedPrice;
    }

    public String getmImageData() {
        return this.mImageData;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public CJRMerchant getmMerchant() {
        return this.mMerchant;
    }

    public String getmOtherRichDesc() {
        return this.mOtherRichDesc;
    }

    public String getmProductRating() {
        return this.mProductRating;
    }

    public String getmProductSkuID() {
        return this.mProductSkuID;
    }

    public String getmProductUrl() {
        return this.mProductUrl;
    }

    public String getmPromoText() {
        return this.mPromoText;
    }

    public String getmPromocodeUrl() {
        return this.mPromocodeUrl;
    }

    public int getmQuantity() {
        return this.mQuantity;
    }

    public String getmShippingCost() {
        return this.mShippingCost;
    }

    public String getmShortDesc() {
        return this.mShortDesc;
    }

    public String getmUpdateQuantityUrl() {
        return this.mUpdateQuantityUrl;
    }

    public ArrayList<String> getmOtherMedia() {
        return this.mOtherMedia;
    }

    public String getmConfigurationCaption() {
        return this.mConfigurationCaption;
    }

    public String getConfigurationName() {
        return this.mConfigurationName;
    }

    public String getFooterImageUrl() {
        return this.mFooterImageUrl;
    }

    public String getmProductID() {
        return this.mProductID;
    }

    public String getparentID() {
        return this.mParentID;
    }

    public ArrayList<CJRLongRichDesc> getmLongRichDesc() {
        return this.mLongRichDesc;
    }

    public ArrayList<CJRFilterItem> getFilterList() {
        return this.mFilterList;
    }

    public int getSelectedConfiguration() {
        return this.mSelectedConfiguration;
    }

    public String getmUrl() {
        return getProductUrl();
    }

    private String getProductUrl() {
        if (!TextUtils.isEmpty(this.mNewUrl)) {
            return this.mNewUrl;
        }
        if (!TextUtils.isEmpty(this.mSeoUrl)) {
            return this.mSeoUrl;
        }
        return this.mUrl;
    }

    public Map<String, CJRFilterValue> getAttributeChart() {
        return this.mAttributeChart;
    }

    public Map<String, String> getAttributes() {
        return this.mAttributes;
    }

    public boolean isInStock() {
        return this.mInStock;
    }

    public String getError() {
        return this.mError;
    }

    public boolean isShippingNeeded() {
        return this.mNeedShipping;
    }

    public String getVerticalLabel() {
        return this.mVerticalLabel;
    }

    public String getBrandId() {
        return this.mBrandId;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public String getShippingDetail() {
        Iterator<CJRLongRichDesc> it2 = this.mLongRichDesc.iterator();
        while (it2.hasNext()) {
            CJRLongRichDesc next = it2.next();
            if (SHIPPING_DETAIL.equalsIgnoreCase(next.getmTitle())) {
                Map<String, String> map = next.getmAttributes();
                if (map.containsKey(ESTIMATED_ARRIVAL)) {
                    return map.get(ESTIMATED_ARRIVAL);
                }
            }
        }
        return null;
    }

    public String getDiscount() {
        return this.mDiscount;
    }

    public String getGAKey() {
        return this.mGAKey;
    }

    public String getmOfferUrl() {
        return this.mOfferUrl;
    }

    public String getmBrandSellerUrl() {
        return this.mBrandSellerUrl;
    }

    public ArrayList<String> getCategoryIds() {
        return this.mCategoryIds;
    }

    public void setCategoryIds(ArrayList<String> arrayList) {
        this.mCategoryIds = arrayList;
    }

    public String getmVerticalID() {
        return this.mVerticalID;
    }

    public void setmVerticalID(String str) {
        this.mVerticalID = str;
    }

    public String getConvenienceFee() {
        return this.convenienceFee;
    }

    public void setConvenienceFee(String str) {
        this.convenienceFee = str;
    }

    public String getmActionId() {
        return this.mActionId;
    }

    public String getmActionText() {
        return this.mActionText;
    }

    public Double getmShippingCharge() {
        return this.mShippingCharge;
    }

    public void setmShippingCharge(Double d2) {
        this.mShippingCharge = d2;
    }

    public String getBrandLogo() {
        return this.mBrandLogo;
    }

    public int getMaxQuantityAllowed() {
        return this.mMaxQuantityAllowed;
    }

    public int getmFullFilledByPaytm() {
        return this.mFullFilledByPaytm;
    }

    public void setmFullFilledByPaytm(int i2) {
        this.mFullFilledByPaytm = i2;
    }

    public void setFilterSelectMap(LinkedHashMap<String, String> linkedHashMap) {
        this.filterSelectMap = linkedHashMap;
    }

    public LinkedHashMap<String, String> getFilterSelectMap() {
        return this.filterSelectMap;
    }

    public void setFilterAppliedUrl(String str) {
        this.mFilterAppliedUrl = str;
    }

    public String getFilterSelectedUrl() {
        return this.mFilterAppliedUrl;
    }

    public boolean hasInstallationServices() {
        return this.hasInstallationServices;
    }

    public int getSelectedQuantity() {
        return this.mSelectedQuantity;
    }

    public void setSelectedQuantity(int i2) {
        this.mSelectedQuantity = i2;
    }

    public String getNotificationItemValue() {
        return this.mCartNotificationValue;
    }

    public void setNotificationItemValue(String str) {
        this.mCartNotificationValue = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public boolean isEmiEnabled() {
        return this.isEmiEnabled;
    }

    public void setEmiEnabled(boolean z) {
        this.isEmiEnabled = z;
    }

    public String getEMIUrl() {
        return this.mEMIUrl;
    }

    public String getInstallationUrl() {
        return this.mInstallationUrl;
    }

    public String getmProtectionUrl() {
        return this.mProtectionUrl;
    }

    public String getmProductName() {
        return this.mProductName;
    }

    public String getmTotalScore() {
        return this.mTotalScore;
    }

    public boolean getmStatus() {
        return this.mStatus;
    }

    public boolean getmPreorder() {
        return this.mPreorder;
    }

    public String ismMerchantSKU() {
        return this.mMerchantSKU;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isFmcgProduct() {
        return this.isFmcgProduct;
    }

    public int getMinQuantity() {
        return this.minQuantity;
    }

    public int getMaxQuantity() {
        return this.maxQuantity;
    }

    public String getInstallationCharge() {
        return this.installationCharge;
    }

    public void setInstallationCharge(String str) {
        this.installationCharge = str;
    }

    public boolean isShowEmiInfo() {
        return this.showEmiInfo;
    }

    public void setShowEmiInfo(boolean z) {
        this.showEmiInfo = z;
    }

    public void setAttributes(Map<String, String> map) {
        this.mAttributes = map;
    }

    public boolean isShowMRPTag() {
        return this.mShowMrpTag;
    }

    public void setmActualPrice(String str) {
        this.mActualPrice = str;
    }

    public void setmDiscountedPrice(String str) {
        this.mDiscountedPrice = str;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setmProductName(String str) {
        this.mName = str;
    }

    public void setmProductID(String str) {
        this.mProductID = str;
    }

    public String getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(String str) {
        this.finalPrice = str;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public void setReturnPolicy(CJRReturnPolicy cJRReturnPolicy) {
        this.returnPolicy = cJRReturnPolicy;
    }

    public void setmMerchant(CJRMerchant cJRMerchant) {
        this.mMerchant = cJRMerchant;
    }

    public String getAllAncestors() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList != null && arrayList.size() > 1) {
            int size = this.mAncestors.size();
            for (int i2 = 0; i2 < size - 1; i2++) {
                sb.append(this.mAncestors.get(i2).getName());
                if (size > 2 && i2 < size - 2) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public CJRAncestor getImmidiateAncestorObj() {
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList == null || arrayList.size() - 2 < 0) {
            return null;
        }
        ArrayList<CJRAncestor> arrayList2 = this.mAncestors;
        CJRAncestor cJRAncestor = arrayList2.get(arrayList2.size() - 2);
        if (cJRAncestor != null) {
            return cJRAncestor;
        }
        return null;
    }
}
