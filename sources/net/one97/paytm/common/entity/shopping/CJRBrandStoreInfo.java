package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrandStoreInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "display_tag")
    private String mBrandStoreDisplayTag;
    @b(a = "link")
    private String mBrandStoreLink;
    @b(a = "url_type")
    private String mBrandStoreURLType;

    public String getmBrandStoreLink() {
        return this.mBrandStoreLink;
    }

    public void setmBrandStoreLink(String str) {
        this.mBrandStoreLink = str;
    }

    public String getmBrandStoreURLType() {
        return this.mBrandStoreURLType;
    }

    public void setmBrandStoreURLType(String str) {
        this.mBrandStoreURLType = str;
    }

    public String getmBrandStoreDisplayTag() {
        return this.mBrandStoreDisplayTag;
    }

    public void setmBrandStoreDisplayTag(String str) {
        this.mBrandStoreDisplayTag = str;
    }
}
