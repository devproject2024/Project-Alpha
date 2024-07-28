package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusPassengerData implements IJRDataModel {
    @b(a = "age")
    private String age;
    @b(a = "email")
    private String email;
    @b(a = "mobile_number")
    private String mobileNumber;

    public String getEmail() {
        return this.email;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getAge() {
        return this.age;
    }
}
