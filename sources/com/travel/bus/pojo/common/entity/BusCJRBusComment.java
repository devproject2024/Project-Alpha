package com.travel.bus.pojo.common.entity;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class BusCJRBusComment implements IJRDataModel {
    @b(a = "age")
    private int age;
    @b(a = "comment_edited")
    private String comment;
    @b(a = "name")
    private String commenterName;
    @b(a = "gender")
    private String gender;
    @b(a = "travel_date")
    private String travelDate;

    public String getTravelDate() {
        return this.travelDate;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getCommenterName() {
        return this.commenterName;
    }

    public String getComment() {
        return this.comment;
    }
}
