package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFilterMinMaxItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "max")
    private Object mMax;
    @b(a = "min")
    private Object mMin;

    public Object getmMin() {
        return this.mMin;
    }

    public void setmMin(Object obj) {
        this.mMin = obj;
    }

    public Object getmMax() {
        return this.mMax;
    }

    public void setmMax(Object obj) {
        this.mMax = obj;
    }
}
