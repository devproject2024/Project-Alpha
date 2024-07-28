package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeProductListGroupArrItemV2 implements IJRDataModel {
    @b(a = "brandImage")
    private boolean brandImage;
    @b(a = "key")
    private String key;
    @b(a = "label")
    private String label;
    @b(a = "type")
    private String type;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public boolean isBrandImage() {
        return this.brandImage;
    }

    public void setBrandImage(boolean z) {
        this.brandImage = z;
    }
}
