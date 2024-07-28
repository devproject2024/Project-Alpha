package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatImages extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "disabled_seat")
    private String disabledSeat;
    @a
    @b(a = "double_arrow")
    private String doubleArrow;
    @a
    @b(a = "left_arrow")
    private String leftArrow;
    @a
    @b(a = "right_arrow")
    private String rightArrow;

    public String getDoubleArrow() {
        return this.doubleArrow;
    }

    public void setDoubleArrow(String str) {
        this.doubleArrow = str;
    }

    public String getLeftArrow() {
        return this.leftArrow;
    }

    public void setLeftArrow(String str) {
        this.leftArrow = str;
    }

    public String getRightArrow() {
        return this.rightArrow;
    }

    public void setRightArrow(String str) {
        this.rightArrow = str;
    }

    public String getDisabledSeat() {
        return this.disabledSeat;
    }

    public void setDisabledSeat(String str) {
        this.disabledSeat = str;
    }
}
