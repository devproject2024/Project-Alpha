package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemBoardDropCount implements IJRDataModel {
    @b(a = "count")
    private Integer count;

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }
}
