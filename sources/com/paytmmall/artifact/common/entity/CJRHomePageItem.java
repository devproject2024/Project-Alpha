package com.paytmmall.artifact.common.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CJRHomePageItem extends CJRItem {
    private static final long serialVersionUID = 1;
    @b(a = "ga_category")
    private String GACategory;
    private String aadhaarOtp;
    private String aadhar_number;
    private String account;
    private String affilaiteID;
    @b(a = "animation_json")
    private String animationjson;
    private String bankAccountNumber;
    private String bankAmount;
    private String bankName;
    private String bankcomment;
    private IJRPaytmDataModel builderModel;
    private String cashbackCampaignId;
    private String cashbackOfferId;
    private String cashbackOfferTag;
    private String cashbackScreen;
    private String childreason;
    private String contactUsIssueParentId;
    private String contactUsIssueVerticalLabel;
    private String contentID;
    private String cstItemId;
    private String cstOrderId;
    @b(a = "deeplink")
    private String deeplink;
    private int deeplinkType = -1;
    private String featureType;
    private int headerVeriticalPos;
    private String ifsc;
    private boolean imageFromResource;
    private HashMap<String, String> insuranceParams;
    private boolean isFromReqDelivery = false;
    private boolean isMore;
    private boolean isOther;
    private boolean isSellerStoreImpressionSent;
    private String issueId;
    private String issueText;
    private boolean itemViewed;
    private String kyc_name;
    private String l1;
    private String l2;
    private String landing_page;
    private String layoutType;
    private String lifafaId;
    private String linkId;
    private String linkName;
    @b(a = "actual_price")
    private float mActualPrice;
    @b(a = "alt_image_url")
    public String mAltImageUrl;
    @b(a = "mAltImageUrl")
    private String mAltImageUrl2;
    private String mAmount;
    @b(a = "brand")
    private String mBrand;
    private String mCallbackUrl;
    @b(a = "category")
    private String mCategory;
    private String mCategoryId;
    private String mCinemaMovieCode = null;
    private boolean mClickConfigurable;
    private String mClickDate;
    public String mContainerInstanceID;
    private String mDbtConsent;
    private boolean mDeepLinking;
    @b(a = "mDeleteUrl")
    private String mDeleteUrl;
    @b(a = "description")
    public String mDescription;
    @b(a = "discount")
    public String mDiscount;
    private String mEventCategory = null;
    private String mEventCityName = null;
    private String mEventId = null;
    private String mEventName = null;
    private String mEventProviderId = null;
    private String mEventSubCategory = null;
    private String mFlightReferral;
    private String mForm60;
    public String mGTMListName;
    public int mGTMPosition;
    public String mGiftCardUrl = null;
    private String mGram;
    private String mGroupId = null;
    @b(a = "has_reward")
    public boolean mHasRewards;
    @b(a = "image_url")
    public String mImageUrl;
    @b(a = "img_height")
    public String mImgHeight;
    @b(a = "img_width")
    public String mImgWidth;
    private boolean mIsFromSearch;
    @b(a = "stock")
    public boolean mIsInStock;
    @b(a = "id")
    private String mItemID;
    @b(a = "label")
    private String mLabel;
    private String mLandingPage;
    private String mListId = "";
    @b(a = "login_required")
    public boolean mLoginRequired;
    @b(a = "metadata")
    private MetaData mMetaData;
    private String mMovieName = null;
    @b(a = "name")
    public String mName;
    @b(a = "offer_price")
    private float mOfferPrice;
    @b(a = "tag")
    private String mOfferTag;
    private String mOpenScreen;
    private String mOrigin;
    @b(a = "parent_id")
    public String mParentId;
    private String mParentItem;
    private String mParkCategory = null;
    private String mParkCityName = null;
    private String mParkId = null;
    private String mParkName = null;
    private String mParkProviderId = null;
    private String mParkcityLabel = null;
    private String mParkcityValue = null;
    private String mPostOrderCinemaId = null;
    private String mPostOrderProviderId = null;
    @b(a = "price")
    public String mPrice;
    @b(a = "priority")
    private String mPripority;
    private boolean mProceed = false;
    private String mPushAlertMessageBody = "";
    private String mPushCashAdd;
    private String mPushCheckInDate;
    private String mPushCheckOutDate;
    private String mPushCity;
    private String mPushCode;
    private String mPushComment;
    private String mPushDate;
    private String mPushDestinationCityName;
    private String mPushDestinationCityShortName;
    @b(a = "featuretype")
    private String mPushFeatureType = "";
    private String mPushFilterJson;
    private String mPushFlightClass;
    private String mPushFlightDepartDate;
    private String mPushFlightReturnDate;
    private String mPushFlightTripType;
    private String mPushHotelExtras;
    private String mPushHotelFinalPriceWithTax;
    private String mPushHotelId;
    private String mPushHotelName;
    private String mPushPassengerCount;
    private String mPushProductId;
    private String mPushPromoCode;
    private String mPushQuantity;
    private String mPushRecipient;
    private String mPushRoomDetailsJson;
    private boolean mPushShowPopup;
    private String mPushSourceCityName;
    private String mPushSourceCityShortName;
    private String mPushTitle;
    private String mPushType;
    private String mPushUtmSource;
    private String mPushWalletCode;
    private String mQueryString;
    @b(a = "rating")
    public float mRating;
    private String mRechargeAmount;
    private String mRechargeNumber;
    private String mRechargePromoCode;
    public String mReferralNo;
    public String mReferralRechargeType;
    public String mReferralSource;
    public String mRefferralAmount;
    @b(a = "related_category")
    private ArrayList<CJRRelatedCategory> mRelatedCategories = new ArrayList<>();
    @b(a = "reward_text")
    public String mRewardText;
    private String mRoamingEnabled;
    private String mSearcKey;
    public String mSearchABValue;
    public String mSearchCategory;
    public String mSearchResultType;
    public String mSearchTerm;
    public String mSearchType;
    private String mSearchUrl;
    @b(a = "source")
    private String mSource;
    @b(a = "status")
    public String mStatus;
    private String mTab;
    private String mTicketId = null;
    private String mTitle = "";
    private int mTodaysClickCount;
    private int mTotalClickCount;
    private String mType;
    @b(a = "url")
    public String mUrl;
    @b(a = "url_info")
    public String mUrlInfo;
    @b(a = "mUrlKey")
    private String mUrlKey;
    @b(a = "url_type")
    public String mUrlType;
    private String mUtmCampaign;
    private String mUtmContent;
    private String mUtmMedium;
    private String mUtmTerm;
    private String mVertical;
    private String mVibeArticleId;
    private String mVibeCategory;
    private int mWidgetPosition;
    private String maxPrice;
    private String merchantMID;
    @a
    private String mid;
    private String minPrice;
    private String mode;
    private String movieCode;
    private String movieSessionId;
    @b(a = "products")
    private ArrayList<CJRHomePageItem> mproducts = new ArrayList<>();
    @b(a = "seourl")
    public String mseourl;
    private String mtAmount;
    private String mtComment;
    private String nonAadhaar;
    private String overlay;
    private String p2mComment;
    private String p2mIsAmountEnable;
    private String p2mIsCommentEnable;
    private String p2mamount;
    private String p2pamount;
    private String p2pcomment;
    private String p2pmobilenumber;
    @a
    private String parentName;
    private String parentreason;
    private String payeeAddress;
    private String payeeName;
    private String pdcQrCodeId;
    public int position;
    private String promoName;
    @b(a = "pushCityValue")
    private String pushCityValue;
    private String qRCodeId;
    private String qRCodeOrderId;
    public String qrid;
    private String replacementreason;
    private Map<String, Object> sourceInfo = null;
    private String sourceName;
    private String ssid;
    private String subtitle;
    private String timestamp;
    private String userName;
    @b(a = "vertical_id")
    private String verticalid;

    public static long getSerialVersionUID() {
        return 1;
    }

    public String getSsId() {
        return this.ssid;
    }

    public void setSsId(String str) {
        this.ssid = str;
    }

    public ArrayList<CJRHomePageItem> getMproducts() {
        return this.mproducts;
    }

    public void setMproducts(ArrayList<CJRHomePageItem> arrayList) {
        this.mproducts = arrayList;
    }

    public String getAnimationjson() {
        if ("null".equalsIgnoreCase(this.animationjson)) {
            return "";
        }
        return this.animationjson;
    }

    public String getIssueText() {
        return this.issueText;
    }

    public void setIssueText(String str) {
        this.issueText = str;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String str) {
        this.issueId = str;
    }

    public String getCstOrderId() {
        return this.cstOrderId;
    }

    public void setCstOrderId(String str) {
        this.cstOrderId = str;
    }

    public String getCstItemId() {
        return this.cstItemId;
    }

    public void setCstItemId(String str) {
        this.cstItemId = str;
    }

    public String getVerticalid() {
        return this.verticalid;
    }

    public void setVerticalid(String str) {
        this.verticalid = str;
    }

    public String getL1() {
        return this.l1;
    }

    public void setL1(String str) {
        this.l1 = str;
    }

    public String getL2() {
        return this.l2;
    }

    public void setL2(String str) {
        this.l2 = str;
    }

    public String getParentreason() {
        return this.parentreason;
    }

    public void setParentreason(String str) {
        this.parentreason = str;
    }

    public String getReplacementreson() {
        return this.replacementreason;
    }

    public void setReplacementreson(String str) {
        this.replacementreason = str;
    }

    public String getChildreason() {
        return this.childreason;
    }

    public void setChildreason(String str) {
        this.childreason = str;
    }

    public String getPdcQrCodeId() {
        return this.pdcQrCodeId;
    }

    public void setPdcQrCodeId(String str) {
        this.pdcQrCodeId = str;
    }

    public String getFeatureType() {
        return this.featureType;
    }

    public void setFeatureType(String str) {
        this.featureType = str;
    }

    public String getLifafaId() {
        return this.lifafaId;
    }

    public void setLifafaId(String str) {
        this.lifafaId = str;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    public String getqRCodeId() {
        return this.qRCodeId;
    }

    public void setqRCodeId(String str) {
        this.qRCodeId = str;
    }

    public String getAffilaiteID() {
        return this.affilaiteID;
    }

    public void setAffilaiteID(String str) {
        this.affilaiteID = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public String getmContainerInstanceID() {
        return this.mContainerInstanceID;
    }

    public String getParentID() {
        return this.mParentId;
    }

    public void setmContainerInstanceID(String str) {
        this.mContainerInstanceID = str;
    }

    public String getCashbackOfferTag() {
        return this.cashbackOfferTag;
    }

    public void setCashbackOfferTag(String str) {
        this.cashbackOfferTag = str;
    }

    public String getCashbackScreen() {
        return this.cashbackScreen;
    }

    public void setCashbackScreen(String str) {
        this.cashbackScreen = str;
    }

    public String getCashbackCampaignId() {
        return this.cashbackCampaignId;
    }

    public void setCashbackCampaignId(String str) {
        this.cashbackCampaignId = str;
    }

    public String getCashbackOfferId() {
        return this.cashbackOfferId;
    }

    public void setCashbackOfferId(String str) {
        this.cashbackOfferId = str;
    }

    public String getmType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }

    public String getmLandingPage() {
        return this.mLandingPage;
    }

    public void setmLandingPage(String str) {
        this.mLandingPage = str;
    }

    public String getmAmount() {
        return this.mAmount;
    }

    public void setmAmount(String str) {
        this.mAmount = str;
    }

    public String getmGram() {
        return this.mGram;
    }

    public void setmGram(String str) {
        this.mGram = str;
    }

    public boolean ismProceed() {
        return this.mProceed;
    }

    public void setmProceed(boolean z) {
        this.mProceed = z;
    }

    public String getOverlay() {
        return this.overlay;
    }

    public void setOverlay(String str) {
        this.overlay = str;
    }

    public String getReferralRechargeType() {
        return this.mReferralRechargeType;
    }

    public void setReferralRechargeType(String str) {
        this.mReferralRechargeType = str;
    }

    public String getReferralSource() {
        return this.mReferralSource;
    }

    public void setmReferralSource(String str) {
        this.mReferralSource = str;
    }

    public String getReferralNo() {
        return this.mReferralNo;
    }

    public void setReferralNo(String str) {
        this.mReferralNo = str;
    }

    public String getReferralAmount() {
        return this.mRefferralAmount;
    }

    public void setReferralAmount(String str) {
        this.mRefferralAmount = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getListName() {
        return this.mGTMListName;
    }

    public void setListName(String str) {
        this.mGTMListName = str;
    }

    public String getQrid() {
        return this.qrid;
    }

    public void setQrid(String str) {
        this.qrid = str;
    }

    public String getPayeeAddress() {
        return this.payeeAddress;
    }

    public void setPayeeAddress(String str) {
        this.payeeAddress = str;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public void setPayeeName(String str) {
        this.payeeName = str;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getMtAmount() {
        return this.mtAmount;
    }

    public void setMtAmount(String str) {
        this.mtAmount = str;
    }

    public String getMtComment() {
        return this.mtComment;
    }

    public void setMtComment(String str) {
        this.mtComment = str;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public int getListPosition() {
        return this.mGTMPosition;
    }

    public void setListPosition(int i2) {
        this.mGTMPosition = i2;
    }

    public String getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(String str) {
        this.mSearchType = str;
    }

    public String getSearchCategory() {
        return this.mSearchCategory;
    }

    public void setSearchCategory(String str) {
        this.mSearchCategory = str;
    }

    public String getSearchTerm() {
        return this.mSearchTerm;
    }

    public void setSearchTerm(String str) {
        this.mSearchTerm = str;
    }

    public String getSearchResultType() {
        return this.mSearchResultType;
    }

    public void setSearchResultType(String str) {
        this.mSearchResultType = str;
    }

    public String getSearchUrl() {
        return this.mSearchUrl;
    }

    public void setSearchUrl(String str) {
        this.mSearchUrl = str;
    }

    public String getSearchKey() {
        return this.mSearcKey;
    }

    public void setSearcKey(String str) {
        this.mSearcKey = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public void setIsFromSearch(boolean z) {
        this.mIsFromSearch = z;
    }

    public boolean isFromFromSearch() {
        return this.mIsFromSearch;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public boolean isHasRewards() {
        return this.mHasRewards;
    }

    public String getRewardText() {
        return this.mRewardText;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public boolean isLoginRequired() {
        return this.mLoginRequired;
    }

    public float getRating() {
        return this.mRating;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public void setParentId(String str) {
        this.mParentId = str;
    }

    public String getPushMessageBody() {
        return this.mPushAlertMessageBody;
    }

    public void setPushMessageBody(String str) {
        this.mPushAlertMessageBody = str;
    }

    public String getPushTitle() {
        return this.mPushTitle;
    }

    public void setPushTitle(String str) {
        this.mPushTitle = str;
    }

    public boolean isPushShowPopup() {
        return this.mPushShowPopup;
    }

    public void setPushShowPopup(boolean z) {
        this.mPushShowPopup = z;
    }

    public String getPushProductId() {
        return this.mPushProductId;
    }

    public void setPushProductId(String str) {
        this.mPushProductId = str;
    }

    public String getPushQuantity() {
        return this.mPushQuantity;
    }

    public void setPushQuantity(String str) {
        this.mPushQuantity = str;
    }

    public String getPushPromoCode() {
        return this.mPushPromoCode;
    }

    public void setPushPromoCode(String str) {
        this.mPushPromoCode = str;
    }

    public String getPushCashAdd() {
        return this.mPushCashAdd;
    }

    public void setPushCashAdd(String str) {
        this.mPushCashAdd = str;
    }

    public String getUtmSource() {
        return this.mPushUtmSource;
    }

    public void setPushUtmSource(String str) {
        this.mPushUtmSource = str;
    }

    public String getOfferTag() {
        return this.mOfferTag;
    }

    public String getPushFeatureType() {
        return this.mPushFeatureType;
    }

    public void setPushFeatureType(String str) {
        this.mPushFeatureType = str;
    }

    public String getPushWalletCode() {
        return this.mPushWalletCode;
    }

    public void setPushWalletCode(String str) {
        this.mPushWalletCode = str;
    }

    public String getPushRecipient() {
        return this.mPushRecipient;
    }

    public void setPushRecipient(String str) {
        this.mPushRecipient = str;
    }

    public String getPushComment() {
        return this.mPushComment;
    }

    public void setPushComment(String str) {
        this.mPushComment = str;
    }

    public String getUrlInfo() {
        return this.mUrlInfo;
    }

    public String getmPripority() {
        return this.mPripority;
    }

    public ArrayList<CJRRelatedCategory> getRelatedCategories() {
        return this.mRelatedCategories;
    }

    public void setRelatedCategories(ArrayList<CJRRelatedCategory> arrayList) {
        this.mRelatedCategories = arrayList;
    }

    public float getOfferPrice() {
        return this.mOfferPrice;
    }

    public float getActualPrice() {
        return this.mActualPrice;
    }

    public String getURLType() {
        return this.mUrlType;
    }

    public String getURL() {
        String str = this.mUrl;
        return str == null ? this.mseourl : str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getPrice() {
        String str = this.mPrice;
        if (str != null && !str.contains("Rs")) {
            this.mPrice = "Rs " + this.mPrice;
        }
        return this.mPrice;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public boolean equals(Object obj) {
        try {
            return this.mItemID.equals(((CJRHomePageItem) obj).mItemID);
        } catch (Exception unused) {
            return false;
        }
    }

    public String getItemID() {
        return this.mItemID;
    }

    public void setItemID(String str) {
        this.mItemID = str;
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getParentItem() {
        return this.mParentItem;
    }

    public void setParentItem(String str) {
        this.mParentItem = str;
    }

    public String getProductCategory() {
        return this.mCategory;
    }

    public void setItemViewed() {
        this.itemViewed = true;
    }

    public boolean isItemViewed() {
        return this.itemViewed;
    }

    public String getUtmMedium() {
        return this.mUtmMedium;
    }

    public void setUtmMedium(String str) {
        this.mUtmMedium = str;
    }

    public String getUtmContent() {
        return this.mUtmContent;
    }

    public void setUtmContent(String str) {
        this.mUtmContent = str;
    }

    public String getUtmTerm() {
        return this.mUtmTerm;
    }

    public void setUtmTerm(String str) {
        this.mUtmTerm = str;
    }

    public String getUtmCampaign() {
        return this.mUtmCampaign;
    }

    public void setUtmCampaign(String str) {
        this.mUtmCampaign = str;
    }

    public boolean isDeepLinking() {
        return this.mDeepLinking;
    }

    public void setDeepLinking(boolean z) {
        this.mDeepLinking = z;
    }

    public String getPushCheckInDate() {
        return this.mPushCheckInDate;
    }

    public void setPushCheckInDate(String str) {
        this.mPushCheckInDate = str;
    }

    public String getPushCheckOutDate() {
        return this.mPushCheckOutDate;
    }

    public void setPushCheckOutDate(String str) {
        this.mPushCheckOutDate = str;
    }

    public String getPushCity() {
        return this.mPushCity;
    }

    public void setPushCity(String str) {
        this.mPushCity = str;
    }

    public String getPushRoomDetailsJson() {
        return this.mPushRoomDetailsJson;
    }

    public void setPushRoomDetailsJson(String str) {
        this.mPushRoomDetailsJson = str;
    }

    public String getQueryString() {
        return this.mQueryString;
    }

    public void setQueryString(String str) {
        this.mQueryString = str;
    }

    public boolean getIsInStock() {
        return this.mIsInStock;
    }

    public void setIsInStock(boolean z) {
        this.mIsInStock = z;
    }

    public String getProductImgWidth() {
        return this.mImgWidth;
    }

    public void setProductImgWidth(String str) {
        this.mImgWidth = str;
    }

    public String getProductImgHeight() {
        return this.mImgHeight;
    }

    public void setProductImgHeight(String str) {
        this.mImgHeight = str;
    }

    public String getDiscountPercent() {
        return this.mDiscount;
    }

    public void setDiscountPercent(String str) {
        this.mDiscount = str;
    }

    public String getPushHotelName() {
        return this.mPushHotelName;
    }

    public void setPushHotelName(String str) {
        this.mPushHotelName = str;
    }

    public String getPushHotelId() {
        return this.mPushHotelId;
    }

    public void setPushHotelId(String str) {
        this.mPushHotelId = str;
    }

    public String getPushHotelExtras() {
        return this.mPushHotelExtras;
    }

    public void setPushHotelExtras(String str) {
        this.mPushHotelExtras = str;
    }

    public String getPushHotelFinalPriceWithTax() {
        return this.mPushHotelFinalPriceWithTax;
    }

    public void setPushHotelFinalPriceWithTax(String str) {
        this.mPushHotelFinalPriceWithTax = str;
    }

    public String getOrigin() {
        return this.mOrigin;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
    }

    public String getPushSourceCityName() {
        return this.mPushSourceCityName;
    }

    public void setPushSourceCityName(String str) {
        this.mPushSourceCityName = str;
    }

    public String getPushSourceCityShortName() {
        return this.mPushSourceCityShortName;
    }

    public void setPushSourceCityShortName(String str) {
        this.mPushSourceCityShortName = str;
    }

    public String getPushDestinationCityName() {
        return this.mPushDestinationCityName;
    }

    public void setPushDestinationCityName(String str) {
        this.mPushDestinationCityName = str;
    }

    public String getPushDestinationCityShortName() {
        return this.mPushDestinationCityShortName;
    }

    public void setPushDestinationCityShortName(String str) {
        this.mPushDestinationCityShortName = str;
    }

    public String getPushDate() {
        return this.mPushDate;
    }

    public void setPushDate(String str) {
        this.mPushDate = str;
    }

    public String getPushPassengerCount() {
        return this.mPushPassengerCount;
    }

    public void setPushPassengerCount(String str) {
        this.mPushPassengerCount = str;
    }

    public String getPushRechargeNumber() {
        return this.mRechargeNumber;
    }

    public void setPushRechargeNumber(String str) {
        this.mRechargeNumber = str;
    }

    public String getPushRechargeAmount() {
        return this.mRechargeAmount;
    }

    public void setPushRechargeAmount(String str) {
        this.mRechargeAmount = str;
    }

    public String getPushRechargePromo() {
        return this.mRechargePromoCode;
    }

    public void setPushRechargePromo(String str) {
        this.mRechargePromoCode = str;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public String getPushType() {
        return this.mPushType;
    }

    public void setPushType(String str) {
        this.mPushType = str;
    }

    public String getPushCode() {
        return this.mPushCode;
    }

    public void setPushCode(String str) {
        this.mPushCode = str;
    }

    public boolean isSellerStoreImpressionSent() {
        return this.isSellerStoreImpressionSent;
    }

    public void setSellerStoreImpressionSent(boolean z) {
        this.isSellerStoreImpressionSent = z;
    }

    public String getListId() {
        return this.mListId;
    }

    public void setListId(String str) {
        this.mListId = str;
    }

    public boolean getImageFromResource() {
        return this.imageFromResource;
    }

    public void setImageFromResource(boolean z) {
        this.imageFromResource = z;
    }

    public String getPushFlightClass() {
        return this.mPushFlightClass;
    }

    public void setPushFlightClass(String str) {
        this.mPushFlightClass = str;
    }

    public String getPushFlightTripType() {
        return this.mPushFlightTripType;
    }

    public void setPushFlightTripType(String str) {
        this.mPushFlightTripType = str;
    }

    public String getPushFlightReturnDate() {
        return this.mPushFlightReturnDate;
    }

    public void setPushFlightReturnDate(String str) {
        this.mPushFlightReturnDate = str;
    }

    public String getPushFlightDepartDate() {
        return this.mPushFlightDepartDate;
    }

    public void setPushFlightDepartDate(String str) {
        this.mPushFlightDepartDate = str;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankUserName(String str) {
        this.userName = str;
    }

    public String getBankUserName() {
        return this.userName;
    }

    public void setBankAccountNumber(String str) {
        this.bankAccountNumber = str;
    }

    public String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public void setBankComment(String str) {
        this.bankcomment = str;
    }

    public String getBankComment() {
        return this.bankcomment;
    }

    public void setBankAmount(String str) {
        this.bankAmount = str;
    }

    public String getBankAmount() {
        return this.bankAmount;
    }

    public String getP2pamount() {
        return this.p2pamount;
    }

    public void setP2pamount(String str) {
        this.p2pamount = str;
    }

    public String getP2pcomment() {
        return this.p2pcomment;
    }

    public void setP2pcomment(String str) {
        this.p2pcomment = str;
    }

    public String getP2pmobilenumber() {
        return this.p2pmobilenumber;
    }

    public void setP2pmobilenumber(String str) {
        this.p2pmobilenumber = str;
    }

    public String getmGroupId() {
        return this.mGroupId;
    }

    public void setmGroupId(String str) {
        this.mGroupId = str;
    }

    public String getEventName() {
        return this.mEventName;
    }

    public void setEventName(String str) {
        this.mEventName = str;
    }

    public String getEventCityName() {
        return this.mEventCityName;
    }

    public void setEventCityName(String str) {
        this.mEventCityName = str;
    }

    public String getmEventId() {
        return this.mEventId;
    }

    public void setmEventId(String str) {
        this.mEventId = str;
    }

    public String getEventCategory() {
        return this.mEventCategory;
    }

    public void setEventCategory(String str) {
        this.mEventCategory = str;
    }

    public String getEventSubCategory() {
        return this.mEventSubCategory;
    }

    public void setEventSubCategory(String str) {
        this.mEventSubCategory = str;
    }

    public String getEventProviderId() {
        return this.mEventProviderId;
    }

    public void setEventProviderId(String str) {
        this.mEventProviderId = str;
    }

    public void setSearchABValue(String str) {
        this.mSearchABValue = str;
    }

    public String getSearchABValue() {
        return this.mSearchABValue;
    }

    public String getParkcityLabel() {
        return this.mParkcityLabel;
    }

    public void setmParkcityLabel(String str) {
        this.mParkcityLabel = str;
    }

    public String getParkcityValue() {
        return this.mParkcityValue;
    }

    public void setParkcityValue(String str) {
        this.mParkcityValue = str;
    }

    public String getmParkCategory() {
        return this.mParkCategory;
    }

    public void setmParkCategory(String str) {
        this.mParkCategory = str;
    }

    public String getmParkProviderId() {
        return this.mParkProviderId;
    }

    public void setmParkProviderId(String str) {
        this.mParkProviderId = str;
    }

    public String getmParkCityName() {
        return this.mParkCityName;
    }

    public void setmParkCityName(String str) {
        this.mParkCityName = str;
    }

    public String getmParkName() {
        return this.mParkName;
    }

    public void setmParkName(String str) {
        this.mParkName = str;
    }

    public String getmParkId() {
        return this.mParkId;
    }

    public void setmParkId(String str) {
        this.mParkId = str;
    }

    public String getGiftCardUrl() {
        return this.mGiftCardUrl;
    }

    public void setGiftCardUrl(String str) {
        this.mGiftCardUrl = str;
    }

    public String getLanding_page() {
        return this.landing_page;
    }

    public void setLanding_page(String str) {
        this.landing_page = str;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getAadhar_number() {
        return this.aadhar_number;
    }

    public void setAadhar_number(String str) {
        this.aadhar_number = str;
    }

    public String getKyc_name() {
        return this.kyc_name;
    }

    public void setKyc_name(String str) {
        this.kyc_name = str;
    }

    public boolean isFromReqDelivery() {
        return this.isFromReqDelivery;
    }

    public void setPushRechargeRoaming(String str) {
        this.mRoamingEnabled = str;
    }

    public void setFromReqDelivery(boolean z) {
        this.isFromReqDelivery = z;
    }

    public String getPushRechargeRoaming() {
        return this.mRoamingEnabled;
    }

    public void setPushCityValue(String str) {
        this.pushCityValue = str;
    }

    public String getPushCityValue() {
        return this.pushCityValue;
    }

    public String getmTicketId() {
        return this.mTicketId;
    }

    public void setmTicketId(String str) {
        this.mTicketId = str;
    }

    public String getCinemaMovieCode() {
        return this.mCinemaMovieCode;
    }

    public String getMovieName() {
        return this.mMovieName;
    }

    public void setMovieName(String str) {
        this.mMovieName = str;
    }

    public void setCinemaMovieCode(String str) {
        this.mCinemaMovieCode = str;
    }

    public String getPostOrderCinemaId() {
        return this.mPostOrderCinemaId;
    }

    public void setPostOrderCinemaId(String str) {
        this.mPostOrderCinemaId = str;
    }

    public String getPostOrderProviderId() {
        return this.mPostOrderProviderId;
    }

    public void setPostOrderProviderId(String str) {
        this.mPostOrderProviderId = str;
    }

    public String getmFlightReferral() {
        return this.mFlightReferral;
    }

    public void setmFlightReferral(String str) {
        this.mFlightReferral = str;
    }

    public void setSourceInfo(Map<String, Object> map) {
        this.sourceInfo = map;
    }

    public Map<String, Object> getSourceInfo() {
        return this.sourceInfo;
    }

    public String getLayoutType() {
        return this.layoutType;
    }

    public void setLayoutType(String str) {
        this.layoutType = str;
    }

    public String getP2mamount() {
        return this.p2mamount;
    }

    public void setP2mamount(String str) {
        this.p2mamount = str;
    }

    public String getMerchantMID() {
        return this.merchantMID;
    }

    public void setMerchantMID(String str) {
        this.merchantMID = str;
    }

    public String getP2mComment() {
        return this.p2mComment;
    }

    public void setP2mComment(String str) {
        this.p2mComment = str;
    }

    public String getAltImageUrl2() {
        return this.mAltImageUrl2;
    }

    public String getDeleteUrl() {
        return this.mDeleteUrl;
    }

    public String getmUrlKey() {
        return this.mUrlKey;
    }

    public void setmUrlKey(String str) {
        this.mUrlKey = str;
    }

    public String getContactUsIssueParentId() {
        return this.contactUsIssueParentId;
    }

    public void setContactUsIssueParentId(String str) {
        this.contactUsIssueParentId = str;
    }

    public String getContactUsIssueVerticalLabel() {
        return this.contactUsIssueVerticalLabel;
    }

    public void setContactUsIssueVerticalLabel(String str) {
        this.contactUsIssueVerticalLabel = str;
    }

    public String getPushFilterJson() {
        return this.mPushFilterJson;
    }

    public void setPushFilterJson(String str) {
        this.mPushFilterJson = str;
    }

    public String getContentID() {
        return this.contentID;
    }

    public void setContentID(String str) {
        this.contentID = str;
    }

    public String getMovieCode() {
        return this.movieCode;
    }

    public void setMovieCode(String str) {
        this.movieCode = str;
    }

    public void setWidgetPosition(int i2) {
        this.mWidgetPosition = i2;
    }

    public int getWidgetPosition() {
        return this.mWidgetPosition;
    }

    public void setCallBackUrl(String str) {
        this.mCallbackUrl = str;
    }

    public String getCallBackUrl() {
        return this.mCallbackUrl;
    }

    public void setVertical(String str) {
        this.mVertical = str;
    }

    public String getVertical() {
        return this.mVertical;
    }

    public void setForm60(String str) {
        this.mForm60 = str;
    }

    public String getForm60() {
        return this.mForm60;
    }

    public void setDbtConsent(String str) {
        this.mDbtConsent = str;
    }

    public String getDbtConsent() {
        return this.mDbtConsent;
    }

    public void setAadhaarOtp(String str) {
        this.aadhaarOtp = str;
    }

    public String getAadhaarOtp() {
        return this.aadhaarOtp;
    }

    public void setNonAadhaar(String str) {
        this.nonAadhaar = str;
    }

    public String getNonAadhaar() {
        return this.nonAadhaar;
    }

    public void setOpenScreen(String str) {
        this.mOpenScreen = str;
    }

    public String getOpenScreen() {
        return this.mOpenScreen;
    }

    public String getP2mIsCommentEnable() {
        return this.p2mIsCommentEnable;
    }

    public void setP2mIsCommentEnable(String str) {
        this.p2mIsCommentEnable = str;
    }

    public String getP2mIsAmountEnable() {
        return this.p2mIsAmountEnable;
    }

    public void setP2mIsAmountEnable(String str) {
        this.p2mIsAmountEnable = str;
    }

    public void setMovieSessionId(String str) {
        this.movieSessionId = str;
    }

    public String getMovieSessionId() {
        return this.movieSessionId;
    }

    public String getTab() {
        return this.mTab;
    }

    public void setTab(String str) {
        this.mTab = str;
    }

    public IJRPaytmDataModel getBuilderModel() {
        return this.builderModel;
    }

    public void setBuilderModel(IJRPaytmDataModel iJRPaytmDataModel) {
        this.builderModel = iJRPaytmDataModel;
    }

    public String getqRCodeOrderId() {
        return this.qRCodeOrderId;
    }

    public void setqRCodeOrderId(String str) {
        this.qRCodeOrderId = str;
    }

    public MetaData getMetaData() {
        return this.mMetaData;
    }

    public void setMetaData(MetaData metaData) {
        this.mMetaData = metaData;
    }

    public void setClickConfigurable(boolean z) {
        this.mClickConfigurable = z;
    }

    public boolean isClickConfigurable() {
        return this.mClickConfigurable;
    }

    public void setClickCount(int i2) {
        this.mTodaysClickCount = i2;
    }

    public int getClickCount() {
        return this.mTodaysClickCount;
    }

    public void setTotalClickCount(int i2) {
        this.mTotalClickCount = i2;
    }

    public int getTotalClickCount() {
        return this.mTotalClickCount;
    }

    public void setClickDate(String str) {
        this.mClickDate = str;
    }

    public String getClickDate() {
        return this.mClickDate;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setInsuranceParam(HashMap<String, String> hashMap) {
        this.insuranceParams = hashMap;
    }

    public HashMap<String, String> getInsuranceParams() {
        return this.insuranceParams;
    }

    public class MetaData extends IJRPaytmDataModel {
        @b(a = "category_weights")
        private List<Weight> mCategoryWeights;

        public MetaData() {
        }

        public List<Weight> getmCategoryWeights() {
            return this.mCategoryWeights;
        }

        public void setmCategoryWeights(List<Weight> list) {
            this.mCategoryWeights = list;
        }
    }

    public class Weight extends IJRPaytmDataModel {
        @b(a = "weight")
        private int weight;

        public Weight() {
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int i2) {
            this.weight = i2;
        }
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String str) {
        this.parentName = str;
    }

    public boolean isOther() {
        return this.isOther;
    }

    public void setOther(boolean z) {
        this.isOther = z;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public int getHeaderVeriticalPos() {
        return this.headerVeriticalPos;
    }

    public void setHeaderVeriticalPos(int i2) {
        this.headerVeriticalPos = i2;
    }

    public String getGACategory() {
        return this.GACategory;
    }

    public String getmVibeCategory() {
        return this.mVibeCategory;
    }

    public void setmVibeCategory(String str) {
        this.mVibeCategory = str;
    }

    public String getmVibeArticleId() {
        return this.mVibeArticleId;
    }

    public void setmVibeArticleId(String str) {
        this.mVibeArticleId = str;
    }

    public String getPromoName() {
        return this.promoName;
    }

    public void setPromoName(String str) {
        this.promoName = str;
    }

    public int getDeeplinkType() {
        return this.deeplinkType;
    }

    public void setDeeplinkType(int i2) {
        this.deeplinkType = i2;
    }
}
