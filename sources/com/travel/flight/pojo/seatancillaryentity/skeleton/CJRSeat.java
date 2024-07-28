package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeat extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "number")
    private final String number;
    @a
    @b(a = "type")
    private final String type;
    @a
    @b(a = "x")
    private final int x;
    @a
    @b(a = "y")
    private final int y;

    public CJRSeat(String str, int i2, int i3, String str2) {
        this.number = str;
        this.x = i2;
        this.y = i3;
        this.type = str2;
    }

    public String getNumber() {
        return this.number;
    }

    public Integer getX() {
        return Integer.valueOf(this.x);
    }

    public Integer getY() {
        return Integer.valueOf(this.y);
    }

    public String getType() {
        return this.type;
    }
}
