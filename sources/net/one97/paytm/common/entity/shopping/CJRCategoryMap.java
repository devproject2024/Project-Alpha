package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoryMap implements IJRDataModel {
    @b(a = "id")
    private String mId;
    @b(a = "name")
    private String mName;

    public String getName() {
        return this.mName;
    }

    public String getCategoryId() {
        return this.mId;
    }
}
