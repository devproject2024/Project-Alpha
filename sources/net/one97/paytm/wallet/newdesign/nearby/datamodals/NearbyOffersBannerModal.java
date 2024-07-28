package net.one97.paytm.wallet.newdesign.nearby.datamodals;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class NearbyOffersBannerModal extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "alt_image_url")
    private Object altImageUrl;
    @c(a = "ancestors")
    private ArrayList<Object> ancestors = new ArrayList<>();
    @c(a = "display_name")
    private String displayName;
    @c(a = "entity_associated_with")
    private Integer entityAssociatedWith;
    @c(a = "entity_type")
    private String entityType;
    @c(a = "footer_image_url")
    private String footerImageUrl;
    @c(a = "ga_key")
    private String gaKey;
    @c(a = "homepage_layout")
    private ArrayList<HomepageLayout> homepage_layout = new ArrayList<>();
    @c(a = "id")
    private Integer id;
    @c(a = "image_url")
    private Object image_url;
    @c(a = "long_rich_desc")
    private String longRichDesc;
    @c(a = "meta_description")
    private String metaDescription;
    @c(a = "meta_keyword")
    private String metaKeyword;
    @c(a = "meta_title")
    private String metaTitle;
    @c(a = "mobile_layout")
    private ArrayList<Object> mobileLayout = new ArrayList<>();
    @c(a = "old_category_id")
    private Object oldCategoryId;
    @c(a = "placeholder_image_url")
    private String placeholderImageUrl;
    @c(a = "storeName")
    private String storeName;
    @c(a = "url_key")
    private String urlKey;

    public ArrayList<HomepageLayout> getHomepageLayout() {
        return this.homepage_layout;
    }

    public void setHomepageLayout(ArrayList<HomepageLayout> arrayList) {
        this.homepage_layout = arrayList;
    }

    public Object getImageUrl() {
        return this.image_url;
    }

    public void setImageUrl(Object obj) {
        this.image_url = obj;
    }

    public Object getAltImageUrl() {
        return this.altImageUrl;
    }

    public void setAltImageUrl(Object obj) {
        this.altImageUrl = obj;
    }

    public String getUrlKey() {
        return this.urlKey;
    }

    public void setUrlKey(String str) {
        this.urlKey = str;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public void setMetaDescription(String str) {
        this.metaDescription = str;
    }

    public String getMetaKeyword() {
        return this.metaKeyword;
    }

    public void setMetaKeyword(String str) {
        this.metaKeyword = str;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public void setMetaTitle(String str) {
        this.metaTitle = str;
    }

    public Integer getEntityAssociatedWith() {
        return this.entityAssociatedWith;
    }

    public void setEntityAssociatedWith(Integer num) {
        this.entityAssociatedWith = num;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String str) {
        this.entityType = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public Object getOldCategoryId() {
        return this.oldCategoryId;
    }

    public void setOldCategoryId(Object obj) {
        this.oldCategoryId = obj;
    }

    public String getPlaceholderImageUrl() {
        return this.placeholderImageUrl;
    }

    public void setPlaceholderImageUrl(String str) {
        this.placeholderImageUrl = str;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String str) {
        this.storeName = str;
    }

    public String getLongRichDesc() {
        return this.longRichDesc;
    }

    public void setLongRichDesc(String str) {
        this.longRichDesc = str;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public ArrayList<Object> getMobileLayout() {
        return this.mobileLayout;
    }

    public void setMobileLayout(ArrayList<Object> arrayList) {
        this.mobileLayout = arrayList;
    }

    public String getFooterImageUrl() {
        return this.footerImageUrl;
    }

    public void setFooterImageUrl(String str) {
        this.footerImageUrl = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public ArrayList<Object> getAncestors() {
        return this.ancestors;
    }

    public void setAncestors(ArrayList<Object> arrayList) {
        this.ancestors = arrayList;
    }

    public class HomepageLayout {
        @c(a = "id")
        private Integer id;
        @c(a = "items")
        private ArrayList<Item> items = new ArrayList<>();
        @c(a = "layout")
        private String layout;
        @c(a = "name")
        private String name;
        @c(a = "priority")
        private Integer priority;
        @c(a = "status")
        private Integer status;

        public HomepageLayout() {
        }

        public String getLayout() {
            return this.layout;
        }

        public void setLayout(String str) {
            this.layout = str;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer num) {
            this.id = num;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public Integer getPriority() {
            return this.priority;
        }

        public void setPriority(Integer num) {
            this.priority = num;
        }

        public Integer getStatus() {
            return this.status;
        }

        public void setStatus(Integer num) {
            this.status = num;
        }

        public ArrayList<Item> getItems() {
            return this.items;
        }

        public void setItems(ArrayList<Item> arrayList) {
            this.items = arrayList;
        }
    }

    public class Item extends CJRItem {
        @c(a = "alt_image_url")
        private Object altImageUrl;
        @c(a = "id")
        private Integer id;
        @c(a = "image_url")
        private String image_url;
        @c(a = "name")
        private String name;
        @c(a = "priority")
        private Integer priority;
        @c(a = "seourl")
        private String seourl;
        @c(a = "status")
        private Integer status;
        @c(a = "subtitle")
        private String subtitle;
        @c(a = "title")
        private String title;
        @c(a = "url")
        private String url;
        @c(a = "url_info")
        private String urlInfo;
        @c(a = "url_type")
        private String url_type;

        public String getBrand() {
            return null;
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

        public String getListId() {
            return null;
        }

        public String getListName() {
            return null;
        }

        public int getListPosition() {
            return 0;
        }

        public String getParentID() {
            return null;
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

        public String getmContainerInstanceID() {
            return null;
        }

        public Item() {
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer num) {
            this.id = num;
        }

        public Integer getPriority() {
            return this.priority;
        }

        public void setPriority(Integer num) {
            this.priority = num;
        }

        public String getURLType() {
            return getUrlType();
        }

        public String getURL() {
            return getUrl();
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getSubtitle() {
            return this.subtitle;
        }

        public void setSubtitle(String str) {
            this.subtitle = str;
        }

        public String getImageUrl() {
            return this.image_url;
        }

        public void setImageUrl(String str) {
            this.image_url = str;
        }

        public Object getAltImageUrl() {
            return this.altImageUrl;
        }

        public void setAltImageUrl(Object obj) {
            this.altImageUrl = obj;
        }

        public String getUrlInfo() {
            return this.urlInfo;
        }

        public void setUrlInfo(String str) {
            this.urlInfo = str;
        }

        public String getUrlType() {
            return this.url_type;
        }

        public void setUrlType(String str) {
            this.url_type = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public Integer getStatus() {
            return this.status;
        }

        public void setStatus(Integer num) {
            this.status = num;
        }

        public String getSeourl() {
            return this.seourl;
        }

        public void setSeourl(String str) {
            this.seourl = str;
        }
    }
}
