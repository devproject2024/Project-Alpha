package com.paytmmall.clpartifact.modal.clpCommon;

import android.text.TextUtils;
import androidx.databinding.a;
import com.google.gson.a.c;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item extends a implements Serializable, Cloneable {
    public static final String CTA_URL_TYPE_DOWNLOAD = "download";
    public static final String CTA_URL_TYPE_MAP = "map";
    public static final String KEY_ACTUAL_PRICE = "actual_price";
    public static final String KEY_ALT_IMAGE_URL = "alt_image_url";
    public static final String KEY_CLASS = "class";
    public static final String KEY_CTA = "cta";
    public static final String KEY_CTA_LABEL = "label";
    public static final String KEY_CTA_URL = "url";
    public static final String KEY_CTA_URL_TYPE = "url_type";
    public static final String KEY_DISCOUNT = "discount";
    public static final String KEY_END_TIME = "end_time";
    public static final String KEY_GA_CATEGORY = "ga_category";
    public static final String KEY_GROUP_ID = "group_view_id";
    public static final String KEY_ID = "id";
    public static final String KEY_IMAGE_COLOR = "imgfb_color";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_INTIAL_NAME = "imgfb_text";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_ITEM_SUBTITLE = "subtitle";
    public static final String KEY_LAYOUT = "layout";
    public static final String KEY_NAME = "name";
    public static final String KEY_NEWURL = "newurl";
    public static final String KEY_OFFER_PRICE = "offer_price";
    public static final String KEY_PRIORITY = "priority";
    public static final String KEY_REASON = "reason";
    public static final String KEY_SEOURL = "seourl";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_START_TIME = "start_time";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_SUB_TITLE_COLOR = "sub_title_color";
    public static final String KEY_TAG = "tag";
    public static final String KEY_TEXT1 = "text1";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    public static final String KEY_URL_INFO = "url_info";
    public static final String KEY_URL_KEY = "url_key";
    public static final String KEY_URL_TYPE = "url_type";
    private String adRequestId;
    @c(a = "address")
    private String address;
    @c(a = "addressDetails")
    private AddressDetailsDM addressDetails;
    @c(a = "grid_badges")
    private ArrayList<CJRGridProduct.GridBadges> badges;
    @c(a = "child_items")
    private ArrayList<Page> childItems;
    @c(a = "closingTime")
    private String closingTime;
    private String containerSize;
    @c(a = "costForTwo")
    private double costForTwo;
    @c(a = "created_at")
    private String created_at;
    @c(a = "ct_campaign_id")
    private String ctCampaignId;
    @c(a = "ct_variant_id")
    private String ctVariantId;
    @c(a = "cta")
    private ItemCTA cta;
    @c(a = "cuisines")
    private List<String> cuisines;
    @c(a = "deepLink")
    private HashMap<String, String> deepLink;
    @c(a = "distance")
    private String distance;
    private Map<String, Object> gaData;
    private boolean greyLineSeperator;
    @c(a = "icon_url")
    private String icon_url;
    private int imageWidth = -1;
    @c(a = "imgfb_color")
    private String image_bg_color;
    private Boolean isAddedtoGA = Boolean.FALSE;
    private boolean isExpanded;
    private boolean isGaAdded;
    public boolean isInStock;
    private boolean isMore;
    private boolean isNotificationActive;
    private Boolean isStoreCategorySelected = Boolean.FALSE;
    private int itemListSize;
    @c(a = "subtitle")
    private String itemSubtitle;
    @c(a = "kybId")
    private String kybId;
    private int listPosition;
    private String listType;
    @c(a = "action_text")
    private String mActionText;
    @c(a = "activeFrom")
    private String mActiveFrom;
    @c(a = "add_to_cart")
    private int mAddToCart;
    @c(a = "alt_image_url")
    private String mAltImageUrl;
    @c(a = "avg_rating")
    private double mAvgRating;
    @c(a = "brand")
    public String mBrand;
    @c(a = "brand_id")
    private long mBrandId;
    @c(a = "brand_image_url")
    private String mBrandImageUrl;
    @c(a = "cardTemplate")
    private CFSVoucherCardTemplate mCFSVoucherCardTemplate;
    @c(a = "totalBalance")
    private CFSVoucherTotalBalance mCFSVoucherTotalBalance;
    @c(a = "category_id")
    private long mCategoryId;
    @c(a = "class")
    private String mClassName;
    private String mContainerinstanceid;
    @c(a = "deg")
    private Float mDegree;
    @c(a = "description")
    private String mDescription;
    @c(a = "discount")
    public String mDiscount;
    @c(a = "Effective_price")
    private int mEffectivePrice;
    @c(a = "end_time")
    private String mEndTime;
    @c(a = "ga_category")
    private String mGaCategory;
    @c(a = "group_view_id")
    public GroupViewId mGroupViewId;
    @c(a = "id")
    private String mId;
    @c(a = "image")
    private String mImage;
    @c(a = "image_url")
    private String mImageUrl;
    @c(a = "isFollowing")
    private Boolean mIsFollowing;
    @c(a = "isLike")
    private Boolean mIsLike;
    @c(a = "isSubcategory")
    private boolean mIsSubcategory;
    @c(a = "item_id")
    private Long mItemId;
    @c(a = "items")
    public List<Item> mItems;
    @c(a = "layout")
    public LayoutData mLayout;
    @c(a = "likeCount")
    private Integer mLikeCount;
    @c(a = "logoUrl")
    private String mLogoUrl;
    @c(a = "max_quantity")
    private int mMaxQuantity;
    @c(a = "merchant")
    private CFSMerchantDataModel mMerchant;
    @c(a = "merchant_name")
    private String mMerchantName;
    @c(a = "message")
    private String mMessage;
    @c(a = "min_quantity")
    private int mMinQuantity;
    @c(a = "name")
    private String mName;
    @c(a = "newurl")
    private String mNewurl;
    @c(a = "offers_more")
    private int mOffersMore;
    private int mPosition;
    @c(a = "priority")
    private Long mPriority;
    @c(a = "promo_text")
    private String mPromoText;
    @c(a = "rank")
    private int mRank;
    @c(a = "reason")
    private String mReason;
    @c(a = "recent_services")
    private boolean mRecentServices;
    @c(a = "seourl")
    private String mSeourl;
    @c(a = "shareUrl")
    private String mShareUrl;
    @c(a = "shopId")
    private boolean mShopId;
    @c(a = "show_brand")
    private boolean mShowBrand;
    @c(a = "source")
    private String mSource;
    @c(a = "start_time")
    private String mStartTime;
    @c(a = "stores")
    private List<StoresDataModel> mStores;
    @c(a = "tag")
    public String mTag;
    @c(a = "title")
    private String mTitle;
    @c(a = "total_ratings")
    private int mTotalRatings;
    @c(a = "total_review")
    private int mTotalReview;
    @c(a = "unmanaged_price")
    private double mUnmanagedPrice;
    @c(a = "url")
    private String mUrl;
    @c(a = "url_info")
    private String mUrlInfo;
    @c(a = "url_key")
    private String mUrlKey;
    @c(a = "url_type")
    private String mUrlType;
    @c(a = "vertical_id")
    private long mVerticalId;
    @c(a = "weather")
    private String mWeather;
    @c(a = "actual_price")
    public String mactualPrice;
    private boolean mdeepLinkfired;
    @c(a = "display_metadata")
    private Displaymetadata mdisplaymetadata;
    @c(a = "merchant_id")
    private String merchandID;
    @c(a = "offer_price")
    public String mofferPrice;
    @c(a = "imgfb_text")
    private String name_intial;
    @c(a = "offers")
    public List<OfferData> offerData = new ArrayList();
    private boolean onPreDrawListenerAdded = false;
    @c(a = "open")
    private boolean open;
    private int parentBindPosition;
    private String parentId;
    private String parentImageUrl;
    private String parentTitle;
    private String parentType;
    @c(a = "paymentEnabled")
    private boolean paymentEnabled;
    @c(a = "pla_tracking_id")
    private String plaTrackingId;
    @c(a = "offer_v1")
    private ArrayList<CJRGridProduct.PromoData> promoData;
    private String promoName;
    @c(a = "rating")
    private float rating;
    @c(a = "rewards")
    private RewardsDM rewards;
    private String searchQuery;
    private int spanCount;
    @c(a = "sponsored")
    private boolean sponsored;
    private Integer statusCode;
    private String storefrontId;
    @c(a = "sub_title_color")
    private String subTitleColor;
    @c(a = "text1")
    private String text1;
    @c(a = "todayCloseTime")
    private String todayCloseTime;
    @c(a = "todayOpenTime")
    private String todayOpenTime;
    @c(a = "type")
    private String type;
    @c(a = "variant_instance_id")
    private String variantInstanceId;
    public String verticalId;
    private String viewTag;

    public Boolean getAddedtoGA() {
        return this.isAddedtoGA;
    }

    public void setAddedtoGA(Boolean bool) {
        this.isAddedtoGA = bool;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public String getContainerSize() {
        return this.containerSize;
    }

    public void setContainerSize(String str) {
        this.containerSize = str;
    }

    public boolean isGreyLineSeperator() {
        return this.greyLineSeperator;
    }

    public void setGreyLineSeperator(boolean z) {
        this.greyLineSeperator = z;
    }

    public boolean getmRecentServices() {
        return this.mRecentServices;
    }

    public void setmRecentServices(boolean z) {
        this.mRecentServices = z;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public String getStorefrontId() {
        return this.storefrontId;
    }

    public void setStorefrontId(String str) {
        this.storefrontId = str;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public String getCtCampaignId() {
        return this.ctCampaignId;
    }

    public void setCtCampaignId(String str) {
        this.ctCampaignId = str;
    }

    public String getCtVariantId() {
        return this.ctVariantId;
    }

    public void setCtVariantId(String str) {
        this.ctVariantId = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getViewTag() {
        return this.viewTag;
    }

    public void setViewTag(String str) {
        this.viewTag = str;
    }

    public String getParentImageUrl() {
        return this.parentImageUrl;
    }

    public void setParentImageUrl(String str) {
        this.parentImageUrl = str;
    }

    public String getParentTitle() {
        return this.parentTitle;
    }

    public void setParentTitle(String str) {
        this.parentTitle = str;
    }

    public boolean isNotificationActive() {
        return this.isNotificationActive;
    }

    public int getSpanCount() {
        return this.spanCount;
    }

    public void setSpanCount(int i2) {
        this.spanCount = i2;
    }

    public void setNotificationActive(boolean z) {
        if (!z) {
            notifyChange();
        }
        this.isNotificationActive = z;
    }

    public String getName_intial() {
        return this.name_intial;
    }

    public void setName_intial(String str) {
        this.name_intial = str;
    }

    public String getImage_bg_color() {
        return this.image_bg_color;
    }

    public void setImage_bg_color(String str) {
        this.image_bg_color = str;
    }

    public boolean isPaymentEnabled() {
        return this.paymentEnabled;
    }

    public void setPaymentEnabled(boolean z) {
        this.paymentEnabled = z;
    }

    public String getVariantInstanceId() {
        return this.variantInstanceId;
    }

    public void setVariantInstanceId(String str) {
        this.variantInstanceId = str;
    }

    public HashMap<String, String> getDeepLink() {
        return this.deepLink;
    }

    public void setDeepLink(HashMap<String, String> hashMap) {
        this.deepLink = hashMap;
    }

    public String getTodayOpenTime() {
        return this.todayOpenTime;
    }

    public void setTodayOpenTime(String str) {
        this.todayOpenTime = str;
    }

    public String getTodayCloseTime() {
        return this.todayCloseTime;
    }

    public void setTodayCloseTime(String str) {
        this.todayCloseTime = str;
    }

    public RewardsDM getRewards() {
        return this.rewards;
    }

    public void setRewards(RewardsDM rewardsDM) {
        this.rewards = rewardsDM;
    }

    public String getKybId() {
        return this.kybId;
    }

    public void setKybId(String str) {
        this.kybId = str;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float f2) {
        this.rating = f2;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public AddressDetailsDM getAddressDetails() {
        return this.addressDetails;
    }

    public void setAddressDetails(AddressDetailsDM addressDetailsDM) {
        this.addressDetails = addressDetailsDM;
    }

    public List<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(List<String> list) {
        this.cuisines = list;
    }

    public double getCostForTwo() {
        return this.costForTwo;
    }

    public void setCostForTwo(double d2) {
        this.costForTwo = d2;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public String getClosingTime() {
        return this.closingTime;
    }

    public void setClosingTime(String str) {
        this.closingTime = str;
    }

    public Displaymetadata getMdisplaymetadata() {
        return this.mdisplaymetadata;
    }

    public void setMdisplaymetadata(Displaymetadata displaymetadata) {
        this.mdisplaymetadata = displaymetadata;
    }

    public Boolean getStoreCategorySelected() {
        return this.isStoreCategorySelected;
    }

    public void setStoreCategorySelected(Boolean bool) {
        this.isStoreCategorySelected = bool;
    }

    public boolean getSponsored() {
        return this.sponsored;
    }

    public void setSponsored(boolean z) {
        this.sponsored = z;
    }

    public String getPlaTrackingId() {
        return this.plaTrackingId;
    }

    public void setPlaTrackingId(String str) {
        this.plaTrackingId = str;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public String getParentType() {
        return this.parentType;
    }

    public void setParentType(String str) {
        this.parentType = str;
    }

    public String getmBrandImageUrl() {
        return this.mBrandImageUrl;
    }

    public void setmBrandImageUrl(String str) {
        this.mBrandImageUrl = str;
    }

    public String getmShareUrl() {
        return this.mShareUrl;
    }

    public void setmShareUrl(String str) {
        this.mShareUrl = str;
    }

    public CFSVoucherCardTemplate getmCFSVoucherCardTemplate() {
        return this.mCFSVoucherCardTemplate;
    }

    public void setmCFSVoucherCardTemplate(CFSVoucherCardTemplate cFSVoucherCardTemplate) {
        this.mCFSVoucherCardTemplate = cFSVoucherCardTemplate;
    }

    public CFSVoucherTotalBalance getmCFSVoucherTotalBalance() {
        return this.mCFSVoucherTotalBalance;
    }

    public void setmCFSVoucherTotalBalance(CFSVoucherTotalBalance cFSVoucherTotalBalance) {
        this.mCFSVoucherTotalBalance = cFSVoucherTotalBalance;
    }

    public CFSMerchantDataModel getmMerchant() {
        return this.mMerchant;
    }

    public void setmMerchant(CFSMerchantDataModel cFSMerchantDataModel) {
        this.mMerchant = cFSMerchantDataModel;
    }

    public Boolean getmIsLike() {
        return this.mIsLike;
    }

    public void setmIsLike(Boolean bool) {
        this.mIsLike = bool;
    }

    public Boolean getmIsFollowing() {
        return this.mIsFollowing;
    }

    public void setmIsFollowing(Boolean bool) {
        this.mIsFollowing = bool;
    }

    public Integer getmLikeCount() {
        return this.mLikeCount;
    }

    public void setmLikeCount(Integer num) {
        this.mLikeCount = num;
    }

    public String getmActiveFrom() {
        return this.mActiveFrom;
    }

    public void setmActiveFrom(String str) {
        this.mActiveFrom = str;
    }

    public String getmDescription() {
        return this.mDescription;
    }

    public void setmDescription(String str) {
        this.mDescription = str;
    }

    public String getmImage() {
        return this.mImage;
    }

    public void setmImage(String str) {
        this.mImage = str;
    }

    public String getmAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setmAltImageUrl(String str) {
        this.mAltImageUrl = str;
    }

    public String getmEndTime() {
        return this.mEndTime;
    }

    public void setmEndTime(String str) {
        this.mEndTime = str;
    }

    public String getmGaCategory() {
        return this.mGaCategory;
    }

    public void setmGaCategory(String str) {
        this.mGaCategory = str;
    }

    public String getmId() {
        return this.mId;
    }

    public void setmId(String str) {
        this.mId = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public Long getmItemId() {
        return this.mItemId;
    }

    public void setmItemId(Long l) {
        this.mItemId = l;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmNewurl() {
        return this.mNewurl;
    }

    public void setmNewurl(String str) {
        this.mNewurl = str;
    }

    public Long getmPriority() {
        return this.mPriority;
    }

    public void setmPriority(Long l) {
        this.mPriority = l;
    }

    public String getmReason() {
        return this.mReason;
    }

    public void setmReason(String str) {
        this.mReason = str;
    }

    public String getmSeourl() {
        return this.mSeourl;
    }

    public void setmSeourl(String str) {
        this.mSeourl = str;
    }

    public String getmSource() {
        return this.mSource;
    }

    public void setmSource(String str) {
        this.mSource = str;
    }

    public String getmStartTime() {
        return this.mStartTime;
    }

    public void setmStartTime(String str) {
        this.mStartTime = str;
    }

    public String getmTitle() {
        return this.mTitle;
    }

    public void setmTitle(String str) {
        this.mTitle = str;
    }

    public String getMUrl() {
        return this.mUrl;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public String getmUrlInfo() {
        return this.mUrlInfo;
    }

    public void setmUrlInfo(String str) {
        this.mUrlInfo = str;
    }

    public String getmUrlKey() {
        return this.mUrlKey;
    }

    public void setmUrlKey(String str) {
        this.mUrlKey = str;
    }

    public String getmUrlType() {
        String str = this.mUrlType;
        return str != null ? str : "";
    }

    public void setmUrlType(String str) {
        this.mUrlType = str;
    }

    public String getMofferPrice() {
        return this.mofferPrice;
    }

    public void setMofferPrice(String str) {
        this.mofferPrice = str;
    }

    public String getMactualPrice() {
        return this.mactualPrice;
    }

    public void setMactualPrice(String str) {
        this.mactualPrice = str;
    }

    public String getmTag() {
        return this.mTag;
    }

    public void setmTag(String str) {
        this.mTag = str;
    }

    public String getmWeather() {
        return this.mWeather;
    }

    public void setmWeather(String str) {
        this.mWeather = str;
    }

    public Float getmDegree() {
        return this.mDegree;
    }

    public void setmDegree(Float f2) {
        this.mDegree = f2;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(String str) {
        this.mMessage = str;
    }

    public double getmUnmanagedPrice() {
        return this.mUnmanagedPrice;
    }

    public void setmUnmanagedPrice(double d2) {
        this.mUnmanagedPrice = d2;
    }

    public int getmAddToCart() {
        return this.mAddToCart;
    }

    public void setmAddToCart(int i2) {
        this.mAddToCart = i2;
    }

    public int getmMinQuantity() {
        return this.mMinQuantity;
    }

    public void setmMinQuantity(int i2) {
        this.mMinQuantity = i2;
    }

    public int getmMaxQuantity() {
        return this.mMaxQuantity;
    }

    public void setmMaxQuantity(int i2) {
        this.mMaxQuantity = i2;
    }

    public String getmPromoText() {
        return this.mPromoText;
    }

    public void setmPromoText(String str) {
        this.mPromoText = str;
    }

    public boolean ismShowBrand() {
        return this.mShowBrand;
    }

    public void setmShowBrand(boolean z) {
        this.mShowBrand = z;
    }

    public String getmDiscount() {
        return this.mDiscount;
    }

    public void setmDiscount(String str) {
        this.mDiscount = str;
    }

    public int getmOffersMore() {
        return this.mOffersMore;
    }

    public void setmOffersMore(int i2) {
        this.mOffersMore = i2;
    }

    public long getmBrandId() {
        return this.mBrandId;
    }

    public void setmBrandId(int i2) {
        this.mBrandId = (long) i2;
    }

    public long getmVerticalId() {
        return this.mVerticalId;
    }

    public void setmVerticalId(int i2) {
        this.mVerticalId = (long) i2;
    }

    public long getmCategoryId() {
        return this.mCategoryId;
    }

    public void setmCategoryId(int i2) {
        this.mCategoryId = (long) i2;
    }

    public int getmEffectivePrice() {
        return this.mEffectivePrice;
    }

    public void setmEffectivePrice(int i2) {
        this.mEffectivePrice = i2;
    }

    public int getmTotalRatings() {
        return this.mTotalRatings;
    }

    public void setmTotalRatings(int i2) {
        this.mTotalRatings = i2;
    }

    public int getmTotalReview() {
        return this.mTotalReview;
    }

    public void setmTotalReview(int i2) {
        this.mTotalReview = i2;
    }

    public double getmAvgRating() {
        return this.mAvgRating;
    }

    public void setmAvgRating(double d2) {
        this.mAvgRating = d2;
    }

    public String getmActionText() {
        return this.mActionText;
    }

    public void setmActionText(String str) {
        this.mActionText = str;
    }

    public int getmRank() {
        return this.mRank;
    }

    public void setmRank(int i2) {
        this.mRank = i2;
    }

    public String getmLogoUrl() {
        return this.mLogoUrl;
    }

    public void setmLogoUrl(String str) {
        this.mLogoUrl = str;
    }

    public List<StoresDataModel> getmStores() {
        return this.mStores;
    }

    public void setmStores(List<StoresDataModel> list) {
        this.mStores = list;
    }

    public boolean ismIsSubcategory() {
        return this.mIsSubcategory;
    }

    public void setmIsSubcategory(boolean z) {
        this.mIsSubcategory = z;
    }

    public boolean ismShopId() {
        return this.mShopId;
    }

    public void setmShopId(boolean z) {
        this.mShopId = z;
    }

    public ArrayList<Page> getChildItems() {
        return this.childItems;
    }

    public void setChildItems(ArrayList<Page> arrayList) {
        this.childItems = arrayList;
    }

    public boolean isGaAdded() {
        return this.isGaAdded;
    }

    public void setGaAdded(boolean z) {
        this.isGaAdded = z;
    }

    public String getMerchandID() {
        return this.merchandID;
    }

    public void setMerchandID(String str) {
        this.merchandID = str;
    }

    public boolean isPromotion() {
        try {
            Integer.parseInt(getActualPrice());
            return false;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(String str) {
        this.verticalId = str;
    }

    public boolean isInStock() {
        return this.isInStock;
    }

    public void setInStock(boolean z) {
        this.isInStock = z;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public LayoutData getLayout() {
        return this.mLayout;
    }

    public void setLayout(LayoutData layoutData) {
        this.mLayout = layoutData;
    }

    public String getmBrand() {
        return this.mBrand;
    }

    public void setmBrand(String str) {
        this.mBrand = str;
    }

    @c(a = "grid_badges")
    public ArrayList<CJRGridProduct.GridBadges> getBadges() {
        return this.badges;
    }

    public void setParentBindPosition(int i2) {
        this.parentBindPosition = i2;
    }

    public void setBadges(ArrayList<CJRGridProduct.GridBadges> arrayList) {
        this.badges = arrayList;
    }

    public ArrayList<CJRGridProduct.PromoData> getPromoData() {
        return this.promoData;
    }

    public void setPromoData(ArrayList<CJRGridProduct.PromoData> arrayList) {
        this.promoData = arrayList;
    }

    public List<OfferData> getOfferData() {
        return this.offerData;
    }

    public void setOfferData(List<OfferData> list) {
        this.offerData = list;
    }

    public String getmMerchantName() {
        return this.mMerchantName;
    }

    public boolean isDiscounted() {
        return !TextUtils.isEmpty(this.mDiscount) && !this.mDiscount.equalsIgnoreCase("0");
    }

    public void setmMerchantName(String str) {
        this.mMerchantName = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getDiscount() {
        return this.mDiscount;
    }

    public void setDiscount(String str) {
        this.mDiscount = str;
    }

    public String getOfferPrice() {
        return this.mofferPrice;
    }

    public void setOfferPrice(String str) {
        this.mofferPrice = str;
    }

    public String getActualPrice() {
        return this.mactualPrice;
    }

    public void setActualPrice(String str) {
        this.mactualPrice = str;
    }

    public String getAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setAltImageUrl(String str) {
        this.mAltImageUrl = str;
    }

    public String getEndTime() {
        return this.mEndTime;
    }

    public void setEndTime(String str) {
        this.mEndTime = str;
    }

    public String getGaCategory() {
        return this.mGaCategory;
    }

    public void setGaCategory(String str) {
        this.mGaCategory = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public Long getItemId() {
        return this.mItemId;
    }

    public void setItemId(Long l) {
        this.mItemId = l;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getNewurl() {
        return this.mNewurl;
    }

    public void setNewurl(String str) {
        this.mNewurl = str;
    }

    public Long getPriority() {
        return this.mPriority;
    }

    public void setPriority(Long l) {
        this.mPriority = l;
    }

    public String getReason() {
        return this.mReason;
    }

    public void setReason(String str) {
        this.mReason = str;
    }

    public String getSeourl() {
        return this.mSeourl;
    }

    public void setSeourl(String str) {
        this.mSeourl = str;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public String getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(String str) {
        this.mStartTime = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getUrl() {
        return getProductUrl();
    }

    private String getProductUrl() {
        if (!TextUtils.isEmpty(this.mNewurl)) {
            return this.mNewurl;
        }
        if (!TextUtils.isEmpty(this.mSeourl)) {
            return this.mSeourl;
        }
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getUrlInfo() {
        return this.mUrlInfo;
    }

    public void setUrlInfo(String str) {
        this.mUrlInfo = str;
    }

    public String getUrlKey() {
        return this.mUrlKey;
    }

    public void setUrlKey(String str) {
        this.mUrlKey = str;
    }

    public String getUrlType() {
        String str = this.mUrlType;
        return str != null ? str : "";
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public void setItems(List<Item> list) {
        this.mItems = list;
    }

    public void setSearchQuery(String str) {
        this.searchQuery = str;
    }

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof Item) || (str = this.mId) == null) {
            return false;
        }
        return str.equals(((Item) obj).mId);
    }

    public int hashCode() {
        String str = this.mId;
        if (str != null) {
            return 21 + str.hashCode();
        }
        return 21;
    }

    public boolean isDeepLinkfired() {
        return this.mdeepLinkfired;
    }

    public void setDeepLinkfired(boolean z) {
        this.mdeepLinkfired = z;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i2) {
        this.mPosition = i2;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public ItemCTA getCta() {
        return this.cta;
    }

    public void setCta(ItemCTA itemCTA) {
        this.cta = itemCTA;
    }

    public String getItemSubtitle() {
        return this.itemSubtitle;
    }

    public void setItemSubtitle(String str) {
        this.itemSubtitle = str;
    }

    public String getmClassName() {
        return this.mClassName;
    }

    public void setmClassName(String str) {
        this.mClassName = str;
    }

    public String getText1() {
        return this.text1;
    }

    public void setText1(String str) {
        this.text1 = str;
    }

    public String getSubTitleColor() {
        return this.subTitleColor;
    }

    public void setSubTitleColor(String str) {
        this.subTitleColor = str;
    }

    public int getParentBindPosition() {
        return this.parentBindPosition;
    }

    public void setParentPosition(Map<String, Object> map) {
        try {
            this.parentBindPosition = 0;
            if (map != null && map.get(CLPConstants.WIDGET_BIND_POSITION) != null) {
                this.parentBindPosition = map != null ? Integer.parseInt(String.valueOf(map.get(CLPConstants.WIDGET_BIND_POSITION))) : 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.parentBindPosition = 0;
        }
    }

    public Map<String, Object> getGaData() {
        return this.gaData;
    }

    public void setGaData(Map<String, Object> map) {
        this.gaData = map;
    }

    public static class LayoutData implements Serializable {
        @c(a = "label_bgcolor")
        private String labelBgColor;
        @c(a = "label_text_color")
        private String labelColor;
        @c(a = "label")
        public String mLabel;

        public String getmLabel() {
            return this.mLabel;
        }

        public void setmLabel(String str) {
            this.mLabel = str;
        }

        public String getLabelColor() {
            return this.labelColor;
        }

        public void setLabelColor(String str) {
            this.labelColor = str;
        }

        public String getLabelBgColor() {
            return this.labelBgColor;
        }

        public void setLabelBgColor(String str) {
            this.labelBgColor = str;
        }
    }

    public Item clone() throws CloneNotSupportedException {
        return (Item) super.clone();
    }

    public static class GroupViewId implements Serializable {
        @c(a = "icon_view_id")
        private ArrayList<String> Icon_view_id;
        @c(a = "ticker_view_id")
        private ArrayList<String> ticker_view_id;

        public void setIcon_view_id(ArrayList<String> arrayList) {
            this.Icon_view_id = arrayList;
        }

        public ArrayList<String> getIcon_view_id() {
            return this.Icon_view_id;
        }

        public void setTicker_view_id(ArrayList<String> arrayList) {
            this.ticker_view_id = arrayList;
        }

        public ArrayList<String> getTicker_view_id() {
            return this.ticker_view_id;
        }
    }

    public GroupViewId getmGroupViewId() {
        return this.mGroupViewId;
    }

    public void setmGroupViewId(GroupViewId groupViewId) {
        this.mGroupViewId = groupViewId;
    }

    public static class Displaymetadata implements Serializable {
        @c(a = "created_at")
        private String created_at;
        @c(a = "id")
        private String id;
        @c(a = "image2_url")
        private String image2_url;
        @c(a = "image_url")
        private String image_url;
        @c(a = "metadata")
        private Metadata mmetadata;
        @c(a = "video_url")
        private String video_url;

        public Metadata getMmetadata() {
            return this.mmetadata;
        }

        public void setMmetadata(Metadata metadata) {
            this.mmetadata = metadata;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public String getImage_url() {
            return this.image_url;
        }

        public void setImage_url(String str) {
            this.image_url = str;
        }

        public String getCreated_at() {
            return this.created_at;
        }

        public void setCreated_at(String str) {
            this.created_at = str;
        }

        public String getImage2_url() {
            return this.image2_url;
        }

        public void setImage2_url(String str) {
            this.image2_url = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public static class Metadata implements Serializable {
            @c(a = "click_pixel_url")
            private String click_pixel_url;
            @c(a = "impression_pixel1")
            private String impression_pixel1;
            @c(a = "impression_pixel2")
            private String impression_pixel2;
            @c(a = "impression_pixel3")
            private String impression_pixel3;
            @c(a = "impression_pixel_url")
            private String impression_pixel_url;
            @c(a = "javascript_resource_url")
            private String javascript_resource_url;
            @c(a = "vendor_key")
            private String vendor_key;
            @c(a = "verification_parameters")
            private String verification_parameters;

            public String getImpression_pixel_url() {
                return this.impression_pixel_url;
            }

            public void setImpression_pixel_url(String str) {
                this.impression_pixel_url = str;
            }

            public String getClick_pixel_url() {
                return this.click_pixel_url;
            }

            public void setClick_pixel_url(String str) {
                this.click_pixel_url = str;
            }

            public String getVendor_key() {
                return this.vendor_key;
            }

            public void setVendor_key(String str) {
                this.vendor_key = str;
            }

            public String getJavascript_resource_url() {
                return this.javascript_resource_url;
            }

            public void setJavascript_resource_url(String str) {
                this.javascript_resource_url = str;
            }

            public String getVerification_parameters() {
                return this.verification_parameters;
            }

            public void setVerification_parameters(String str) {
                this.verification_parameters = str;
            }

            public String getImpression_pixel1() {
                return this.impression_pixel1;
            }

            public void setImpression_pixel1(String str) {
                this.impression_pixel1 = str;
            }

            public String getImpression_pixel2() {
                return this.impression_pixel2;
            }

            public void setImpression_pixel2(String str) {
                this.impression_pixel2 = str;
            }

            public String getImpression_pixel3() {
                return this.impression_pixel3;
            }

            public void setImpression_pixel3(String str) {
                this.impression_pixel3 = str;
            }
        }
    }

    public String getContainerinstatnceid() {
        return this.mContainerinstanceid;
    }

    public void setContainerinstatnceid(String str) {
        this.mContainerinstanceid = str;
    }

    public boolean isOnPreDrawListenerAdded() {
        return this.onPreDrawListenerAdded;
    }

    public void setOnPreDrawListenerAdded(boolean z) {
        this.onPreDrawListenerAdded = z;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i2) {
        this.imageWidth = i2;
    }

    public int getBannerCornerRadius() {
        String parentType2 = getParentType();
        if (!ViewHolderFactory.TYPE_BANNER_2.equalsIgnoreCase(parentType2) && !ViewHolderFactory.TYPE_BANNER_3.equalsIgnoreCase(parentType2)) {
            return 0;
        }
        String str = getmClassName();
        if (ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE.equals(str)) {
            return 0;
        }
        return ViewHolderFactory.CLASS_HOME.equals(str) ? 32 : 5;
    }

    public String getPromoName() {
        return this.promoName;
    }

    public void setPromoName(String str) {
        this.promoName = str;
    }

    public String getListType() {
        return this.listType;
    }

    public void setListType(String str) {
        this.listType = str;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    public void setListPosition(int i2) {
        this.listPosition = i2;
    }

    public int getItemListSize() {
        return this.itemListSize;
    }

    public void setItemListSize(int i2) {
        this.itemListSize = i2;
    }
}
