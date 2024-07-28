package net.one97.paytm.common.entity.trainticket;

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

    public void setmId(int i2) {
        this.mId = i2;
    }

    public int getmPriority() {
        return this.mPriority;
    }

    public void setmPriority(int i2) {
        this.mPriority = i2;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmAltImageUrl() {
        return this.mAltImageUrl;
    }

    public void setmAltImageUrl(String str) {
        this.mAltImageUrl = str;
    }

    public String getmUrlInfo() {
        return this.mUrlInfo;
    }

    public void setmUrlInfo(String str) {
        this.mUrlInfo = str;
    }

    public String getmUrlType() {
        return this.mUrlType;
    }

    public void setmUrlType(String str) {
        this.mUrlType = str;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public String getmDelete_url() {
        return this.mDelete_url;
    }

    public void setmDelete_url(String str) {
        this.mDelete_url = str;
    }

    public String getMurl_key() {
        return this.murl_key;
    }

    public void setMurl_key(String str) {
        this.murl_key = str;
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

    public void setTnc(List<String> list) {
        this.tnc = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
