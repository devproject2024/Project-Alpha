package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import com.google.gson.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CJRGrid implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "contextParams")
    private HashMap<String, String> contextParam;
    @c(a = "custom_link_content")
    private String customLinkContent;
    @c(a = "custom_link_enabled")
    private int customLinkEnabled;
    @c(a = "location_score")
    private double locationScore;
    @c(a = "location_racking_enabled")
    private boolean locationTrackingEnable;
    @c(a = "add_to_cart")
    private int mAddToCart;
    @c(a = "ancestors")
    private ArrayList<CJRAncestor> mAncestors = new ArrayList<>();
    @c(a = "app_object")
    private String mAppObject;
    @c(a = "app_url")
    private String mAppUrl;
    @c(a = "default_sorting_param")
    private String mDeafultSortParam;
    @c(a = "experiment")
    private String mExperiment;
    @c(a = "filters")
    private ArrayList<CJRFilterItem> mFilterList = new ArrayList<>();
    @c(a = "footer_html")
    private String mFooterHtml;
    @c(a = "footer_image_url")
    private String mFooterImageUrl;
    @c(a = "frontend_filters")
    private ArrayList<CJRFrontEndFilter> mFrontEndFilterList = new ArrayList<>();
    @c(a = "ga_key")
    private String mGAKey;
    private String mGATitle;
    @c(a = "grid_header")
    private CJRGridHeader mGridHeader;
    @c(a = "grid_layout")
    private ArrayList<CJRGridProduct> mGridLayout = new ArrayList<>();
    @c(a = "meta")
    private CJRGridMeta mGridMeta;
    @c(a = "has_more")
    private boolean mHasMore;
    @c(a = "id")
    private String mID;
    @c(a = "name")
    private String mName;
    @c(a = "offer_text")
    private String mOfferText;
    @c(a = "pincode")
    private String mPincode;
    @c(a = "query_type")
    private String mQueryType;
    @c(a = "result_type")
    private String mResultType;
    @c(a = "total_count")
    private String mSearchCount;
    @c(a = "search_id")
    private String mSearchId;
    @c(a = "search_suggestion")
    private ArrayList<CJRSearchSuggestion> mSearchSuggestionList;
    @c(a = "totalCount")
    private String mSearchTotalCount;
    @c(a = "search_user_id")
    private String mSearchUserId;
    @c(a = "show_offers")
    private int mShowOffers;
    @c(a = "sorting_keys")
    private ArrayList<CJRSortingKeys> mSortKeys = new ArrayList<>();
    @c(a = "terms_conditions")
    private CJRTermsAndConditions mTermsConditions;
    @c(a = "view_type")
    private String mViewType;
    @c(a = "render_url")
    private String renderUrl;
    private String searchCookie;

    public String getRenderUrl() {
        return this.renderUrl;
    }

    public void setRenderUrl(String str) {
        this.renderUrl = str;
    }

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

    public ArrayList<CJRFilterItem> getFilterList() {
        return this.mFilterList;
    }

    public CJRGridHeader getGridHeader() {
        return this.mGridHeader;
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

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        f fVar = new f();
        return fVar.b(this).equals(fVar.b(obj));
    }

    public String getExperiment() {
        return this.mExperiment;
    }

    public void setExperiment(String str) {
        this.mExperiment = str;
    }
}
