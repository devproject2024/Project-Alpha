package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatText extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "angle")
    private Integer angle;
    @a
    @b(a = "height")
    private Integer height;
    @a
    @b(a = "left_image")
    private String leftImage;
    @a
    @b(a = "right_image")
    private String rightImage;
    @a
    @b(a = "text")
    private String text;
    @a
    @b(a = "width")
    private Integer width;
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

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getLeftImage() {
        return this.leftImage;
    }

    public void setLeftImage(String str) {
        this.leftImage = str;
    }

    public String getRightImage() {
        return this.rightImage;
    }

    public void setRightImage(String str) {
        this.rightImage = str;
    }

    public Integer getAngle() {
        return this.angle;
    }

    public void setAngle(Integer num) {
        this.angle = num;
    }
}
