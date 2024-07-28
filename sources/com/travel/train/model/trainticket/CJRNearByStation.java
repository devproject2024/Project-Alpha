package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNearByStation extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "d1")
    private String d1;
    @a
    @b(a = "d2")
    private String d2;
    @a
    @b(a = "data")
    private String data;
    @a
    @b(a = "dest_city")
    private String destCity;
    @a
    @b(a = "dest_code")
    private String destCode;
    @a
    @b(a = "dest_name")
    private String destName;
    @a
    @b(a = "src_city")
    private String srcCity;
    @a
    @b(a = "src_code")
    private String srcCode;
    @a
    @b(a = "src_name")
    private String srcName;

    public String getData() {
        return this.data;
    }

    public String getSrcCode() {
        return this.srcCode;
    }

    public String getDestCode() {
        return this.destCode;
    }

    public String getSrcName() {
        return this.srcName;
    }

    public String getDestName() {
        return this.destName;
    }

    public String getSrcCity() {
        return this.srcCity;
    }

    public String getDestCity() {
        return this.destCity;
    }

    public String getD1() {
        return this.d1;
    }

    public String getD2() {
        return this.d2;
    }
}
