package com.travel.bus.pojo.photos;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusPhotoWrapper implements IJRDataModel {
    @b(a = "app")
    private CJRBusPhoto app;

    public CJRBusPhoto getApp() {
        return this.app;
    }
}
