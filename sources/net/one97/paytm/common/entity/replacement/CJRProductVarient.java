package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRProductVarient implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "product_variant_name")
    private String mName;
    @b(a = "product_id")
    private long mProductId;

    public long getProductId() {
        return this.mProductId;
    }

    public void setProductId(long j) {
        this.mProductId = j;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
