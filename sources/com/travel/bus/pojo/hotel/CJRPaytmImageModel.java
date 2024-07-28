package com.travel.bus.pojo.hotel;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPaytmImageModel implements IJRDataModel {
    @c(a = "thumb")
    @a
    private List<String> thumb = null;

    public List<String> getThumb() {
        return this.thumb;
    }
}
