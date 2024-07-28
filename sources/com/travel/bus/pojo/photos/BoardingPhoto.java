package com.travel.bus.pojo.photos;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class BoardingPhoto implements IJRDataModel {
    @b(a = "default")
    private String _default;
    @b(a = "thumbnail")
    private String thumbnail;

    public String getDefault() {
        return this._default;
    }

    public void setDefault(String str) {
        this._default = str;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }
}
