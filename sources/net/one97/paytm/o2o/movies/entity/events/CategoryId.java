package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;

public final class CategoryId {
    @c(a = "icon_img")
    private String iconImg;
    @c(a = "_id")
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

    public final String getIconImg() {
        return this.iconImg;
    }

    public final void setIconImg(String str) {
        this.iconImg = str;
    }
}
