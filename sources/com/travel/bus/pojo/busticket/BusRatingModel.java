package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class BusRatingModel implements IJRDataModel {
    @b(a = "average_rating")
    private double average_rating;
    @b(a = "color_code")
    private String color_code;
    @b(a = "count")
    private int count;
    @b(a = "review_count")
    private int review_count;

    public double getAvgRating() {
        return this.average_rating;
    }

    public void setAverage_rating(double d2) {
        this.average_rating = d2;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public int getReview_count() {
        return this.review_count;
    }

    public void setReview_count(int i2) {
        this.review_count = i2;
    }

    public String getColor_code() {
        return this.color_code;
    }

    public void setColor_code(String str) {
        this.color_code = str;
    }
}
