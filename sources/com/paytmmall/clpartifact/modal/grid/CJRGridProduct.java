package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CJRGridProduct implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "actual_price")
    private String actualPrice;
    @c(a = "add_to_cart")
    private int addToCart;
    private int addedQuantity = 1;
    private String affiliateID;
    @c(a = "ancestors")
    private ArrayList<CJRAncestor> ancestors;
    @c(a = "attributes")
    private Attribute attribute;
    @c(a = "brand")
    private String brand;
    private String deeplink;
    @c(a = "discount")
    private String discountPercent;
    @c(a = "offer_price")
    private String discountedPrice;
    private Map<String, Object> gaData;
    @c(a = "image_data")
    private String imageData;
    @c(a = "img_height")
    private String imageHeight;
    @c(a = "image_url")
    public String imageUrl;
    @c(a = "img_width")
    private String imageWidth;
    @c(a = "stock")
    private boolean inStock;
    private boolean isAddToCartShow = true;
    private Boolean isAddedtoGA = Boolean.FALSE;
    private boolean isPromoRemoved;
    private boolean itemViewed;
    @c(a = "location_score")
    private double locationScore;
    @c(a = "long_rich_desc")
    private ArrayList<CJRLongRichDesc> longRichDesc = new ArrayList<>();
    private String mAncestorID;
    @c(a = "avg_rating")
    public String mAvgRating;
    @c(a = "grid_badges")
    private List<GridBadges> mBadges;
    private String mContainerInstanceID;
    private boolean mHasVisibleDetails;
    private boolean mIsAdded;
    private boolean mIsExpanded;
    private boolean mIsSelect;
    private String mItemBgColor = "#FFFFFFFF";
    private String mListId = "";
    private String mListName;
    private int mListPosition;
    @c(a = "offers_url")
    private String mOfferURL;
    @c(a = "offers")
    private List<PromoData> mPromoData;
    private String mSearchABValue;
    private String mSearchCategory;
    private String mSearchResultType;
    private String mSearchTerm;
    private String mSearchType;
    private String mSelectedPromo;
    private String mSelectedPromoCashBack;
    private String mSelectedPromoMSg;
    @c(a = "seourl")
    private String mSeoUrl;
    @c(a = "total_ratings")
    public String mTotalrating;
    @c(a = "vertical_id")
    private String mVerticalId;
    @c(a = "max_quantity")
    private int maxQuantity = 10;
    @c(a = "merchant_id")
    private int merchantId;
    @c(a = "merchant_name")
    private String merchantName;
    @c(a = "message")
    private CJRTermsAndConditions message;
    @c(a = "min_quantity")
    private int minPurchaseQuantity;
    @c(a = "offers_more")
    private int moreOfferCount;
    @c(a = "name")
    private String name;
    @c(a = "tag")
    private String offerTag;
    @c(a = "parent_id")
    private String parentId;
    @c(a = "pla_tracking_id")
    private String plaTrackingId;
    @c(a = "product_id")
    private String productID;
    @c(a = "product_type")
    private String productType;
    @c(a = "promo_text")
    private String promoText;
    private String qrCodeID;
    private String qrCodeOrderID;
    @c(a = "render_url")
    private String renderUrl;
    @c(a = "short_desc")
    private String shortDesc;
    @c(a = "show_brand")
    public boolean showBrand;
    @c(a = "source")
    private String source;
    private Map<String, Object> sourceInfo = null;
    @c(a = "sponsored")
    private boolean sponsored;
    private String timeStamp;
    @c(a = "url")
    private String url;
    @c(a = "url_type")
    private String urlType;
    @c(a = "variants")
    private Variant variant;
    private String variantValue;

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

    public int getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(int i2) {
        this.merchantId = i2;
    }

    public String getPlaTrackingId() {
        return this.plaTrackingId;
    }

    public void setPlaTrackingId(String str) {
        this.plaTrackingId = str;
    }

    public boolean isSponsored() {
        return this.sponsored;
    }

    public void setSponsored(boolean z) {
        this.sponsored = z;
    }

    public List<GridBadges> getmBadges() {
        return this.mBadges;
    }

    public void setmBadges(List<GridBadges> list) {
        this.mBadges = list;
    }

    public boolean isShowBrand() {
        return this.showBrand;
    }

    public void setShowBrand(boolean z) {
        this.showBrand = z;
    }

    public ArrayList<CJRAncestor> getAncestors() {
        return this.ancestors;
    }

    public void setAncestors(ArrayList<CJRAncestor> arrayList) {
        this.ancestors = arrayList;
    }

    public Boolean getAddedtoGA() {
        return this.isAddedtoGA;
    }

    public void setAddedtoGA(Boolean bool) {
        this.isAddedtoGA = bool;
    }

    public String getVariantValue() {
        return this.variantValue;
    }

    public void setVariantValue(String str) {
        this.variantValue = str;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute2) {
        this.attribute = attribute2;
    }

    public String getRenderUrl() {
        return this.renderUrl;
    }

    public void setRenderUrl(String str) {
        this.renderUrl = str;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public void setVariant(Variant variant2) {
        this.variant = variant2;
    }

    public String getmTotalrating() {
        return this.mTotalrating;
    }

    public void setmTotalrating(String str) {
        this.mTotalrating = str;
    }

    public String getmAvgRating() {
        return this.mAvgRating;
    }

    public void setmAvgRating(String str) {
        this.mAvgRating = str;
    }

    public void setMoreOfferCount(int i2) {
        this.moreOfferCount = i2;
    }

    public List<PromoData> getPromoData() {
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

    public boolean isDiscounted() {
        try {
            return Double.parseDouble(this.discountPercent) > 0.0d;
        } catch (NumberFormatException unused) {
            return false;
        }
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
        String str = this.url;
        return str == null ? this.mSeoUrl : str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getSeoUrl() {
        return this.mSeoUrl;
    }

    public void setSeoUrl(String str) {
        this.mSeoUrl = str;
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

    public boolean ismIsSelect() {
        return this.mIsSelect;
    }

    public void setmIsSelect(boolean z) {
        this.mIsSelect = z;
    }

    public Map<String, Object> getGaData() {
        return this.gaData;
    }

    public void setGaData(Map<String, Object> map) {
        this.gaData = map;
    }

    public static class PromoData implements Serializable {
        @c(a = "isFlashCode")
        private boolean isFlashSale;
        @c(a = "cashback")
        private String mCashBack;
        @c(a = "offerText")
        private String mOfferText;
        @c(a = "code")
        private String mPromoCode;
        @c(a = "offer")
        private CJROffer offer;
        @c(a = "offer_v1")
        private CJROfferV1 offer_v1;

        public boolean isFlashSale() {
            return this.isFlashSale;
        }

        public void setFlashSale(boolean z) {
            this.isFlashSale = z;
        }

        public CJROffer getOffer() {
            return this.offer;
        }

        public void setOffer(CJROffer cJROffer) {
            this.offer = cJROffer;
        }

        public CJROfferV1 getOffer_v1() {
            return this.offer_v1;
        }

        public void setOffer_v1(CJROfferV1 cJROfferV1) {
            this.offer_v1 = cJROfferV1;
        }

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

    public static class CJROffer implements Serializable {
        @c(a = "icon")
        private String icon;
        @c(a = "singleRedemptionValue")
        private int singleRedemptionValue;
        @c(a = "text")
        private String text;
        @c(a = "title")
        private String title;
        @c(a = "type")
        private String type;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public int getSingleRedemptionValue() {
            return this.singleRedemptionValue;
        }

        public void setSingleRedemptionValue(int i2) {
            this.singleRedemptionValue = i2;
        }
    }

    public static class GridBadges implements Serializable {
        @c(a = "img_url")
        private String mImageUrl;
        @c(a = "text")
        private String mText;
        @c(a = "type")
        private String mType;

        public String getmType() {
            return this.mType;
        }

        public void setmType(String str) {
            this.mType = str;
        }

        public String getmText() {
            return this.mText;
        }

        public void setmText(String str) {
            this.mText = str;
        }

        public String getmImageUrl() {
            return this.mImageUrl;
        }

        public void setmImageUrl(String str) {
            this.mImageUrl = str;
        }
    }

    public static class Attribute implements Serializable {
        @c(a = "capacity")
        private String capacity;
        @c(a = "description")
        private String description;
        @c(a = "set_contents")
        private String setContents;
        @c(a = "type")
        private String type;
        @c(a = "veg_or_non_Veg")
        private String vegNonveg;

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public String getVegNonveg() {
            return this.vegNonveg;
        }

        public void setVegNonveg(String str) {
            this.vegNonveg = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getCapacity() {
            return this.capacity;
        }

        public void setCapacity(String str) {
            this.capacity = str;
        }

        public String getSetContents() {
            return this.setContents;
        }

        public void setSetContents(String str) {
            this.setContents = str;
        }
    }

    public static class Variant implements Serializable {
        @c(a = "dimensions")
        private ArrayList<Dimension> dimensions;
        @c(a = "items")
        private ArrayList<CJRGridProduct> items;

        public ArrayList<Dimension> getDimensions() {
            return this.dimensions;
        }

        public void setDimensions(ArrayList<Dimension> arrayList) {
            this.dimensions = arrayList;
        }

        public ArrayList<CJRGridProduct> getItems() {
            return this.items;
        }

        public void setItems(ArrayList<CJRGridProduct> arrayList) {
            this.items = arrayList;
        }
    }

    public static class Dimension implements Serializable {
        @c(a = "count")
        private int count;
        @c(a = "label")
        private String label;

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i2) {
            this.count = i2;
        }
    }
}
