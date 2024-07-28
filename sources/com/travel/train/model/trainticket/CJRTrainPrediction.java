package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPrediction implements IJRDataModel {
    @b(a = "colour")
    private String colour;
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "text_key")
    private String textKey;
    @b(a = "text_value")
    private String textValue;
    @b(a = "value")
    private String value;

    public boolean getEnabled() {
        return this.enabled;
    }

    public String getValue() {
        return this.value;
    }

    public String getColour() {
        return this.colour;
    }

    public String getTextKey() {
        return this.textKey;
    }

    public String getTextValue() {
        return this.textValue;
    }
}
