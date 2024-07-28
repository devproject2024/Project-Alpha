package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;

public final class DigitalEvent {
    @c(a = "h5url")
    private String h5url;
    @c(a = "tag_id")
    private String tagId;
    @c(a = "thumbnail_url")
    private String thumbnailUrl;
    @c(a = "title")
    private String title;
    @c(a = "url")
    private String url;

    public final String getTagId() {
        return this.tagId;
    }

    public final void setTagId(String str) {
        this.tagId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public final String getH5url() {
        return this.h5url;
    }

    public final void setH5url(String str) {
        this.h5url = str;
    }
}
