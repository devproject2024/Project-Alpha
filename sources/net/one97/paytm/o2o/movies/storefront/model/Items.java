package net.one97.paytm.o2o.movies.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class Items extends IJRPaytmDataModel {
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "name")
    private String name;
    @b(a = "url")
    private String url;
    @b(a = "url_type")
    private String urlType;

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(String str) {
        this.urlType = str;
    }
}
