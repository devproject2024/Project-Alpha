package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCartItemTag implements IJRDataModel {
    @b(a = "display_name")
    private String display_name;
    @b(a = "name")
    private String name;

    public String getDisplay_name() {
        return this.display_name;
    }

    public void setDisplay_name(String str) {
        this.display_name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
