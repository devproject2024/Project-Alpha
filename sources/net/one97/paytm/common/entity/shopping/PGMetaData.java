package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class PGMetaData extends IJRPaytmDataModel {
    @b(a = "displayValue")
    private String displayValue;
    @b(a = "mode")
    private String mode;
    @b(a = "type")
    private String type;
    @b(a = "value")
    private String value;

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getConvFee() {
        return this.value;
    }

    public void setConvFee(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(String str) {
        this.displayValue = str;
    }
}
