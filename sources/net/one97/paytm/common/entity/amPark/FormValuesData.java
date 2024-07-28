package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class FormValuesData implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "value")
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
