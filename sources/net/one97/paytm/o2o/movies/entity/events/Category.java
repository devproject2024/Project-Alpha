package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;

public final class Category {
    @c(a = "eventCount")
    private Integer eventCount;
    @c(a = "h5url")
    private String h5url;
    @c(a = "icon")
    private String icon;
    @c(a = "id")
    private String id;
    @c(a = "name")
    private String name;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final Integer getEventCount() {
        return this.eventCount;
    }

    public final void setEventCount(Integer num) {
        this.eventCount = num;
    }

    public final String getH5url() {
        return this.h5url;
    }

    public final void setH5url(String str) {
        this.h5url = str;
    }
}
