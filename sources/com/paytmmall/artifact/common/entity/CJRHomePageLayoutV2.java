package com.paytmmall.artifact.common.entity;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRHomePageLayoutV2 extends CJRItem {
    private static final long serialVersionUID = 1;
    private String affiliateID;
    private CJRHomePageLayoutV2 browseCategory;
    @b(a = "datasources")
    private ArrayList<CJRDataSource> datasources = new ArrayList<>();
    private String deeplink;
    @b(a = "display_fields")
    private ArrayList<String> displayParams = new ArrayList<>();
    private String gaKey;
    @a
    private boolean isAnotherMidPresent;
    private boolean isBlue;
    private boolean isBorderVisible = true;
    private boolean isLast;
    private boolean isSellerStoreImpressionSent;
    private String mFooterImageURL;
    private boolean mGDREventSent;
    @b(a = "header_imageurl")
    private String mHeaderImageData;
    @b(a = "items")
    private ArrayList<CJRHomePageItem> mHomePageItemList = new ArrayList<>();
    @b(a = "html")
    private String mHtml;
    @b(a = "id")
    private String mID;
    @b(a = "image_url")
    private String mImageUrl;
    private boolean mIsRecommended;
    private boolean mIsViewExpanded;
    @b(a = "type")
    private String mLayout;
    @b(a = "layout_type")
    private String mLayoutType;
    private String mListId = "";
    @b(a = "name")
    private String mListTitleName;
    @b(a = "title")
    private String mName;
    private ArrayList<IJRPaytmDataModel> mRecentPaymentList;
    @b(a = "see_all_url")
    private String mSeeAllUrl;
    @b(a = "seourl")
    private String mSeoUrl;
    @b(a = "subtitle")
    private String mSubtitle;
    private int mWidgetPosition;
    private String qrCode;
    private String timeStamp;

    public String getBrand() {
        return null;
    }

    public String getCardState() {
        return "";
    }

    public String getCategoryId() {
        return null;
    }

    public String getItemID() {
        return null;
    }

    public String getLabel() {
        return null;
    }

    public String getListName() {
        return null;
    }

    public int getListPosition() {
        return -1;
    }

    public String getParentID() {
        return "";
    }

    public String getPrice() {
        return "";
    }

    public String getPromoCode() {
        return "";
    }

    public String getPromoText() {
        return "";
    }

    public String getSearchABValue() {
        return null;
    }

    public String getSearchCategory() {
        return null;
    }

    public String getSearchResultType() {
        return null;
    }

    public String getSearchTerm() {
        return null;
    }

    public String getSearchType() {
        return null;
    }

    public String getSource() {
        return null;
    }

    public String getStatusSubText() {
        return "";
    }

    public String getStatusText() {
        return "";
    }

    public String getThumbnailUrl() {
        return "";
    }

    public String getURLType() {
        return null;
    }

    public String getmContainerInstanceID() {
        return "";
    }

    public boolean isExpanded() {
        return false;
    }

    public boolean isKeepTryingEnabled() {
        return false;
    }

    public boolean isPendingCancelEnabled() {
        return false;
    }

    public boolean isRetryEnabled() {
        return false;
    }

    public ArrayList<CJRDataSource> getDatasources() {
        return this.datasources;
    }

    public void setDatasources(ArrayList<CJRDataSource> arrayList) {
        this.datasources = arrayList;
    }

    public String getmLayoutType() {
        return this.mLayoutType;
    }

    public void setmLayoutType(String str) {
        this.mLayoutType = str;
    }

    public String getmListTitleName() {
        return this.mListTitleName;
    }

    public void setmListTitleName(String str) {
        this.mListTitleName = str;
    }

    public void setmID(String str) {
        this.mID = str;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public String getAffiliateID() {
        return this.affiliateID;
    }

    public void setAffiliateID(String str) {
        this.affiliateID = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public void setmHomePageItemList(ArrayList<CJRHomePageItem> arrayList) {
        this.mHomePageItemList = arrayList;
    }

    public boolean ismIsRecommended() {
        return this.mIsRecommended;
    }

    public String getmID() {
        return this.mID;
    }

    public ArrayList<CJRHomePageItem> getHomePageItemList() {
        for (int i2 = 0; i2 < this.mHomePageItemList.size(); i2++) {
            this.mHomePageItemList.get(i2).setListId(getmID());
        }
        return this.mHomePageItemList;
    }

    public String getLayout() {
        if (getmLayoutType() != null) {
            return getmLayoutType();
        }
        return this.mLayout;
    }

    public void setLayout(String str) {
        this.mLayout = str;
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mName)) {
            sb.append(this.mName);
        } else {
            String str = this.mListTitleName;
            if (str == null) {
                str = "";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getHtml() {
        return this.mHtml;
    }

    public String getHeaderImage() {
        return this.mHeaderImageData;
    }

    public String getSeeAllUrl() {
        return this.mSeeAllUrl;
    }

    public String getURL() {
        return this.mSeeAllUrl;
    }

    public void setUrlType(String str) {
        this.mLayout = str;
    }

    public String getFooterImageURL() {
        return this.mFooterImageURL;
    }

    public void setFooterImageURL(String str) {
        this.mFooterImageURL = str;
    }

    public void setIsRecommended(boolean z) {
        this.mIsRecommended = z;
    }

    public void setGDREventSent() {
        this.mGDREventSent = true;
    }

    public boolean isGDREventSent() {
        return this.mGDREventSent;
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

    public ArrayList<String> getDisplayParams() {
        return this.displayParams;
    }

    public boolean isViewExpanded() {
        return this.mIsViewExpanded;
    }

    public void setViewExpanded(boolean z) {
        this.mIsViewExpanded = z;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getmSubtitle() {
        return this.mSubtitle;
    }

    public String getSeoUrl() {
        return this.mSeoUrl;
    }

    public int getWidgetPosition() {
        return this.mWidgetPosition;
    }

    public void setWidgetPosition(int i2) {
        this.mWidgetPosition = i2;
    }

    public boolean isAnotherMidPresent() {
        return this.isAnotherMidPresent;
    }

    public void setAnotherMidPresent(boolean z) {
        this.isAnotherMidPresent = z;
    }

    public ArrayList<IJRPaytmDataModel> getRecentPaymentList() {
        return this.mRecentPaymentList;
    }

    public void setRecentPaymentList(ArrayList<IJRPaytmDataModel> arrayList) {
        this.mRecentPaymentList = arrayList;
    }

    public CJRHomePageLayoutV2 getBrowseCategory() {
        return this.browseCategory;
    }

    public void setBrowseCategory(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        this.browseCategory = cJRHomePageLayoutV2;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public boolean isBorderVisible() {
        return this.isBorderVisible;
    }

    public void setBorderVisible(boolean z) {
        this.isBorderVisible = z;
    }

    public boolean isBlue() {
        return this.isBlue;
    }

    public void setBlue(boolean z) {
        this.isBlue = z;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setLast(boolean z) {
        this.isLast = z;
    }
}
