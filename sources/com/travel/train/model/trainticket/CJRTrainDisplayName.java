package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainDisplayName extends IJRPaytmDataModel {
    @b(a = "alignment")
    private String alignment;
    @b(a = "text")
    private String text;
    @b(a = "color")
    private String textColor;
    @b(a = "text_type")
    private String textType;

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
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

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public String getTextColor() {
        return this.textColor;
    }
}
