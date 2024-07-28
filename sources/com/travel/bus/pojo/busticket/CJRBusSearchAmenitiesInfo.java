package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchAmenitiesInfo implements IJRDataModel {
    private int count = 0;
    @b(a = "icon")
    private String icon;
    @b(a = "icon_selected")
    private String icon_selected;
    @b(a = "id")
    private String id;
    private boolean isSelected;
    @b(a = "label")
    private String label;
    @b(a = "name")
    private String name;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getIconSelected() {
        return this.icon_selected;
    }

    public void setIconSelected(String str) {
        this.icon_selected = str;
    }
}
