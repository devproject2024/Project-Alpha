package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class CJROfferItems extends CJRItem {
    private static final long serialVersionUID = 1;
    @b(a = "alt_image_url")
    private String mAltImageUrl;
    @b(a = "delete_url")
    private String mDelete_url;
    @b(a = "id")
    private int mId;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "name")
    private String mName;
    @b(a = "priority")
    private int mPriority;
    @b(a = "status")
    private String mStatus;
    @b(a = "url")
    private String mUrl;
    @b(a = "url_info")
    private String mUrlInfo;
    @b(a = "url_type")
    private String mUrlType;
    @b(a = "seourl")
    private String mseourl;
    @b(a = "url_key")
    private String murl_key;
    @b(a = "title")
    private String title;
    @b(a = "tnc")
    private List<String> tnc;

    public String getBrand() {
        return null;
    }

    public String getCategoryId() {
        return null;
    }

    public String getLabel() {
        return null;
    }

    public String getListId() {
        return "";
    }

    public String getListName() {
        return null;
    }

    public int getListPosition() {
        return 0;
    }

    public String getParentID() {
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

    public String getmContainerInstanceID() {
        return "";
    }

    public int getmId() {
        return this.mId;
    }

    public int getmPriority() {
        return this.mPriority;
    }

    public String getmName() {
        return this.mName;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public String getmAltImageUrl() {
        return this.mAltImageUrl;
    }

    public String getmUrlInfo() {
        return this.mUrlInfo;
    }

    public String getmUrlType() {
        return this.mUrlType;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public String getmDelete_url() {
        return this.mDelete_url;
    }

    public String getMurl_key() {
        return this.murl_key;
    }

    public String getURLType() {
        return this.mUrlType;
    }

    public String getURL() {
        return this.mUrl;
    }

    public String getName() {
        return this.mName;
    }

    public String getItemID() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mId);
        return sb.toString();
    }

    public List<String> getTnc() {
        return this.tnc;
    }

    public String getTitle() {
        return this.title;
    }
}
