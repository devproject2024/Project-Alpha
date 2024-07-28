package com.paytmmall.artifact.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;

public class CJRHomePageV2 extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "alt_image_url")
    private String alt_image_url;
    @b(a = "api_version")
    private String apiVersion;
    @b(a = "name")
    private String banner_name;
    @b(a = "contextParams")
    private HashMap<String, String> contextParam;
    @b(a = "description")
    private String description;
    private String entityAssociatedWith;
    @b(a = "image_url")
    private String image_url;
    public boolean isOrderDetailsExpanded;
    @b(a = "entity_type")
    private String mEntity;
    @b(a = "entity_associated_with")
    private long mEntityAssociatedWith;
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "footer_image_url")
    private String mFooterImage;
    @b(a = "ga_key")
    public String mGAKey;
    private String mGATitle;
    @b(a = "page_id")
    private String mID = "";
    @b(a = "old_category_id")
    private String mOldCategoryId;
    @b(a = "placeholder_image_url")
    public String mPlaceHolderImageUrl;
    @b(a = "page_name")
    private String pageName;
    @b(a = "url_key")
    private String urlKey;

    public String getName() {
        return null;
    }

    public HashMap<String, String> getContextParam() {
        return this.contextParam;
    }

    public long getEntityId() {
        return this.mEntityAssociatedWith;
    }

    public String getEntity() {
        return this.mEntity;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getOldCategoryId() {
        return this.mOldCategoryId;
    }

    public String getID() {
        return this.mID;
    }

    public String getGAKey() {
        return this.mGAKey;
    }

    public String getFooterImage() {
        return this.mFooterImage;
    }

    public void setFooterImageUrl(String str) {
        this.mFooterImage = str;
    }

    public String getPlaceHolderImageUrl() {
        return this.mPlaceHolderImageUrl;
    }

    public String getGATitle() {
        return this.mGATitle;
    }

    public void setGATitle(String str) {
        this.mGATitle = str;
    }

    public String getEntityAssociatedWith() {
        return this.mID;
    }

    public void setEntityAssociatedWith(String str) {
        this.entityAssociatedWith = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getUrlKey() {
        return this.urlKey;
    }

    public String getAlt_image_url() {
        return this.alt_image_url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getBannerName() {
        return this.banner_name;
    }

    public boolean isOrderDetailsExpanded() {
        return this.isOrderDetailsExpanded;
    }

    public void setIsOrderDetailsExpanded(boolean z) {
        this.isOrderDetailsExpanded = z;
    }

    public String getPageName() {
        return this.pageName;
    }
}
