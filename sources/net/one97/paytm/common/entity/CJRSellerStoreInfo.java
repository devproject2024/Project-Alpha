package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRSellerStoreInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "link")
    private String sellerStoreLink;
    @b(a = "url_type")
    private String urlType;

    public String getSellerStoreLink() {
        return this.sellerStoreLink;
    }

    public String getUrlType() {
        return this.urlType;
    }
}
