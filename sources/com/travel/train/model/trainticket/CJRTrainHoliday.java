package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainHoliday extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "date")
    private String date;
    @a
    @b(a = "id")
    private String id;
    @a
    @b(a = "name")
    private String name;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }
}
