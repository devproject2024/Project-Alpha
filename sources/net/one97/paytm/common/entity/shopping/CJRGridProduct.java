package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGridProduct extends CJRItem {
    private static final long serialVersionUID = 1;
    @b(a = "actual_price")
    private String actualPrice;
    @b(a = "add_to_cart")
    private int addToCart;
    private int addedQuantity = 1;
    private String affiliateID;
    @b(a = "brand")
    private String brand;
    private String deeplink;
    @b(a = "discount")
    private String discountPercent;
    @b(a = "offer_price")
    private String discountedPrice;
    private boolean hasBorder = false;
    @b(a = "image_data")
    private String imageData;
    @b(a = "img_height")
    private String imageHeight;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "img_width")
    private String imageWidth;
    @b(a = "stock")
    private boolean inStock;
    private boolean isAddToCartShow = true;
    private boolean isDeleted;
    private boolean isPromoRemoved;
    private boolean isSelected = false;
    private boolean itemViewed;
    private String jsonValue;
    @b(a = "updated_at")
    private String lastUpdatedAt;
    @b(a = "location_score")
    private double locationScore;
    @b(a = "long_rich_desc")
    private ArrayList<CJRLongRichDesc> longRichDesc = new ArrayList<>();
    private String mAncestorID;
    private String mContainerInstanceID;
    private String mDealError = "";
    private boolean mHasVisibleDetails;
    private boolean mIsAdded;
    private boolean mIsExpanded;
    private boolean mIsSelect;
    private String mItemBgColor = "#FFFFFFFF";
    private String mListId = "";
    private String mListName;
    private int mListPosition;
    @b(a = "offers_url")
    private String mOfferURL;
    @b(a = "offers")
    private ArrayList<PromoData> mPromoData = new ArrayList<>();
    private String mSearchABValue;
    private String mSearchCategory;
    private String mSearchResultType;
    private String mSearchTerm;
    private String mSearchType;
    private String mSelectedPromo;
    private String mSelectedPromoCashBack;
    private String mSelectedPromoMSg;
    @b(a = "vertical_id")
    private String mVerticalId;
    @b(a = "max_quantity")
    private int maxQuantity = 10;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "message")
    private CJRTermsAndConditions message;
    @b(a = "min_quantity")
    private int minPurchaseQuantity;
    @b(a = "offers_more")
    private int moreOfferCount;
    @b(a = "name")
    private String name;
    @b(a = "tag")
    private String offerTag;
    @b(a = "parent_id")
    private String parentId;
    @b(a = "product_id")
    private String productID;
    @b(a = "product_type")
    private String productType;
    @b(a = "promo_text")
    private String promoText;
    private String qrCodeID;
    private String qrCodeOrderID;
    @b(a = "short_desc")
    private String shortDesc;
    @b(a = "source")
    private String source;
    private Map<String, Object> sourceInfo = null;
    private String timeStamp;
    @b(a = "url")
    private String url;
    @b(a = "url_type")
    private String urlType;

    public String getCategoryId() {
        return null;
    }

    public String getItemID() {
        return null;
    }

    public String getLabel() {
        return null;
    }

    public ArrayList<CJRRelatedCategory> getRelatedCategories() {
        return null;
    }

    public void setMoreOfferCount(int i2) {
        this.moreOfferCount = i2;
    }

    public String getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public void setLastUpdatedAt(String str) {
        this.lastUpdatedAt = str;
    }

    public String getJsonValue() {
        return this.jsonValue;
    }

    public void setJsonValue(String str) {
        this.jsonValue = str;
    }

    public ArrayList<PromoData> getPromoData() {
        return this.mPromoData;
    }

    public int getMoreOfferCount() {
        return this.moreOfferCount;
    }

    public String getOfferURL() {
        return this.mOfferURL;
    }

    public boolean isPromoRemoved() {
        return this.isPromoRemoved;
    }

    public void setPromoRemoved(boolean z) {
        this.isPromoRemoved = z;
    }

    public String getSelectedPromoCashBack() {
        return this.mSelectedPromoCashBack;
    }

    public void setSelectedPromoCashBack(String str) {
        this.mSelectedPromoCashBack = str;
    }

    public String getSelectedPromoMSg() {
        return this.mSelectedPromoMSg;
    }

    public void setSelectedPromoMSg(String str) {
        this.mSelectedPromoMSg = str;
    }

    public String getSelectedPromo() {
        return this.mSelectedPromo;
    }

    public void setSelectedPromo(String str) {
        this.mSelectedPromo = str;
    }

    public int getAddedQuantity() {
        return this.addedQuantity;
    }

    public void setAddedQuantity(int i2) {
        this.addedQuantity = i2;
    }

    public int getMinPurchaseQuantity() {
        return this.minPurchaseQuantity;
    }

    public int getMaxQuantity() {
        return this.maxQuantity;
    }

    public int getAddToCart() {
        return this.addToCart;
    }

    public double getLocationScore() {
        return this.locationScore;
    }

    public boolean isHasBorder() {
        return this.hasBorder;
    }

    public void setHasBorder(boolean z) {
        this.hasBorder = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getDealError() {
        return this.mDealError;
    }

    public void setDealError(String str) {
        this.mDealError = str;
    }

    public String getAncestorID() {
        return this.mAncestorID;
    }

    public void setAncestorID(String str) {
        this.mAncestorID = str;
    }

    public boolean getHasVisibleDetails() {
        return this.mHasVisibleDetails;
    }

    public void setHasVisibleDetails(boolean z) {
        this.mHasVisibleDetails = z;
    }

    public boolean getIsAdded() {
        return this.mIsAdded;
    }

    public boolean getIsExpanded() {
        return this.mIsExpanded;
    }

    public void setIsExpanded(boolean z) {
        this.mIsExpanded = z;
    }

    public void setIsAdded(boolean z) {
        this.mIsAdded = z;
    }

    public String getActualPrice() {
        return this.actualPrice;
    }

    public void setActualPrice(String str) {
        this.actualPrice = str;
    }

    public String getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(String str) {
        this.discountedPrice = str;
    }

    public String getImageData() {
        return this.imageData;
    }

    public void setImageData(String str) {
        this.imageData = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductID(String str) {
        this.productID = str;
    }

    public String getPromoText() {
        return this.promoText;
    }

    public void setPromoText(String str) {
        this.promoText = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public void setUrlType(String str) {
        this.urlType = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getURLType() {
        return this.urlType;
    }

    public String getURL() {
        return this.url;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public String getOfferTag() {
        return this.offerTag;
    }

    public void setOfferTag(String str) {
        this.offerTag = str;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public void setShortDesc(String str) {
        this.shortDesc = str;
    }

    public String getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(String str) {
        this.discountPercent = str;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public void setInStock(boolean z) {
        this.inStock = z;
    }

    public ArrayList<CJRLongRichDesc> getLongRichDesc() {
        return this.longRichDesc;
    }

    public void setLongRichDesc(ArrayList<CJRLongRichDesc> arrayList) {
        this.longRichDesc = arrayList;
    }

    public String getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(String str) {
        this.imageWidth = str;
    }

    public String getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(String str) {
        this.imageHeight = str;
    }

    public CJRTermsAndConditions getMessage() {
        return this.message;
    }

    public void setMessage(CJRTermsAndConditions cJRTermsAndConditions) {
        this.message = cJRTermsAndConditions;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getListName() {
        return this.mListName;
    }

    public int getListPosition() {
        return this.mListPosition;
    }

    public void setListName(String str) {
        this.mListName = str;
    }

    public void setListPosition(int i2) {
        this.mListPosition = i2;
    }

    public void setSearchType(String str) {
        this.mSearchType = str;
    }

    public void setSearchCategory(String str) {
        this.mSearchCategory = str;
    }

    public void setSearchTerm(String str) {
        this.mSearchTerm = str;
    }

    public void setSearchResultType(String str) {
        this.mSearchResultType = str;
    }

    public String getSearchType() {
        return this.mSearchType;
    }

    public String getSearchCategory() {
        return this.mSearchCategory;
    }

    public String getSearchTerm() {
        return this.mSearchTerm;
    }

    public String getSearchResultType() {
        return this.mSearchResultType;
    }

    public String getItemBgColor() {
        return this.mItemBgColor;
    }

    public void setItemViewed() {
        this.itemViewed = true;
    }

    public boolean isItemViewed() {
        return this.itemViewed;
    }

    public String getListId() {
        return this.mListId;
    }

    public void setListId(String str) {
        this.mListId = str;
    }

    public String getmContainerInstanceID() {
        return this.mContainerInstanceID;
    }

    public String getParentID() {
        return this.parentId;
    }

    public String getSearchABValue() {
        return this.mSearchABValue;
    }

    public void setSearchABValue(String str) {
        this.mSearchABValue = str;
    }

    public void setmContainerInstanceID(String str) {
        this.mContainerInstanceID = str;
    }

    public void setSourceInfo(Map<String, Object> map) {
        this.sourceInfo = map;
    }

    public Map<String, Object> getSourceInfo() {
        return this.sourceInfo;
    }

    public String getQrCodeID() {
        return this.qrCodeID;
    }

    public void setQrCodeID(String str) {
        this.qrCodeID = str;
    }

    public String getAffiliateID() {
        return this.affiliateID;
    }

    public void setAffiliateID(String str) {
        this.affiliateID = str;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public boolean isAddToCartShow() {
        return this.isAddToCartShow;
    }

    public void setAddToCartShow(boolean z) {
        this.isAddToCartShow = z;
    }

    public String getVerticalId() {
        return this.mVerticalId;
    }

    public void setVerticalId(String str) {
        this.mVerticalId = str;
    }

    public String getQrCodeOrderID() {
        return this.qrCodeOrderID;
    }

    public void setQrCodeOrderID(String str) {
        this.qrCodeOrderID = str;
    }

    public static class PromoData implements IJRDataModel {
        @b(a = "cashback")
        private String mCashBack;
        @b(a = "offerText")
        private String mOfferText;
        @b(a = "code")
        private String mPromoCode;

        public String getPromoCode() {
            return this.mPromoCode;
        }

        public String getCashBack() {
            return this.mCashBack;
        }

        public String getOfferText() {
            return this.mOfferText;
        }
    }

    public boolean ismIsSelect() {
        return this.mIsSelect;
    }

    public void setmIsSelect(boolean z) {
        this.mIsSelect = z;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean z) {
        this.isDeleted = z;
    }
}
