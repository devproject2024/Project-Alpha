package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainInfantInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "age")
    private String age;
    @b(a = "gender")
    private String gender;
    @b(a = "infantSerialNumber")
    private String infantSerialNumber;
    @b(a = "name")
    private String name;
    @b(a = "passengerCategory")
    private String passengerCategory;

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getPassengerCategory() {
        return this.passengerCategory;
    }

    public String getInfantSerialNumber() {
        return this.infantSerialNumber;
    }
}
