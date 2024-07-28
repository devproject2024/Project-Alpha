package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPDPMedia implements IJRDataModel {
    @b(a = "type")
    private String mediaType;
    @b(a = "thumbnail_url")
    private String thumbnailUrl;
    @b(a = "url")
    private String url;

    public String getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
