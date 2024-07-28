package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRExistingAttribute implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "Size")
    private String mSize;

    public String getSize() {
        return this.mSize;
    }
}
