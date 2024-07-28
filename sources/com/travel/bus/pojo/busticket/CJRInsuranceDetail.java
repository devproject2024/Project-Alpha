package com.travel.bus.pojo.busticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsuranceDetail implements IJRDataModel {
    private int id;

    public CJRInsuranceDetail(int i2) {
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }
}
