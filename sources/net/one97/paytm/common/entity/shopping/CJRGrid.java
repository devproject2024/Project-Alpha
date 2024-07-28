package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRDataModelItem;
import net.one97.paytm.common.entity.CJRFilterItem;
import net.one97.paytm.common.entity.CJRFrontEndFilter;

public class CJRGrid extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "contextParams")
    private HashMap<String, String> contextParam;
    @b(a = "custom_link_content")
    private String customLinkContent;
    @b(a = "custom_link_enabled")
    private int customLinkEnabled;
    @b(a = "location_score")
    private double locationScore;
    @b(a = "location_racking_enabled")
    private boolean locationTrackingEnable;
    @b(a = "add_to_cart")
    private int mAddToCart;
    @b(a = "ancestors")
    private ArrayList<CJRAncestor> mAncestors = new ArrayList<>();
    @b(a = "app_object")
    private String mAppObject;
    @b(a = "app_url")
    private String mAppUrl;
    @b(a = "datasources")
    private ArrayList<CJRDataSource> mDataSourceList = new ArrayList<>();
    @b(a = "default_sorting_param")
    private String mDeafultSortParam;
    @b(a = "filters")
    private ArrayList<CJRFilterItem> mFilterList = new ArrayList<>();
    @b(a = "footer_html")
    private String mFooterHtml;
    @b(a = "footer_image_url")
    private String mFooterImageUrl;
    @b(a = "frontend_filters")
    private ArrayList<CJRFrontEndFilter> mFrontEndFilterList = new ArrayList<>();
    @b(a = "ga_key")
    private String mGAKey;
    private String mGATitle;
    @b(a = "grid_layout")
    private ArrayList<CJRGridProduct> mGridLayout = new ArrayList<>();
    @b(a = "meta")
    private CJRGridMeta mGridMeta;
    @b(a = "has_more")
    private boolean mHasMore;
    @b(a = "id")
    private String mID;
    @b(a = "name")
    private String mName;
    @b(a = "offer_text")
    private String mOfferText;
    @b(a = "pincode")
    private String mPincode;
    @b(a = "query_type")
    private String mQueryType;
    @b(a = "result_type")
    private String mResultType;
    @b(a = "total_count")
    private String mSearchCount;
    @b(a = "search_id")
    private String mSearchId;
    @b(a = "search_suggestion")
    private ArrayList<CJRSearchSuggestion> mSearchSuggestionList;
    @b(a = "totalCount")
    private String mSearchTotalCount;
    @b(a = "search_user_id")
    private String mSearchUserId;
    @b(a = "show_offers")
    private int mShowOffers;
    @b(a = "sorting_keys")
    private ArrayList<CJRSortingKeys> mSortKeys = new ArrayList<>();
    @b(a = "terms_conditions")
    private CJRTermsAndConditions mTermsConditions;
    @b(a = "view_type")
    private String mViewType;
    private String searchCookie;

    public String getmPincode() {
        return this.mPincode;
    }

    public int getAddToCart() {
        return this.mAddToCart;
    }

    public int getShowOffers() {
        return this.mShowOffers;
    }

    public boolean getLocationTrackingEnable() {
        return this.locationTrackingEnable;
    }

    public double getLocationScore() {
        return this.locationScore;
    }

    public String getmQueryType() {
        return this.mQueryType;
    }

    public int getCustomLinkEnabled() {
        return this.customLinkEnabled;
    }

    public String getCustomLinkContent() {
        return this.customLinkContent;
    }

    public HashMap<String, String> getContextParam() {
        return this.contextParam;
    }

    public String getmAppObject() {
        return this.mAppObject;
    }

    public ArrayList<CJRDataSource> getmDataSourceList() {
        return this.mDataSourceList;
    }

    public String getmID() {
        return this.mID;
    }

    public String getSearchId() {
        return this.mSearchId;
    }

    public void setSearchId(String str) {
        this.mSearchId = str;
    }

    public ArrayList<CJRFrontEndFilter> getFrontEndFilterList() {
        return this.mFrontEndFilterList;
    }

    public ArrayList<CJRAncestor> getAncestors() {
        return this.mAncestors;
    }

    public String getLastAncestorID() {
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.mAncestors.get(this.mAncestors.size() - 1).getAncestorID();
    }

    public String getLastAncestorName() {
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.mAncestors.get(this.mAncestors.size() - 1).getName();
    }

    public ArrayList<CJRFilterItem> getFilterList() {
        return this.mFilterList;
    }

    public String getOfferText() {
        return this.mOfferText;
    }

    public String getFooterImageUrl() {
        return this.mFooterImageUrl;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public String getDefaultSortParam() {
        return this.mDeafultSortParam;
    }

    public String getFooterHtml() {
        return this.mFooterHtml;
    }

    public ArrayList<CJRGridProduct> getGridLayout() {
        for (int i2 = 0; i2 < this.mGridLayout.size(); i2++) {
            this.mGridLayout.get(i2).setListId(getmID());
        }
        return this.mGridLayout;
    }

    public ArrayList<CJRSortingKeys> getSortingKeys() {
        return this.mSortKeys;
    }

    public String getName() {
        return this.mName;
    }

    public String getSearchCount() {
        return this.mSearchCount;
    }

    public String getSearchTotalCount() {
        return this.mSearchTotalCount;
    }

    public CJRTermsAndConditions getTermsConditions() {
        return this.mTermsConditions;
    }

    public String getGATitle() {
        return this.mGATitle;
    }

    public void setGATitle(String str) {
        this.mGATitle = str;
    }

    public String getCategoryMapPath() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mAncestors.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mAncestors.get(i2).getName());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public ArrayList<CJRSearchSuggestion> getSearchSuggestionList() {
        return this.mSearchSuggestionList;
    }

    public String getResultType() {
        return this.mResultType;
    }

    public String getAppUrl() {
        return this.mAppUrl;
    }

    public String getGAKey() {
        return this.mGAKey;
    }

    public String getSearchUserId() {
        return this.mSearchUserId;
    }

    public CJRGridMeta getGridMeta() {
        return this.mGridMeta;
    }

    public String getAncestorID() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRAncestor> arrayList = this.mAncestors;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.mAncestors.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.mAncestors.get(i2).getAncestorID());
                if (size > 1 && i2 < size - 1) {
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }

    public String getSearchCookie() {
        return this.searchCookie;
    }

    public void setSearchCookie(String str) {
        this.searchCookie = str;
    }

    public String getViewType() {
        return this.mViewType;
    }

    public void setViewType(String str) {
        this.mViewType = str;
    }
}
