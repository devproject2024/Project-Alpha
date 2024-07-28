package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRCouponHeaderItem extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "name")
    private String mName;
    @b(a = "url")
    private String mUrl;
    @b(a = "url_type")
    private String mUrlType;

    public String getName() {
        return this.mName;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getUrlType() {
        return this.mUrlType;
    }
}
