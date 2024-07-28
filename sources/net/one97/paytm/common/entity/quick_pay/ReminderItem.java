package net.one97.paytm.common.entity.quick_pay;

import net.one97.paytm.common.entity.IJRDataModel;

public class ReminderItem implements IJRDataModel {
    public String display;
    public boolean isSelected;
    public String item;

    public ReminderItem(String str, boolean z) {
        this.item = str;
        this.display = str;
        this.isSelected = z;
    }

    public ReminderItem(String str, String str2, boolean z) {
        this.item = str;
        this.display = str2;
        this.isSelected = z;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String str) {
        this.display = str;
    }

    public String getItem() {
        return this.item;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
