package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRStatusMeta implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "berths")
    private HashMap<String, String> mBerths;
    @b(a = "booking_status")
    private HashMap<String, String> mBookingStatusMap;
    @b(a = "classes")
    private HashMap<String, String> mClasses;

    public HashMap<String, String> getmBerths() {
        return this.mBerths;
    }

    public HashMap<String, String> getmClasses() {
        return this.mClasses;
    }

    public HashMap<String, String> getBookingStatusMap() {
        return this.mBookingStatusMap;
    }
}
