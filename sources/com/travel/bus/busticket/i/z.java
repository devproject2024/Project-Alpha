package com.travel.bus.busticket.i;

import android.text.TextUtils;
import com.travel.bus.a;

public final class z {
    public static String a() {
        a.a();
        String p = a.b().p();
        return (p == null || TextUtils.isEmpty(p)) ? "http://travel.paytm.com/api/trains/v1/holidays" : p;
    }
}
