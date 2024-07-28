package net.one97.paytm.common.entity.shopping;

import android.text.TextUtils;
import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHomePageLayoutV2 extends CJRItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String affiliateID;
    private CJRHomePageLayoutV2 browseCategory;
    private boolean dataFromCache;
    @b(a = "datasources")
    private ArrayList<CJRDataSource> datasources = new ArrayList<>();
    private String deeplink;
    @b(a = "display_fields")
    private ArrayList<String> displayParams = new ArrayList<>();
    private String gaKey;
    private ArrayList<CJRHomePageLayoutV2> homeChildren;
    @a
    private boolean isAnotherMidPresent;
    private boolean isBlue;
    private boolean isBorderVisible = true;
    @a
    private boolean isDataAbsent;
    @a
    private boolean isFromHome;
    private boolean isLast;
    private boolean isSellerStoreImpressionSent;
    private String itempos = "";
    @b(a = "class")
    private String mClassName;
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
    private ArrayList<IJRDataModel> mRecentPaymentList;
    @b(a = "see_all_url")
    private String mSeeAllUrl;
    @b(a = "seourl")
    private String mSeoUrl;
    @b(a = "subtitle")
    private String mSubtitle;
    private int mWidgetPosition;
    @b(a = "no_of_rows")
    private int max_row_shown;
    @b(a = "display_metadata")
    private Displaymetadata mdisplaymetadata;
    @a
    private String price;
    private String qrCode;
    @b(a = "viewless_image")
    private String show_less_image_url;
    @b(a = "viewless_label")
    private String show_less_label;
    @b(a = "viewall_image")
    private String show_more_image_url;
    @b(a = "viewall_label")
    private String show_more_label;
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

    public boolean getDataFromCache() {
        return this.dataFromCache;
    }

    public void setDataFromCache(boolean z) {
        this.dataFromCache = z;
    }

    public String getItempos() {
        return this.itempos;
    }

    public void setItempos(String str) {
        this.itempos = str;
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

    public Displaymetadata getDisplaymetadata() {
        return this.mdisplaymetadata;
    }

    public void setDisplaymetadata(Displaymetadata displaymetadata) {
        this.mdisplaymetadata = displaymetadata;
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

    public ArrayList<IJRDataModel> getRecentPaymentList() {
        return this.mRecentPaymentList;
    }

    public void setRecentPaymentList(ArrayList<IJRDataModel> arrayList) {
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

    public ArrayList<CJRHomePageLayoutV2> getHomeChildren() {
        return this.homeChildren;
    }

    public void setHomeChildren(ArrayList<CJRHomePageLayoutV2> arrayList) {
        this.homeChildren = arrayList;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getPrimePrince() {
        return this.price;
    }

    public boolean getIsFromHome() {
        return this.isFromHome;
    }

    public void setIsFromHome(boolean z) {
        this.isFromHome = z;
    }

    public boolean isDataAbsent() {
        return this.isDataAbsent;
    }

    public void setDataAbsent(boolean z) {
        this.isDataAbsent = z;
    }

    public String getmClassName() {
        return this.mClassName;
    }

    public void setmClassName(String str) {
        this.mClassName = str;
    }

    public class Displaymetadata implements IJRDataModel {
        @b(a = "created_at")
        private String created_at;
        @b(a = "id")
        private String id;
        @b(a = "image2_url")
        private String image2_url;
        @b(a = "image_url")
        private String image_url;
        @b(a = "metadata")
        private Metadata mmetadata;
        @b(a = "video_url")
        private String video_url;

        public Displaymetadata() {
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

        public Metadata getMmetadata() {
            return this.mmetadata;
        }

        public void setMmetadata(Metadata metadata) {
            this.mmetadata = metadata;
        }

        public class Metadata implements IJRDataModel {
            @b(a = "click_pixel_url")
            private String click_pixel_url;
            @b(a = "impression_pixel1")
            private String impression_pixel1;
            @b(a = "impression_pixel2")
            private String impression_pixel2;
            @b(a = "impression_pixel3")
            private String impression_pixel3;
            @b(a = "impression_pixel_url")
            private String impression_pixel_url;
            @b(a = "javascript_resource_url")
            private String javascript_resource_url;
            @b(a = "vendor_key")
            private String vendor_key;
            @b(a = "verification_parameters")
            private String verification_parameters;

            public Metadata() {
            }

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

            public String getImpression_pixel2() {
                return this.impression_pixel2;
            }

            public String getImpression_pixel3() {
                return this.impression_pixel3;
            }
        }
    }
}
