package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSortingKeys extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private boolean isSelected;
    @b(a = "default")
    private String mDefault;
    @b(a = "name")
    private String mName;
    @b(a = "urlParams")
    private String mUrlParams;

    public String getDefault() {
        return this.mDefault;
    }

    public String getUrlParams() {
        return this.mUrlParams;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUrlParams(String str) {
        this.mUrlParams = str;
    }

    public void setDefault(String str) {
        this.mDefault = str;
    }
}
