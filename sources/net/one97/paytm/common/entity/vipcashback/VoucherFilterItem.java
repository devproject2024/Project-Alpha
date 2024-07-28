package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;

public class VoucherFilterItem {
    @b(a = "count")
    private String count;
    @b(a = "displayName")
    private String displayName;
    @b(a = "fieldValue")
    private String fieldValue;
    @b(a = "id")
    private String id;
    private boolean isSelected;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(String str) {
        this.fieldValue = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
