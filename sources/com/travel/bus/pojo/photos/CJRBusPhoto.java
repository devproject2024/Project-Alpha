package com.travel.bus.pojo.photos;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusPhoto implements IJRDataModel {
    @b(a = "photo")
    private String photo;
    @b(a = "thumbnail")
    private String thumbnail;

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public void setPhoto(String str) {
        this.photo = str;
    }
}
