package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityRcV2 implements IJRDataModel {
    @b(a = "selected")
    private boolean isSelected;
    @b(a = "label")
    private String label;
    @b(a = "type")
    private String type;
    @b(a = "url")
    private String url;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
