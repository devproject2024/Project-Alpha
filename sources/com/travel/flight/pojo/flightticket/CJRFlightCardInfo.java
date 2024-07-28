package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightCardInfo implements IJRDataModel {
    @a(a = false, b = false)
    private int listItemPos;
    @b(a = "flights_length")
    private int mFlightLength;
    @b(a = "id")
    private int mId;
    @b(a = "position")
    private int mPosition;
    @b(a = "text")
    private String mText;

    public int getId() {
        return this.mId;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i2) {
        this.mPosition = i2;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getFlightLength() {
        return this.mFlightLength;
    }

    public int getListItemPos() {
        return this.listItemPos;
    }

    public void setListItemPos(int i2) {
        this.listItemPos = i2;
    }
}
