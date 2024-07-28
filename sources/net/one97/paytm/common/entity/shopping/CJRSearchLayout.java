package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSearchLayout extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "isPaytm")
    private Boolean isPaytm;
    @b(a = "apiUrl")
    private String mAPIUrl;
    @b(a = "meta")
    private HashMap<String, String> mAutoSearchMetaData;
    @b(a = "count")
    public String mCount;
    @b(a = "filter_attributes")
    private HashMap<String, String> mFilterAttributes;
    @b(a = "image_url")
    public String mImageUrl;
    @b(a = "price")
    public String mPrice;
    @b(a = "cats")
    private ArrayList<CJRSearchPageItem> mSearchPageItemList = new ArrayList<>();
    @b(a = "seourl")
    public String mSeourl;
    @b(a = "text")
    private String mText;
    @b(a = "html_text")
    private String mTextHtml;
    @b(a = "curation")
    private CJRSearchCuration searchCuration;

    public String getName() {
        return null;
    }

    public String getmTextHtml() {
        return this.mTextHtml;
    }

    public String getText() {
        return this.mText;
    }

    public ArrayList<CJRSearchPageItem> getSearchPageItemList() {
        return this.mSearchPageItemList;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getSeourl() {
        return this.mSeourl;
    }

    public String getCount() {
        return this.mCount;
    }

    public String getPrice() {
        String str = this.mPrice;
        if (str != null && !str.contains("Rs")) {
            this.mPrice = "Rs " + this.mPrice;
        }
        return this.mPrice;
    }

    public HashMap<String, String> getmAutoSearchMetaData() {
        return this.mAutoSearchMetaData;
    }

    public void setmAutoSearchMetaData(HashMap<String, String> hashMap) {
        this.mAutoSearchMetaData = hashMap;
    }

    public HashMap<String, String> getmFilterAttributes() {
        return this.mFilterAttributes;
    }

    public void setmFilterAttributes(HashMap<String, String> hashMap) {
        this.mFilterAttributes = hashMap;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public CJRSearchCuration getSearchCuration() {
        return this.searchCuration;
    }

    public void setSearchCuration(CJRSearchCuration cJRSearchCuration) {
        this.searchCuration = cJRSearchCuration;
    }

    public String getAPIUrl() {
        return this.mAPIUrl;
    }

    public void setAPIUrl(String str) {
        this.mAPIUrl = str;
    }

    public Boolean isPaytm() {
        return this.isPaytm;
    }

    public void setPaytm(Boolean bool) {
        this.isPaytm = bool;
    }
}
