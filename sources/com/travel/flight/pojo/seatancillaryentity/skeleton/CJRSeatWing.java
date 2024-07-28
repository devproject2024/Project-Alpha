package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatWing extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "height")
    private Integer height;
    @a
    @b(a = "x")
    private Integer x;
    @a
    @b(a = "y")
    private Integer y;

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer num) {
        this.x = num;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer num) {
        this.y = num;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }
}
