package com.travel.train.model.trainticket;

import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainLsDateModel implements IJRDataModel {
    private Date date;
    private String date_str;
    private int index;
    private boolean isToday;
    private boolean isTomorrow;
    private String value1;
    private String value2;

    public String getValue1() {
        return this.value1;
    }

    public void setValue1(String str) {
        this.value1 = str;
    }

    public String getValue2() {
        return this.value2;
    }

    public void setValue2(String str) {
        this.value2 = str;
    }

    public String getDate_str() {
        return this.date_str;
    }

    public void setDate_str(String str) {
        this.date_str = str;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isToday() {
        return this.isToday;
    }

    public void setToday(boolean z) {
        this.isToday = z;
    }

    public boolean isTomorrow() {
        return this.isTomorrow;
    }

    public void setTomorrow(boolean z) {
        this.isTomorrow = z;
    }
}
