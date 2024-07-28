package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeInputFieldsTypeV2 implements IJRDataModel {
    private String configKey;
    private boolean mandatory;
    @b(a = "max")
    private String max;
    private String message;
    @b(a = "min")
    private String min;
    @b(a = "regex")
    private String regex;
    private String title;
    @b(a = "type")
    private String type;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    public void setConfigKey(String str) {
        this.configKey = str;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isMandatory() {
        return this.mandatory;
    }

    public void setMandatory(boolean z) {
        this.mandatory = z;
    }

    public String getMin() {
        return this.min;
    }

    public void setMin(String str) {
        this.min = str;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String str) {
        this.max = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
