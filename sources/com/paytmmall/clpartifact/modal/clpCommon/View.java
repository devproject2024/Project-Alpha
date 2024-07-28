package com.paytmmall.clpartifact.modal.clpCommon;

import android.text.TextUtils;
import androidx.databinding.a;
import com.google.gson.a.c;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class View extends a implements Serializable {
    public static final String KEY_ALL_SEOURL = "see_all_url";
    public static final String KEY_ALL_SEO_SEOURL = "see_all_seourl";
    public static final String KEY_ID = "id";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_LANDING_PAGE_META_FLAG = "landing_page_meta_flag";
    public static final String KEY_MANAGE_BY_ENGAGE = "manage_by_engage";
    public static final String KEY_MAX_ITEMS = "no_of_rows";
    public static final String KEY_PRIORITY = "priority";
    public static final String KEY_RATING_REVIEW = "review_rating";
    public static final String KEY_SEOURL = "seourl";
    public static final String KEY_SHOW_LESS_IMAGE_URL = "viewless_image";
    public static final String KEY_SHOW_LESS_TEXT = "viewless_label";
    public static final String KEY_SHOW_MORE_IMAGE_URL = "viewall_image";
    public static final String KEY_SHOW_MORE_TEXT = "viewall_label";
    public static final String KEY_START_TIME = "start_time";
    public static final String KEY_STORE_INFO = "store_info";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL_TYPE = "url_type";
    private static Map<String, Integer> MIN_ITEM_SIZE = new HashMap<String, Integer>() {
        {
            put(ViewHolderFactory.TYPE_BANNER_2XN, 1);
            put(ViewHolderFactory.TYPE_BANNER_3XN, 2);
        }
    };
    private String adRequestId;
    @c(a = "auto_scroll")
    private String auto_scroll;
    @c(a = "class")
    private String className;
    @c(a = "container_size")
    private String containerSize;
    @c(a = "datasources")
    private ArrayList<ViewDataSource> dataSources;
    @c(a = "dwell_time")
    private float dwellTime;
    @c(a = "end_time")
    private String endTime;
    private Map<String, Object> gaData;
    private String gaKey;
    @c(a = "grey_line_separator")
    private boolean greyLineSeperator;
    @c(a = "is_bg_active")
    private boolean isBGActive;
    private boolean isFollowedFeedOn = false;
    private boolean isGaAdded;
    private boolean isSmartHeaderV2;
    private boolean isViewDraw;
    private boolean isViewExpanded = false;
    @c(a = "item_images")
    private List<String> item_images;
    private int lastItemPosition = -1;
    @c(a = "layout")
    private ViewLayoutDetails layout;
    @c(a = "has_more")
    private String mHasMore;
    @c(a = "id")
    private Long mId;
    @c(a = "image_url")
    private String mImageUrl;
    @c(a = "items")
    public List<Item> mItems;
    @c(a = "landing_page_meta_flag")
    private Long mLandingPageMetaFlag;
    @c(a = "manage_by_engage")
    private Long mManageByEngage;
    @c(a = "meta_layout")
    private MetaLayout mMetaLayout;
    @c(a = "priority")
    private Long mPriority;
    @c(a = "see_all_seourl")
    private String mSeeAllSeoUrl;
    @c(a = "see_all_url")
    private String mSeeAllUrl;
    @c(a = "seourl")
    private String mSeourl;
    @c(a = "start_time")
    private String mStartTime;
    @c(a = "subtitle")
    private String mSubtitle;
    @c(a = "title")
    private String mTitle;
    @c(a = "type")
    private String mType;
    private View mView;
    @c(a = "viewItems")
    private List<Item> mViewItems;
    @c(a = "view_tag")
    private String mViewTag;
    protected TreeMap<Integer, List<Item>> mWalletStripMap = new TreeMap<>();
    @c(a = "no_of_rows")
    private int max_row_shown;
    @c(a = "review_rating")
    private CJRRatingReview ratingReview;
    private boolean showProductPrice = true;
    @c(a = "viewless_image")
    private String show_less_image_url;
    @c(a = "viewless_label")
    private String show_less_label;
    @c(a = "viewall_image")
    private String show_more_image_url;
    @c(a = "viewall_label")
    private String show_more_label;
    @c(a = "store_info")
    private CJRStoreInfo storeInfo;
    private String storefrontId;
    @c(a = "url_type")
    private String urlType;

    public String getmViewTag() {
        return this.mViewTag;
    }

    public void setmViewTag(String str) {
        this.mViewTag = str;
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

    public boolean isBGActive() {
        return this.isBGActive;
    }

    public void setBGActive(boolean z) {
        this.isBGActive = z;
    }

    public List<String> getItem_images() {
        return this.item_images;
    }

    public void setStorefrontId(String str) {
        this.storefrontId = str;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public float getDwellTime() {
        return this.dwellTime;
    }

    public void setDwellTime(float f2) {
        this.dwellTime = f2;
    }

    public void setItem_images(List<String> list) {
        this.item_images = list;
    }

    public String getAuto_scroll() {
        return this.auto_scroll;
    }

    public void setAuto_scroll(String str) {
        this.auto_scroll = str;
    }

    public String getShow_more_image_url() {
        return this.show_more_image_url;
    }

    public void setShow_more_image_url(String str) {
        this.show_more_image_url = str;
    }

    public String getShow_less_image_url() {
        return this.show_less_image_url;
    }

    public void setShow_less_image_url(String str) {
        this.show_less_image_url = str;
    }

    public String getShow_more_label() {
        return this.show_more_label;
    }

    public void setShow_more_label(String str) {
        this.show_more_label = str;
    }

    public String getShow_less_label() {
        return this.show_less_label;
    }

    public void setShow_less_label(String str) {
        this.show_less_label = str;
    }

    public int getMax_items_shown() {
        return this.max_row_shown;
    }

    public void setMax_items_shown(int i2) {
        this.max_row_shown = i2;
    }

    public int getLastItemPosition() {
        return this.lastItemPosition;
    }

    public void setLastItemPosition(int i2) {
        this.lastItemPosition = i2;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public boolean isFollowedFeedOn() {
        return this.isFollowedFeedOn;
    }

    public void setFollowedFeedOn(boolean z) {
        this.isFollowedFeedOn = z;
    }

    public boolean isShowProductPrice() {
        return this.showProductPrice;
    }

    public void setShowProductPrice(boolean z) {
        this.showProductPrice = z;
    }

    public View() {
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public View(String str) {
        this.mType = str;
    }

    public boolean isGaAdded() {
        return this.isGaAdded;
    }

    public void setGaAdded(boolean z) {
        this.isGaAdded = z;
    }

    public ArrayList<ViewDataSource> getDataSources() {
        return this.dataSources;
    }

    public void setDataSources(ArrayList<ViewDataSource> arrayList) {
        this.dataSources = arrayList;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public void setUrlType(String str) {
        this.urlType = str;
    }

    public String getmSeeAllSeoUrl() {
        return this.mSeeAllSeoUrl;
    }

    public void setmSeeAllSeoUrl(String str) {
        this.mSeeAllSeoUrl = str;
    }

    public String getmSeeAllUrl() {
        return this.mSeeAllUrl;
    }

    public void setmSeeAllUrl(String str) {
        this.mSeeAllUrl = str;
    }

    public CJRRatingReview getRatingReview() {
        return this.ratingReview;
    }

    public void setRatingReview(CJRRatingReview cJRRatingReview) {
        this.ratingReview = cJRRatingReview;
    }

    public CJRStoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    public void setStoreInfo(CJRStoreInfo cJRStoreInfo) {
        this.storeInfo = cJRStoreInfo;
    }

    public Long getId() {
        return this.mId;
    }

    public void setId(Long l) {
        this.mId = l;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public void setItems(List<Item> list) {
        this.mItems = list;
    }

    public View getmView() {
        return this.mView;
    }

    public void setmView(View view) {
        this.mView = view;
    }

    public List<Item> getmViewItems() {
        return this.mViewItems;
    }

    public void setmViewItems(List<Item> list) {
        this.mViewItems = list;
    }

    public MetaLayout getmMetaLayout() {
        return this.mMetaLayout;
    }

    public Long getLandingPageMetaFlag() {
        return this.mLandingPageMetaFlag;
    }

    public void setLandingPageMetaFlag(Long l) {
        this.mLandingPageMetaFlag = l;
    }

    public Long getManageByEngage() {
        return this.mManageByEngage;
    }

    public void setManageByEngage(Long l) {
        this.mManageByEngage = l;
    }

    public Long getPriority() {
        return this.mPriority;
    }

    public void setPriority(Long l) {
        this.mPriority = l;
    }

    public String getSeourl() {
        return this.mSeourl;
    }

    public void setSeourl(String str) {
        this.mSeourl = str;
    }

    public String getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(String str) {
        this.mStartTime = str;
    }

    public String getSubtitle() {
        return this.mSubtitle;
    }

    public void setSubtitle(String str) {
        this.mSubtitle = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
        notifyPropertyChanged(BR.title);
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
        notifyChange();
    }

    public int getMinItemSize(String str) {
        Map<String, Integer> map = MIN_ITEM_SIZE;
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        return MIN_ITEM_SIZE.get(str).intValue();
    }

    public TreeMap<Integer, List<Item>> getSmartItems() {
        return this.mWalletStripMap;
    }

    public void setSmartItems(TreeMap<Integer, List<Item>> treeMap) {
        this.mWalletStripMap = treeMap;
    }

    public ViewLayoutDetails getLayout() {
        return this.layout;
    }

    public void setLayout(ViewLayoutDetails viewLayoutDetails) {
        this.layout = viewLayoutDetails;
    }

    public Map<String, Object> getGaData() {
        return this.gaData;
    }

    public void setGaData(Map<String, Object> map) {
        this.gaData = map;
    }

    public void setItemData() {
        List<Item> list = this.mItems;
        if (list != null) {
            traverseChildItems(list);
        }
        List<Item> list2 = this.mViewItems;
        if (list2 != null) {
            traverseChildItems(list2);
        }
        View view = this.mView;
        if (view != null) {
            view.setPageParams(this.adRequestId, this.storefrontId);
            this.mView.setGaKey(this.gaKey);
            this.mView.setItemData();
        }
    }

    private void traverseChildItems(List<Item> list) {
        String type = getType();
        String className2 = getClassName();
        String imageUrl = getImageUrl();
        String title = getTitle();
        for (Item next : list) {
            if (next != null) {
                next.setParentType(type);
                next.setmClassName(className2);
                next.setParentImageUrl(imageUrl);
                next.setParentTitle(title);
                ArrayList<ViewDataSource> arrayList = this.dataSources;
                if (!(arrayList == null || arrayList.size() <= 0 || this.dataSources.get(0) == null)) {
                    next.setContainerinstatnceid(this.dataSources.get(0).getContainerInstanceId());
                }
                next.setParentId(String.valueOf(getId()));
                next.setStorefrontId(this.storefrontId);
                next.setAdRequestId(this.adRequestId);
                next.setContainerSize(this.containerSize);
                next.setItemListSize(list.size());
                next.setViewTag(getmViewTag());
            }
        }
    }

    public boolean isViewExpanded() {
        return this.isViewExpanded;
    }

    public void setExpanded(boolean z) {
        this.isViewExpanded = z;
    }

    public boolean isSmartHeaderV2() {
        return this.isSmartHeaderV2;
    }

    public void setSmartHeaderV2(boolean z) {
        this.isSmartHeaderV2 = z;
    }

    public boolean equals(Object obj) {
        if (obj instanceof View) {
            if (!this.isSmartHeaderV2) {
                View view = (View) obj;
                if (!getType().equals(view.getType()) || !getId().equals(view.getId())) {
                    return false;
                }
                return true;
            } else if (getmView() != null && !TextUtils.isEmpty(getmView().getType())) {
                View view2 = (View) obj;
                if (!getmView().getType().equals(view2.getType()) || !getmView().getId().equals(view2.getId())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void setPageParams(String str, String str2) {
        this.storefrontId = str;
        this.adRequestId = str2;
    }
}
