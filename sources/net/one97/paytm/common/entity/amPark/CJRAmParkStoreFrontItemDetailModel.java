package net.one97.paytm.common.entity.amPark;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class CJRAmParkStoreFrontItemDetailModel extends CJRItem {
    private static final long serialVersionUID = 1;
    private boolean isVisited;
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
    @b(a = "subtitle")
    private String mSubTitle;
    @b(a = "title")
    private String mTitle;
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

    public String getBrand() {
        return "";
    }

    public String getCategoryId() {
        return "";
    }

    public String getLabel() {
        return "";
    }

    public String getListId() {
        return "";
    }

    public String getListName() {
        return "";
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
        return "";
    }

    public String getSearchResultType() {
        return "";
    }

    public String getSearchTerm() {
        return "";
    }

    public String getSearchType() {
        return "";
    }

    public String getSource() {
        return null;
    }

    public String getmContainerInstanceID() {
        return "";
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i2) {
        this.mPriority = i2;
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
        try {
            String num = Integer.toString(getId());
            if (!TextUtils.isEmpty(num)) {
                return num;
            }
            return "";
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setAltImageUrl(String str) {
        this.mAltImageUrl = str;
    }

    public String getUrlInfo() {
        return this.mUrlInfo;
    }

    public void setUrlInfo(String str) {
        this.mUrlInfo = str;
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getDelete_url() {
        return this.mDelete_url;
    }

    public void setDelete_url(String str) {
        this.mDelete_url = str;
    }

    public String getUrl_key() {
        return this.murl_key;
    }

    public void setUrl_key(String str) {
        this.murl_key = str;
    }

    public String getSeourl() {
        return this.mseourl;
    }

    public void setSeourl(String str) {
        this.mseourl = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public void setVisited(boolean z) {
        this.isVisited = z;
    }
}
