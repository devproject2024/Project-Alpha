package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieGalleryData implements IJRDataModel {
    @c(a = "type")
    private String type;
    @c(a = "url")
    private String url;
    @c(a = "url2")
    private String url2;

    public String getUrl() {
        return this.url;
    }

    public String getUrl2() {
        return this.url2;
    }

    public String getType() {
        return this.type;
    }
}
