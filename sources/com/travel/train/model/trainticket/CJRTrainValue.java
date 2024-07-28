package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainValue extends IJRPaytmDataModel {
    @b(a = "alignment")
    private String alignment;
    @b(a = "amount")
    private boolean isAmount;
    private String serverAmount;
    @b(a = "text")
    private String text;
    @b(a = "color")
    private String textColor;
    @b(a = "text_type")
    private String textType;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setAlignment(String str) {
        this.alignment = str;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public void setTextType(String str) {
        this.textType = str;
    }

    public String getTextType() {
        return this.textType;
    }

    public boolean isAmount() {
        return this.isAmount;
    }

    public void setAmount(boolean z) {
        this.isAmount = z;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String getServerAmount() {
        return this.serverAmount;
    }

    public void setServerAmount(String str) {
        this.serverAmount = str;
    }
}
