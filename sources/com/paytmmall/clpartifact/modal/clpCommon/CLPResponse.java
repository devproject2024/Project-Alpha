package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import com.google.gson.f;
import com.paytmmall.clpartifact.modal.grid.CJRDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CLPResponse extends CLPNetworkResponse {
    @c(a = "entity_identifier")
    private String entityIdentifier;
    @c(a = "alt_image_url")
    private Object mAltImageUrl;
    @c(a = "api_version")
    private Long mApiVersion;
    @c(a = "canonical_url")
    private String mCanonicalUrl;
    @c(a = "contextParams")
    private HashMap<String, String> mContextParams;
    @c(a = "datasources")
    private ArrayList<CJRDataSource> mDataSourceList = new ArrayList<>();
    @c(a = "entity_associated_with")
    private Long mEntityAssociatedWith;
    @c(a = "entity_type")
    private String mEntityType;
    @c(a = "footer_image_url")
    private String mFooterImageUrl;
    @c(a = "ga_category")
    private String mGaCategory;
    @c(a = "ga_key")
    private String mGaKey;
    @c(a = "has_more")
    private boolean mHasMore;
    @c(a = "image_url")
    private Object mImageUrl;
    @c(a = "layout")
    private Layout mLayout;
    @c(a = "long_rich_desc")
    private String mLongRichDesc;
    @c(a = "meta_description")
    private String mMetaDescription;
    @c(a = "meta_keyword")
    private String mMetaKeyword;
    @c(a = "meta_title")
    private String mMetaTitle;
    @c(a = "no_follow")
    private Boolean mNoFollow;
    @c(a = "no_index")
    private Boolean mNoIndex;
    @c(a = "page")
    private List<Page> mPage;
    @c(a = "page_id")
    private Long mPageId;
    @c(a = "page_name")
    private String mPageName;
    @c(a = "placeholder_image_url")
    private String mPlaceholderImageUrl;
    @c(a = "redirect")
    private Boolean mRedirect;
    @c(a = "redirect_url")
    private String mRedirectUrl;
    @c(a = "sub_api")
    private List<SubApi> mSubApi;
    @c(a = "totalViewCount")
    private Long mTotalViewCount;

    public String getEntityIdentifier() {
        return this.entityIdentifier;
    }

    public void setEntityIdentifier(String str) {
        this.entityIdentifier = str;
    }

    public Object getAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setAltImageUrl(Object obj) {
        this.mAltImageUrl = obj;
    }

    public Long getApiVersion() {
        return this.mApiVersion;
    }

    public void setApiVersion(Long l) {
        this.mApiVersion = l;
    }

    public String getCanonicalUrl() {
        return this.mCanonicalUrl;
    }

    public void setCanonicalUrl(String str) {
        this.mCanonicalUrl = str;
    }

    public HashMap<String, String> getContextParams() {
        return this.mContextParams;
    }

    public void setContextParams(HashMap<String, String> hashMap) {
        this.mContextParams = hashMap;
    }

    public Long getEntityAssociatedWith() {
        return this.mEntityAssociatedWith;
    }

    public void setEntityAssociatedWith(Long l) {
        this.mEntityAssociatedWith = l;
    }

    public String getEntityType() {
        return this.mEntityType;
    }

    public void setEntityType(String str) {
        this.mEntityType = str;
    }

    public String getFooterImageUrl() {
        return this.mFooterImageUrl;
    }

    public void setFooterImageUrl(String str) {
        this.mFooterImageUrl = str;
    }

    public String getGaCategory() {
        return this.mGaCategory;
    }

    public void setGaCategory(String str) {
        this.mGaCategory = str;
    }

    public String getGaKey() {
        return this.mGaKey;
    }

    public void setGaKey(String str) {
        this.mGaKey = str;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public Object getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(Object obj) {
        this.mImageUrl = obj;
    }

    public Layout getLayout() {
        return this.mLayout;
    }

    public void setLayout(Layout layout) {
        this.mLayout = layout;
    }

    public String getLongRichDesc() {
        return this.mLongRichDesc;
    }

    public void setLongRichDesc(String str) {
        this.mLongRichDesc = str;
    }

    public String getMetaDescription() {
        return this.mMetaDescription;
    }

    public void setMetaDescription(String str) {
        this.mMetaDescription = str;
    }

    public String getMetaKeyword() {
        return this.mMetaKeyword;
    }

    public void setMetaKeyword(String str) {
        this.mMetaKeyword = str;
    }

    public String getMetaTitle() {
        return this.mMetaTitle;
    }

    public void setMetaTitle(String str) {
        this.mMetaTitle = str;
    }

    public Boolean getNoFollow() {
        return this.mNoFollow;
    }

    public void setNoFollow(Boolean bool) {
        this.mNoFollow = bool;
    }

    public Boolean getNoIndex() {
        return this.mNoIndex;
    }

    public void setNoIndex(Boolean bool) {
        this.mNoIndex = bool;
    }

    public List<Page> getPage() {
        return this.mPage;
    }

    public void setPage(List<Page> list) {
        this.mPage = list;
    }

    public Long getPageId() {
        return this.mPageId;
    }

    public void setPageId(Long l) {
        this.mPageId = l;
    }

    public String getPageName() {
        return this.mPageName;
    }

    public void setPageName(String str) {
        this.mPageName = str;
    }

    public String getPlaceholderImageUrl() {
        return this.mPlaceholderImageUrl;
    }

    public void setPlaceholderImageUrl(String str) {
        this.mPlaceholderImageUrl = str;
    }

    public Boolean getRedirect() {
        return this.mRedirect;
    }

    public void setRedirect(Boolean bool) {
        this.mRedirect = bool;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    public List<SubApi> getSubApi() {
        return this.mSubApi;
    }

    public void setSubApi(List<SubApi> list) {
        this.mSubApi = list;
    }

    public Long getTotalViewCount() {
        return this.mTotalViewCount;
    }

    public void setTotalViewCount(Long l) {
        this.mTotalViewCount = l;
    }

    public boolean isMhasMore() {
        return this.mHasMore;
    }

    public void setMhasMore(boolean z) {
        this.mHasMore = z;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        f fVar = new f();
        return fVar.b(this).equals(fVar.b(obj));
    }

    public ArrayList<CJRDataSource> getDataSourceList() {
        return this.mDataSourceList;
    }

    public void setDataSourceList(ArrayList<CJRDataSource> arrayList) {
        this.mDataSourceList = arrayList;
    }
}
