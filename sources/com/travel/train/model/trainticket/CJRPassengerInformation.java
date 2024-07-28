package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPassengerInformation extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "passenger_age")
    private String mPassengerAge;
    @b(a = "passenger_gender")
    private String mPassengerGender;

    public String getPassengerGender() {
        return this.mPassengerGender;
    }

    public String getPassengerAge() {
        return this.mPassengerAge;
    }
}
