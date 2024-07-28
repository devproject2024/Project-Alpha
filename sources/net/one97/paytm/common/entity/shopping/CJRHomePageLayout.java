package net.one97.paytm.common.entity.shopping;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;

public class CJRHomePageLayout extends CJRItem {
    private static final long serialVersionUID = 1;
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
    private boolean mIsRecommended;
    @b(a = "layout")
    private String mLayout;
    private String mListId = "";
    @b(a = "name")
    private String mName;
    @b(a = "see_all_url")
    private String mSeeAllUrl;

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

    public ArrayList<CJRRelatedCategory> getRelatedCategories() {
        return null;
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
        return this.mLayout;
    }

    public void setLayout(String str) {
        this.mLayout = str;
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mName)) {
            sb.append(this.mName);
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
}
